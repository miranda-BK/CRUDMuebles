package com.mx.Muebles.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "MUEBLES_DB")
@Data
public class Muebles {
	
	@Id
	private int id;
	private String tipo;
	private String marca;
	private String area;
	private double precio;
	private int stock;

}
