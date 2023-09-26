package com.camimrtzcode.restapi.calculototalplanillas.modelos.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.camimrtzcode.restapi.calculototalplanillas.modelos.entidades.Empleado;


public interface EmpleadoRepository extends JpaRepository<Empleado, Integer>{
}
