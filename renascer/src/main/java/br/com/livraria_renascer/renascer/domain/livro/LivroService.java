package br.com.livraria_renascer.renascer.domain.livro;

import br.com.livraria_renascer.renascer.domain.autor.Autor;
import br.com.livraria_renascer.renascer.domain.autor.AutorRepository;
import br.com.livraria_renascer.renascer.domain.categoria.Categoria;
import br.com.livraria_renascer.renascer.domain.categoria.CategoriaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Autor buscaAutor (Long id) {
        return autorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Autor não encontrado ou Id incorreto fornecido."));
    }

    public Categoria buscaCategoria (Long id) {
        return categoriaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Categoria não encontrada ou Id incorreto fornecido."));
    }

    public List<Livro> listaLivros () {
        var listaDeLivros = livroRepository.findAll();
        return listaDeLivros;
    }

    public void cadastrar(DadosCadastroLivro dados) {
        var autor = buscaAutor(dados.id_autor());
        var categoria = buscaCategoria(dados.id_categoria());
        Livro livro = new Livro(dados, autor, categoria);
        livroRepository.save(livro);
    }
}
