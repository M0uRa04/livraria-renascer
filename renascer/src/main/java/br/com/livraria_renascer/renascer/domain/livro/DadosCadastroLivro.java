package br.com.livraria_renascer.renascer.domain.livro;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosCadastroLivro(

                @NotBlank
                String titulo,

                @NotNull
                BigDecimal preco,

                @NotNull
                @PastOrPresent
                LocalDate dataPublicacao,

                @NotNull
                Integer qtdEmEstoque,

                @NotNull
                Long id_autor,

                @NotNull
                Long id_categoria
){}
