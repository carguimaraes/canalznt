package com.digicastservices.canalznt.webapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.digicastservices.canalznt.webapi.dto.AssociadoDto;
import com.digicastservices.canalznt.webapi.service.AssociadoNovoService;



//http://localhost:8088/canalznt/api/v1/associados
@RestController
@RequestMapping("api/v1")
public class AssociadoController {

	
	private  AssociadoNovoService novoService;
	@Autowired
	public void setAssociadoNovoService(AssociadoNovoService novoService)
	{
		this.novoService=novoService;
	}
	
	@RequestMapping(value = "/associados", method = RequestMethod.GET)
    public ResponseEntity<List<AssociadoDto>> getListaAssociado() {
		
		 List<AssociadoDto> listaAssociado =  new ArrayList<AssociadoDto>();  
		
		 novoService.execute();
		 
         return new ResponseEntity<List<AssociadoDto>>(listaAssociado, HttpStatus.OK);
    }
	
}
