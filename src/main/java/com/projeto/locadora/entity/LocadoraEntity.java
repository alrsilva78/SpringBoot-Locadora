package com.projeto.locadora.entity;

import java.time.LocalDate;

import com.projeto.locadora.ods.Cambio;
import com.projeto.locadora.ods.DadosAtualizarLocadora;
import com.projeto.locadora.ods.DadosCadastroLocadora;
import com.projeto.locadora.ods.Marca;
import com.projeto.locadora.ods.Tipo;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity (name = "Locadora")
@Table (name = "locadora")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class LocadoraEntity {

    // Contructor do encapsulamento do Post 
    public LocadoraEntity(DadosCadastroLocadora dados) {
        this.ativo = true;
        this.tipo = dados.tipo();
        this.nome = dados.nome();
        this.marca = dados.marca();
        this.placa = dados.placa();
        this.cambio = dados.cambio();
        this.dataretirada = dados.dataretirada();
    }

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    private String nome;

    @Enumerated(EnumType.STRING)
    private Marca marca;

    private String placa;

    @Enumerated(EnumType.STRING)
    private Cambio cambio;

    private Double valor;
    private LocalDate dataretirada;

    private Boolean ativo;


    public void atualizarInformacoes(@Valid DadosAtualizarLocadora dados) {
       if (dados.nome() != null) {
        this.nome = dados.nome();
        
       }
       if (dados.marca() !=null) {
        this.marca = dados.marca();
        
       }
    }

    public void inativar() {
        this.ativo = false;
    }


    public void ativar() {
        this.ativo = true;
    }



}
