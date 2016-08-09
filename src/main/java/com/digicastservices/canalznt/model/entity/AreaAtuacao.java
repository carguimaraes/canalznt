package com.digicastservices.canalznt.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AREA_ATUACAO_TB")
public class AreaAtuacao 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_AREA_ATUACAO")
	private Integer id;
 
	@Column(name="NOME")	
	private String  nome;
	
	public Integer getId() {
		return id;
	}
 
	private void setId(Integer id) {
		this.id = id;
	}
 
	public String getNome() {
		return nome;
	}
 
	public void setNome(String nome) {
		this.nome = nome;
	}
}
