package application.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sistema.FachadaLoja;
import sistema.classesbase.Admin;

import java.io.File;

import application.LojaApp;

public class ControladorCriarContaTela {
	
	private LojaApp lojaApp;
	private Stage criarContaTelaStage;
	private boolean criarContaClicked = false;
	
	//codigo de hudo
    private FachadaLoja fachada = FachadaLoja.getInstance();
    @FXML
    public TextField passTxt;

    @FXML
    public TextField userTxt;
    //codigo de hudo
	
	public void setCriarContaTelaStage(Stage criarContaTelaStage) {
        this.criarContaTelaStage = criarContaTelaStage;
    }
	
	//codigo de hudo
	@FXML
    public void criarContaAction(ActionEvent event) {
    	//if(fachada.existe(userTxt.getText()))//adicionar excecao pra usuario q ja existe durante criacao
    	fachada.listar();
    	fachada.criarConta(userTxt.getText(), passTxt.getText());
    	lojaApp.abrirTelaLogin();
    }
	//codigo de hudo
	
	public boolean isCriarContaClicked() {
		return criarContaClicked;
	}
}
