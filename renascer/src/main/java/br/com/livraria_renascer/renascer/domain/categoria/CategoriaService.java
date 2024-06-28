package br.com.livraria_renascer.renascer.domain.categoria;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria buscaCategoria (Long id) {
        return categoriaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Categoria não encontrada ou Id incorreto fornecido."));
    }

    public List<Categoria> listaCategorias () {
        return categoriaRepository.findAll();
    }

    public Categoria cadastrar(DadosCadastroCategoria dados) {
        var categoria = new Categoria(dados);
        categoriaRepository.save(categoria);
        return categoria;
    }

    public Categoria atualiza(DadosAtualizacaoCategoria dados) {
        var categoriaRecuperada = categoriaRepository.findById(dados.id()).orElseThrow(() -> new RuntimeException("Livro não encontrado para o Id Fornecido"));

        if (!dados.nome().isBlank()) {
            categoriaRecuperada.setNome(dados.nome());
        }
        if (!(dados.descricao() == null)) {
            categoriaRecuperada.setDescricao(dados.descricao());
        }

        return categoriaRepository.save(categoriaRecuperada);
    }

    public void inativa(Categoria categoria) {
        categoria.setAtivo(false);
    }
}
