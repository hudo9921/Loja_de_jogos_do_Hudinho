package application.view;

import application.LojaApp;
import javafx.fxml.FXML;
import javafx.fxml.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sistema.FachadaLoja;
import javafx.event.ActionEvent;

public class ControladorAddJogoTela {
	
	private LojaApp lojaApp;
	private FachadaLoja fachada = FachadaLoja.getInstance();
	
	@FXML
	public TextField jogoNameText;
	
	@FXML
	public TextField jogoPrecoText;
	
	@FXML
	public void okAction(ActionEvent e) throws Exception {
		String nomeJogo = jogoNameText.getText();
		String precoJogo = jogoPrecoText.getText();
		Alert alerta = new Alert(Alert.AlertType.WARNING);
		if( nomeJogo.isEmpty() || precoJogo.isEmpty()) {
			alerta.setTitle("Operação inválida");
			alerta.setContentText("Preencher todos os campos.");
			alerta.setHeaderText(null);
			alerta.showAndWait();
		}else {
			if( fachada.existeJogo(nomeJogo)) {
				alerta.setTitle("Operação inválida");
				alerta.setContentText("Jogo já existe.");
				alerta.setHeaderText(null);
				alerta.showAndWait();
			}else {
				fachada.cadastrarJogo(nomeJogo, Float.parseFloat(precoJogo));
				lojaApp.abrirSistemaTela();
			}
		}
	}
	
	@FXML
	public void cancelarAction(ActionEvent e) throws Exception {
		lojaApp.abrirSistemaTela();
	}
	
	public void setLojaApp(LojaApp lojaApp) {
		this.lojaApp = lojaApp;
	}
	

}
