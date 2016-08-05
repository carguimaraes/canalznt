package com.digicastservices.canalznt.model.entity;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name="bairro_tb")
public class Bairro {
	
	private long       id;
	private Uf         uf;
	private Localidade localidade;
	private String     descricao;
	private String     cepInicial;
	private String     cepFinal;
	
	
	@Column(name="id")
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@ManyToOne
	@JoinColumn(name="fk_id_uf")
	public Uf getUf() {
		return uf;
	}
	public void setUf(Uf uf) {
		this.uf = uf;
	}
	
	@ManyToOne
	@JoinColumn(name="fk_id_localidade")
	public Localidade getLocalidade() {
		return localidade;
	}
	public void setLocalidade(Localidade localidade) {
		this.localidade = localidade;
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