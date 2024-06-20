package br.com.livraria_renascer.renascer.infra.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity <String> tratarElementoNaoEncontradoNoBd () {
        return new ResponseEntity<>("Recurso não encontrado", HttpStatus.NOT_FOUND);
    }
}
