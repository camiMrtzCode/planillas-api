package com.camimrtzcode.restapi.calculototalplanillas.modelos.servicios;

import java.util.List;

import org.springframework.stereotype.Component;

import com.camimrtzcode.restapi.calculototalplanillas.modelos.entidades.Empleado;
import com.camimrtzcode.restapi.calculototalplanillas.modelos.jpa.EmpleadoRepository;

@Component
public class ProveedorMiembrosPlanillaImpl implements ProveedorMiembrosPlanilla {
	
	private EmpleadoRepository emplService;
	
	public ProveedorMiembrosPlanillaImpl(EmpleadoRepository emplRepository) {
		this.emplService = emplRepository;
	}
	
	@Override
	public List<Empleado> obtenerEmpleadosPlanilla() {
		return emplService.findAll();
	}

}
