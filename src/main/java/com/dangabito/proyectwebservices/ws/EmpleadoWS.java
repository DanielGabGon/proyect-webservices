/**
 * 
 */
package com.dangabito.proyectwebservices.ws;

import java.util.List;

import com.dangabito.proyectwebservices.entity.Empleado;
import com.dangabito.proyectwebservices.service.EmpleadoService;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 * @author Dangabito
 * Webservice generado con Jersey
 */
@Path(value = "empleadosWS")
public class EmpleadoWS {
	
	private EmpleadoService empleadoService= new EmpleadoService();

	/**
	 * 
	 */
	public EmpleadoWS() {
	}
	
	@GET
	@Path("test")
	public String test() {
		return "Probando Webservices con Jersey";
	}
	
	@GET
	@Path("consultarEmpleado")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Empleado consultarEmpleado() {
		return this.empleadoService.consultarEmpleado();
	}
	
	@GET
	@Path("consultarEmpleados")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Empleado> consultarEmpleados(){
		return this.empleadoService.consultarEmpleados();
	}
	
	@GET
	@Path("consultarEmpleadoNumeroEmpleado/{numEmp}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response consultarEmpleadoNumeroEmpleado(@PathParam("numEmp") String numeroEmpleado) {
		Empleado empleadoConsultadoEmpleado= this.empleadoService.consultarEmpleadoNumeroEmpleado(numeroEmpleado);
		if(empleadoConsultadoEmpleado==null) {
			return Response.noContent().build();
		}
		GenericEntity<Empleado> empleadoGeneric=new GenericEntity<Empleado>(empleadoConsultadoEmpleado, Empleado.class);
		return Response.ok(empleadoGeneric).build();
	}
	
	@POST
	@Path("guardarEmpleado")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response guardarEmpleado(Empleado empleado) {
		if(empleado==null) {
			return Response.status(400).entity("No se ingresó información del empleado, favor de capturar sus datos").build();
		}
		
		if(empleado.getNombre()==null || empleado.getNombre().isEmpty()) {
			return Response.status(400).entity("El nombre empleado es requerido").build();
		}
		GenericEntity<Empleado> emGenericEntity= new GenericEntity<Empleado>(empleado, Empleado.class);
		return Response.ok(emGenericEntity).build();
	}

}
