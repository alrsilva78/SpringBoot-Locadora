package com.projeto.locadora.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.projeto.locadora.entity.LocadoraEntity;
import com.projeto.locadora.ods.DadosAtualizarLocadora;
import com.projeto.locadora.ods.DadosCadastroLocadora;
import com.projeto.locadora.ods.DadosDetalhamentoCarros;
import com.projeto.locadora.ods.DadosDetalheAtualizarCarros;
import com.projeto.locadora.ods.DadosListagemLocadora;
import com.projeto.locadora.repository.LocadoraRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    public ResponseEntity<DadosDetalhamentoCarros> cadastrarCarro (@RequestBody @Valid DadosCadastroLocadora dados, UriComponentsBuilder uriBuilder) {
        var locadora = (new LocadoraEntity(dados));
        repository.save(locadora);

        var uri = uriBuilder.path("/locadora/{id}").buildAndExpand(locadora.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoCarros(locadora));
    }

     // Definição do tipo de requisição como Get    
    @GetMapping

    // Exibir dados cadastrados conforme requisição
    public ResponseEntity<List<DadosListagemLocadora>> listar (){
        var lista = repository.findAllByAtivoTrue().stream().map(DadosListagemLocadora::new).toList();
        return ResponseEntity.ok(lista);

    }

    @PutMapping
    @Transactional

    public ResponseEntity<DadosDetalheAtualizarCarros> atualizarCarro (@RequestBody @Valid DadosAtualizarLocadora dados){
        var locadora = repository.getReferenceById(dados.id());
        locadora.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalheAtualizarCarros(locadora));

    }

    @DeleteMapping("/{id}")
    @Transactional

    public ResponseEntity<Void> excluir (@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.ok().build();
       
    }

    @DeleteMapping ("inativar/{id}")
    @Transactional

    public ResponseEntity<Void> inativar (@PathVariable Long id) {
        var locadora = repository.getReferenceById(id);
        locadora.inativar();
        return ResponseEntity.ok().build();

    }

    @PutMapping ("ativar/{id}")
    @Transactional

    public ResponseEntity<Void> ativar (@PathVariable Long id) {
        var locadora = repository.getReferenceById(id);
        locadora.ativar();
        return ResponseEntity.ok().build();
    }

}
