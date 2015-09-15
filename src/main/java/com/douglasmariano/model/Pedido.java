package com.douglasmariano.model;

import java.time.LocalTime;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Pedido {
	
	@Id
	@GeneratedValue
	private Long id;
	

	private Long numped;


	@NotNull(message = "{tarefa.descricao.vazia}")
	@Size(min = 5, max = 45, message = "{tarefa.descricao.pequena}")
	private String descricao;
	
	private boolean finalizado;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Calendar dataFinalizacao;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Calendar dataInicio;
			
	private Separador separador;
	
	
	private Long mediaTempo;
	
	public enum quantidadeSeparado{
		TOTAL,PARCIAL;
	}
		
	
		
	public Long getId() {
		return id;
	}
	
	private Vendedor vendedor;
	
	
	public Long getIdVendedor() {
		return id;
	}
	

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isFinalizado() {
		return finalizado;
	}

	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}

	public Calendar getDataFinalizacao() {
		return dataFinalizacao;
	}

	public void setDataFinalizacao(Calendar dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}

	public Separador getSeparador() {
		return separador;
	}

	public void setSeparador(Separador separador) {
		this.separador = separador;
	}


	public Vendedor getVendedor() {
		return vendedor;
	}


	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	
	public Long getNumped() {
		return numped;
	}


	public void setNumped(Long numped) {
		this.numped = numped;
	}


	public Calendar getDataInicio() {
		return dataInicio;
	}


	public void setDataInicio(Calendar dataInicio) {
		this.dataInicio = dataInicio;
	}


	public String getMediaTempo() {
		return LocalTime.MIN.plusSeconds(mediaTempo).toString();
	}


	public void setMediaTempo(Long mediaTempo) {
		this.mediaTempo = mediaTempo;
	}

	

}
