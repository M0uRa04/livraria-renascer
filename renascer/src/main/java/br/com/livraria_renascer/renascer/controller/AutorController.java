package br.com.livraria_renascer.renascer.controller;

import br.com.livraria_renascer.renascer.domain.autor.Autor;
import br.com.livraria_renascer.renascer.domain.autor.AutorRepository;
import br.com.livraria_renascer.renascer.domain.autor.DadosCadastroAutor;
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

    @GetMapping
    public ResponseEntity listaAutores () {
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity cadastraAutor (@Valid @RequestBody DadosCadastroAutor dados) {
        var uri = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUri();
        repository.save(new Autor(dados));
        return ResponseEntity.created(uri).body(dados);
    }


}
