package com.example.demo.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "empleados")
public class Empleados {
	//Atributos de entidad Departamentos
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)//busca el último valor e incrementa desde la id final de la db
	private String dni;
	@Column(name = "nombre")
	private String nombre;
	@Column(name ="apellidos")
	private String apellidos;
	//No se coloca el campo de la foreign key, se define después con el @ManyToOne
	
	@ManyToOne
	@JoinColumn(name = "codigo_departamento")
	private Departamentos departamentos;
	//constructores
	

	public Empleados(){
	}
	//@param dni - @param nombre - @param apellidos - @param codigo_departamento
	public Empleados(String dni, String nombre, String apellidos, Departamentos departamentos) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.departamentos = departamentos;
	}
	//Getters y setters
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public Departamentos getDepartamentos() {
		return departamentos;
	}
	public void setDepartamentos(Departamentos departamentos) {
		this.departamentos = departamentos;
	}
	
	//Método String
	@Override
	public String toString() {
		return "Empleados [dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + "]";
	}
	
	
}

