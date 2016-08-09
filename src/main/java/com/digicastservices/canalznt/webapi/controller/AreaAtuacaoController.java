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

import com.digicastservices.canalznt.webapi.dto.AreaAtuacaoDto;
import com.digicastservices.canalznt.webapi.dto.AssociadoDto;
import com.digicastservices.canalznt.webapi.service.ApiServiceRetorno;
import com.digicastservices.canalznt.webapi.service.AreaAtuacaoWebApiService;
import com.digicastservices.canalznt.webapi.service.AssociadoWebApiService;



//http://localhost:8088/canalznt/api/v1/areasatuacao
@RestController
@RequestMapping("api/v1")
public class AreaAtuacaoController {
	
	private  AreaAtuacaoWebApiService _areaAtuacaoWebApiService;
	
	@Autowired
	public void setAreaAtuacaoWebApiService(AreaAtuacaoWebApiService areaAtuacaoWebApiService)
	{
		this._areaAtuacaoWebApiService=areaAtuacaoWebApiService;
	}
	
	@RequestMapping(value = "/areasatuacao/", method = RequestMethod.GET)
    public ResponseEntity<Object> getListAreaAtuacao() 
	{
	     
		 ApiServiceRetorno s=  _areaAtuacaoWebApiService.getListaAreaAtuacao();
		 
         return new ResponseEntity<Object>(s.ObterRetorno(), s.ObterHttpStatusCode());
    }
	
    @RequestMapping(value = "/areasatuacao/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAreaAtuacao(@PathVariable("id") long id) 
    {
	  	 ApiServiceRetorno s=  _areaAtuacaoWebApiService.getAreaAtuacao(id);
	   	 return new ResponseEntity<Object>(s.ObterRetorno(), s.ObterHttpStatusCode());
	 }
	 
	//Para teste na ferramenta Rest
    // Deve ser colocado no Header
    //  Content-Type - application/json
	//
    @RequestMapping(value = "/areasatuacao/", method = RequestMethod.POST,  consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object>criarAreaAtuacao(@RequestBody AreaAtuacaoDto areaAtuacaoDto) 
    {
	 ApiServiceRetorno s=  _areaAtuacaoWebApiService.criarAreaAtuacao(areaAtuacaoDto);
	     
     return new ResponseEntity<Object>(s.ObterRetorno(), s.ObterHttpStatusCode());
	 }
    
    @RequestMapping(value = "/areasatuacao/{id}", method = RequestMethod.PUT,  consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object>alterarAssociado(@RequestBody AreaAtuacaoDto areaAtuacaoDto,@PathVariable("id") long id) 
    {
	 ApiServiceRetorno s=  _areaAtuacaoWebApiService.alterarAreaAtuacao(areaAtuacaoDto,id);
	     
     return new ResponseEntity<Object>(s.ObterRetorno(), s.ObterHttpStatusCode());
	 }
    


}
