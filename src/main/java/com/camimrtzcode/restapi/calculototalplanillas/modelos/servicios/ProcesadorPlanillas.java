package com.camimrtzcode.restapi.calculototalplanillas.modelos.servicios;

import java.util.List;

import com.camimrtzcode.restapi.calculototalplanillas.modelos.entidades.Empleado;

public class ProcesadorPlanillas {
	
//	private final ProveedorMiembrosPlanilla proveedorMiembrosPlanilla;

    
//    public ProcesadorPlanillas(ProveedorMiembrosPlanilla proveedorMiembrosPlanilla) {
//        this.proveedorMiembrosPlanilla = proveedorMiembrosPlanilla;
//    }
//
//    public float calcularTotalPagar() {
//        float totalPagar = 0;
//        List<Empleado> empleados = proveedorMiembrosPlanilla.obtenerEmpleadosPlanilla();
//
//        for (Empleado empleado : empleados) {
//            if (empleado.isActivo()) {
//                if (empleado.getMontoMensual() < 0 || empleado.getId() == 0 || empleado.getNombre().isEmpty()) {
//                    throw new IllegalArgumentException("Datos de empleado no válidos");
//                }
//                totalPagar += empleado.getMontoMensual();
//            }
//        }
//
//        return totalPagar;
//    }
}
