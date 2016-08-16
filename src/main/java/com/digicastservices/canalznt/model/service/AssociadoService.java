package com.digicastservices.canalznt.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import com.digicastservices.canalznt.model.dao.IAssociadoRepositorio;
import com.digicastservices.canalznt.model.entity.Associado;

public class AssociadoService 
{
	public static final String NOME_N_INFORMADO = "Nome não foi informado";
    public static final String NOME_PEQUENO = "Nome muito pequeno (<5)";
	public static final String NOME_GRANDE = "Nome muito grande (>100)";
	public static final String ASSOCIADO_N_ENCONTRADO = "Associado não encontrado";
	  
	 private ArrayList<String> _listaMsg;
	 
	 @Autowired
	  private  IAssociadoRepositorio _repositorio;
	  

	  public AssociadoService()
	  {
		  _listaMsg= new ArrayList<String>();
	  }
	  
	  public ArrayList<String> getListaMsg()
	  {
		return  _listaMsg;
	  }
		
	  
	  public void novo(Associado associado)
	  {
		  
	    //if(!validar(areaAtuacao.getNome())) return;
		  
	   // areaAtuacao.setNome(areaAtuacao.getNome().trim());
		 _repositorio.save(associado);
	  }
	  
	  private boolean _validar()
	  {
		 
		  _listaMsg= new ArrayList<String>(); 
		  
		  
		  return _listaMsg.isEmpty();
	  }
	  
	  
	  //TODO retirar e colocar em funcao util - codigo duplicado 
	  private boolean _validarNome(String nome)
	  {
		  
		  if(nome==null)
		  {
			  _listaMsg.add(NOME_N_INFORMADO);
		      return false;
		  }
		  
		  if( nome.trim().isEmpty())
		  {
			  _listaMsg.add(NOME_N_INFORMADO);
			  return false;
		  }
		  
		  if(nome.trim().length()<5)
		  {
			  _listaMsg.add(NOME_PEQUENO);
		  }
		  
		  if(nome.trim().length()>100)
		  {
			  _listaMsg.add(NOME_GRANDE);
		  }
		  
		  
		  return _listaMsg.isEmpty();
	  }
}
