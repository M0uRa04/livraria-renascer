package br.com.livraria_renascer.renascer.controller;

import br.com.livraria_renascer.renascer.domain.autor.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    private AutorRepository repository;

    @Autowired
    private AutorService service;

    @GetMapping
    public ResponseEntity listaAutores () {
        var listaDeAutores = repository.findAll();
        return ResponseEntity.ok().body(listaDeAutores);
    }

    @PostMapping
    public ResponseEntity cadastraAutor (@Valid @RequestBody DadosCadastroAutor dados) {
        var uri = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUri();
        repository.save(new Autor(dados));
        return ResponseEntity.created(uri).body(dados);
    }

    @PatchMapping
    @Transactional
    public ResponseEntity atualizaAutor (@Valid @RequestBody DadosAtualizacaoAutor dados) {
        var autor = service.atualiza(dados);
        return ResponseEntity.ok(autor);
    }

    @DeleteMapping ("/{id}")
    @Transactional
    public ResponseEntity atualizaAutor (@PathVariable Long id) {
        var autor = repository.getReferenceById(id);
        service.inativa(autor);
        repository.save(autor);
        return ResponseEntity.noContent().build();
    }


}