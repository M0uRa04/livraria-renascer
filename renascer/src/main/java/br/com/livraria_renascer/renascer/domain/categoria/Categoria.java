package br.com.livraria_renascer.renascer.domain.categoria;

import br.com.livraria_renascer.renascer.domain.livro.Livro;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categoria")
@Data
@EqualsAndHashCode(of = "id")
public class Categoria {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricao;

    @JsonIgnore
    @OneToMany(mappedBy = "categoria", fetch = FetchType.LAZY)
    private List<Livro> livros = new ArrayList<>();

    private boolean ativo;

    public Categoria (){};

    public Categoria (DadosCadastroCategoria dados){
        this.nome = dados.nome();
        this.descricao = dados.descricao();
        this.ativo = true;
    };


    public void adicionarLivro(Livro livro) {
        livros.add(livro);
        livro.setCategoria(this);
    }

}
