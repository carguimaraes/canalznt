package com.digicastservices.canalznt.teste.model.servico;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;

import com.digicastservices.canalznt.model.entity.AreaAtuacao;
import com.digicastservices.canalznt.model.service.AreaAtuacaoService;

 
public class AreaAtuacaoServiceTest 
{
	private AreaAtuacaoService  _areaAtuacaoService;
	
	@Before
	public void setUp() throws Exception
	{
		//TODO conf Mock
		//TODO injetr Mock
		 
		//_votarServicoMock = mock(IVotarServico.class);
				
	//	_votarController=  new VotarController(_votarServicoMock);
		_areaAtuacaoService= new AreaAtuacaoService();
	}
	
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
