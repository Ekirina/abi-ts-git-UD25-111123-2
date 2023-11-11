package com.example.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name ="departamentos")
public class Departamentos {
	//Atributos de la entidad fabricante
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)//busca último valor e incrementa desde la id final del db
	private int codigo;
	@Column(name = "nombre")
	private String nombre;
	@Column(name= "presupuesto")
	private int presupuesto;


	@OneToMany
	@JoinColumn(name = "codigo")
	private List <Empleados> empleados;

	//Constructores
	public Departamentos() {

	}
	//En el anterior ejercicio eliminé el de articulos, con la lista incluida.
	public Departamentos(int codigo, String nombre, int presupuesto, List<Empleados> empleados) {
		//super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.empleados = empleados;
	}

	//Getters y setters:
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPresupuesto() {
		return presupuesto;
	}
	public void setPresupuesto(int presupuesto) {
		this.presupuesto = presupuesto;
	}
	
	//return empleados
	@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY, mappedBy = "Empleados")
	public List<Empleados> getEmpleados(){
		return empleados;
	}

	public void setEmpleados(List<Empleados> empleados) {
		this.empleados = empleados;
	}
	//Método impresión de datos por consola
	@Override
	public String toString() {
		return "Departamentos [codigo=" + codigo + ", nombre=" + nombre + ", presupuesto=" + presupuesto
				+ ", empleados=" + empleados + "]";
	}
}