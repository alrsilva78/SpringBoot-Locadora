package com.projeto.locadora.controller;

import org.springframework.web.bind.annotation.RestController;

import com.projeto.locadora.entity.LocadoraEntity;
import com.projeto.locadora.model.DadosCadastroLocadora;
import com.projeto.locadora.model.DadosListagemLocadora;
import com.projeto.locadora.repository.LocadoraRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;


// Definição da classe como Controller
@RestController
@RequestMapping ("/locadora")

public class LocadoraController {

    // Instancia do Repository JPA
    @Autowired
    LocadoraRepository repository;

    // Definição do tipo de requisição como Post
    @PostMapping
    @Transactional
    // Encapsulamento dos dados e Save no BD
    public void cadastrarCarro (@RequestBody @Valid DadosCadastroLocadora dados) {
        repository.save(new LocadoraEntity(dados));
    }

     // Definição do tipo de requisição como Get    
    @GetMapping

    // Exibir dados cadastrados conforme requisição
    public List<DadosListagemLocadora> listar (){
        return repository.findAll().stream().map(DadosListagemLocadora::new).toList();

    }
}
