package com.projeto.locadora.view;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.locadora.model.LocadoraEntity;

public interface LocadoraRepository extends JpaRepository <LocadoraEntity, Long>{

}
