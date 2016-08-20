package com.digicastservices.canalznt.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Membro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_MEMBRO")
	private long id;
	
	@ManyToOne
	@JoinColumn(name="FK_ID_PESSOA")
	private Pessoa idPessoa;	
	
	
	
	
	public long getId() {
		return id;
	}

	public Pessoa getIdPessoa() {
		return idPessoa;
	}
	public void setIdPessoa(Pessoa idPessoa) {
		this.idPessoa = idPessoa;
	}


}
