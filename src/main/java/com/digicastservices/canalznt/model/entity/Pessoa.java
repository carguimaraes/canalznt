package com.digicastservices.canalznt.model.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PESSOA_TB")
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name="ID_PESSOA")
	private Long id;
	
	@Column(name="NOME")
	private String nome;
	
	@Column(name="CGCCPF")
	private String cgccpf;
	
	@Enumerated(EnumType.STRING)
	@Column(name="TIPOPESSOA")
	private TipoPessoa tipoPessoa;
	
	@Column(name="SENHA")
	private String senha;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="LEMBRETE")
	private String lembrete;
	
	@Column(name="RESPOSTA")
	private String resposta;
	
	@Column(name="DATACADASTRO")
	private Calendar   dataCadastro;
	
	@Column(name="DATAALTERACAO")
	private Calendar   dataAlteracao;
	
	

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
	
	public String getCgccpf() {
		return cgccpf;
	}
	public void setCgccpf(String cgccpf) {
		this.cgccpf = cgccpf;
	}
	
	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}
	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getLembrete() {
		return lembrete;
	}
	public void setLembrete(String lembrete) {
		this.lembrete = lembrete;
	}
	
	public String getResposta() {
		return resposta;
	}
	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	public Calendar getDataAlteracao() {
		return dataAlteracao;
	}
	public void setDataAlteracao(Calendar dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}



}
