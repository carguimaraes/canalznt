package com.digicastservices.canalznt.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digicastservices.canalznt.model.entity.AreaAtuacao;

@Repository
public interface IAreaAtuacaoRepositorio extends JpaRepository<AreaAtuacao, Long>  
{

}
