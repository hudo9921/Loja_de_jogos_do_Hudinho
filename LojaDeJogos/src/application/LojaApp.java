package application;

import java.io.IOException;
import java.io.File;

import application.view.ControladorCriarContaTela;
import application.view.ControladorSistemaTela;
import application.view.ControladorTelaLogin;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sistema.FachadaLoja;
import sistema.classesbase.Usuario;

public class LojaApp extends Application {
	
    private Stage primaryStage;
    private BorderPane rootLayout;
    private static Stage stage;
    private static Usuario userSistema;
    
    private static Scene telaLogin;

    @Override
    public void start(Stage primaryStage) throws Exception {
    	
    	Usuario user01 = new Usuario("",0,"");
    	this.userSistema = user01;
    	
    	stage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("TelaLogin.fxml"));
        Scene scene = new Scene(root);
        this.telaLogin = scene;
        primaryStage.setScene(scene);
        primaryStage.setTitle("Loja de Jogos do Hudinho");
	    
        primaryStage.show();
    }
    
	/**
	 * Retorna o palco principal.
	 * @return
	 */
	public Stage getPrimaryStage() {
		return primaryStage;
	}

    public static void main(String[] args) {
        launch(args);
    }
    
    public static void abrirCriarContaTela() throws Exception { 	    
    	Parent criarContaTela = FXMLLoader.load(LojaApp.class.getResource("view/telas/CriarContaTela.fxml"));
	    Scene sceneCriarContaTela = new Scene(criarContaTela);
    	stage.setScene(sceneCriarContaTela);
    }
    
    public static void abrirSistemaTela() throws Exception { 	    
    	Parent sistemaTela = FXMLLoader.load(LojaApp.class.getResource("view/telas/SistemaTela2.fxml"));
	    Scene sceneSistemaTela = new Scene(sistemaTela);
    	stage.setScene(sceneSistemaTela);
    	
    }
    
    public static void abrirTelaLogin() { 	    
    	stage.setScene(telaLogin);  
    }

	public static Usuario getUserSistema() {
		return userSistema;
	}

	public static void setUserSistema(Usuario userSistema) {
		LojaApp.userSistema = userSistema;
	}
    
    
    
    

}
