package com.digicastservices.canalznt.teste.model.servico;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.digicastservices.canalznt.model.entity.AreaAtuacao;
import com.digicastservices.canalznt.model.entity.Associado;
import com.digicastservices.canalznt.model.service.AreaAtuacaoService;
import com.digicastservices.canalznt.model.service.AssociadoService;

public class AssociadoServiceTest 
{
	@InjectMocks 
	private AssociadoService  _associadoService;
	
	@Before
	public void setUp() throws Exception
	{
		 MockitoAnnotations.initMocks(this);
	
	}
	
	 /**************************************************************
	  *  NOVO (CRIAR)
	  **************************************************************/
	@Test 
	public void  novo_falha_nome_nao_informado_null_lista_mensagem_nao_vazia()
	{
		
		 _testaNomeVazio(true,null);
		 _testaNomeVazio(true,"");
		 _testaNomeVazio(true,new String(new char[] {32}) );
		
	}
	
	private void _testaNomeVazio(boolean isInc,String nome)
	{
        if(isInc)
        {
        	 Associado a= new Associado();
             a.setNome(nome);
        	_associadoService.novo(a);	
        }
        else
        {
         //	_associadoService.alterar(1, nome);  
        }
		
		ArrayList<String>  listaMsg=_associadoService.getListaMsg();
		
		assertTrue("Lista Vazia", !listaMsg.isEmpty());
		assertTrue("Nome Nao Informado+"+nome,listaMsg.contains(AreaAtuacaoService.NOME_N_INFORMADO));		
	
	}
	
}
