package com.digicastservices.canalznt.teste.model.servico;

import static org.junit.Assert.*;
import org.mockito.Mockito.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


import java.util.ArrayList;
import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.digicastservices.canalznt.model.dao.IAreaAtuacaoRepositorio;
import com.digicastservices.canalznt.model.entity.AreaAtuacao;
import com.digicastservices.canalznt.model.service.AreaAtuacaoService;

 
public class AreaAtuacaoServiceTest 
{
	@InjectMocks 
	private AreaAtuacaoService  _areaAtuacaoService;
	@Mock
	private IAreaAtuacaoRepositorio _repositorioMock;
	
	@Before
	public void setUp() throws Exception
	{
		 MockitoAnnotations.initMocks(this);
		//_repositorioMock = mock(IAreaAtuacaoRepositorio.class);

	//	_areaAtuacaoService= new AreaAtuacaoService(_repositorioMock);
	}
	
   /**************************************************************
    *  NOVO (CRIAR)
    **************************************************************/
	
	@Test 
	public void  novo_falha_nome_nao_informado_null_lista_mensagem_nao_vazia()
	{
		
		 _testaNomeVazio(null);
		 _testaNomeVazio("");
		 _testaNomeVazio(new String(new char[] {32}) );
		
	}
	
	@Test 
	public void  novo_falha_nome_pequeno_mensagem_nao_vazia()
	{
		
		   AreaAtuacao areaAtuacao= new AreaAtuacao();
	       areaAtuacao.setNome("a ss");
			
			_areaAtuacaoService.novo(areaAtuacao);
			ArrayList<String>  listaMsg=_areaAtuacaoService.getListaMsg();
			
			assertTrue(listaMsg.size()==1);
			assertTrue(listaMsg.contains(AreaAtuacaoService.NOME_PEQUENO));		
		   
		
	}
	
	@Test 
	public void  novo_falha_nome_grande_mensagem_nao_vazia()
	{
		
		  AreaAtuacao areaAtuacao= new AreaAtuacao();
	 
		  
		   areaAtuacao.setNome(StringUtils.repeat('x', 101));
	       
			System.out.println(areaAtuacao.getNome());
			
			_areaAtuacaoService.novo(areaAtuacao);
			ArrayList<String>  listaMsg=_areaAtuacaoService.getListaMsg();
			
			assertTrue(listaMsg.size()==1);
			assertTrue(listaMsg.contains(AreaAtuacaoService.NOME_GRANDE));		
		   
		
	}
	
	@Test 
	public void  novo_sucesso_lista_mensagem_vazia()
	{
		 
		   AreaAtuacao areaAtuacao= new AreaAtuacao();
	       areaAtuacao.setNome("Teste nome valido");
	     
	      when(_repositorioMock.save(any(AreaAtuacao.class))).
	      then( (x) -> {System.out.println("salvandp Area Atuacao"); return "";});
	      
	       
	       //.thenReturn("Using mockito is great");
	       
	       
			_areaAtuacaoService.novo(areaAtuacao);
			ArrayList<String>  listaMsg=_areaAtuacaoService.getListaMsg();
			
			assertTrue(listaMsg.isEmpty());
			Mockito.verify(_repositorioMock).save(areaAtuacao);
			
	}
	
	/**************************************************************
	*  Alterar
	 **************************************************************/
	@Test
	public void alterar_falha_area_atuacao_para_alterar_n_encontrada_lista_mensagem_n_vazia()
	{
		 
		  when(_repositorioMock.findOne(anyLong())).
		  thenReturn(null);
		  
	      
			_areaAtuacaoService.alterar(anyLong(),"1");
			ArrayList<String>  listaMsg=_areaAtuacaoService.getListaMsg();
			
			assertTrue(listaMsg.size()==1);
			assertTrue(listaMsg.contains(AreaAtuacaoService.AREA_ATUACAO_N_ENCONTRADA));	
	}
	
	
	private void _testaNomeVazio(String nome)
	{
        AreaAtuacao areaAtuacao= new AreaAtuacao();
        areaAtuacao.setNome(nome);
		
		_areaAtuacaoService.novo(areaAtuacao);
		ArrayList<String>  listaMsg=_areaAtuacaoService.getListaMsg();
		
		assertTrue(!listaMsg.isEmpty());
		assertTrue(listaMsg.contains(AreaAtuacaoService.NOME_N_INFORMADO));		
	
	}
	
}
