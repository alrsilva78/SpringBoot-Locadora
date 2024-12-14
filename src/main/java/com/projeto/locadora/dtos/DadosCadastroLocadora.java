package com.projeto.locadora.dtos;

import java.time.LocalDate;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;

// Classe Record DTO

public record DadosCadastroLocadora(

    @Enumerated
    Tipo tipo,

    @NotBlank
    String nome,

    @Enumerated
    Marca marca,

    @NotBlank
    String placa,

    @Enumerated
    Cambio cambio,

    Double valor,

    @Future
    LocalDate dataretirada

) {

}
