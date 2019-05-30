package controladores;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ManejadorEscenarios {
	
	public static final ManejadorEscenarios instanciaEscenarios= new ManejadorEscenarios();
	public Stage stage; 
    public Parent root ;
    public FXMLLoader loader = new FXMLLoader();
	
	
	public static ManejadorEscenarios getInstancia() {
		return instanciaEscenarios;
	}
	
	public void viewRegistrarEstudiante(ActionEvent event, Button registrarse) {
		try {
	  		   if(event.getSource()==registrarse){
	  			  //Obtener referencia a la Escena del botón         
	  			  stage=(Stage) registrarse.getScene().getWindow();
	  			  //cargar el otro documento, en este caso la segundo pantalla
	  			  root = loader.load(getClass().getResource("../vistas/RegistrarEstudiante.fxml").openStream());
	  			  Scene scene = new Scene(root);
	  			  stage.setScene(scene);
	  			  stage.show();
	  		 }
		} catch (IOException e) {
			// TODO: handle exception
		}
	}

}
