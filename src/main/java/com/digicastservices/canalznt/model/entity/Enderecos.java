package com.digicastservices.canalznt.model.entity;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name="enderecos_tb")
public class Enderecos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer        id;
	private TipoLogradouro tipoLogradouro;
	private String         logradouro;
	private String         numero;
	private String         complemento;
	private String         cep;
	private String         bairro;
	private Localidade     localidade;
	private Uf             uf;
	
	
	
	
	@Column(name="id_endereco")
	public Integer getId() {
		return id;
	}
	private void setId(Integer id) {
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
	
	@Column(name="logradouro")
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	
	@Column(name="numero")
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	@Column(name="complemento")
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	@Column(name="cep")
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	@Column(name="bairro")
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	@ManyToOne
	@JoinColumn(name="fk_id_localidade")
	public Localidade getLocalidade() {
		return localidade;
	}
	public void setLocalidade(Localidade localidade) {
		this.localidade = localidade;
	}
	
	@ManyToOne
	@JoinColumn(name="fk_id_uf")
	public Uf getUf() {
		return uf;
	}
	public void setUf(Uf uf) {
		this.uf = uf;
	}
 



}
