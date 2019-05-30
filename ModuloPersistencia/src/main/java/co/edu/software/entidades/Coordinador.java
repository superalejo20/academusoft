package co.edu.software.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Permite manejar la informacion del empleado Entity implementation class for
 * Entity: Coordinador
 * @author John Alejandro Gonzalez
 * @version 1.0
 */
@Entity
@NamedQueries(value = { @NamedQuery(name = Coordinador.LISTAR_COORDINADOR, query = " select e from Coordinador e")})
public class Coordinador extends Persona implements Serializable {

	/**
	 * variable estatica que permite hacer el uso de listar los coordinadores
	 */
	public static final String LISTAR_COORDINADOR = "listarEmpleado";
	
	
	/**
	 * proyectos asociados
	 */
	@OneToMany(mappedBy = "miCoordinador")
	private List<Proyecto> misProyectos;
	
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor de la clase 
	 */
	public Coordinador() {
		super();
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
	 * Concatena los atributos del coordinador
	 */
	@Override
	public String toString() {
		return "Coordinador: \n" + super.toString();
	}
}
