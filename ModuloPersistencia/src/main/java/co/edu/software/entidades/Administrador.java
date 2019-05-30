package co.edu.software.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * entidad que permite manejar la informacion de Administrador en la bd
 * Entity implementation class for Entity: Administrador
 * 
 * @author John Alejandro Gonzalez
 * @version 1.0 
 */
@Entity
public class Administrador extends Persona implements Serializable {
	public static final String LISTAR_ADMINISTRADOR = "listarAdministrador";
	private static final long serialVersionUID = 1L;

	
	/**
	 * Constructor de la clase
	 */
	public Administrador() {
		super();
	}
	
	

	/**
	 * Se encarga de concatenar los atributos
	 */
	@Override
	public String toString() {
		return "Administrador: \n" + super.toString() ;
	}
}
