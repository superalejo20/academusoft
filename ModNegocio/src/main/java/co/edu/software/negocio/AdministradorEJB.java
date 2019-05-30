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
import co.edu.software.excepciones.InformacionRepetidaException;



/**
 * Permite realizar todas las operaciones realacionadas con el administrador
 * @author John Alejandro Gonzalez
 
 * @version 1.0
 */
@Stateless
@LocalBean
public class AdministradorEJB implements AdministradorEJBRemote {

	/**
	 * permite realizar todas las transacciones con la base de datos
	 */
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * constructor vacio por defecto
	 */
	public AdministradorEJB() {
	}

	
	public List<Tutor> listarTutores() {
		TypedQuery<Tutor> query = entityManager.createNamedQuery(Tutor.LISTAR_TODOS, Tutor.class);
		return query.getResultList();
	}

	
	public Tutor actualizarTutor(Tutor tutor) {
		if (entityManager.find(Tutor.class, tutor.getCedula()) != null) {
			entityManager.merge(tutor);
		}
		return null;
	}

	
	public Tutor eliminarTutor(Tutor tutor) {
		if (entityManager.find(Tutor.class, tutor.getCedula()) != null) {
			if (!entityManager.contains(tutor)) {
				tutor = entityManager.merge(tutor);
			}
			entityManager.remove((Tutor) tutor);
			return tutor;
		}
		return null;
	}

	
	public Tutor agregarTutor(Tutor r) throws InformacionRepetidaException {
		if (entityManager.find(Tutor.class, r.getCedula()) != null) {
			throw new InformacionRepetidaException("Un tutor con esa cedula ya ha sido registrado");
		} else if (buscarPorEmail(r.getCorreo())) {
			throw new InformacionRepetidaException("Un tutor con ese email ya ha sido registrado");
		}
		entityManager.persist(r);
		return r;
	}

	/**
	 * permite determinar si hay una persona registrada con el mismo email
	 * 
	 * @param email email a ser buscado
	 * @return true si el email se encuentra, false si no
	 */
	private boolean buscarPorEmail(String email) {
		TypedQuery<Persona> query = entityManager.createNamedQuery(Persona.LISTAR_EMAIL, Persona.class);
		query.setParameter("email", email);
		return query.getResultList().size() > 0;
	}

	public Estudiante agregarEstudiante(Estudiante estudiante) throws InformacionRepetidaException {

		if (entityManager.find(Persona.class, estudiante.getCedula()) != null) {
			throw new InformacionRepetidaException("Un estudiante con esa cedula ya ha sido registrado");
		} else if (buscarPorEmail(estudiante.getCorreo())) {
			throw new InformacionRepetidaException("Un estudiante con ese email ya ha sido registrado");
		}

		entityManager.persist(estudiante);
		return estudiante;

	}
	
	
  public Persona buscarPersona(String cedula) {
		
		return entityManager.find(Persona.class, cedula);
	}




}
