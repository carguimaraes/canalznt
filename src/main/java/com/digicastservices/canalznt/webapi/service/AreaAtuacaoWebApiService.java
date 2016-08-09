package com.digicastservices.canalznt.webapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.digicastservices.canalznt.model.dao.IAreaAtuacaoRepositorio;
import com.digicastservices.canalznt.model.entity.AreaAtuacao;
import com.digicastservices.canalznt.webapi.dto.AreaAtuacaoDto;


@Service
public class AreaAtuacaoWebApiService 
{
 
	 @Autowired
     private  IAreaAtuacaoRepositorio _repositorio;
	 
	 public  ApiServiceRetorno criarAreaAtuacao(AreaAtuacaoDto areaAtuacaoDto)
		{
			 AreaAtuacao a= new AreaAtuacao();
			 a.setNome(areaAtuacaoDto.nome);
		 	 
			 _repositorio.save(a);
			
			return ApiServiceRetorno.getApiServiceRetorno(HttpStatus.CREATED , null);
		}
		
		
		public  ApiServiceRetorno alterarAreaAtuacao(AreaAtuacaoDto areaAtuacaoDto, long id)
		{
			   AreaAtuacao a=  _repositorio.findOne(id);
			   if(a==null)
			   {
				   return ApiServiceRetorno.FalhaRetornoVazioOuNaoEncontrado(new String[] {"Area de atuação não encontrada"});
			   }
			 
			 a.setNome(areaAtuacaoDto.nome);
		 
			 
			 _repositorio.save(a);
			
			return ApiServiceRetorno.getApiServiceRetorno(HttpStatus.OK , null);
		}
		
		
		
		public ApiServiceRetorno getListaAreaAtuacao()
		{
			
			List<AreaAtuacao> lista =_repositorio.findAll();
			List<AreaAtuacaoDto> listadto = new  ArrayList<AreaAtuacaoDto>(); 
			
			for(AreaAtuacao a : lista)
			{
			 AreaAtuacaoDto dto= new AreaAtuacaoDto();
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

		public ApiServiceRetorno getAreaAtuacao(long id)
		{
			
			   AreaAtuacao a=  _repositorio.findOne(id);
			   if(a==null)
			   {
				   return ApiServiceRetorno.FalhaRetornoVazioOuNaoEncontrado(new String[] {"Area de atuação não encontrada"});
			   }
		
		        AreaAtuacaoDto areaAtuacaoDto= new AreaAtuacaoDto();
		        areaAtuacaoDto.id=a.getId();
		        areaAtuacaoDto.nome=a.getNome();
		       
		        
		        return ApiServiceRetorno.Sucesso(areaAtuacaoDto);
		}
}
