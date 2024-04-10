package com.cadastroCliente.domain.model;


import com.cadastroCliente.domain.dtos.ContatoDTO;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "contato")
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private String tipo;
    private String texto;


    public Contato() {
    }

    public Contato(ContatoDTO contatoDTO) {
        this.texto = contatoDTO.texto();
        this.tipo = contatoDTO.tipo();
    }
}
