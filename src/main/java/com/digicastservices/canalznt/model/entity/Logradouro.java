package com.digicastservices.canalznt.model.entity;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name="logradouro_tb")
public class Logradouro {
	
	private Long           id;
	private TipoLogradouro tipoLogradouro;
	private Localidade     localidade;
	private String         descricao;
	private Uf             uf;
	private String         cep;
	private Bairro         bairro;
	private String         numInicio;
	private String         numFinal;
	private boolean        par;
	private boolean        impar;
	
	
	
	@Column(name="id")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@ManyToOne
	@JoinColumn(name="fk_id_tipoLogradouro")
	public TipoLogradouro getTipoLogradouro() {
		return tipoLogradouro;
	}
	public void setTipoLogradouro(TipoLogradouro tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
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
	
	@ManyToOne
	@JoinColumn(name="fk_id_uf")
	public Uf getUf() {
		return uf;
	}
	public void setUf(Uf uf) {
		this.uf = uf;
	}
	
	@Column(name="cep")
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	@ManyToOne
	@JoinColumn(name="fk_id_bairro")
	public Bairro getBairro() {
		return bairro;
	}
	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}
	
	@Column(name="numInicio")
	public String getNumInicio() {
		return numInicio;
	}
	public void setNumInicio(String numInicio) {
		this.numInicio = numInicio;
	}
	
	@Column(name="numFinal")
	public String getNumFinal() {
		return numFinal;
	}
	public void setNumFinal(String numFinal) {
		this.numFinal = numFinal;
	}
	
	@Column(name="par")
	public boolean isPar() {
		return par;
	}
	public void setPar(boolean par) {
		this.par = par;
	}
	
	@Column(name="impar")
	public boolean isImpar() {
		return impar;
	}
	public void setImpar(boolean impar) {
		this.impar = impar;
	}
	
	
	
	
	
	
	
}