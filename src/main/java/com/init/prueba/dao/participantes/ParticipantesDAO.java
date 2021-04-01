package com.init.prueba.dao.participantes;

import org.springframework.data.jpa.repository.JpaRepository;

import com.init.prueba.entitys.Participante;

public interface ParticipantesDAO extends JpaRepository<Participante, Integer> {

}
