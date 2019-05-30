package co.edu.software.excepciones;

/**
 * excepcion que controla un elemento repetido
  * @author John Alejandro Gonzalez
  * @author Diego Alejandro Diaz
  * @author Fabio Vanegas
  * @version 1.0 
 *
 */
public class ElementoRepetidoException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * constructor con mensaje
	 * @param msj a mostrar
	 */
	public ElementoRepetidoException(String mensaje) {
		super(mensaje);
	}
	

}
