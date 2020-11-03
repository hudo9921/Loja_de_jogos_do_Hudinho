package application.view;

import java.util.ArrayList;

import application.LojaApp;
import javafx.fxml.FXML;
import javafx.fxml.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sistema.FachadaLoja;
import sistema.classesbase.Admin;
import sistema.classesbase.Jogo;
import sistema.classesbase.Usuario;
import javafx.event.ActionEvent;

public class ControladorTelaLogin {
	
	@FXML
	public TextField userNameText;
	
	@FXML
	public PasswordField userPassText;
	
	private LojaApp lojaApp;
    private FachadaLoja fachada = FachadaLoja.getInstance();
    private ControladorSistemaTela controladorSistemaTela;
	
    @FXML
	public void criarContaAction(ActionEvent e) throws Exception {
		lojaApp.abrirCriarContaTela();
	}
	
	@FXML
	public void entrarContaAction(ActionEvent e)  throws Exception {
		Alert alerta = new Alert(Alert.AlertType.WARNING);

		if(fachada.existe(userNameText.getText()) == true || fachada.existeAdmin(userNameText.getText()) == true) {
			
			if(fachada.existe(userNameText.getText()) == true) {
				Usuario user = new Usuario("",0,"");
				user = fachada.procurarUsuario(userNameText.getText());
				System.out.println(user);
				if(user.getSenha().equals(userPassText.getText())) {
					lojaApp.setUserSistema(user);
					lojaApp.abrirSistemaTela();
				}else {
					alerta.setTitle("Falha ao logar");
					alerta.setContentText("Senha incorreta.");
					alerta.setHeaderText(null);
					alerta.showAndWait();
				}
			}
			if(fachada.existeAdmin(userNameText.getText()) == true) {
				Admin admin = new Admin("",0, "",0);
				admin = fachada.procurarAdmin(userNameText.getText());
				if(admin.getSenha().equals(userPassText.getText())) {
					lojaApp.setAdminSistema(admin);
					lojaApp.abrirSistemaTela();
				}else {
					alerta.setTitle("Falha ao logar");
					alerta.setContentText("Senha incorreta.");
					alerta.setHeaderText(null);
					alerta.showAndWait();
				}
			}
			
		}else {
			alerta.setTitle("Falha ao logar");
			alerta.setContentText("Usuário não existe.");
			alerta.setHeaderText(null);
			alerta.showAndWait();
		}
	}
	
	@FXML
	public void initialize() {
		Admin admin = new Admin("Admin",0,"123",0);
		fachada.existeAdmin(admin.getUser());
		if(fachada.existeAdmin(admin.getUser()) == false) {
			fachada.criarContaAdmin(admin.getUser(), admin.getSenha());
		}
	} 
	
	public void setLojaApp(LojaApp lojaApp) {
		this.lojaApp = lojaApp;
	}
	
	public void setControladorSistemaTela(ControladorSistemaTela controlador) {
		this.controladorSistemaTela = controlador;
	}
	

}
