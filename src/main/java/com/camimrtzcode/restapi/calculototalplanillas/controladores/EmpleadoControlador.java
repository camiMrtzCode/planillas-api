package com.camimrtzcode.restapi.calculototalplanillas.controladores;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.camimrtzcode.restapi.calculototalplanillas.modelos.entidades.Empleado;
import com.camimrtzcode.restapi.calculototalplanillas.modelos.jpa.EmpleadoRepository;

@RestController
public class EmpleadoControlador {
	
	private EmpleadoRepository emplService;

	public EmpleadoControlador(EmpleadoRepository emplService) {
		this.emplService = emplService;
	}
	
	@GetMapping("/empleados")
	public List<Empleado> findAll() {
		return emplService.findAll();
	}
	
	@GetMapping("/empleados/{id}")
	public Optional<Empleado> findOne(@PathVariable Integer id) {
		Optional<Empleado> empl = emplService.findById(id);
		return empl;
	}
	
	@DeleteMapping("/borrarEmpleado/{id}")
	public void eliminarEmpleado(@PathVariable Integer id) {
		emplService.deleteById(id);
	}
	
	@PostMapping("/agregarEmpleado")
	public ResponseEntity<Empleado> crearEmpleado(@RequestBody Empleado empl) {
		emplService.save(empl);
		return ResponseEntity.created(null).build();
	}
}
