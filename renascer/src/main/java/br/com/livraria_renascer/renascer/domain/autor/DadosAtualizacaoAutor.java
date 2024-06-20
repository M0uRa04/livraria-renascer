package br.com.livraria_renascer.renascer.domain.autor;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoAutor(

        @NotNull
        Long id,

        String nome,

        String biografia,

        boolean ativo
){}

