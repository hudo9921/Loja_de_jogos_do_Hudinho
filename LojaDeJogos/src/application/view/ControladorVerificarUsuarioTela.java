package application.view;

import java.util.ArrayList;

import application.LojaApp;
import javafx.fxml.FXML;
import javafx.fxml.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import sistema.FachadaLoja;
import sistema.classesbase.Jogo;
import sistema.classesbase.Pedido;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

public class ControladorVerificarUsuarioTela {
	
	private LojaApp lojaApp;
	private FachadaLoja fachada = FachadaLoja.getInstance();
	
	@FXML
    public Label nomeUsuario;
	 
	@FXML
	public ListView listaJogos;

    @FXML
    public Label valor;

    @FXML
    public Label senhaUsuario;
    
    @FXML
    public TableColumn<Jogo, String> jogoColumn;

    @FXML
    public TableColumn<Jogo, String> precoColumn;

    @FXML
    public TableView<Jogo> tableJogo;
	
	@FXML
	public void okAction(ActionEvent e) throws Exception {
		lojaApp.abrirSistemaTela();
	}
	
	@FXML
	public void cancelarAction(ActionEvent e) throws Exception {
		lojaApp.abrirSistemaTela();
	}
	
	@FXML
	public void initialize() {
		nomeUsuario.setText(lojaApp.getVerificarSistema().getUser());
		senhaUsuario.setText(lojaApp.getVerificarSistema().getSenha());
		//valor.setText(arg0);
		ArrayList<Pedido> pedidos = fachada.getListaPedido();
		float x = 0;
		for( Pedido pedido : pedidos) {
			if( pedido.getComprador().getUser().equals(lojaApp.getVerificarSistema().getUser())) {
				x += pedido.getValorTotal();
			}
		}
		valor.setText(Float.toString(x));
		
		jogoColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNome()));
		precoColumn.setCellValueFactory(cellData -> new SimpleStringProperty(Float.toString(cellData.getValue().getPreco())));
		
		 ObservableList<Jogo> dados = FXCollections.observableArrayList();
	        fachada.getListaJogo().stream().forEach(c -> dados.add(c));
	        setDados(dados);
		
	}
	public void setDados(ObservableList<Jogo> dadosConta) {
    	tableJogo.setItems(dadosConta);
    }
	
	public void setLojaApp(LojaApp lojaApp) {
		this.lojaApp = lojaApp;
	}
	

}
