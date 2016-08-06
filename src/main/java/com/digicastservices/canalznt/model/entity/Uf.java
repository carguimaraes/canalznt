package com.digicastservices.canalznt.model.entity;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name="uf_tb")
public class Uf {

	
	private long   id;
	private String uf;
	private String descricao;
	private String cepInicial;
	private String cepFinal;
	
	@Column(name="id")
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name="uf")
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	
	@Column(name="descricao")
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Column(name="cepInicial")
	public String getCepInicial() {
		return cepInicial;
	}
	public void setCepInicial(String cepInicial) {
		this.cepInicial = cepInicial;
	}
	
	@Column(name="cepFinal")
	public String getCepFinal() {
		return cepFinal;
	}
	public void setCepFinal(String cepFinal) {
		this.cepFinal = cepFinal;
	}
	
	
	
	
}