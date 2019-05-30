package controladores;

import java.awt.HeadlessException;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;


import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class RegistrarEstudianteController implements Initializable{
	
	RegistrarEstudianteController registrarCliente;


    
    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtApellidos;

    @FXML
    private TextField txtCedula;

    @FXML
    private TextField txtTelefono;

    @FXML
    private TextField txtDireccion;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtContrasena;

    @FXML
    private Button btnVolver;

    @FXML
    private Button btnRegistrar;

    @FXML
    private ComboBox<String> tipoPrestamo;

    @FXML
    private Label lblTipoP;
    
    @FXML
    private Label lblInformacion;

    @FXML
    private Label lblValorPrestamo;

    @FXML
    private TextField txtValorP;

    @FXML
    private ComboBox<Integer> cuotasDiferidas;

    @FXML
    private Label lblCuotasDiferidas;

    @FXML
    private Label lblFecha;

    @FXML
    private Label lnlNombre;

    @FXML
    private TextField txtPropietario1;

    @FXML
    private Label lbIdentificacion;

    @FXML
    private TextField txtCedula1;

    @FXML
    private Label lblTasaInteres;

    @FXML
    private TextField txtInteres;

    @FXML
    private DatePicker fechaSeleccionada;

    @FXML
    private Label lblValorCuotas;

    @FXML
    private TextField txtValorCuotas;

    @FXML
    private Label lblTotalPrestamo;

    @FXML
    private TextField txtTotalPrestamo;

    /**
     * @param event
     */
    @FXML
    void registrarCliente(ActionEvent event) {


    }
	    

	@FXML
    void volver(ActionEvent event) {

    }
	    
	    

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
	}

	@FXML
    void fechaSeleccionada(ActionEvent event) {

    }
    
    
    @FXML
    public void calcularCuotas(ActionEvent event) {
    	
    }


    @FXML
    void tipoPrestamo(ActionEvent event) {
    	
    }
	    
}

	   






	