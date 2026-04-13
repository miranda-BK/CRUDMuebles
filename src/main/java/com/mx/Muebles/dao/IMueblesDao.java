package com.mx.Muebles.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.Muebles.dominio.Muebles;

public interface IMueblesDao extends JpaRepository<Muebles, Integer>{
	
	Muebles findByTipoIgnoreCase(String tipo);
	
	List<Muebles> findByAreaIgnoreCase(String area);

}
