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
import sistema.classesbase.Jogo;
import sistema.classesbase.Usuario;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ControladorSistemaTela {
	
	private LojaApp lojaApp;
	public Usuario usuarioAtual;
	
	@FXML
	public Label user;
	
	@FXML
	public ListView listBiblioteca;
	
	@FXML
	public ListView listLoja;
	
	@FXML
	public ListView listCarrinho;
	
	@FXML
	public void removerJogoAction(ActionEvent e) throws Exception {
		
		TextInputDialog dialog = new TextInputDialog("Remover jogo");
		dialog.setTitle("Remover Jogo");
		dialog.setContentText("Escolha um jogo para remover da biblioteca");
		
		Optional<String> resultado = dialog.showAndWait();
		if( resultado.isPresent()) {
			ObservableList<String> lista = listBiblioteca.getItems();
			lista.remove(resultado.get());
			listBiblioteca.setItems(lista);
			System.out.println("funcionou");
		}
	}
	
	@FXML
	public void adicionarCarrinhoAction(ActionEvent e) throws Exception {
		
		TextInputDialog dialog = new TextInputDialog("Adicionar ao carrinho");
		dialog.setTitle("Adicionar ao carrinho");
		dialog.setContentText("Escolha um jogo para adicionar ao carrinho");
		
		Optional<String> resultado = dialog.showAndWait();
		if( resultado.isPresent()) {
			ObservableList<String> lista = listCarrinho.getItems();
			System.out.println(lista);
			lista.add(resultado.get());
			listCarrinho.setItems(lista);
		}
	}
	
	@FXML
	public void comprarJogoAction(ActionEvent e) throws Exception {
		//tentativa falha de criar um dialogpane customizado
		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setLocation(getClass().getResource("telas/Teste.fxml"));
		DialogPane testeDialog = fxmlLoader.load();
		
		ControladorAddModJogoTela controlador = fxmlLoader.getController();
		Dialog<ButtonType> dialog = new Dialog<>();
		dialog.setDialogPane(testeDialog);
		dialog.setTitle("MODIFICAR");
		dialog.showAndWait();
	}
	
	@FXML
	public void initialize() {
		user.setText(lojaApp.getUserSistema().getUser());
		
		ArrayList<String> listona = new ArrayList<>();
		listona.add("SAMUEL LEGAL GAME");
		listona.add("VITO VALORENT PLAYER");
		listona.add("FERNANDO BONITINHO");
		
		ArrayList<Jogo> listaJogos = lojaApp.getUserSistema().getJogosPossuidos();
		for( Jogo jogo : listaJogos) {
			listona.add((String)jogo.getNome());
		}
		ObservableList<String> teste = FXCollections.observableArrayList(listona);
		listBiblioteca.setItems(teste);
		
		listona.clear();
		listona.add("VALORANT");
		listona.add("KDA JOGO");
		ObservableList<String> teste2 = FXCollections.observableArrayList(listona);
		listLoja.setItems(teste2);

		
	}

	public Label getUser() {
		return user;
	}

	public void setUser(Label user) {
		this.user = user;
	}
	
	public void setUsuarioAtual(Usuario user) {
		this.usuarioAtual = user;
	}
	
	public void atualizar(Usuario user) {
		this.user.setText(user.getUser());
	}


}
