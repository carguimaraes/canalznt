package com.digicastservices.canalznt.teste.cfg;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.digicastservices.canalznt.model.dao.IAreaAtuacaoRepositorio;


//@Configuration
//@Profile("useMocks")
public class GMACfg 
{

   @Mock
   IAreaAtuacaoRepositorio beanA;
   
   public GMACfg() {
       MockitoAnnotations.initMocks(this); //This is a key
   }
   
	
	@Bean
    public IAreaAtuacaoRepositorio nameService() {
        //return Mockito.mock(IAreaAtuacaoRepositorio.class);
        //Teste ajsute 
		//Teste ajuste git xxx
        return beanA;
    }
	
	private void nada()
	{
		//Teste para inettação continua 004
	}
}
