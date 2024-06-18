package br.com.livraria_renascer.renascer.controller;

import br.com.livraria_renascer.renascer.domain.autor.DadosCadastroAutor;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @GetMapping
    public ResponseEntity listaAutores () {
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity cadastraAutor (@Valid @RequestBody DadosCadastroAutor dados) {
        var uri = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUri();
        return ResponseEntity.created(uri).body(dados);
    }


}
