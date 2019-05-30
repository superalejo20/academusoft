package co.edu.software.negocio;

import java.text.ParseException;
import java.util.List;

import javax.ejb.Remote;

import co.edu.software.entidades.Tutor;
import co.edu.software.entidades.Proyecto;
import co.edu.software.excepciones.*;
import co.edu.software.negocio.*;

/**
 * Session Bean implementation class BancoEJBRemote
 * @author John Alejandro Gonzalez

 * @version 1.0
 */

@Remote
public interface AcademusoftEJBRemote {
	
	/**
	 * contexto del ejb
	 */
     String JNDI="java:global/proyectoear/proyectoejb/BancoEJB!org.negocio.BancoEJBRemote";
     
     /**
 	 * permite agregar un tutor a la bd
 	 * 
 	 * @param tutor
 	 * @return el tutor agregado o null si no lo agrega
 	 */

 	public Tutor agregarTutor(Tutor tutor) throws ElementoRepetidoException;
 	
 	/**
	 * permite buscar un tutor por email en la bd
	 * 
	 * @param email
	 * @return true si encuentra el tutor o false sino
	 */
	public boolean buscarTutorPorEmail(String email);
 	
     /**
 	 * Permite hacer un proyecto en la bd
 	 * 
 	 * @param proyecto
 	 * @return true si fue creado con exito
 	 * @throws ElementoRepetidoException avisa si el registro que intenta crear esta repetido
 	 */
 	public boolean crearProyecto(Proyecto proyecto) throws ElementoRepetidoException;
 	
 	/**
	 * Permite buscar un proyecto
	 * 
	 * @param id del proyecto
	 * @return el proyecto buscado
	 * @throws NoExisteException avisa si el proyecto no existe
	 */
	public Proyecto buscarProyecto(String id) throws NoExisteException;
	
	/**
	 * Permite eliminar un proyecto
	 * 
	 * @param id del proyecto
	 * @return true si fue eliminado con exito
	 * @throws NoExisteException avisa si no existe el proyecto
	 */
	public boolean eliminarProyecto(String id) throws NoExisteException;
	
	/**
	 * Permite listar todos los proyectos
	 * 
	 * @return lista con los proyectos
	 * @throws NoExisteException avisa si no hay proyectos
	 */
	public List<Proyecto> listarProyectos() throws NoExisteException;
	
	/**
	 * Lista los proyectos según la fecha ingresada
	 * 
	 * @param date fecha del proyecto
	 * @return lista de los proyectos en la fecha ingresada
	 * @throws ParseException
	 * @throws NoExisteException avisa cuando no hay proyectos en la fecha ingresada
	 */
	public List<Proyecto> listarProyectoPorFecha(String date) throws ParseException, NoExisteException;
     
     
	

}
