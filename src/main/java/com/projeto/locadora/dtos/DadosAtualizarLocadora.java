package com.projeto.locadora.dtos;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarLocadora(

@NotNull
Long id,
String nome,
Marca marca

) {

}
