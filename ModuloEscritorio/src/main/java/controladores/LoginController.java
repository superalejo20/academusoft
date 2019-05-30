package controladores;

import java.io.IOException;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.fxml.Initializable;

public class LoginController implements Initializable{
	   
	
    @FXML
    private TextField txtUsuario;

    @FXML
    private Label labelUsuario;

    @FXML
    private Label LabelContrasena;

    @FXML
    private Button IniciarSesion;

    @FXML
    private PasswordField txtContrasena;

    @FXML
    private Hyperlink recuperarContrasena;
    
    @FXML
    private Button Registrarse;
    
    
    
    @FXML
    void IniciarSesion(ActionEvent event) {     	
      	

    }

    @FXML
    void RecuperarContrasena(ActionEvent event) {
    	
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}
	

    @FXML
    void Registrarse(ActionEvent event) {
    	
    	ManejadorEscenarios manejador = new ManejadorEscenarios();
    	manejador.viewRegistrarEstudiante(event, Registrarse);

    }
	


}
