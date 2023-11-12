package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Departamentos;
//El error que indica es de tamaño para el int, que es la pk de departamentos

public interface IDepartamentosDAO extends JpaRepository<Departamentos, Short>{

}
