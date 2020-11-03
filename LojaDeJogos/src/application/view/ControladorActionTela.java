package application.view;

import java.time.LocalDate;
import java.util.ArrayList;

import application.LojaApp;
import javafx.fxml.FXML;
import javafx.fxml.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sistema.FachadaLoja;
import sistema.classesbase.Jogo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

public class ControladorActionTela {
	
	private LojaApp lojaApp;
	private FachadaLoja fachada = FachadaLoja.getInstance();
	private LocalDate inicial;
	private LocalDate ultima;
	
	@FXML
	public Label labelValor;
	
	@FXML
    public DatePicker data1;
	
	@FXML
    public DatePicker data2;
	
	@FXML
	public void okAction(ActionEvent e) throws Exception {
		if( inicial == null || ultima == null  ) {
			
			Alert alerta = new Alert(Alert.AlertType.WARNING);
			alerta.setTitle("Operação inválida");
			alerta.setContentText("Preencha todos os campos de data.");
			alerta.setHeaderText(null);
			alerta.showAndWait();
		}else {
			this.labelValor.setText(Float.toString(fachada.lucroData(inicial, ultima)));
		}
	}
	
    @FXML
    public void localDateInicial(ActionEvent event) {
    	if( data1.toString() == "" ) {
    		this.inicial = null;
    	}else {
    		this.inicial = data1.getValue();
    	}
    	
    	//System.out.println(inicial);
    }

    @FXML
    public void localDateFinal(ActionEvent event) {
    	if( data2.toString() == "") {
    		this.ultima = null;
    	}else {
    		this.ultima = data2.getValue();
    	}
    	
    	//System.out.println(ultima);
    }
	
	@FXML
	public void cancelarAction(ActionEvent e) throws Exception {
		lojaApp.abrirSistemaTela();
	}
	
	@FXML
	public void initialize() {
		labelValor.setText(Float.toString((fachada.lucroTotal())));
		
	}
	
	public void setLojaApp(LojaApp lojaApp) {
		this.lojaApp = lojaApp;
	}
	

}
