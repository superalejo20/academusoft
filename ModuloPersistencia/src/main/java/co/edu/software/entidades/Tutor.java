package co.edu.software.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * entidad que permite manejar la informacion del Recolector en la bd 
 * implementation class for Entity: Tutor
 * @author John Alejandro Gonzalez
 * @version 1.0
 */
@Entity
@NamedQueries(value = { @NamedQuery(name = Tutor.LISTAR_TUTORES, query = "select r from Tutor r"),
		@NamedQuery(name = Tutor.LISTAR_EMAIL, query = "select p from Persona p where p.correo=:correo "),
		
		@NamedQuery(name = Tutor.BUSCAR_PROYECTO_POR_CEDULA, query = "select Proyecto from Tutor tutor INNER JOIN tutor.misProyectos proyecto where tutor.cedula =:cedula")
})
public class Tutor extends Persona implements Serializable {

	/**
	 * variable estatica que permite listar a los tutores
	 */
	public static final String LISTAR_TUTORES = "listarTutores";
	
	/**
	 * variable estatica que permite buscar Proyectos por cedula
	 */
	public static final String BUSCAR_PROYECTO_POR_CEDULA = "buscarProyectoPorCedula";
	
	/**
	 * varable estatica que permite hacer el uso de listar personas por email
	 */
	public static final String LISTAR_EMAIL = "listarEmail";
	
	/**
	 * lista de las respuestas de las consultas 
	 */
	@OneToMany(mappedBy = "miTutor")
	private List<Consulta> misConsultas;
	
	/**
	 * proyectos asociados
	 */
	@OneToMany(mappedBy = "miTutor")
	private List<Proyecto> misProyectos;
	
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor de la clase
	 */
	public Tutor() {
		super();
	}
	
	/**
	 * Se encarga de obtener la lista de las consultas del estudiante
	 * 
	 * @return miConsulta
	 */
	public List<Consulta> getMisConsultas() {
		return misConsultas;
	}

	/**
	 * Se encarga de asignar la lista de consultas al tutor
	 * 
	 * @param miConsultas
	 */
	public void setMisConsultas(List<Consulta> miConsultas) {
		this.misConsultas = miConsultas;
	}
	
	
	/**
	 * @return the misProyectos
	 */
	public List<Proyecto> getMisProyectos() {
		return misProyectos;
	}

	/**
	 * @param misProyectos the misProyectos to set
	 */
	public void setMisProyectos(List<Proyecto> misProyectos) {
		this.misProyectos = misProyectos;
	}

	

	/**
	 * Concatena los atributos del estudiante
	 */
	@Override
	public String toString() {
		return "Tutor: \n" + super.toString();
	}

}

