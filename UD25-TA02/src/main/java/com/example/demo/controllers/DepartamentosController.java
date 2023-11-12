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

import com.example.demo.dto.Departamentos;
import com.example.demo.services.DepartamentosServiceImpl;

@RestController
@RequestMapping("/api")
public class DepartamentosController {
	@Autowired
	DepartamentosServiceImpl departamentosServiceImpl;
	@GetMapping("/departamentos")
	public List<Departamentos> listarDepartamentos(){
		return departamentosServiceImpl.listarDepartamentos();
	}
	
	@PostMapping("/departamentos")
	public Departamentos salvarDepartamentos(@RequestBody Departamentos departamentos) {
		return departamentosServiceImpl.guardarDepartamentos(departamentos);
	}
	@GetMapping("/departamentos/{id}")
	public Departamentos departamentosXCOD(@PathVariable(name="codigo")Short codigo) {
		Departamentos departamentos_xcod = new Departamentos();
		departamentos_xcod = departamentosServiceImpl.departamentosXCOD(codigo);
		System.out.println("Departamentos XCOD: "+departamentos_xcod);
		return departamentos_xcod;
	}
	@PutMapping("/departamentos/{id}")
	public Departamentos actualizarDepartamentos(@PathVariable(name="codigo")Short codigo, @RequestBody Departamentos departamentos) {
		Departamentos departamentos_seleccionado = new Departamentos();
		Departamentos departamentos_actualizado = new Departamentos();
		
		departamentos_seleccionado = departamentosServiceImpl.departamentosXCOD(codigo);
		
		departamentos_seleccionado.setNombre(departamentos.getNombre());
		departamentos_seleccionado.setPresupuesto(departamentos.getPresupuesto());
		
		departamentos_actualizado = departamentosServiceImpl.actualizarDepartamentos(departamentos_seleccionado);
		System.out.println("El departamento actualizado es: "+departamentos_actualizado);
		
		return departamentos_actualizado;
	}
	@DeleteMapping("/departamentos/{id}")
	public void eliminarDepartamentos (@PathVariable(name="codigo")Short codigo) {
		departamentosServiceImpl.eliminarDepartamentos(codigo);
	}

}
