package co.edu.software.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * entidad que permite manejar la informacion del Recolector en la bd 
 * implementation class for Entity: Estudiante
 * @author John Alejandro Gonzalez
 * @version 1.0
 */
@Entity
@NamedQueries(value = { @NamedQuery(name = Estudiante.LISTAR_ESTUDIANTES, query = "select r from Estudiante r")})
public class Estudiante extends Persona implements Serializable {

	/**
	 * variable estatica que permite listar a los estudiantes
	 */
	public static final String LISTAR_ESTUDIANTES = "listarEstudiantes";
	
	/**
	 * lista de las consultas
	 */
	@OneToMany(mappedBy = "miEstudiante")
	private List<Consulta> miConsulta;
	
	/**
	 * proyecto asociado 
	 */
	@ManyToOne
	private Proyecto miProyecto;
	
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor de la clase
	 */
	public Estudiante() {
		super();
	}
	
	/**
	 * Se encarga de obtener la lista de las consultas del estudiante
	 * 
	 * @return miConsulta
	 */
	public List<Consulta> getMiConsulta() {
		return miConsulta;
	}

	/**
	 * Se encarga de asignar la lista de consultas al estudiante
	 * 
	 * @param miConsulta
	 */
	public void setMiConsulta(List<Consulta> miConsulta) {
		this.miConsulta = miConsulta;
	}

	/**
	 * Concatena los atributos del estudiante
	 */
	@Override
	public String toString() {
		return "Estudiante: \n" + super.toString();
	}

}
