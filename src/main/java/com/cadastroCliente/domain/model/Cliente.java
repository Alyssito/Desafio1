
package com.cadastroCliente.domain.model;

import com.cadastroCliente.domain.dtos.ClienteDTO;
import jakarta.persistence.*;
        import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "clientes")
public class Cliente {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(name="dataCadastro")
    private String dataCadastro;

    @OneToOne
    private Contato contato;

    public Cliente() {
    }

    public Cliente(ClienteDTO clienteDto) {
        this.nome = clienteDto.nome();
        this.dataCadastro = clienteDto.dataCadastro();
    }

}
