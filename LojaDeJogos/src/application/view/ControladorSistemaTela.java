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
import sistema.classesbase.Carrinho;
import sistema.classesbase.Jogo;
import sistema.classesbase.Usuario;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.time.LocalDate;

public class ControladorSistemaTela {
	
	private LojaApp lojaApp;
	public Usuario usuarioAtual;
	private FachadaLoja fachada = FachadaLoja.getInstance();
	
	@FXML
	public Label user;
	
	@FXML
	public Label totalJogosBiblioteca;
	
	@FXML
	public Label totalJogosLoja;
	
	@FXML
	public Label totalJogosCarrinho;
	
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
			if( lista.contains(resultado.get())) {
				Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
				alerta.setTitle("Confirmação de operação");
				alerta.setContentText("Deseja realmente remover permanentemente o jogo escolhido da biblioteca?");
				alerta.setHeaderText(null);
				Optional<ButtonType> resultado2 = alerta.showAndWait();
				if( resultado2.isPresent() && resultado2.get() == ButtonType.OK) {
					lista.remove(resultado.get());
					listBiblioteca.setItems(lista);
					this.totalJogosBiblioteca.setText(Integer.toString(lista.size()));
					fachada.removerJogoUsuario(fachada.consultarJogo(resultado.get()), this.lojaApp.getUserSistema());
					//System.out.println(this.lojaApp.getUserSistema());
				}
			}else {
				Alert alerta = new Alert(Alert.AlertType.WARNING);
				alerta.setTitle("Item não existe");
				alerta.setContentText("Item não existe na biblioteca.");
				alerta.setHeaderText(null);
				alerta.showAndWait();
			}
			
		}
	}
	
	@FXML
	public void adicionarCarrinhoAction(ActionEvent e) throws Exception {
		//Botão finalizado
		TextInputDialog dialog = new TextInputDialog("Adicionar ao carrinho");
		dialog.setTitle("Adicionar ao carrinho");
		dialog.setContentText("Escolha um jogo para adicionar ao carrinho");
		
		Optional<String> resultado = dialog.showAndWait();
		if( resultado.isPresent()) {
			ObservableList<String> listaLoja = listLoja.getItems();
			if( listaLoja.contains(resultado.get())) {
				ArrayList<Jogo> jogosUser = this.lojaApp.getUserSistema().getJogosPossuidos();
				if( jogosUser.isEmpty()) {
					ObservableList<String> lista = listCarrinho.getItems();
					lista.add(resultado.get());
					listCarrinho.setItems(lista);
					int i = Integer.parseInt(this.totalJogosCarrinho.getText());
					this.totalJogosCarrinho.setText(Integer.toString(i + 1));
					System.out.println("if");
				}else {
						for( Jogo jogo : jogosUser) {
							if( listBiblioteca.getItems().contains(resultado.get())) {
								Alert alerta = new Alert(Alert.AlertType.WARNING);
								alerta.setTitle("Operaçõa inválida");
								alerta.setContentText("Jogo já comprado.");
								alerta.setHeaderText(null);
								alerta.showAndWait();
								System.out.println("for if");
								break;
							}else if( !(jogosUser.contains(fachada.consultarJogo(resultado.get())))){
								ObservableList<String> lista = listCarrinho.getItems();
								lista.add(resultado.get());
								listCarrinho.setItems(lista);
								int i = Integer.parseInt(this.totalJogosCarrinho.getText());
								this.totalJogosCarrinho.setText(Integer.toString(i + 1));
								System.out.println("for else");
								break;
							}
					}
				}
				
				
			}else {
				Alert alerta = new Alert(Alert.AlertType.WARNING);
				alerta.setTitle("Item não encontrado");
				alerta.setContentText("Jogo não existe na loja.");
				alerta.setHeaderText(null);
				alerta.showAndWait();
			}	
		}
	}
	
	@FXML
	public void comprarJogoAction(ActionEvent e) throws Exception {
		if( listCarrinho.getItems().isEmpty()) {
			Alert alerta = new Alert(Alert.AlertType.WARNING);
			alerta.setTitle("Operaçõa inválida");
			alerta.setContentText("Carrinho vazio.");
			alerta.setHeaderText(null);
			alerta.showAndWait();
		}else {
			Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
			alerta.setTitle("Confirmação de compra");
			alerta.setContentText("Deseja realmente comprar todos os itens do carrinho?");
			alerta.setHeaderText(null);
			Optional<ButtonType> resultado = alerta.showAndWait();
			if( resultado.isPresent() && resultado.get() == ButtonType.OK) {
				ObservableList<String> lista = this.listCarrinho.getItems();
				ArrayList<Jogo> listaJogo = new ArrayList<>();
				for( String itens : lista) {
					listaJogo.add(fachada.consultarJogo(itens));
				}
				Usuario user = fachada.procurarUsuario(this.lojaApp.getUserSistema().getUser());
				fachada.adicionarJogoUsuario(listaJogo, user);
				
				LocalDate data = LocalDate.now();
				Carrinho carrinho = new Carrinho(listaJogo, this.lojaApp.getUserSistema(), data);
				fachada.inserirPedido(carrinho);
				
				lista.clear();
				listaJogo = user.getJogosPossuidos();
				for( Jogo jogo : listaJogo) {
					lista.add(jogo.getNome());
				}
				this.listBiblioteca.setItems(lista);
				this.totalJogosBiblioteca.setText(Integer.toString(lista.size()));
				ObservableList<String> lista2 = this.listCarrinho.getItems();
				lista2.clear();
				listCarrinho.setItems(lista2);
				this.totalJogosCarrinho.setText(Integer.toString(0));
				lojaApp.abrirSistemaTela();
			}
		
		}
	}
	
	@FXML
	public void limparCarrinhoAction(ActionEvent e) throws Exception {
		//Botão finalizado
		Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
		alerta.setTitle("Confirmação limpar carrinho");
		alerta.setContentText("Deseja realmente retirar todos os itens do carrinho?");
		alerta.setHeaderText(null);
		Optional<ButtonType> resultado = alerta.showAndWait();
		if( resultado.isPresent() && resultado.get() == ButtonType.OK) {
			ObservableList<String> lista = listCarrinho.getItems();
			lista.clear();
			this.listCarrinho.setItems(lista);
			this.totalJogosCarrinho.setText(Integer.toString(0));
		}
	}
	
	@FXML
	public void removerCarrinhoAction(ActionEvent e) throws Exception {
		//Botão finalizado
		TextInputDialog dialog = new TextInputDialog("Remover jogo do carrinho");
		dialog.setTitle("Remover do carrinho");
		dialog.setContentText("Escolha um jogo para remover do carrinho.");
		
		Optional<String> resultado = dialog.showAndWait();
		if( resultado.isPresent()) {
			ObservableList<String> lista = listCarrinho.getItems();
			if( lista.contains(resultado.get())) {
				lista.remove(resultado.get());
				this.listBiblioteca.setItems(lista);
				int i = Integer.parseInt(this.totalJogosCarrinho.getText());
				this.totalJogosCarrinho.setText(Integer.toString(i-1));
			}else {
				Alert alerta = new Alert(Alert.AlertType.WARNING);
				alerta.setTitle("Item não encontrado");
				alerta.setContentText("Jogo não presente no carrinho.");
				alerta.setHeaderText(null);
				alerta.showAndWait();
			}
		}
		
	}
	
	@FXML
	public void alterarSenhaAction(ActionEvent e) throws Exception {
		//Revisao
		TextInputDialog dialog = new TextInputDialog("Alterar Senha");
		dialog.setTitle("Nova senha");
		dialog.setContentText("Digite uma nova senha para a conta.");
		
		Optional<String> resultado = dialog.showAndWait();
		if( resultado.isPresent()) {
			if( resultado.get().equals("")) {
				Alert alerta = new Alert(Alert.AlertType.WARNING);
				alerta.setTitle("Operação inválida");
				alerta.setContentText("Preencha todos os campos.");
				alerta.setHeaderText(null);
				alerta.showAndWait();
			}else {
				this.fachada.alterarSenhaUsuario(lojaApp.getUserSistema().getUser(), resultado.get());
			}
		}
	}
	
	@FXML
	public void initialize() {
		//Falta iniciar todas as listas com itens vindos dos repositorios
		user.setText(lojaApp.getUserSistema().getUser());
		
		ArrayList<String> listona = new ArrayList<>();
		
		ArrayList<Jogo> listaJogos = lojaApp.getUserSistema().getJogosPossuidos();
		for( Jogo jogo : listaJogos) {
			listona.add((String)jogo.getNome());
		}
		ObservableList<String> teste = FXCollections.observableArrayList(listona);
		listBiblioteca.setItems(teste);
		
		listona.clear();
		ArrayList<Jogo> jogosRep = fachada.getListaJogo();
		for(Jogo jogo : jogosRep) {
			listona.add(jogo.getNome());
		}
		ObservableList<String> teste2 = FXCollections.observableArrayList(listona);
		listLoja.setItems(teste2);
		
		ObservableList<String> lista = this.listBiblioteca.getItems();
		this.totalJogosBiblioteca.setText(Integer.toString(lista.size()));
		lista = this.listLoja.getItems();
		this.totalJogosLoja.setText(Integer.toString(lista.size()));
		lista = this.listCarrinho.getItems();
		this.totalJogosCarrinho.setText(Integer.toString(lista.size()));

	}

	public Label getUser() {
		return user;
	}

	public void setUser(Label user) {
		this.user = user;
	}
	
	public void setTotalJogosBiblioteca(Label totalJogosBiblioteca) {
		this.totalJogosBiblioteca = totalJogosBiblioteca;
	}
	
	public void setTotalJogosCarrinho(Label totalJogosCarrinho) {
		this.totalJogosCarrinho = totalJogosCarrinho;
	}
	
	public void setTotalJogosLoja(Label totalJogosLoja) {
		this.totalJogosLoja = totalJogosLoja;
	}
	
	public void setUsuarioAtual(Usuario user) {
		this.usuarioAtual = user;
	}
	
	public void atualizar(Usuario user) {
		this.user.setText(user.getUser());
	}


}
