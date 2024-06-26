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

    private Integer qtdEmEstoque;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categotia_id")
    private Categoria categoria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id")
    private Autor autor;
}
