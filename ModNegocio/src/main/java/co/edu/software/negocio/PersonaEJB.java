package co.edu.software.negocio;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import co.edu.software.entidades.Estudiante;
import co.edu.software.entidades.Persona;
import co.edu.software.entidades.Tutor;
import co.edu.software.excepciones.*;

/**
 * Session Bean implementation class PersonaEJB
 * @author John Alejandro Gonzalez

 * @version 1.0
 */

@Stateless
@LocalBean
public class PersonaEJB implements PersonaEJBRemote {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public PersonaEJB() {
		// TODO Auto-generated constructor stub
	}

	public boolean registrarPersona(Persona persona) throws ElementoRepetidoException, EmailRepetidoException {
		if (entityManager.find(Estudiante.class, persona.getCedula()) != null) {
			throw new ElementoRepetidoException("La persona ya fue registrada");
		} else if (buscarPorEmail(persona.getCorreo())) {
			throw new EmailRepetidoException("El correo ya existe");
		}
		entityManager.persist(persona);
		return true;
	}

	/**
	 * Busca una persona por el email
	 * 
	 * @param correo electronico de la persona
	 * @return verdadero si esta
	 */
	public boolean buscarPorEmail(String correo) {
		TypedQuery<Persona> query = entityManager.createNamedQuery(Persona.LISTAR_EMAIL, Persona.class);
		query.setParameter("correo", correo);
		if (query.getResultList().size() == 0) {
			return false;
		}
		return true;
	}

	/**
	 * listar empleados 
	 */
	public List<Estudiante> listarEstudiante() throws NoExisteException {
		TypedQuery<Estudiante> query = entityManager.createNamedQuery(Estudiante.LISTAR_ESTUDIANTES, Estudiante.class);
		List<Estudiante> estudiante = query.getResultList();
		if (estudiante.isEmpty()) {
			throw new NoExisteException("Lo siento, No hay Estudiantes");
		}
		return estudiante;
	}

	/**
	 * listar tutores 
	 */
	public List<Tutor> listarTutores() throws NoExisteException {
		TypedQuery<Tutor> query = entityManager.createNamedQuery(Tutor.LISTAR_TUTORES, Tutor.class);
		List<Tutor> tutor = query.getResultList();
		if (tutor.isEmpty()) {
			throw new NoExisteException("Lo siento, No hay tutoress");
		}

		return tutor;

	}

	
	public boolean eliminarPersona(String cedula) throws NoExisteException {
		Persona persona = buscarPersona(cedula);
		if (persona == null) {
			throw new NoExisteException("Lo siento, la persona que trata de eliminar no se encuentra registrado");
		}
		entityManager.remove(persona);
		return true;
	}

	
	public Persona buscarPersona(String cedula) throws NoExisteException {

		Persona persona = entityManager.find(Persona.class, cedula);
		if (persona == null) {
			throw new NoExisteException("Lo siento, la persona no se pudo encontrar");
		}
		return persona;
	}

	
	public boolean modificarPersona(Persona persona) {
		entityManager.merge(persona);
		return true;
	}

}
