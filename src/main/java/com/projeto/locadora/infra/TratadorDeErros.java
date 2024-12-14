package com.projeto.locadora.infra;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.projeto.locadora.dtos.DadosErros;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice

public class TratadorDeErros {

    @ExceptionHandler(MethodArgumentNotValidException.class)

    public ResponseEntity<?>treatError400(MethodArgumentNotValidException ex){
        var erros = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(erros.stream().map(DadosErros::new).toList());
    }

    @ExceptionHandler(EntityNotFoundException.class)

    public ResponseEntity<String>treatNotFound(){
        var message = "Item not found.";
        return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    
    public ResponseEntity<String>treatErrorConflict(){
        var message = "Data Integrity Violation -> Duplicate Placa.";
        return new ResponseEntity<>(message,HttpStatus.CONFLICT);
    }


}
