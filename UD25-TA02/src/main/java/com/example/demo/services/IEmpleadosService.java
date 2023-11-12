package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.Empleados;

public interface IEmpleadosService {
	//Métodos del CRUD
	public List<Empleados> listarEmpleados(); //Listar ALL
	public Empleados guardarEmpleados(Empleados empleados); //Guardar
	public Empleados empleadosXDNI (String dni); //Leer datos de un cliente READ
	public Empleados actualizarEmpleados(Empleados empleados); //UPDATE
	public void eliminarEmpleados (String dni); //DELETE

}
