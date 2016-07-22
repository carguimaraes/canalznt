package com.digicastservices.canalznt.webapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.digicastservices.canalznt.model.dao.IAssociadoDao;
import com.digicastservices.canalznt.model.entity.Associado;

@Service
public class AssociadoNovoService {
	
      private final IAssociadoDao dao;
  
	  @Autowired
	  public AssociadoNovoService(IAssociadoDao prdao)
	  {
		  this.dao=prdao;
	 }
	
	public void execute()
	{
		 Associado a= new Associado();
		 a.setNome("Associado 05");
		
		 dao.adicionar(a);
	}

}
