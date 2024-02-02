package com.kardec.clinica.infra.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice //Anotação para dizer ao spring que irá tratar erros na API
public class TradadorDeErros {

    @ExceptionHandler(EntityNotFoundException.class) //Anotação para qual exceção ele vai ser chamado(quando vai ser chamado)
    public ResponseEntity tratarErro404(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarErro400(MethodArgumentNotValidException exception){
        var erros = exception.getFieldErrors();


        return ResponseEntity.badRequest().body(erros.stream().map(DadosErroValicao::new).toList());
    }

    private record DadosErroValicao(String campo, String messagem){
        public DadosErroValicao(FieldError erro){
            this(erro.getField(), erro.getDefaultMessage());
        }

    }
}
