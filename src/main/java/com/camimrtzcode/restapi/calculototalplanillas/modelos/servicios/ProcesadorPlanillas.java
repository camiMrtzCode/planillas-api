package com.camimrtzcode.restapi.calculototalplanillas.modelos.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import com.camimrtzcode.restapi.calculototalplanillas.modelos.entidades.Empleado;


@Service
public class ProcesadorPlanillas {
	
	private final ProveedorMiembrosPlanilla proveedorMiembrosPlanilla;

	public ProcesadorPlanillas(ProveedorMiembrosPlanilla proveedorMiembrosPlanilla) {
        this.proveedorMiembrosPlanilla = proveedorMiembrosPlanilla;
    }

    public float calcularTotalPagar() {
        float totalPagar = 0;
        List<Empleado> empleados = proveedorMiembrosPlanilla.obtenerEmpleadosPlanilla();
        int numEmpleados = empleados.size();
        for (int i = 0; i < numEmpleados; i++) {
        	Empleado empl = empleados.get(i);
            if (empl.isActivo()) {
                if (empl.getMontoMensual() < 0 || empl.getId() == 0 || empl.getNombre().isEmpty()) {
                    throw new IllegalArgumentException("Datos de empleado no válidos");
                }
                totalPagar += empl.getMontoMensual();
            }
        }

        return totalPagar;
    }
}
