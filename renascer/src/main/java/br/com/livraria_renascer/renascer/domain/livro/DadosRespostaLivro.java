package br.com.livraria_renascer.renascer.domain.livro;

import java.time.LocalDate;

public record DadosRespostaLivro(

        String titulo,

        LocalDate dataDePublicacao
) {

    public DadosRespostaLivro (Livro livro) {
        this(livro.getTitulo(), livro.getDataPublicacao());
    }
}
