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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

public class ControladorModJogoTela {
	
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
				if( nomeJogo.equals(lojaApp.getJogoSistema().getNome())) {
					fachada.editarJogo(nomeJogo, Float.parseFloat(precoJogo), lojaApp.getJogoSistema().getNome());
					lojaApp.abrirSistemaTela();
				}else {
					alerta.setTitle("Operação inválida");
					alerta.setContentText("Jogo já existe.");
					alerta.setHeaderText(null);
					alerta.showAndWait();
				}
				
			}else {
				if( Float.parseFloat(precoJogo) < 0) {
					alerta.setTitle("Operação inválida");
					alerta.setContentText("Preço menor que zero.");
					alerta.setHeaderText(null);
					alerta.showAndWait();
				}else {
					fachada.editarJogo(nomeJogo, Float.parseFloat(precoJogo), lojaApp.getJogoSistema().getNome());
					lojaApp.abrirSistemaTela();
				}
			}
		}
	}
	
	@FXML
	public void cancelarAction(ActionEvent e) throws Exception {
		lojaApp.abrirSistemaTela();
	}
	
	@FXML
	public void initialize() {
		jogoNameText.setText(lojaApp.getJogoSistema().getNome());
		jogoPrecoText.setText(Float.toString(lojaApp.getJogoSistema().getPreco()));
		
	}
	
	public void setLojaApp(LojaApp lojaApp) {
		this.lojaApp = lojaApp;
	}
	

}
