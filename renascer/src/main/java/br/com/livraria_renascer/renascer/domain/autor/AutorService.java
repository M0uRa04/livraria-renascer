package br.com.livraria_renascer.renascer.domain.autor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorService {

    @Autowired
    private AutorRepository repository;

    public Autor atualiza(DadosAtualizacaoAutor dados) {
        var autorRecuperado = repository.findById(dados.id()).get();
        if (!dados.nome().isBlank()) {
            autorRecuperado.setNome(dados.nome());
        }

        if (!dados.biografia().isBlank()) {
            autorRecuperado.setBiografia(dados.biografia());
        }
        repository.save(autorRecuperado);
        return autorRecuperado;
    }
}
