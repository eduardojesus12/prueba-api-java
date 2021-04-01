package com.init.prueba.dao.participantes;

import org.springframework.data.jpa.repository.JpaRepository;

import com.init.prueba.entitys.Grupo;

public interface GruposDAO extends JpaRepository<Grupo, Integer> {

}
