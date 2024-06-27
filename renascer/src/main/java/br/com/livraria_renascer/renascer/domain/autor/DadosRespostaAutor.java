package br.com.livraria_renascer.renascer.domain.autor;

import java.util.List;

public record DadosRespostaAutor(

        String nome,
        List<String> listaTitulos
) {
    public DadosRespostaAutor (Autor autor) {
        this(autor.getNome(), autor.getLivros());
    }
}
