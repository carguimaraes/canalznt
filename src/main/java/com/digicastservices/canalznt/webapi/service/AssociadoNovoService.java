package com.digicastservices.canalznt.webapi.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.digicastservices.canalznt.model.dao.IAssociadoDao;
import com.digicastservices.canalznt.model.dao.IAssociadoRepositorio;
import com.digicastservices.canalznt.model.entity.Associado;
import com.digicastservices.canalznt.webapi.dto.AssociadoDto;

 

@Service
public class AssociadoNovoService {
	
	 @Autowired
      private  IAssociadoDao dao;
  
      @Autowired
      private  IAssociadoRepositorio repositorio;
      
      
	
	public void execute(AssociadoDto associadoDto)
	{
		 Associado a= new Associado();
		 a.setNome(associadoDto.nome);
	 
		 repositorio.save(a);
		
		// dao.adicionar(a);
	}
	
	public List<AssociadoDto> getLista()
	{
		
		List<Associado> lista =repositorio.findAll();
		List<AssociadoDto> listadto = new  ArrayList<AssociadoDto>(); 
		
		for(Associado a : lista)
		{
		 AssociadoDto dto= new AssociadoDto();
		 dto.id=a.getId();
		 dto.nome=a.getNome();
		 listadto.add(dto);
		}
	    
		return listadto;
	}

}
