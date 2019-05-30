package main;
import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.stage.Stage;



public class Main extends Application {
	
	public Label escena1;
	public Scene  scene;
	public Stage primaryStage;
	
	public static void main(String[] args) {
		launch(args);
		
	}


	
	public void start(Stage primaryStage) throws Exception {
		
		this.primaryStage=primaryStage;
		
		
	    Parent root = FXMLLoader.load(getClass().getResource("../vistas/Login.fxml"));

	    
	    scene = new Scene(root);// indicamos qu� scene contendr� el Parent de cada ventana

	    
	    primaryStage.setTitle("REPOSITORIO");//Esto no es necesario a menos que deses colocar un titulo, iria entre comillas
	    primaryStage.setScene(scene);//declaras la escena de la ventana, en este caso sera la principal
	    primaryStage.show();


	}
	
	
	
	private void ButtonClicked(ActionEvent e) {
	    //aqu� en caso de presionar alg�n boton se declara qu� escena deseamos ejecutar
	    //esto podr�a te�ricamente cambiarse con un switch, pero en este caso s�lo hacemos intercambio entre dos escenas

	}
	
	
	

}
