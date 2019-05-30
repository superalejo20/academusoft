package co.edu.software.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;


/**
 * entidad que permite manejar la informacion del proyecto en la bd 
 * implementation class for Entity: Proyecto
 * @author John Alejandro Gonzalez
 * @version 1.0
 */
@Entity
@NamedQueries(value = { @NamedQuery(name = Proyecto.BUSCAR_POR_FECHA_PROYECTO, query = "select proyecto.id from Proyecto proyecto where proyecto.fecha=:fecha"),
		@NamedQuery(name = Proyecto.LISTAR_PROYECTOS, query = " select g from Proyecto g"),
})
public class Proyecto implements Serializable {
	/**
	 * listar proyectos
	 */
	public static final String LISTAR_PROYECTOS = "listarProyectos";
	/**
	 * variable estatica que permite mostrar varios campos del registro
	 */
	public static final String BUSCAR_POR_FECHA_PROYECTO = "BuscarPorFechaProyecto";
	
	
	
	/**
	 * fecha de creacion proyecto
	 */
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
	
	/**
	 * identificador de la entidad
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", length = 15)
	private int id;
	
	/**
	 * descripcion
	 */
	@Column(length=100)
	private String descripcion;
	
	
	/**
	 * estudiantes asociados al proyecto
	 */
	
	@OneToMany(mappedBy = "miProyecto")
	private List<Estudiante> misEstudiantes;
	
	/**
	 * coordinador asociado al proyecto
	 */
	@ManyToOne
	private Coordinador miCoordinador;
	
	/**
	 * tutor asociado al proyecto
	 */
	@ManyToOne
	private Tutor miTutor;
	
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor de la clase
	 */
	public Proyecto() {
		super();
	}

	/**
	 * Obtiene la fecha 
	 * 
	 * @return
	 */
	public Date getFecha() {
		return this.fecha;
	}

	/**
	 * Asigna la fecha
	 * 
	 * @param fecha
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	/**
	 * Obtiene el identificador de la entidad
	 * 
	 * @return id
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Asigna el identificador de la entidad
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Se encarga de obtener coordinador
	 * @return coordinador
	 */	
	public Coordinador getMiCoordinador() {
		return miCoordinador;
	}
	/**
	 * Asigna coordinador
	 */
	public void setMiCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}
	

	
	/**
	 * obtiene la descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * Asigna la descripcion
	 */
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	/**
	 * metodo que obtiene estudiantes asociados
	 */

	public List<Estudiante> getMisEstudiantes() {
		return misEstudiantes;
	}
	/**
	 * metodo que asigna estudiantes
	 */
	public void setMisEstudiantes(List<Estudiante> misEstudiantes) {
		this.misEstudiantes= misEstudiantes;
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
		Proyecto other = (Proyecto) obj;
		if (id != other.id)
			return false;
		return true;
	}

	/**
	 * Concatena los atributos del proyecto
	 */
	@Override
	public String toString() {
		return "Proyecto [fecha=" + fecha + ", id=" + id + ", Coordinador=" + miCoordinador
				+ "]";
	}

}
