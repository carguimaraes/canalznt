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
	
	@RequestMapping(value = "/associados/", method = RequestMethod.GET)
    public ResponseEntity<List<AssociadoDto>> getListaAssociado() {
		 
		 
		 
		 List<AssociadoDto> listaAssociado =novoService.getLista();
		 
		 if(listaAssociado.isEmpty())
		 {
	            return new ResponseEntity<List<AssociadoDto>>(HttpStatus.NOT_FOUND);
	     }
		 
         return new ResponseEntity<List<AssociadoDto>>(listaAssociado, HttpStatus.OK);
    }
	
	    @RequestMapping(value = "/associados/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<AssociadoDto> getUser(@PathVariable("id") long id) {
		 
	        System.out.println("Associado id " + id);
	        AssociadoDto associadoDto= new AssociadoDto();
	        associadoDto.nome="Retornado";
	       /* 
	        User user = userService.findById(id);
	        if (user == null) {
	            System.out.println("User with id " + id + " not found");
	            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	        }
	        */
	        return new ResponseEntity<AssociadoDto>(associadoDto, HttpStatus.OK);
	    }
	 
	
	
    @RequestMapping(value = "/associados/", method = RequestMethod.POST,  consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> criarAssociado(@RequestBody AssociadoDto associadoDto) {
		 
		 novoService.execute(associadoDto);
	      //  System.out.println("Creating User " + user.getName());
	 
	     //   if (userService.isUserExist(user)) {
	     //       System.out.println("A User with name " + user.getName() + " already exist");
	     //       return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	     //   }
	 
	    //    userService.saveUser(user);
	 
	      //  HttpHeaders headers = new HttpHeaders();
	      //  headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand("1"));
	        return new ResponseEntity<Void>( HttpStatus.CREATED);
	    }
    
    


}
