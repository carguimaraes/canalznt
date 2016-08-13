package com.digicastservices.canalznt.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digicastservices.canalznt.model.dao.IAreaAtuacaoRepositorio;
import com.digicastservices.canalznt.model.entity.AreaAtuacao;
import com.digicastservices.canalznt.model.entity.Associado;

@Service
public class AreaAtuacaoService 
{
  public static final String NOME_N_INFORMADO = "Nome não foi informado";
  public static final String NOME_PEQUENO = "Nome muito pequeno (<5)";
  public static final String NOME_GRANDE = "Nome muito grande (>100)";
  public static final String AREA_ATUACAO_N_ENCONTRADA = "Area atuação não encontrada";
	
  private ArrayList<String> _listaMsg;
  
  @Autowired
  private  IAreaAtuacaoRepositorio _repositorio;
  
 // @Autowired
  //public AreaAtuacaoService(IAreaAtuacaoRepositorio repositorio)
  public AreaAtuacaoService()
  {
//	  _repositorio=repositorio;
	  _listaMsg= new ArrayList<String>();
  }
  
  public ArrayList<String> getListaMsg()
  {
	return  _listaMsg;
  }
	
  public void novo(AreaAtuacao areaAtuacao)
  {
	  
    if(!validar(areaAtuacao.getNome())) return;
	  
	 _repositorio.save(areaAtuacao);
  }
  
  public void alterar(long id, String nome)
  {
	 
	  AreaAtuacao areaAtuacao=   _repositorio.findOne(id);
	  
	  if(areaAtuacao==null)
	  {
		  _listaMsg= new ArrayList<String>();
		  _listaMsg.add(AREA_ATUACAO_N_ENCONTRADA);
		  return;
	  }
	  
	  if(!validar(nome)) return;
	
	  areaAtuacao.setNome(nome);
	  _repositorio.save(areaAtuacao);
	  
  }
  
  
  
  private boolean validar(String nome)
  {
	   boolean isOk=true;
	  _listaMsg= new ArrayList<String>(); 
	  
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
