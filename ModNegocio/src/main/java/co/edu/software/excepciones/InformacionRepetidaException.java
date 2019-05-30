package co.edu.software.excepciones;
/**
 * 
 * @author John Alejandro Gonzalez
 * @author Diego Alejandro Diaz
 * @author Fabio Vanegas
 * @version 1.0
 */
public class InformacionRepetidaException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public InformacionRepetidaException(String mensaje) {
		super(mensaje);
	}

}
