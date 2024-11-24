package com.projeto.locadora.ods;

import java.time.LocalDate;

import com.projeto.locadora.entity.LocadoraEntity;

public record DadosDetalheAtualizarCarros(
    Long id,
    Tipo tipo,
    String nome,
    Marca marca,
    String placa,
    Cambio cambio,
    Double valor,
    LocalDate dataretirada,
    Boolean ativo
) {
    public DadosDetalheAtualizarCarros(LocadoraEntity locadoraEntity){
        this(locadoraEntity.getId(),locadoraEntity.getTipo(), 
        locadoraEntity.getNome(), locadoraEntity.getMarca(), 
        locadoraEntity.getPlaca(), locadoraEntity.getCambio(), 
        locadoraEntity.getValor(), locadoraEntity.getDataretirada(), locadoraEntity.getAtivo());
    }

}
