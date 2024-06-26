package br.com.livraria_renascer.renascer.domain.categoria;

import br.com.livraria_renascer.renascer.domain.livro.Livro;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "categoria")
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricao;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Livro> livros;

}
