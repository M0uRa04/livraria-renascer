package br.com.livraria_renascer.renascer.domain.autor;

import br.com.livraria_renascer.renascer.domain.livro.Livro;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.stream.Collectors;

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

    @OneToMany(mappedBy = "autor",fetch = FetchType.LAZY)
    private List<Livro> livros;

    @Transient
    private List<String> listaDeTitulosDeLivros;

    public Autor (){
        ativo = true;
    };

    public Autor (DadosCadastroAutor dados) {
        ativo = true;
        this.nome = dados.nome();
        this.biografia = dados.biografia();
    }

    public List<String> getLivros() {
        listaDeTitulosDeLivros = livros.stream()
                .map(Livro::getTitulo)
                .sorted()
                .collect(Collectors.toList());
        return listaDeTitulosDeLivros;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "nome='" + nome + '\'' +
                ", biografia='" + biografia + '\'' +
                ", ativo=" + ativo +
                ", livros=" + listaDeTitulosDeLivros +
                '}';
    }
}
