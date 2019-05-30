package co.edu.software.negocio;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import co.edu.software.entidades.Proyecto;
import co.edu.software.excepciones.*;
import co.edu.software.negocio.*;

/**
 * Session Bean implementation class Pago
 * @author John Alejandro Gonzalez

 * @version 1.0
 */

@Stateless
@LocalBean
public class ProyectoEJB implements ProyectoEJBRemote {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public ProyectoEJB() {
	}

	@Override
	
	public boolean registrarProyecto(Proyecto proyecto) throws ElementoRepetidoException, NoExisteException {
		if (buscarProyecto(proyecto.getId()) != null) {
			throw new ElementoRepetidoException("El proyecto ya existe");
		}
		entityManager.persist(proyecto);
		return true;
	}

	@Override
	
	public Proyecto buscarProyecto(int id) throws NoExisteException {
		Proyecto proyecto = entityManager.find(Proyecto.class, id);
		if (proyecto == null) {
			throw new NoExisteException("El proyeccto no existe");
		}
		return proyecto;
	}

	@Override
	
	public boolean modificarProyecto(Proyecto proyecto) {
		entityManager.merge(proyecto);
		return true;
	}

	@Override
	
	public List<Proyecto> listarProyectos() throws NoExisteException {
		TypedQuery<Proyecto> query = entityManager.createNamedQuery(Proyecto.LISTAR_PROYECTOS, Proyecto.class);
		List<Proyecto> proyectos = query.getResultList();
		if (proyectos.isEmpty()) {
			throw new NoExisteException("No hay proyectos en la lista");
		}
		return proyectos;
	}

}
