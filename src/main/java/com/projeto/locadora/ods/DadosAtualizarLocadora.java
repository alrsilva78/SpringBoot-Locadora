package com.projeto.locadora.ods;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarLocadora(

@NotNull
Long id,
String nome,
Marca marca

) {

}
