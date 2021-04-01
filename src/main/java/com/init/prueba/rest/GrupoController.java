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

import com.init.prueba.dao.participantes.GruposDAO;
import com.init.prueba.entitys.Grupo;
import com.init.prueba.entitys.Participante;

@RestController
@RequestMapping("/grupos")
public class GrupoController {

	@Autowired
	private GruposDAO grupoDao;
	
	@GetMapping
	public ResponseEntity<List<Grupo>> getAllGrupos() {
		List<Grupo> grupos = grupoDao.findAll();
		
		return ResponseEntity.ok(grupos);
	}
	
	@RequestMapping(value="{id}")
	public ResponseEntity<Grupo> getGrupoById(@PathVariable("id") int id) {
		Optional<Grupo> optionalGrupo = grupoDao.findById(id);
		
		if(optionalGrupo.isPresent()) {
			return ResponseEntity.ok(optionalGrupo.get());
		} else {
			return ResponseEntity.noContent().build();
		}
		
		
	}
	
	@PostMapping
	public ResponseEntity<Grupo> postGrupo(@RequestBody Grupo grupo) {
	
		Grupo newGrupo = grupoDao.save(grupo);
		return ResponseEntity.ok(newGrupo);
		
	}
	
	@PutMapping
	public ResponseEntity<Grupo> putGrupo(@RequestBody Grupo grupo) {
		Optional<Grupo> optionalGrupo = grupoDao.findById(grupo.getId());
		
		if(optionalGrupo.isPresent()) {
			Grupo updateGrupo = optionalGrupo.get();
			updateGrupo.setDescripcion(grupo.getDescripcion());
			updateGrupo.setTipo(grupo.getTipo());
			
			grupoDao.save(updateGrupo);

			return ResponseEntity.ok(updateGrupo);
			
			
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	@DeleteMapping(value="{id}")
	public ResponseEntity<Void> deleteGrupo(@PathVariable("id") int id) {
		grupoDao.deleteById(id);
		return ResponseEntity.ok(null);
	}
	
}
