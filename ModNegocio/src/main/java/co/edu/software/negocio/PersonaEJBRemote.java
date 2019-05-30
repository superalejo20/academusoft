package co.edu.software.negocio;

import java.util.List;

/**
 * Session Bean implementation class PersonaEJBRemote
 * @author John Alejandro Gonzalez
 * @author Francisney Sanchez
 * @version 1.0
 */

import javax.ejb.Remote;

import co.edu.software.entidades.Estudiante;
import co.edu.software.entidades.Persona;
import co.edu.software.entidades.Tutor;
import co.edu.software.excepciones.*;
import co.edu.software.negocio.*;

/**
 * Session Bean implementation class PersonaEJBRemote
 * @author John Alejandro Gonzalez

 * @version 1.0
 */

@Remote
public interface PersonaEJBRemote {
	
	/**
	 * contexto del ejb
	 */
     String JNDI="java:global/proyectoear/proyectoejb/PersonaEJB!org.entidades.PersonaEJBRemote";
     			
	/**
	 * Permite agregar una persona
	 * @param persona, persona a registrar
	 * @return true si la persona fue agregada con exito
	 * @throws ElementoRepetidoException avisa que el elemento ya esta registrado
	 * @throws EmailRepetidoException avisa que el correo ingresado ya esta registrado
	 */
	 public boolean registrarPersona(Persona persona ) throws ElementoRepetidoException, EmailRepetidoException;
	 /**
	  * Permite listar los estudiantes registrados 
	  * @return lista de estudiantes registrados
	  * @throws NoExisteException Avisa si la lista esta vacia
	  */
	 public List<Estudiante> listarEstudiante() throws NoExisteException;
	 /**
	  * Permite listar los tutores registrados
	  * @return lista de tutores registrados
	  * @throws NoExisteException avisa si la lista esta vacia
	  */
	 public List<Tutor> listarTutores() throws NoExisteException;
	 /**
	  * Permite eliminar a una persona
	  * @param cedula, identificacion de la persona a eliminar
	  * @return true si la persona se elimino con exito
	  * @throws NoExisteException avisa si la persona a eliminar no esta resgistrada 
	  */
	 public boolean eliminarPersona(String cedula) throws NoExisteException;
	 /**
	  * Permite buscar a una persona en la aplicacion
	  * @param cedula, identificacion de la persona a buscar
	  * @return la persona buscada
	  * @throws NoExisteException avisa si la persona a buscar no existe
	  */
	 public Persona buscarPersona(String cedula) throws NoExisteException;
	 /**
	  * Permite modificar a una persona registrada
	  * @param persona, persona que desea modificar la informacion
	  * @return true si la persona fue modificada con exito
	  */
	 public boolean modificarPersona(Persona persona);
}
