package com.camimrtzcode.restapi.calculototalplanillas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.camimrtzcode.restapi.calculototalplanillas.modelos.entidades.Empleado;
import com.camimrtzcode.restapi.calculototalplanillas.modelos.servicios.ProcesadorPlanillas;
import com.camimrtzcode.restapi.calculototalplanillas.modelos.servicios.ProveedorMiembrosPlanilla;
import com.camimrtzcode.restapi.calculototalplanillas.modelos.servicios.ProveedorMiembrosPlanillaImpl;

@SpringBootTest
class CalculoTotalPlanillasApplicationTests {
	
	@Test
    public void testMontoMensualNegativo() {
        ProveedorMiembrosPlanilla proveedor = mock(ProveedorMiembrosPlanilla.class);

        List<Empleado> empleados = new ArrayList<>();
        empleados.add(new Empleado(1, "Juan", 2000.0f, true));
        empleados.add(new Empleado(2, "Maria", -1500.0f, true));
        empleados.add(new Empleado(3, "Carlos", 1800.0f, true));
        
        when(proveedor.obtenerEmpleadosPlanilla()).thenReturn(empleados);

        ProcesadorPlanillas procesador = new ProcesadorPlanillas(proveedor);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, procesador::calcularTotalPagar);

        assertEquals("El monto mensual no puede ser negativo", exception.getMessage());
    }
	
	@Test
    public void testIdCero() {
        ProveedorMiembrosPlanilla proveedor = mock(ProveedorMiembrosPlanilla.class);

        List<Empleado> empleados = new ArrayList<>();
        empleados.add(new Empleado(1, "Juan", 2000.0f, true));
        empleados.add(new Empleado(2, "Maria", 1800.0f, true));
        empleados.add(new Empleado(0, "Carlos", 1500.0f, true));

        when(proveedor.obtenerEmpleadosPlanilla()).thenReturn(empleados);

        ProcesadorPlanillas procesador = new ProcesadorPlanillas(proveedor);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, procesador::calcularTotalPagar);

        assertEquals("El ID del empleado no puede ser igual a 0", exception.getMessage());
    }
	
	@Test
    public void testNombreVacio() {
        ProveedorMiembrosPlanilla proveedor = mock(ProveedorMiembrosPlanilla.class);

        List<Empleado> empleados = new ArrayList<>();
        empleados.add(new Empleado(1, "Juan", 2000.0f, true));
        empleados.add(new Empleado(2, "Maria", 1800.0f, true));
        empleados.add(new Empleado(3, "", 1500.0f, true));

        when(proveedor.obtenerEmpleadosPlanilla()).thenReturn(empleados);

        ProcesadorPlanillas procesador = new ProcesadorPlanillas(proveedor);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, procesador::calcularTotalPagar);

        assertEquals("El nombre del empleado no puede estar vacío", exception.getMessage());
    }

}
