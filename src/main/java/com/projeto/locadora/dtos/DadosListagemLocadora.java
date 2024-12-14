package com.projeto.locadora.dtos;

// Classe Record DTO
import java.time.LocalDate;

import com.projeto.locadora.entity.LocadoraEntity;


public record DadosListagemLocadora(
    Long id,
    Tipo tipo,
    String nome,
    Marca marca,
    String placa,
    Cambio cambio,
    Double valor,
    LocalDate dataretirada
) {

    // Contructor do encapsulamento do Get
    public DadosListagemLocadora (LocadoraEntity locadoraEntity) {
        this(locadoraEntity.getId(),locadoraEntity.getTipo(),locadoraEntity.getNome() , locadoraEntity.getMarca()
        , locadoraEntity.getPlaca(), locadoraEntity.getCambio()
        , locadoraEntity.getValor(), locadoraEntity.getDataretirada());
    }

}
