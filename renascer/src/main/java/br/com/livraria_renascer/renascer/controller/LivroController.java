package br.com.livraria_renascer.renascer.controller;

import br.com.livraria_renascer.renascer.domain.livro.DadosAtualizacaoLivro;
import br.com.livraria_renascer.renascer.domain.livro.DadosCadastroLivro;
import br.com.livraria_renascer.renascer.domain.livro.LivroRepository;
import br.com.livraria_renascer.renascer.domain.livro.LivroService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private LivroService service;

    @Autowired
    private LivroRepository repository;

    @GetMapping
    public ResponseEntity listaLivros () {
        var livroList = service.listaLivros();
        return ResponseEntity.ok().body(livroList);
    }

    @PostMapping
    public ResponseEntity CadastraLivros (@Valid @RequestBody DadosCadastroLivro dados) {
        var uri = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUri();
        var livroCadastrado = service.cadastrar(dados);
        return ResponseEntity.created(uri).body(livroCadastrado);
    }

    @PatchMapping
    @Transactional
    public ResponseEntity atualizaLivro (@Valid @RequestBody DadosAtualizacaoLivro dados) {
        var livro = service.atualiza(dados);
        return ResponseEntity.ok(livro);
    }
//
//    @DeleteMapping ("/{id}")
//    @Transactional
//    public ResponseEntity inativaAutor (@PathVariable Long id) {
//        var autor = repository.getReferenceById(id);
//        service.inativa(autor);
//        repository.save(autor);
//        return ResponseEntity.noContent().build();
//    }
//
    @GetMapping ("/{id}")
    public ResponseEntity buscaLivroPorId (@PathVariable Long id) {
        var livro = repository.findById(id);
        if(livro.isPresent()) {
            return ResponseEntity.ok().body(livro);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

}