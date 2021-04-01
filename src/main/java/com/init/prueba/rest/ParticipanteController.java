package com.init.prueba.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.init.prueba.dao.participantes.ParticipantesDAO;
import com.init.prueba.entitys.Participante;

@RestController
@RequestMapping("/participantes")
public class ParticipanteController {

	@Autowired
	private ParticipantesDAO participanteDao;
	
	@GetMapping
	public ResponseEntity<List<Participante>> getAllParticipantes() {
		List<Participante> participantes = participanteDao.findAll();
		
		return ResponseEntity.ok(participantes);
	}
	
	@RequestMapping(value="{id}")
	public ResponseEntity<Participante> getParticipanteById(@PathVariable("id") int id) {
		Optional<Participante> optionalParticipante = participanteDao.findById(id);
		
		if(optionalParticipante.isPresent()) {
			return ResponseEntity.ok(optionalParticipante.get());
		} else {
			return ResponseEntity.noContent().build();
		}
		
		
	}
	
	@PostMapping
	public ResponseEntity<Participante> postParticipante(@RequestBody Participante participante) {
	
		Participante newParticipante = participanteDao.save(participante);
		return ResponseEntity.ok(newParticipante);
		
	}
	
	@DeleteMapping(value="{id}")
	public ResponseEntity<Void> deleteParticipante(@PathVariable("id") int id) {
		participanteDao.deleteById(id);
		return ResponseEntity.ok(null);
	}
	
	@PutMapping
	public ResponseEntity<Participante> putParticipante(@RequestBody Participante participante) {
		Optional<Participante> optionalParticipante = participanteDao.findById(participante.getId());
		
		if(optionalParticipante.isPresent()) {
			Participante updateParticipante = optionalParticipante.get();
			updateParticipante.setNombre(participante.getNombre());
			updateParticipante.setCorreo_electronico(participante.getCorreo_electronico());
			updateParticipante.setComentarios(participante.getComentarios());
			updateParticipante.setGrupo(participante.getGrupo());
			
			participanteDao.save(updateParticipante);

			return ResponseEntity.ok(updateParticipante);
			
			
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	
	
}
