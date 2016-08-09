package com.digicastservices.canalznt.webapi.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.digicastservices.canalznt.model.dao.IAssociadoDao;
import com.digicastservices.canalznt.model.dao.IAssociadoRepositorio;
import com.digicastservices.canalznt.model.entity.Associado;
import com.digicastservices.canalznt.webapi.dto.AssociadoDto;

 

@Service
public class AssociadoWebApiService {
	
	// @Autowired
    //  private  IAssociadoDao dao;
  
      @Autowired
      private  IAssociadoRepositorio _repositorio;
            
	
	public  ApiServiceRetorno criarAssociado(AssociadoDto associadoDto)
	{
		 Associado a= new Associado();
		 a.setNome(associadoDto.nome);
	 
		 
		 //TODO verificar CNPJ
	   //  if (_repositorio.exists(1L)) 
	   //  {
	   // 	return ApiServiceRetorno.getApiServiceRetorno(HttpStatus.CONFLICT, new String[] {"CNPJ ja cadastrado"});
	   //   
	   //   }
	 
	   
	      //  headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand("1"));
		 		 
		 
		 _repositorio.save(a);
		
		return ApiServiceRetorno.getApiServiceRetorno(HttpStatus.CREATED , null);
	}
	
	
	public  ApiServiceRetorno alterarAssociado(AssociadoDto associadoDto, long id)
	{
		   Associado a=  _repositorio.findOne(id);
		   if(a==null)
		   {
			   return ApiServiceRetorno.FalhaRetornoVazioOuNaoEncontrado(new String[] {"Associado não encontrado"});
		   }
		 
		 
		 
		 a.setNome(associadoDto.nome);
		 
	 
		 
		 //TODO verificar CNPJ
	   //  if (_repositorio.exists(1L)) 
	   //  {
	   // 	return ApiServiceRetorno.getApiServiceRetorno(HttpStatus.CONFLICT, new String[] {"CNPJ ja cadastrado"});
	   //   
	   //   }
	 	 		 
		 
		 _repositorio.save(a);
		
		return ApiServiceRetorno.getApiServiceRetorno(HttpStatus.OK , null);
	}
	
	
	
	public ApiServiceRetorno getListaAssociado()
	{
		
		List<Associado> lista =_repositorio.findAll();
		List<AssociadoDto> listadto = new  ArrayList<AssociadoDto>(); 
		
		for(Associado a : lista)
		{
		 AssociadoDto dto= new AssociadoDto();
		 dto.id=a.getId();
		 dto.nome=a.getNome();
		 listadto.add(dto);
		}
	    
		if(listadto.isEmpty())
		{
		   return	ApiServiceRetorno.FalhaRetornoVazioOuNaoEncontrado(new String[] {"Informação não encontrada"});
		}
		else
		{
		  return	ApiServiceRetorno.Sucesso(listadto);
		 	
		}
		
		
		
		
	}

	public ApiServiceRetorno getAssociado(long id)
	{
		
		   Associado a=  _repositorio.findOne(id);
		   if(a==null)
		   {
			   return ApiServiceRetorno.FalhaRetornoVazioOuNaoEncontrado(new String[] {"Associado não encontrado"});
		   }
	
	        AssociadoDto associadoDto= new AssociadoDto();
	        associadoDto.id=a.getId();
	        associadoDto.nome=a.getNome();
	       
	        
	        return ApiServiceRetorno.Sucesso(associadoDto);
	}
	
}
