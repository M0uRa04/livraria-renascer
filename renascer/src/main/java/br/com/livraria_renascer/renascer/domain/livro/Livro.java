package br.com.livraria_renascer.renascer.domain.livro;

import br.com.livraria_renascer.renascer.domain.autor.Autor;
import br.com.livraria_renascer.renascer.domain.categoria.Categoria;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "livro")
@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @Column(precision = 10, scale = 2)
    private BigDecimal preco;

    private LocalDate dataPublicacao;

    @Column(name = "estoque")
    private Integer qtdEmEstoque;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "autor_id")
    private Autor autor;

    public Livro (DadosCadastroLivro dados, Autor autor, Categoria categoria) {
        this.titulo = dados.titulo();
        this.preco = dados.preco();
        this.dataPublicacao = dados.dataPublicacao();
        this.qtdEmEstoque = dados.qtdEmEstoque();
        this.autor = autor;
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Livro {\n");
        sb.append("    Título: '").append(titulo).append("'\n");
        sb.append("    Preço: ").append(preco).append("\n");
        sb.append("    Data de Publicação: ").append(dataPublicacao).append("\n");
        sb.append("    Quantidade em Estoque: ").append(qtdEmEstoque).append("\n");

        if (autor != null) {
            sb.append("    Autor: ").append(autor.getNome()).append("\n");
        } else {
            sb.append("    Autor: não especificado\n");
        }

        if (categoria != null) {
            sb.append("    Categoria: ").append(categoria.getNome()).append("\n");
            sb.append("    Descrição da Categoria: ").append(categoria.getDescricao()).append("\n");
        } else {
            sb.append("    Categoria: não especificada\n");
        }

        sb.append("}");
        return sb.toString();
    }

}
