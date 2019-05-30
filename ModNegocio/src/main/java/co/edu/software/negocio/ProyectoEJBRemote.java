package co.edu.software.negocio;

import java.util.List;

import javax.ejb.Remote;

import co.edu.software.entidades.Proyecto;
import co.edu.software.excepciones.*;
import co.edu.software.negocio.*;
/**
 * Session Bean implementation class PagoEJBRemote
 * @author John Alejandro Gonzalez

 * @version 1.0
 */
@Remote
public interface ProyectoEJBRemote {

	/**
	 * contexto del ejb
	 */
     String JNDI="java:global/proyectoear/proyectoejb/BancoEJB!org.entidades.PagoEJBRemote";
     
	/**
	 * Permite crear un proyecto
	 * 
	 * @param proyecto realizado
	 * @return true si fue agregada exitosamente
	 * @throws ElementoRepetidoException avisa si el proyecto ya esta agregado
	 */
	public boolean registrarProyecto(Proyecto proyecto) throws ElementoRepetidoException, NoExisteException;

	/**
	 * Permite buscar un proyecto
	 * * @param id del proyecto
	 * @return proyecto
	 * @throws NoExisteException avisa si el registro no existe
	 */
	public Proyecto buscarProyecto(int id) throws NoExisteException;

	/**
	 * Permite Modificar un proyecto
	 * 
	 * @param proyecto a modificar
	 * @return true si fue modificado exitosamente, false sino
	 */
	public boolean modificarProyecto(Proyecto proyecto);

	/**
	 * Permite listar todos los proyectos registrados
	 * 
	 * @return lista de proyectos
	 * @throws NoExisteException avisa si no hay proyectos
	 */
	public List<Proyecto> listarProyectos() throws NoExisteException;
}
