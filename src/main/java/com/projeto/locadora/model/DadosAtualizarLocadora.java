package com.projeto.locadora.model;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarLocadora(

@NotNull
Long id,
String nome,
Marca marca

) {

}
