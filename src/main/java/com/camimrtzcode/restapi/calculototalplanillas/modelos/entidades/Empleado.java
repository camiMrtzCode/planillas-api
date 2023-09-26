package com.camimrtzcode.restapi.calculototalplanillas.modelos.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Empleado {
	
	@Id
	@GeneratedValue
	public Integer id;
	
	public String nombre;
	public float montoMensual;
	public boolean activo;
	
	public Empleado() { }

	public Empleado(Integer id, String nombre, float montoMensual, boolean activo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.montoMensual = montoMensual;
		this.activo = activo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getMontoMensual() {
		return montoMensual;
	}

	public void setMontoMensual(float montoMensual) {
		this.montoMensual = montoMensual;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", montoMensual=" + montoMensual + ", activo=" + activo
				+ "]";
	}
}
