package co.edu.software.entidades;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * entidad que permite manejar la informacion de la consulta en la bd
 * Entity: Consulta
 * @author John Alejandro Gonzalez
 * @version 1.0
 */
@Entity
//@NamedQueries(value = { @NamedQuery(name = Consulta.LISTAR_CONSULTA, query = " select cl from Consulta cl")})

public class Consulta implements Serializable {
	/**
	 * variable estatica que permite listar las consultas
	 */
	public static final String LISTAR_CONSULTA = "listarConsulta";
	/**
	 * variable estatica que permite listar los empleados asociados a consultas
	 */
	public static final String LISTAR_CONSULTAS_ESTUDIANTES = "listarConsultaEstudiantes";
    
	
	
	/**
	 * pregunta
	 */
	@Column(name = "PREGUNTA", nullable = false, length = 2000)
	private String pregunta;
	/**
	 * respuesta
	 */
	@Column(name = "RESPUESTA", nullable = false, length = 2000)
	private String Respuesta;
	/**
	 * identificador de la entidad
	 */
	@Id
	@Column(name = "ID", length = 15)
	private int id;
	/**
	 * estudiante que realiza la pregunta
	 */
	@ManyToOne
	private Estudiante miEstudiante;
	/**
	 * Coordinador responde la pregunta
	 */
	@ManyToOne
	private Tutor miTutor;
	
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor de la clase consulta
	 */
	public Consulta() {
		super();
	}

	/**
	 * se encarga de obtener la pregunta
	 * 
	 * @return pregunta
	 */
	public String getPregunta() {
		return this.pregunta;
	}

	/**
	 * se encarga de asignar la pregunta
	 * 
	 * @param pregunta
	 */
	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	/**
	 * se encarga de obtener la respuesta
	 * 
	 * @return respuesta
	 */
	public String getRespuesta() {
		return this.Respuesta;
	}

	/**
	 * se encarga de asignar la respuesta
	 * 
	 * @param Respuesta
	 */
	public void setRespuesta(String Respuesta) {
		this.Respuesta = Respuesta;
	}

	/**
	 * se encarga de obtener el id
	 * 
	 * @return id
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * se encarga de asignar el id
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * se encarga de obtener el estudiante
	 * 
	 * @return recolector
	 */
	public Estudiante getMiEstudiante() {
		return miEstudiante;
	}

	/**
	 * se encarga de asignar el estudiante
	 * 
	 * @param misRecolectores
	 */
	public void setMiCliente(Estudiante miEstudiante) {
		this.miEstudiante = miEstudiante;
	}
	
	/**
	 * Se encarga de obtener el tutor
	 * @return misEmpleados
	 */
	public Tutor getMiTutor() {
		return miTutor;
	}

	/**
	 * Se encarga de asignar al tutor
	 */
	public void setMiTutor(Tutor miTutor) {
		this.miTutor = miTutor;
	}

	/**
	 * Concatena los atributos de la persona
	 */
	@Override
	public String toString() {
		return "Consulta [pregunta=" + pregunta + ", Respuesta=" + Respuesta + ", id=" + id + ", miEstudiante="
				+ miEstudiante+ ", miTutor=" + miTutor + " ]";
	}

	/**
	 * metodo que asigna un hash unico a la instacia de la clase
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	/**
	 * Metodo que compara si dos objetos de la clase apuntan al mismo objeto
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Consulta other = (Consulta) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
