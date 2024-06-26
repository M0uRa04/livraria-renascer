package br.com.livraria_renascer.renascer.domain.categoria;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroCategoria(

        @NotBlank
        String nome,

        @NotBlank
        String descricao
){}
