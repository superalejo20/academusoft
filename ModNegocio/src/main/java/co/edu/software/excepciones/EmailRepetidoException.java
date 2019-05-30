package co.edu.software.excepciones;

/**
 * Excepcion que controla un correo electronico repetido
 * 
 * @author John Alejandro Gonzalez
 * @author Diego Alejandro Diaz
 * @author Fabio Vanegas
 * @version 1.0 
 *
 */
public class EmailRepetidoException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Contructor de la excepción con mensaje
	 * 
	 * @param message a mostrar
	 */
	public EmailRepetidoException(String message) {
		super(message);
	}

}
