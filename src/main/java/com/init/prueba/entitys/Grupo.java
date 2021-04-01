package com.init.prueba.entitys;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="grupos")
public class Grupo {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="descripcion", nullable = false, length=255)
	private String descripcion;
	
	@Column(name="tipo", nullable = false, length=255)
	private String tipo;
	
	@OneToMany( targetEntity=Participante.class )
	private List participantes;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List getParticipantes() {
		return participantes;
	}

	public void setParticipantes(List participantes) {
		this.participantes = participantes;
	}



	
	
	
}
