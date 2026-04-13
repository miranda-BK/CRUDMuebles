package com.mx.Muebles.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mx.Muebles.dominio.Muebles;
import com.mx.Muebles.service.MueblesService;

@RestController
@RequestMapping("Muebles")
@CrossOrigin
public class MueblesWS {
	
	@Autowired
	private MueblesService service;
	
	/* ResponseEntity es una clase que representa toda la 
	 * repuesta HTTP completa, es decir: cabecera, cuerpo y estatus.
	 */
	@GetMapping("listar")
	public ResponseEntity<List<Muebles>> listar(){
		List<Muebles> lista = service.listar();
		
		if(lista.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}else {
			return ResponseEntity.status(HttpStatus.OK).body(lista);
		}
	}
	
	@PostMapping("guardar")
	public ResponseEntity<?> guardar(@RequestBody Muebles m){
		Muebles aux = service.buscar(m.getId());
		
		if (aux == null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(m));
		}else {
			return ResponseEntity.status(HttpStatus.CONFLICT)
					.body("Error: Ese ID ya existe, intenta con otro.");
		}
	} 
	
	@GetMapping("buscar/{id}")
	public ResponseEntity<Muebles> buscar(@PathVariable int id){
		Muebles aux = service.buscar(id);
		
		if(aux == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}else {
			return ResponseEntity.status(HttpStatus.OK).body(aux);
		}
	}
	
	@PutMapping("editar")
	public ResponseEntity<?> editar(@RequestBody Muebles m){
		return ResponseEntity.status(HttpStatus.OK).body(service.editar(m));
	}
	
	@DeleteMapping("eliminar/{id}")
	public ResponseEntity<?> eliminar(@PathVariable int id){
		service.eliminar(id);
		return ResponseEntity.status(HttpStatus.OK).body("Mensaje: Eliminacion exitosa!");
	}
	
	@GetMapping("buscar-tipo/{tipo}")
	public ResponseEntity<Muebles> buscarPorTipo(@PathVariable String tipo){
		Muebles aux = service.buscarPorTipo(tipo);
		
		if(aux == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}else {
			return ResponseEntity.status(HttpStatus.OK).body(aux);
		}
	}
	
	@GetMapping("buscar-area")
	public ResponseEntity<List<Muebles>> buscarPorArea(@RequestParam String area){
		List<Muebles> lista = service.buscarPorArea(area);
		
		if(lista.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}else {
			return ResponseEntity.status(HttpStatus.OK).body(lista); 
		}
	}
	
	
}
