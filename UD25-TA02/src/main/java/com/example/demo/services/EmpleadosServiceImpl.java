package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IEmpleadosDAO;
import com.example.demo.dto.Empleados;

@Service
public class EmpleadosServiceImpl implements IEmpleadosService {
	@Autowired
	IEmpleadosDAO iEmpleadosDAO;
	
	@Override
	public List<Empleados> listarEmpleados() {
		return iEmpleadosDAO.findAll();
	}

	@Override
	public Empleados guardarEmpleados(Empleados empleados) {
		return iEmpleadosDAO.save(empleados);

	}

	@Override
	public Empleados empleadosXDNI(String dni) {
		return iEmpleadosDAO.findById(dni).get();

	}

	@Override
	public Empleados actualizarEmpleados(Empleados empleados) {
		return iEmpleadosDAO.save(empleados);

	}

	@Override
	public void eliminarEmpleados(String dni) {
		iEmpleadosDAO.deleteById(dni);		
		
	}
	

}
