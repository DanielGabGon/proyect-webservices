package com.dangabito.proyectwebservices.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.dangabito.proyectwebservices.entity.Empleado;

public class EmpleadoService {

	/**
	 * Metodo que permite consultar un empleado por su id.
	 * @param numeroEmpleado {@link String} numero del empleado.
	 * @return {@link Empleado} empleado consultado.
	 */
	public Empleado consultarEmpleadoNumeroEmpleado(String numeroEmpleado) {
		   List<Empleado> empleadosConsultados=this.consultarEmpleados();
		for (Empleado empleado : empleadosConsultados) {
			if(empleado.getNumeroEmpleado().equalsIgnoreCase(numeroEmpleado)) {
				return empleado;
			}
		}
		return null;
	}
	
	/**
	 * Metodo que simula la consulta de un empleado
	 * @return {@link Empleado} empleado consultado
	 */
	public Empleado consultarEmpleado() {
		Empleado empleado = new Empleado();
		empleado.setNumeroEmpleado("123456");
		empleado.setNombre("Dan");
		empleado.setPrimerApellido("Gab");
		empleado.setSegundoApellido("Gon");
		empleado.setEdad(49);
		empleado.setFechaCreacion(LocalDateTime.now());
		return empleado;
	}
	
	/**
	 * Metodo que simula la consulta de un empleado
	 * @return {@link Empleado} empleado consultado
	 */
	public List<Empleado> consultarEmpleados() {
		List<Empleado> listaEmpleados=new  ArrayList<Empleado>();
		Empleado empleado = new Empleado();
		empleado.setNumeroEmpleado("123456");
		empleado.setNombre("Dan");
		empleado.setPrimerApellido("Gab");
		empleado.setSegundoApellido("Gon");
		empleado.setEdad(49);
		empleado.setFechaCreacion(LocalDateTime.now());
		listaEmpleados.add(empleado);
		
		Empleado empleado2 = new Empleado();
		empleado2.setNumeroEmpleado("654321");
		empleado2.setNombre("Pedro");
		empleado2.setPrimerApellido("Paramo");
		empleado2.setSegundoApellido("G.");
		empleado2.setEdad(60);
		empleado2.setFechaCreacion(LocalDateTime.now());
		listaEmpleados.add(empleado2);
		
		return listaEmpleados;
	}
	
	
	
	

}
