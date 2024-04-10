package com.cadastroCliente.controller;


import com.cadastroCliente.domain.dtos.ClienteDTO;
import com.cadastroCliente.domain.dtos.ContatoDTO;
import com.cadastroCliente.domain.model.Cliente;
import com.cadastroCliente.domain.model.Contato;
import com.cadastroCliente.domain.repository.ContatoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/contato")
public class ContatoController {

    private ContatoRepository contatoRepository;

    @GetMapping
    public List<Contato> listar() {

        return contatoRepository.findAll();
    }

    @GetMapping("/{contatoId}")
    public ResponseEntity<Contato> buscar(@PathVariable Long contatoId){
        return contatoRepository.findById(contatoId).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Contato inserirContato(@RequestBody ContatoDTO contatoDTO){

        return contatoRepository.save(new Contato(contatoDTO));
    }

    @PutMapping("/{contatoId}")
    public ResponseEntity<Contato> atualizar(@PathVariable Long contatoId,
                                             @RequestBody Contato contato){
        if (!contatoRepository.existsById(contatoId)){

            return ResponseEntity.notFound().build();
        }
        contato.setId(contatoId);
        Contato contatonovo =contatoRepository.save(contato);
        return ResponseEntity.ok(contatonovo);
    }

    @DeleteMapping("/{contatoId}")
    public ResponseEntity remover(@PathVariable long contatoId){
        if (!contatoRepository.existsById(contatoId)){
            return ResponseEntity.notFound().build();
        }
        contatoRepository.deleteById(contatoId);
        return ResponseEntity.noContent().build();

    }



}
