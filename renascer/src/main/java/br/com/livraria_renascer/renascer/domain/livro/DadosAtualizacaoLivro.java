package br.com.livraria_renascer.renascer.domain.livro;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosAtualizacaoLivro (

        @NotNull
        Long id,

        String titulo,

        BigDecimal preco,

        LocalDate dataPublicacao,

        Integer qtdEmEstoque
) {
}
