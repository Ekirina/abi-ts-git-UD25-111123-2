package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.Departamentos;

public interface IDepartamentosService {
	public List<Departamentos> listarDepartamentos(); //Listar ALL
	public Departamentos guardarDepartamentos(Departamentos departamentos); //Guardar
	public Departamentos departamentosXCOD (Short codigo); //Leer datos de un cliente READ
	public Departamentos actualizarDepartamentos(Departamentos departamentos); //UPDATE
	public void eliminarDepartamentos (Short codigo); //DELETE

}
