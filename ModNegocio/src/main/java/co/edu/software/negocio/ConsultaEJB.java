package co.edu.software.negocio;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import co.edu.software.entidades.Consulta;
import co.edu.software.excepciones.*;
import co.edu.software.negocio.*;


/**
 * Session Bean implementation class ConsultaEJB
 * @author John Alejandro Gonzalez

 * @version 1.0
 */
@Stateless
@LocalBean
public class ConsultaEJB implements ConsultaEJBRemote {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public ConsultaEJB() {
		// TODO Auto-generated constructor stub
	}


	@Override
	
	public boolean crearConsulta(Consulta consulta) throws NoExisteException, ElementoRepetidoException {
		if (buscarConsulta(consulta.getId()) != null) {
			throw new ElementoRepetidoException("La consulta que intenta registrar ya existe");
		}
		entityManager.persist(consulta);
		return true;
	}

	@Override
	
	public Consulta buscarConsulta(int id) throws NoExisteException {
		Consulta consulta = entityManager.find(Consulta.class, id);
		if (consulta == null) {
			throw new NoExisteException("La consullta que busca no existe");
		}
		return consulta;
	}

	@Override
	
	public boolean modificarConsulta(Consulta consulta) {
		entityManager.merge(consulta);
		return true;
	}

	@Override
	
	public boolean eliminarConsulta(Consulta consulta) {
		entityManager.remove(consulta);
		return true;
	}

	@Override
	
	public List<Consulta> listarConsultas() throws NoExisteException {
		TypedQuery<Consulta> query = entityManager.createNamedQuery(Consulta.LISTAR_CONSULTA, Consulta.class);
		List<Consulta> consultas = query.getResultList();
		if (consultas.isEmpty()) {
			throw new NoExisteException("No existen consultas para listar");
		}
		return consultas;
	}

}
