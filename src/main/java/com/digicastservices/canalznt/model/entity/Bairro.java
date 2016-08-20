package com.digicastservices.canalznt.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="BAIRRO_TB")
public class Bairro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_BAIRRO")
	private long id;

	@JoinColumn(name="FK_ID_UF")
	private Uf uf;
	
	@ManyToOne
	@JoinColumn(name="FK_ID_LOCALIDADE")
	private Localidade localidade;
	
	@Column(name="CEPINICIAL")
	private String cepInicial;
	
	@Column(name="CEPFINAL")
	private String cepFinal;
	
	@Column(name="DESCRICAO")
	private String     descricao;
	

	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public Uf getUf() {
		return uf;
	}
	public void setUf(Uf uf) {
		this.uf = uf;
	}
	
	public Localidade getLocalidade() {
		return localidade;
	}
	public void setLocalidade(Localidade localidade) {
		this.localidade = localidade;
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
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}