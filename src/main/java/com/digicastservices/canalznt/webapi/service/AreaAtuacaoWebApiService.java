package com.digicastservices.canalznt.webapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.digicastservices.canalznt.model.dao.IAreaAtuacaoRepositorio;
import com.digicastservices.canalznt.model.entity.AreaAtuacao;
import com.digicastservices.canalznt.model.service.AreaAtuacaoService;
import com.digicastservices.canalznt.webapi.dto.AreaAtuacaoDto;


@Service
public class AreaAtuacaoWebApiService 
{
 
	 @Autowired
	 private  AreaAtuacaoService _areaAtuacaoService;
	 @Autowired
	 private  IAreaAtuacaoRepositorio _repositorio;
	 
	  public  ApiServiceRetorno criarAreaAtuacao(AreaAtuacaoDto areaAtuacaoDto)
		{
			 AreaAtuacao a= new AreaAtuacao();
			 a.setNome(areaAtuacaoDto.nome);
		 	 
			 _areaAtuacaoService.novo(a);
			
			if( _areaAtuacaoService.getListaMsg().isEmpty())
			{
				return ApiServiceRetorno.getApiServiceRetorno(HttpStatus.CREATED , null);
			}
			else
			{
				
				return ApiServiceRetorno.FalhaValidacaoSolicitacao(
						 _areaAtuacaoService.getListaMsg().toArray(new String[_areaAtuacaoService.getListaMsg().size()])
						);
			}
			
			
		}
		
		
	  public  ApiServiceRetorno alterarAreaAtuacao(AreaAtuacaoDto areaAtuacaoDto, long id)
	  {
			   AreaAtuacao a=  _repositorio.findOne(id);
			   if(a==null)
			   {
				   return ApiServiceRetorno.FalhaRetornoVazioOuNaoEncontrado(new String[] {"Area de atuação não encontrada"});
			   }
			 
			   _areaAtuacaoService.alterar(id, areaAtuacaoDto.nome);  
				
				if( _areaAtuacaoService.getListaMsg().isEmpty())
				{
					return ApiServiceRetorno.getApiServiceRetorno(HttpStatus.OK, null);
				}
				else
				{
					
					return ApiServiceRetorno.FalhaValidacaoSolicitacao(
							 _areaAtuacaoService.getListaMsg().toArray(new String[_areaAtuacaoService.getListaMsg().size()])
							);
				}
			 
			  
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
