package com.mx.Muebles.service;

import java.util.List;

import com.mx.Muebles.dominio.Muebles;

public interface IMueblesService {
	
	Muebles guardar(Muebles m);
	
	Muebles editar(Muebles m);
	
	Muebles buscar(int id);
	
	void eliminar(int id);
	
	List<Muebles> listar();

}
