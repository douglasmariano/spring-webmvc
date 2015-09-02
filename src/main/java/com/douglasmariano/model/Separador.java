package com.douglasmariano.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Separador {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull(message = "{tarefa.descricao.vazia}")
	@Size(min = 5, max = 45, message = "{tarefa.descricao.pequena}")
	private String nome;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
