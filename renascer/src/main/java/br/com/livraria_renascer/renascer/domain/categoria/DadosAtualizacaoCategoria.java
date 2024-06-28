package br.com.livraria_renascer.renascer.domain.categoria;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoCategoria (

        @NotNull
        Long id,

        String nome,

        String descricao
) {
}
