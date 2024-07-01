package br.com.livraria_renascer.renascer.controller;

import br.com.livraria_renascer.renascer.domain.autor.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/autor")
@SecurityRequirement(name = "bearer-key")
public class AutorController {

    @Autowired
    private AutorRepository repository;

    @Autowired
    private AutorService service;

    @GetMapping
    public ResponseEntity listaAutores () {
        var listaDeAutores = repository.findAll();
        var listaRespostaAutores = listaDeAutores.stream()
                .map(a -> new DadosRespostaAutor(a))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(listaRespostaAutores);
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
    public ResponseEntity inativaAutor (@PathVariable Long id) {
        var autor = repository.getReferenceById(id);
        service.inativa(autor);
        repository.save(autor);
        return ResponseEntity.noContent().build();
    }

    @GetMapping ("/{id}")
    public ResponseEntity buscaAutorPorId (@PathVariable Long id) {
        var autor = repository.findById(id);
        if(autor.isPresent()) {
            return ResponseEntity.ok().body(autor);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

}