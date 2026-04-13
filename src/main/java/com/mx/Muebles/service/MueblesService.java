package com.mx.Muebles.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mx.Muebles.dao.IMueblesDao;
import com.mx.Muebles.dominio.Muebles;

@Service
public class MueblesService implements IMueblesService {
	
	@Autowired
	private IMueblesDao dao;

	@Override
	public Muebles guardar(Muebles m) {
		return dao.save(m);
	}

	@Override
	public Muebles editar(Muebles m) {
		return dao.save(m);
	}

	@Override
	public Muebles buscar(int id) {
		return dao.findById(id).orElse(null);
	}

	@Override
	public void eliminar(int id) {
		dao.deleteById(id);
	}

	@Override
	public List<Muebles> listar() {
		return dao.findAll(Sort.by(Sort.Direction.DESC, "id"));
	}
	
	public Muebles buscarPorTipo(String tipo) {
		return dao.findByTipoIgnoreCase(tipo);
	}
	
	public List<Muebles> buscarPorArea(String area){
		return dao.findByAreaIgnoreCase(area);
	} 
	 
	

}
