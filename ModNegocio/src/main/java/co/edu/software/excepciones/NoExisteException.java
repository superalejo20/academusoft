package co.edu.software.excepciones;

/**
 * Excepci�n que contrala si no existe un elemento
 * @author John Alejandro Gonzalez
 * @author Diego Alejandro Diaz
 * @author Fabio Vanegas
 * @version 1.0 
 *
 */
public class NoExisteException extends Exception {

	static final long serialVersionUID = 1L;

	/**
	 * Constructor de la excepci�n con mensaje	 * 
	 * @param mensaje a mostrar
	 */
	public NoExisteException(String mensaje) {
		super(mensaje);
	}

}
