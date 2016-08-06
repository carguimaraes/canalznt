package com.digicastservices.canalznt.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.digicastservices.canalznt.model.entity.Associado;


@Repository
class AssociadoDao implements IAssociadoDao {
  
	@PersistenceContext
    private EntityManager manager;
	
	@Transactional //(propagation = Propagation.REQUIRED)
	 public void adicionar(Associado associado) {
	      manager.persist(associado);
	    
	    }
}
