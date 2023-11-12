package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Empleados;
import com.example.demo.services.EmpleadosServiceImpl;

@RestController
@RequestMapping("/api")
public class EmpleadosController {
	@Autowired
	EmpleadosServiceImpl empleadosServiceImpl;
	@GetMapping("/empleados")
	public List<Empleados> listarEmpleados(){
		return empleadosServiceImpl.listarEmpleados();
	}

	@PostMapping("/empleados")
	public Empleados salvarEmpleados(@RequestBody Empleados empleados) {
		return empleadosServiceImpl.guardarEmpleados(empleados);
	}
	@GetMapping("/empleados/{id}")
	public Empleados empleadosXDNI(@PathVariable(name="dni")String dni) {
		Empleados empleados_xdni = new Empleados();
		empleados_xdni = empleadosServiceImpl.empleadosXDNI(dni);
		System.out.println("Empleados XID: "+empleados_xdni);
		return empleados_xdni;
	}
	@PutMapping("/empleados/{id}")
	public Empleados actualizarEmpleados(@PathVariable(name="id")String dni, @RequestBody Empleados empleados) {
		Empleados empleados_seleccionado = new Empleados();
		Empleados empleados_actualizado = new Empleados();

		empleados_seleccionado = empleadosServiceImpl.empleadosXDNI(dni);

		empleados_seleccionado.setNombre(empleados.getNombre());
		empleados_seleccionado.setApellidos(empleados.getApellidos());
		empleados_seleccionado.setDepartamentos(empleados.getDepartamentos());

		empleados_actualizado = empleadosServiceImpl.actualizarEmpleados(empleados_seleccionado);
		System.out.println("El empleado actualizado es: "+empleados_actualizado);

		return empleados_actualizado;
	}
	@DeleteMapping("/empleados/{id}")
	public void eliminarEmpleados (@PathVariable(name="dni")String dni) {
		empleadosServiceImpl.eliminarEmpleados(dni);
	}
}
