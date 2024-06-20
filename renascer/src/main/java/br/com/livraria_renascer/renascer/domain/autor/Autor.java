package br.com.livraria_renascer.renascer.domain.autor;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "autor")
@Data
@EqualsAndHashCode (of = "id")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    private String biografia;

    @NotNull
    private boolean ativo;

    public Autor (){
        ativo = true;
    };

    public Autor (DadosCadastroAutor dados) {
        ativo = true;
        this.nome = dados.nome();
        this.biografia = dados.biografia();
    }
}
