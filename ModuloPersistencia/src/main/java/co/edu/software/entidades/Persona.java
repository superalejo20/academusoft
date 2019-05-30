package co.edu.software.entidades;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

import co.edu.software.entidades.Persona;


/**
 * entidad que permite manejar la informacion de Persona en la bd 
 * implementation class for Entity: Persona
 * 
 * @author John Alejandro Gonzalez
 * @version 1.0 
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQueries(value = { @NamedQuery(name = Persona.LISTAR_EMAIL, query = "select p from Persona p where p.correo=:correo "),
		
		@NamedQuery(name = Persona.LISTAR_TODOS, query = " select p from Persona p"),
		})
public class Persona implements Serializable {
	/**
	 * varable estatica que permite hacer el uso de listar personas
	 */
	public static final String LISTAR_TODOS = "listarTodos";
	
	/**
	 * varable estatica que permite hacer el uso de listar personas por email
	 */
	public static final String LISTAR_EMAIL = "listarEmail";
	/**
	 * identificador de la entidad y cedula de la persona
	 */
	@Id
	@Column(name = "CEDULA", length = 15)
	private String cedula;
	/**
	 * Nombre de la persona
	 */
	@Column(name = "NOMBRE", nullable = false, length = 90)
	private String nombre;
	/**
	 * correo de la persona
	 */
	@Column(name = "CORREO", nullable = false)
	private String correo;
	/**
	 * Clave de ingreso de la persona
	 */
	@Column(name = "CLAVE", nullable = false, length = 100)
	private String clave;
	/**
	 * lista de telefonos
	 */
	@Column(nullable=true)
	@ElementCollection
	private List<String> telefonos;
	
	/**
	 * fecha de nacimiento de la persona
	 */	
	@Column(unique=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	
	
	

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor de la clase persona
	 */
	public Persona() {
		super();
	}
	/**
	 * Se encarga de obtener la cedula de la persona
	 * 
	 * @return cedula
	 */
	public String getCedula() {
		return this.cedula;
	}

	/**
	 * Se encarga de asignar el idesntificador de la entidad y la cedula de la
	 * persona
	 * 
	 * @param cedula
	 */
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public List<String> getTelefonos() {
		return telefonos;
	}
	/**
	 * Se encarga de asignar telefonos
	 * @param telefonos
	 */
	public void setTelefonos(List<String> telefonos) {
		this.telefonos = telefonos;
	}

	public Date getFecha() {
		return fecha;
	}
	/**
	 * Se encarga de asignar fechanacimiento
	 * @param telefonos
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * Se encarga de obtener el nombre de la persona
	 * 
	 * @return nombre
	 */
	public String getNombre() {
		return this.nombre;
	}

	/**
	 * Se encarga de asignar el nombre a la persona
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Se encarga de obtener el correo de la persona
	 * 
	 * @return correo
	 */
	public String getCorreo() {
		return this.correo;
	}

	/**
	 * Se encarga de asignar el correo a la persona
	 * 
	 * @param correo
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	
	/**
	 * Concatena los atributos de la persona
	 */
	@Override
	public String toString() {
		return "Persona [cedula: " + cedula + "\n nombre: " + nombre + "\n correo: " + correo + "\n clave: " + clave
				+ "\n telefonos: " + telefonos + "\n fecha: " + fecha + "]";
	}

	/**
	 * metodo que asigna un hash unico a la instacia de la clase
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cedula == null) ? 0 : cedula.hashCode());
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
		Persona other = (Persona) obj;
		if (cedula == null) {
			if (other.cedula != null)
				return false;
		} else if (!cedula.equals(other.cedula))
			return false;
		
		return true;
	}

}

