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
@Table(name="LOGRADOURO_TB")
public class Logradouro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_LOGRADOURO")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="FK_ID_TIPO_LOGRADOURO")
	private TipoLogradouro tipoLogradouro;
	
	@ManyToOne
	@JoinColumn(name="FK_ID_LOCALIDADE")
	private Localidade localidade;
	
	@ManyToOne
	@JoinColumn(name="FK_ID_BAIRRO")
	private Bairro bairro;	
	
	@ManyToOne
	@JoinColumn(name="FK_ID_UF")
	private Uf uf;
	
	@Column(name="NUMINICIO")
	private Long numInicio;
	
	@Column(name="NUMFINAL")
	private Long numFinal;
	
	@Column(name="PAR")
	private boolean par;
	
	@Column(name="IMPAR")
	private boolean impar;
	
	@Column(name="CEP")
	private String cep;
	
	@Column(name="DESCRICAO")
	private String descricao;
	



	public Long getId() {
		return id;
	}

	public TipoLogradouro getTipoLogradouro() {
		return tipoLogradouro;
	}
	public void setTipoLogradouro(TipoLogradouro tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}
	
	public Localidade getLocalidade() {
		return localidade;
	}
	public void setLocalidade(Localidade localidade) {
		this.localidade = localidade;
	}
	
	public Bairro getBairro() {
		return bairro;
	}
	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}	
	
	public Uf getUf() {
		return uf;
	}
	public void setUf(Uf uf) {
		this.uf = uf;
	}
	
	public Long getNumInicio() {
		return numInicio;
	}
	public void setNumInicio(Long numInicio) {
		this.numInicio = numInicio;
	}

	public Long getNumFinal() {
		return numFinal;
	}
	public void setNumFinal(Long numFinal) {
		this.numFinal = numFinal;
	}

	public boolean isPar() {
		return par;
	}
	public void setPar(boolean par) {
		this.par = par;
	}

	public boolean isImpar() {
		return impar;
	}
	public void setImpar(boolean impar) {
		this.impar = impar;
	}
	
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


}