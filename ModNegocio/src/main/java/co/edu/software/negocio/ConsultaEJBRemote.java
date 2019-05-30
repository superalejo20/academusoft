package co.edu.software.negocio;

import java.util.List;

import javax.ejb.Remote;

import co.edu.software.entidades.Consulta;
import co.edu.software.excepciones.*;
import co.edu.software.negocio.*;


/**
 * Session Bean implementation class ConsultaEJBRemote
 * @author John Alejandro Gonzalez

 * @version 1.0
 */
@Remote
public interface ConsultaEJBRemote {

	/**
	 * contexto del ejb
	 */
     String JNDI="java:global/proyectoear/proyectoejb/BancoEJB!org.entidades.ConsultEJBRemote";
     
	/**
	 * Permite crear una consulta
	 * 
	 * @param consulta a crear
	 * @return true si fue creada exitosamente, false sino
	 * @throws NoExisteException avisa si existe la consulta
	 * @throws ElementoRepetidoException avisa si la consulta ya se encuentra registrada
	 */
	public boolean crearConsulta(Consulta consulta) throws NoExisteException, ElementoRepetidoException;

	/**
	 * Permite buscar una consulta
	 * 
	 * @param id de la consulta
	 * @return conslta encontrado
	 * @throws NoExisteException avisa si no se pudo encontrar la consulta
	 */
	public Consulta buscarConsulta(int id) throws NoExisteException;

	/**
	 * Permite modificar una consulta
	 * 
	 * @param consulta a modificar
	 * @return true si fue modificado exitosamente, false sino
	 */
	public boolean modificarConsulta(Consulta consulta);

	/**
	 * Permite eliminar una consulta
	 * 
	 * @param consult a eliminar
	 * @return true si fue eliminado con exito, false sino
	 */
	public boolean eliminarConsulta(Consulta consulta);

	/**
	 * Permite Listar consultas
	 * 
	 * @return lista de consultas
	 * @throws NoExisteException avisa si no existen consultas a listar
	 */
	public List<Consulta> listarConsultas() throws NoExisteException;
}
