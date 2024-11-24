package com.projeto.locadora.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.locadora.entity.LocadoraEntity;

public interface LocadoraRepository extends JpaRepository <LocadoraEntity, Long>{

    List<LocadoraEntity> findAllByAtivoTrue();

}
