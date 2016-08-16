package com.digicastservices.canalznt.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digicastservices.canalznt.model.dao.IAreaAtuacaoRepositorio;
import com.digicastservices.canalznt.model.entity.AreaAtuacao;
import com.digicastservices.canalznt.model.entity.Associado;



@Service
public class AreaAtuacaoService extends AbstractService
{
  public static final String NOME_N_INFORMADO = "Nome não foi informado";
  public static final String NOME_PEQUENO = "Nome muito pequeno (<5)";
  public static final String NOME_GRANDE = "Nome muito grande (>100)";
  public static final String AREA_ATUACAO_N_ENCONTRADA = "Area atuação não encontrada";
	
 
  @Autowired
  private  IAreaAtuacaoRepositorio _repositorio;
  

  public AreaAtuacaoService()
  {
	   
  }
  
  
	
  public void novo(AreaAtuacao areaAtuacao)
  {
	  
    if(!_validar(areaAtuacao.getNome())) return;
	  
    areaAtuacao.setNome(areaAtuacao.getNome().trim());
	 _repositorio.save(areaAtuacao);
  }
  
  public void alterar(long id, String nome)
  {
	 
	  AreaAtuacao areaAtuacao=   _repositorio.findOne(id);
	  
	  if(areaAtuacao==null)
	  {
		  _clearMsg();
		  _addMsg(AREA_ATUACAO_N_ENCONTRADA);
		  return;
	  }
	  
	  if(!_validar(nome)) return;
	
	  areaAtuacao.setNome(nome.trim());
	  _repositorio.save(areaAtuacao);
	  
  }
    
  
  private boolean _validar(String nome)
  {
	  
	  _clearMsg(); 
	  
	  if(nome==null)
	  {
		  _addMsg(NOME_N_INFORMADO);
	      return false;
	  }
	  
	  if( nome.trim().isEmpty())
	  {
		  _addMsg(NOME_N_INFORMADO);
		  return false;
	  }
	  
	  if(nome.trim().length()<5)
	  {
		  _addMsg(NOME_PEQUENO);
	  }
	  
	  if(nome.trim().length()>100)
	  {
		  _addMsg(NOME_GRANDE);
	  }
	  
	  
	  return getListaMsg().isEmpty();
  }
  
}
