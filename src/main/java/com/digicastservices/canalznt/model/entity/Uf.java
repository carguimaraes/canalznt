package com.digicastservices.canalznt.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="UF_TB")
public class Uf {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_UF")
	private long id;
	
	@Column(name="UF")
	private String uf;
	
	@Column(name="DESCRICAO")
	private String descricao;
	
	@Column(name="CEPINICIAL")
	private String cepInicial;
	
	@Column(name="CEPFINAL")
	private String cepFinal;
	

	
	public long getId() {
		return id;
	}

	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCepInicial() {
		return cepInicial;
	}
	public void setCepInicial(String cepInicial) {
		this.cepInicial = cepInicial;
	}
	
	public String getCepFinal() {
		return cepFinal;
	}
	public void setCepFinal(String cepFinal) {
		this.cepFinal = cepFinal;
	}
	
	
}