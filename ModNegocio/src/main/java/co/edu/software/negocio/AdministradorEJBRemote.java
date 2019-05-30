package co.edu.software.negocio;

import java.util.List;

import javax.ejb.Remote;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import co.edu.software.entidades.Estudiante;
import co.edu.software.entidades.Persona;
import co.edu.software.entidades.Tutor;
import co.edu.software.excepciones.InformacionRepetidaException;

/**
 * permire generar una capa para dar el acceso solo a los metodos básicos  
 * @author John Alejandro Gonzalez
 * @version 1.0
 */
@Remote
public interface AdministradorEJBRemote {

	/**
	 * contexro del EJB
	 */
	String JNDI = "java:global/teloprestamos-ear/teloprestamos-negocio/AdministradorEJB!co.edu.uniquindio.grid.negocio.AdministradorEJBRemote";

	/**
	 * permite listar todos los tutores 
	 * 
	 * @return devuelve todos los tutores 
	 */
	public List<Tutor> listarTutores();

	/**
	 * pemite actulizar la informacion de un tutor
	 * 
	 * @param tutor a ser actualizado
	 * @return el recolector si se actualiza, null si no
	 */
	public Tutor actualizarTutor(Tutor tutor);

	/**
	 * permite eliminar un tutor de la base de datos
	 * 
	 * @param tutor a ser eliminado
	 * @return tutor eliminado o null si no elimina
	 */
	public Tutor eliminarTutor(Tutor tutor);

	/**
	 * Permite agregar un tutor
	 * 
	 * @param tutor que se desea agregar
	 * @return tutor agregado
	 * @throws InformacionRepetidaException se ejecuta cuando se agrega informacion repetida de personas
	 */
	public Tutor agregarTutor(Tutor tutor) throws InformacionRepetidaException;
	/**
	 * Permite agregar un estudiante
	 * 
	 * @param estudiante que se desea agregar
	 * @return estudiante agregado
	 * @throws InformacionRepetidaException se ejecuta cuando se agrega informacion repetida de personas
	 */
	public Estudiante agregarEstudiante(Estudiante estudiante) throws InformacionRepetidaException;

	
    public Persona buscarPersona(String cedula);
	


}
