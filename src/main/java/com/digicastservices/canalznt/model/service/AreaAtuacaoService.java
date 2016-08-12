package com.digicastservices.canalznt.model.service;

import java.util.ArrayList;

import com.digicastservices.canalznt.model.entity.AreaAtuacao;

public class AreaAtuacaoService 
{
  public static final String NOME_N_INFORMADO = "Nome não foi informado";
  public static final String NOME_PEQUENO = "Nome muito pequeno (<5)";
  public static final String NOME_GRANDE = "Nome muito grande (>100)";
	
  private ArrayList<String> _listaMsg;
  
  public AreaAtuacaoService()
  {
	  _listaMsg= new ArrayList<String>();
  }
  
  public ArrayList<String> getListaMsg()
  {
	return  _listaMsg;
  }
	
  public void novo(AreaAtuacao areaAtuacao)
  {
	  
    if(!validar(areaAtuacao)) return;
	  
	  
  }
  
  
  
  
  private boolean validar(AreaAtuacao areaAtuacao)
  {
	   boolean isOk=true;
	  _listaMsg= new ArrayList<String>(); 
	  
	  if(areaAtuacao.getNome()==null)
	  {
		  _listaMsg.add(NOME_N_INFORMADO);
	      return false;
	  }
	  
	  if( areaAtuacao.getNome().trim().isEmpty())
	  {
		  _listaMsg.add(NOME_N_INFORMADO);
		  return false;
	  }
	  
	  if(areaAtuacao.getNome().trim().length()<5)
	  {
		  _listaMsg.add(NOME_PEQUENO);
	  }
	  
	  if(areaAtuacao.getNome().trim().length()>100)
	  {
		  _listaMsg.add(NOME_GRANDE);
	  }
	  
	  
	  return _listaMsg.isEmpty();
  }
  
}
