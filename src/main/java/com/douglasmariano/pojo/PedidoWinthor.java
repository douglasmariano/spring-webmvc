package com.douglasmariano.pojo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PedidoWinthor {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private Integer numped;

	private String cliente;
	
	private Date data;
			
	private String vendedor;
	
	private String observacao;
	
	private String posicao;
	
	private String valor;
	
	private Integer codCliente;
	
	private Integer hora;
	
	private Integer minuto;
	
	private Integer codVendedor;
	
	private Integer peso;
	
	private Integer volume;
	
	private Integer numNota;
	
	private Integer numVias;
	
	private Date inicioPedido;
	
	private Date fimPedido;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumped() {
		return numped;
	}

	public void setNumped(Integer numped) {
		this.numped = numped;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getVendedor() {
		return vendedor;
	}

	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getPosicao() {
		return posicao;
	}

	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Integer getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(Integer codCliente) {
		this.codCliente = codCliente;
	}

	public Integer getHora() {
		return hora;
	}

	public void setHora(Integer hora) {
		this.hora = hora;
	}

	public Integer getMinuto() {
		return minuto;
	}

	public void setMinuto(Integer minuto) {
		this.minuto = minuto;
	}



	public Integer getPeso() {
		return peso;
	}

	public void setPeso(Integer peso) {
		this.peso = peso;
	}

	public Integer getVolume() {
		return volume;
	}

	public void setVolume(Integer volume) {
		this.volume = volume;
	}

	public Integer getNumNota() {
		return numNota;
	}

	public void setNumNota(Integer numNota) {
		this.numNota = numNota;
	}

	public Date getInicioPedido() {
		return inicioPedido;
	}

	public void setInicioPedido(Date inicioPedido) {
		this.inicioPedido = inicioPedido;
	}

	public Date getFimPedido() {
		return fimPedido;
	}

	public void setFimPedido(Date fimPedido) {
		this.fimPedido = fimPedido;
	}

	public Integer getNumVias() {
		return numVias;
	}

	public void setNumVias(Integer numVias) {
		this.numVias = numVias;
	}

	public Integer getCodVendedor() {
		return codVendedor;
	}

	public void setCodVendedor(Integer codVendedor) {
		this.codVendedor = codVendedor;
	}
	
	


	
	
}