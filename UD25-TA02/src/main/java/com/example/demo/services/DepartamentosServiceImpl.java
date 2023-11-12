package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IDepartamentosDAO;
import com.example.demo.dto.Departamentos;

@Service
public class DepartamentosServiceImpl implements IDepartamentosService {
	@Autowired
	IDepartamentosDAO iDepartamentosDAO;

	@Override
	public List<Departamentos> listarDepartamentos() {
		return iDepartamentosDAO.findAll();
	}

	@Override
	public Departamentos guardarDepartamentos(Departamentos departamentos) {
		return  iDepartamentosDAO.save(departamentos);
	}

	@Override
	public Departamentos departamentosXCOD(Short codigo) {
		return iDepartamentosDAO.findById(codigo).get();
	}

	@Override
	public Departamentos actualizarDepartamentos(Departamentos departamentos) {
		return iDepartamentosDAO.save(departamentos);
	}

	@Override
	public void eliminarDepartamentos(Short codigo) {
		iDepartamentosDAO.deleteById(codigo);		
		
	}
	

}
