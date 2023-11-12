package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Empleados;

public interface IEmpleadosDAO extends JpaRepository<Empleados, String> {

}
