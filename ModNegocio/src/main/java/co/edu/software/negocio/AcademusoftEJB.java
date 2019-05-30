package co.edu.software.negocio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;

import co.edu.software.entidades.Persona;
import co.edu.software.entidades.Proyecto;
import co.edu.software.entidades.Tutor;
import co.edu.software.excepciones.*;
import co.edu.software.negocio.*;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * Session Bean implementation class AcademusoftEJB
 * @author John Alejandro Gonzalez

 * @version 1.0
 */

@Stateless
@LocalBean
public class AcademusoftEJB implements AcademusoftEJBRemote {
	@PersistenceContext
	private EntityManager entityManager;

	
   /**
	 * instancia del objeto
	 */
	private AcademusoftEJBRemote AcademusoftEJB;

	/**
	 * Default constructor.
	 */
	public AcademusoftEJB() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * permite agregar un tutor a la bd
	 * 
	 * @param tutor
	 * @return el recolector agregado o null si no lo agrega
	 */

	public Tutor agregarTutor(Tutor tutor) throws ElementoRepetidoException {
		if (entityManager.find(Tutor.class, tutor.getCedula()) != null) {
			throw new ElementoRepetidoException("error persona ya registrada con esa cedula");
		} else if (buscarTutorPorEmail(tutor.getCorreo())) {
			throw new ElementoRepetidoException("error persona ya regisrada con ese email");

		}
		try {
			entityManager.persist(tutor);
			return tutor;
		} catch (Exception e) {
			e.printStackTrace();
			return null;

		}

	}
	
	/**
	 * permite buscar un tutor por email en la bd
	 * 
	 * @param email
	 * @return true si encuentra el tutor o false sino
	 */
	public boolean buscarTutorPorEmail(String email) {
		TypedQuery<Tutor> query = entityManager.createNamedQuery("Tutor.BUSCAR_POR_EMAIL", Tutor.class);
		query.setParameter("email", email);
		return query.getResultList().size() > 0;
	}

	@Override
	
	public boolean crearProyecto(Proyecto proyecto) throws ElementoRepetidoException {
		if (entityManager.find(Proyecto.class, proyecto.getId()) != null) {
			throw new ElementoRepetidoException("El proyecto ya fue generado");
		}
		entityManager.persist(proyecto);
		return true;
	}

	@Override
	
	public Proyecto buscarProyecto(String id) throws NoExisteException {
		Proyecto proyecto= entityManager.find(Proyecto.class, id);
		if (proyecto == null) {
			throw new NoExisteException("El proyecto no se pudo encontrar");
		}
		return proyecto;
	}

	@Override
	
	public boolean eliminarProyecto(String id) throws NoExisteException {
		Proyecto proyecto = buscarProyecto(id);
		if (proyecto == null) {
			throw new NoExisteException("El proyecto que trata de eliminar no se encuentra registrado");
		}
		entityManager.remove(proyecto);
		return true;
	}

	@Override
	
	public List<Proyecto> listarProyectos() throws NoExisteException {
		TypedQuery<Proyecto> query = entityManager.createNamedQuery(Proyecto.LISTAR_PROYECTOS, Proyecto.class);
		List<Proyecto> proyectos = query.getResultList();
		if (proyectos.isEmpty()) {
			throw new NoExisteException("No existen proyectos hechos");
		}
		return proyectos;
	}

	@Override
	
	public List<Proyecto> listarProyectoPorFecha(String date) throws ParseException, NoExisteException {
		Date fecha = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(date + " 00:00:00.0");
		TypedQuery<Proyecto> query = entityManager.createNamedQuery(Proyecto.BUSCAR_POR_FECHA_PROYECTO, Proyecto.class);
		query.setParameter("fecha", fecha);
		List<Proyecto> proyectos = query.getResultList();
		if (proyectos.isEmpty()) {
			throw new NoExisteException("No existen registros en fecha ingresada");
		}
		return proyectos;
	}
}