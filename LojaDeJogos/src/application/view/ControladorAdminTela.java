package application.view;

import application.LojaApp;
import javafx.fxml.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;
import sistema.FachadaLoja;
import sistema.classesbase.Jogo;
import sistema.classesbase.Usuario;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ControladorAdminTela {
	
	private LojaApp lojaApp;
	private FachadaLoja fachada = FachadaLoja.getInstance();
	
	@FXML
	public Label admin;
	
	@FXML
	public ListView listBiblioteca;
	
	@FXML
	public ListView listLoja;
	
	@FXML
	public Label totalJogosLoja;
	
	@FXML
	public void alterarSenhaAction(ActionEvent e) throws Exception {
		TextInputDialog dialog = new TextInputDialog("Alterar Senha");
		dialog.setTitle("Nova senha");
		dialog.setContentText("Digite uma nova senha para a conta.");
		
		Optional<String> resultado = dialog.showAndWait();
		if( resultado.isPresent()) {
			this.fachada.alterarSenhaAdmin(lojaApp.getAdminSistema().getUser(), resultado.get());
		}
	}
	
	@FXML
	public void adicionarJogoAction(ActionEvent e) throws Exception {
		//Botão funcionando.
		lojaApp.abrirAddJogoTela();
	}
	
	@FXML
	public void removerJogoAction(ActionEvent e) throws Exception {
		//Botão funcionando
		TextInputDialog dialog = new TextInputDialog("Remover jogo do Sistema");
		dialog.setTitle("Remover jogo");
		dialog.setContentText("Digite um jogo para ser removido permanentemente do sistema.");
		Optional<String> resultado = dialog.showAndWait();
		if( resultado.isPresent()) {
			ObservableList<String> lista = listLoja.getItems();
			if( lista.contains(resultado.get())) {
				Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
				alerta.setTitle("Confirmação de operação");
				alerta.setContentText("Deseja realmente remover permanentemente o jogo escolhido do Sistema?");
				alerta.setHeaderText(null);
				Optional<ButtonType> resultado2 = alerta.showAndWait();
				if( resultado2.isPresent() && resultado2.get() == ButtonType.OK) {
					lista.remove(resultado.get());
					listLoja.setItems(lista);
					this.totalJogosLoja.setText(Integer.toString(lista.size()));
					fachada.rmvJogo(resultado.get());
				}
				
			}else {
				Alert alerta = new Alert(Alert.AlertType.WARNING);
				alerta.setTitle("Item não existe");
				alerta.setContentText("Item não existe na Loja.");
				alerta.setHeaderText(null);
				alerta.showAndWait();
			}
		}
	}
	
	@FXML
	public void modificarJogoAction(ActionEvent e) throws Exception {
		//Botão funcionando
		TextInputDialog dialog = new TextInputDialog("Modificar Jogo");
		dialog.setTitle("Modificar jogo");
		dialog.setContentText("Digite um jogo para ser modificado.");
		Optional<String> resultado = dialog.showAndWait();
		if(resultado.isPresent()) {
			if(fachada.existeJogo(resultado.get())) {
				lojaApp.setJogoSistema(fachada.consultarJogo(resultado.get()));
				lojaApp.abrirModJogoTela();
			}else {
				Alert alerta = new Alert(Alert.AlertType.WARNING);
				alerta.setTitle("Jogo não existe");
				alerta.setContentText("O jogo selecionado para edição não existe no sistema.");
				alerta.setHeaderText(null);
				alerta.showAndWait();
			}
		}
	}
	
	@FXML
	public void relatorioAction(ActionEvent e) throws Exception {
		lojaApp.abrirRelatorioTela();
	}
	
	@FXML
	public void verificarUsuarioAction(ActionEvent e) throws Exception {
		TextInputDialog dialog = new TextInputDialog("Verificar Usuário");
		dialog.setTitle("Nome de Usuário");
		dialog.setContentText("Digite um usuário para ser verificado.");
		Optional<String> resultado = dialog.showAndWait();
		if(resultado.isPresent()) {
			if( fachada.existe(resultado.get())) {
				lojaApp.setVerificarSistema(fachada.procurarUsuario(resultado.get()));
				lojaApp.abrirVerificarUsuarioTela();
			}else {
				Alert alerta = new Alert(Alert.AlertType.WARNING);
				alerta.setTitle("Usuário não existe");
				alerta.setContentText("O usuário selecionado para verificação não existe no sistema.");
				alerta.setHeaderText(null);
				alerta.showAndWait();
			}
		}
	}
	
	@FXML
	public void verificarLucroAction(ActionEvent e) throws Exception {
		lojaApp.abrirActionTela();
	}
	
	@FXML
	public void initialize() {
		//Falta iniciar as variaveis/listas com informações do repositorio.
		admin.setText(lojaApp.getAdminSistema().getUser());
		
		ArrayList<String> listona = new ArrayList<>();
		ArrayList<Jogo> listaJogos = fachada.getListaJogo();
		
		for(Jogo jogo : listaJogos) {
			//System.out.println(jogo.toString());
			listona.add(jogo.getNome());
		}

		ObservableList<String> teste = FXCollections.observableArrayList(listona);
		listLoja.setItems(teste);
		this.totalJogosLoja.setText(Integer.toString(listona.size()));
		
	}

}
