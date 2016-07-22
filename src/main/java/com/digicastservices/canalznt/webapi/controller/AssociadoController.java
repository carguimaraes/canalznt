package com.digicastservices.canalznt.webapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.digicastservices.canalznt.webapi.dto.AssociadoDto;

//http://localhost:8088/canalznt/api/v1/associados
@RestController
@RequestMapping("api/v1")
public class AssociadoController {

	@RequestMapping(value = "/associados", method = RequestMethod.GET)
    public ResponseEntity<List<AssociadoDto>> getListaAssociado() {
		
		 List<AssociadoDto> listaAssociado =  new ArrayList<AssociadoDto>();  
		
           return new ResponseEntity<List<AssociadoDto>>(listaAssociado, HttpStatus.OK);
    }
	
}
