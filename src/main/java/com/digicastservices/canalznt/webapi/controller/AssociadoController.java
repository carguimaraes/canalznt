package com.digicastservices.canalznt.webapi.controller;

 
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.digicastservices.canalznt.webapi.dto.AssociadoDto;
import com.digicastservices.canalznt.webapi.service.ApiServiceRetorno;
import com.digicastservices.canalznt.webapi.service.AssociadoWebApiService;



//http://localhost:8088/canalznt/api/v1/associados
@RestController
@RequestMapping("api/v1")
public class AssociadoController {
	
	private  AssociadoWebApiService _associadoWebApiService;
	
	@Autowired
	public void setAssociadoNovoService(AssociadoWebApiService associadoWebApiService)
	{
		this._associadoWebApiService=associadoWebApiService;
	}
	
	@RequestMapping(value = "/associados/", method = RequestMethod.GET)
    public ResponseEntity<Object> getListaAssociado() 
	{
	     
		 ApiServiceRetorno s=  _associadoWebApiService.getListaAssociado();
		 
         return new ResponseEntity<Object>(s.ObterRetorno(), s.ObterHttpStatusCode());
    }
	
    @RequestMapping(value = "/associados/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAssociado(@PathVariable("id") long id) 
    {
	  	 ApiServiceRetorno s=  _associadoWebApiService.getAssociado(id);
	   	 return new ResponseEntity<Object>(s.ObterRetorno(), s.ObterHttpStatusCode());
	 }
	 
	//Para teste na ferramenta Rest
    // Deve ser colocado no Header
    //  Content-Type - application/json
	//
    @RequestMapping(value = "/associados/", method = RequestMethod.POST,  consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object>criarAssociado(@RequestBody AssociadoDto associadoDto) 
    {
	 ApiServiceRetorno s=  _associadoWebApiService.criarAssociado(associadoDto);
	     
     return new ResponseEntity<Object>(s.ObterRetorno(), s.ObterHttpStatusCode());
	 }
    
    @RequestMapping(value = "/associados/{id}", method = RequestMethod.PUT,  consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object>alterarAssociado(@RequestBody AssociadoDto associadoDto,@PathVariable("id") long id) 
    {
	 ApiServiceRetorno s=  _associadoWebApiService.alterarAssociado(associadoDto,id);
	     
     return new ResponseEntity<Object>(s.ObterRetorno(), s.ObterHttpStatusCode());
	 }
    


}
