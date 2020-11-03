package application.view;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

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
import sistema.classesbase.AuxRelatorioDate;
import sistema.classesbase.AuxRelatorioJogo;
import sistema.classesbase.AuxRelatorioUsuario;
import sistema.classesbase.Conta;
import sistema.classesbase.Jogo;
import sistema.classesbase.Pedido;
import sistema.classesbase.Usuario;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;

public class ControladorRelatorioTela {
	
	private LojaApp lojaApp;
	private FachadaLoja fachada = FachadaLoja.getInstance();
	 
	@FXML
	public TableColumn<AuxRelatorioUsuario, String> valorUsuarioColumn;

    @FXML
    public TableColumn<AuxRelatorioUsuario, String> usuarioColumn;

    @FXML
    public TableView<AuxRelatorioDate> dataTableView;

    @FXML
    public TableColumn<AuxRelatorioDate, String> dataColumn;

    @FXML
    public TableColumn<AuxRelatorioJogo, String> jogoColumn;

    @FXML
    public TableView<AuxRelatorioJogo> jogoTableView;

    @FXML
    public TableView<AuxRelatorioUsuario> usuarioTableView;

    @FXML
    public TableColumn<AuxRelatorioDate, String> valorDataColumn;

    @FXML
    public TableColumn<AuxRelatorioJogo, String> valorJogoColumn;

    @FXML
    public void sairAction(ActionEvent event) throws Exception {
    	lojaApp.abrirSistemaTela();
    }
	
	@FXML
	public void initialize() {
		
		jogoColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getJogos()));
		valorJogoColumn.setCellValueFactory(cellData -> new SimpleStringProperty(Float.toString(cellData.getValue().getQuantiaVendida())));
		
		usuarioColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getUser()));
		valorUsuarioColumn.setCellValueFactory(cellData -> new SimpleStringProperty(Float.toString(cellData.getValue().getValorGasto())));
		
		dataColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getData().toString()));
		valorDataColumn.setCellValueFactory(cellData -> new SimpleStringProperty(Float.toString(cellData.getValue().getValorData())));
		
		ArrayList<LocalDate> dataTemp = new ArrayList<>();
		ArrayList<Float> valorData = new ArrayList<>();
		ArrayList<AuxRelatorioDate> auxDate = new ArrayList<>();
		
		ArrayList<AuxRelatorioJogo> auxJogo = new ArrayList<>();
		ArrayList<Float> valorJogo = new ArrayList<>();
		ArrayList<String> jogos = new ArrayList<>();
		
		ArrayList<AuxRelatorioUsuario> auxUsuario = new ArrayList<>();
		ArrayList<String> users = new ArrayList<>();
		ArrayList<Float> valorUsuario = new ArrayList<>();

	        
        ObservableList<Pedido> dadosPedido = FXCollections.observableArrayList();
        fachada.getListaPedido().stream().forEach(c -> dadosPedido.add(c));
        
        for( Pedido pedido : fachada.getListaPedido()) {
        	if(!(dataTemp.contains(pedido.getDataVenda()))) {
        		dataTemp.add(pedido.getDataVenda());
        	}
        }
        Collections.sort(dataTemp);
        
        for( LocalDate date : dataTemp) {
        	float valor = 0;
        	for( Pedido pedido : fachada.getListaPedido()) {
        		if( pedido.getDataVenda().equals(date)) {
        			valor += pedido.getValorTotal();
        		}
        	}
        	valorData.add(valor);
        }
        for( int i = 0 ; i < dataTemp.size(); i++) {
        	auxDate.add(new AuxRelatorioDate(dataTemp.get(i), valorData.get(i)));
        }
        ObservableList<AuxRelatorioDate> dadosAuxDate = FXCollections.observableArrayList();
        auxDate.stream().forEach(c -> dadosAuxDate.add(c));
        setDadosData(dadosAuxDate);
        //final setar data
        for( Jogo jogo : fachada.getListaJogo()) {
        	jogos.add(jogo.getNome());
        }
        Collections.sort(jogos);
        for( int i = 0; i < jogos.size() ; i++) {
        	float contador = 0;
        	for( Pedido pedido : fachada.getListaPedido()) {
        		for( Jogo jogo : pedido.getListaJogosPedido()) {
        			if( jogo.getNome().equals(jogos.get(i))) {
        				contador++;
        			}
        		}
        	}
        	auxJogo.add(new AuxRelatorioJogo(jogos.get(i), contador));
        }
        ObservableList<AuxRelatorioJogo> dadosAuxJogo = FXCollections.observableArrayList();
        auxJogo.stream().forEach(c -> dadosAuxJogo.add(c));
        setDadosJogo(dadosAuxJogo);
        //fim auxJogos
        for( Usuario user : fachada.listar()) {
        	users.add(user.getUser());
        }
        Collections.sort(users);
        for( int i = 0; i < users.size() ; i++) {
        	float contador = 0;
        	for( Pedido pedido : fachada.getListaPedido()) {
        		if( pedido.getComprador().getUser().equals(users.get(i))) {
        			contador += pedido.getValorTotal();
        		}
        	}
        	auxUsuario.add(new AuxRelatorioUsuario(users.get(i), contador));
        }
        ObservableList<AuxRelatorioUsuario> dadosAuxUsuario = FXCollections.observableArrayList();
        auxUsuario.stream().forEach(c -> dadosAuxUsuario.add(c));
        setDadosUsuario(dadosAuxUsuario);
		
	}
	public void setDadosJogo(ObservableList<AuxRelatorioJogo> dadosConta) {
    	jogoTableView.setItems(dadosConta);
    }
	
	public void setDadosUsuario(ObservableList<AuxRelatorioUsuario> dadosConta) {
    	usuarioTableView.setItems(dadosConta);
    }
	
	public void setDadosData(ObservableList<AuxRelatorioDate> dadosConta) {
    	dataTableView.setItems(dadosConta);
    }
	
	public void setLojaApp(LojaApp lojaApp) {
		this.lojaApp = lojaApp;
	}
	

}
