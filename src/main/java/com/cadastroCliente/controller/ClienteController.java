package com.cadastroCliente.controller;

import com.cadastroCliente.domain.dtos.ClienteDTO;
import com.cadastroCliente.domain.model.Cliente;
import com.cadastroCliente.domain.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private ClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> listar() {

        return clienteRepository.findAll();
    }

    @GetMapping("/{clienteId}")
    public ResponseEntity<Cliente> buscar(@PathVariable Long clienteId){
        return clienteRepository.findById(clienteId).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente inserirClientes(@RequestBody ClienteDTO clienteDto){

        return clienteRepository.save(new Cliente(clienteDto));
    }


    @PutMapping("/{clienteId}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long clienteId,
                                                @RequestBody Cliente cliente){
        if (!clienteRepository.existsById(clienteId)){

            return ResponseEntity.notFound().build();
        }
        cliente.setId(clienteId);
        Cliente clienteatual =clienteRepository.save(cliente);
        return ResponseEntity.ok(clienteatual);
    }
    @DeleteMapping("/{clienteId}")
    public ResponseEntity remover(@PathVariable long clienteId){
        if (!clienteRepository.existsById(clienteId)){
            return ResponseEntity.notFound().build();
        }
        clienteRepository.deleteById(clienteId);
        return ResponseEntity.noContent().build();

    }

}