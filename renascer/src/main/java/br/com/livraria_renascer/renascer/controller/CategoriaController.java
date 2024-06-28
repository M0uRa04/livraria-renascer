package br.com.livraria_renascer.renascer.controller;

import br.com.livraria_renascer.renascer.domain.categoria.CategoriaRepository;
import br.com.livraria_renascer.renascer.domain.categoria.CategoriaService;
import br.com.livraria_renascer.renascer.domain.categoria.DadosAtualizacaoCategoria;
import br.com.livraria_renascer.renascer.domain.categoria.DadosCadastroCategoria;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @Autowired
    private CategoriaRepository repository;

    @GetMapping
    public ResponseEntity listaCategorias () {
        var categorias = service.listaCategorias();
        return ResponseEntity.ok().body(categorias);
    }

    @PostMapping
    public ResponseEntity CadastraCategoria (@Valid @RequestBody DadosCadastroCategoria dados) {
        var uri = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUri();
        var categoriaCadastrada = service.cadastrar(dados);
        return ResponseEntity.created(uri).body(categoriaCadastrada);
    }

    @PatchMapping
    @Transactional
    public ResponseEntity AtualizaCategoria (@Valid @RequestBody DadosAtualizacaoCategoria dados) {
        var categoria = service.atualiza(dados);
        return ResponseEntity.ok(categoria);
    }

    @DeleteMapping ("/{id}")
    @Transactional
    public ResponseEntity inativaCategoria (@PathVariable Long id) {
        var categoria = repository.getReferenceById(id);
        service.inativa(categoria);
        repository.save(categoria);
        return ResponseEntity.noContent().build();
    }

    @GetMapping ("/{id}")
    public ResponseEntity buscarCategoriaPorId (@PathVariable Long id) {
        var categoria = repository.findById(id);
        if(categoria.isPresent()) {
            return ResponseEntity.ok().body(categoria);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

}