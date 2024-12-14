package com.projeto.locadora.dtos;

import org.springframework.validation.FieldError;

public record DadosErros(String field, String messaage) {

    public DadosErros(FieldError erros){
        this(erros.getField(), erros.getDefaultMessage());
    }

}
