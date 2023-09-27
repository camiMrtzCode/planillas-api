package com.camimrtzcode.restapi.calculototalplanillas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.camimrtzcode.restapi.calculototalplanillas.modelos.entidades.Empleado;
import com.camimrtzcode.restapi.calculototalplanillas.modelos.jpa.EmpleadoRepository;
import com.camimrtzcode.restapi.calculototalplanillas.modelos.servicios.ProcesadorPlanillas;
import com.camimrtzcode.restapi.calculototalplanillas.modelos.servicios.ProveedorMiembrosPlanilla;

@SpringBootTest
class CalculoTotalPlanillasApplicationTests {
	
	@Test
    void testObtenerMontoTotalPlanilla() {
        ProveedorMiembrosPlanilla proveedorMiembrosPlanilla = Mockito.mock(ProveedorMiembrosPlanilla.class);
        List<Empleado> empleados = Arrays.asList(
            new Empleado(1, "Camilo", 1000, true),
            new Empleado(2, "Felipe", 1200, true),
//          El monto mensual es negativo
            new Empleado(3, "Laura", -500, true),
//            new Empleado(3, "Laura", 500, true),
            new Empleado(4, "Viviana", 1500, false),
//          El Id es 0
//            new Empleado(0, "David", 2000, true),
            new Empleado(5, "David", 2000, true),
//          El Nombre esta vacio
//            new Empleado(6, "", 2500, true)
            new Empleado(6, "Enrique", 2500, true)
        );
        Mockito.when(proveedorMiembrosPlanilla.obtenerEmpleadosPlanilla()).thenReturn(empleados);

        EmpleadoRepository empleadoRepository = Mockito.mock(EmpleadoRepository.class);

        ProcesadorPlanillas procesadorPlanillas = new ProcesadorPlanillas(proveedorMiembrosPlanilla, empleadoRepository);

        float montoTotal = procesadorPlanillas.calcularTotalPagar();

        assertEquals(7200, montoTotal);
//        assertEquals(4700, montoTotal);
    }
}
