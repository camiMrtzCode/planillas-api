package com.camimrtzcode.restapi.calculototalplanillas.modelos.servicios;

import java.util.List;

import com.camimrtzcode.restapi.calculototalplanillas.modelos.entidades.Empleado;

public interface ProveedorMiembrosPlanilla {
	
	List<Empleado> obtenerEmpleadosPlanilla();
}
