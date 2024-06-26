package br.com.livraria_renascer.renascer.domain.autor;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroAutor(

        @NotBlank
        String nome,

        @NotBlank
        String biografia
){}
