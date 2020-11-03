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
import sistema.classesbase.Admin;
import sistema.classesbase.Jogo;
import sistema.classesbase.Usuario;

public class LojaApp extends Application {
	
    private Stage primaryStage;
    private BorderPane rootLayout;
    private static Stage stage;
    private static Usuario userSistema;
    private static Jogo jogoSistema;
    private static Usuario verificarSistema;
    private static Admin adminSistema;
    
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
    	Parent sistemaTela = FXMLLoader.load(LojaApp.class.getResource("view/telas/SistemaTela3.fxml"));
    	if( getAdminSistema() != null) {
    		sistemaTela = FXMLLoader.load(LojaApp.class.getResource("view/telas/AdminTela1.fxml"));
    	}
	    Scene sceneSistemaTela = new Scene(sistemaTela);
    	stage.setScene(sceneSistemaTela);
    	
    }
    
    public static void abrirAddJogoTela() throws Exception { 	    
    	Parent addJogoTela = FXMLLoader.load(LojaApp.class.getResource("view/telas/AddJogoTela.fxml"));
	    Scene sceneAddJogoTela = new Scene(addJogoTela);
    	stage.setScene(sceneAddJogoTela);	
    }
    
    public static void abrirRelatorioTela() throws Exception { 	    
    	Parent addJogoTela = FXMLLoader.load(LojaApp.class.getResource("view/telas/RelatorioTela.fxml"));
	    Scene sceneAddJogoTela = new Scene(addJogoTela);
    	stage.setScene(sceneAddJogoTela);	
    }
    
    public static void abrirVerificarUsuarioTela() throws Exception { 	    
    	Parent verificarUsuarioTela = FXMLLoader.load(LojaApp.class.getResource("view/telas/VerificarUsuarioTela.fxml"));
	    Scene sceneVerificarUsuarioTela = new Scene(verificarUsuarioTela);
    	stage.setScene(sceneVerificarUsuarioTela);	
    }
    
    public static void abrirActionTela() throws Exception { 	    
    	Parent actionTela = FXMLLoader.load(LojaApp.class.getResource("view/telas/ActionTela.fxml"));
	    Scene sceneActionTela = new Scene(actionTela);
    	stage.setScene(sceneActionTela);	
    }
    
    public static void abrirModJogoTela() throws Exception { 	    
    	Parent addJogoTela = FXMLLoader.load(LojaApp.class.getResource("view/telas/ModJogoTela.fxml"));
	    Scene sceneAddJogoTela = new Scene(addJogoTela);
    	stage.setScene(sceneAddJogoTela);	
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

	public static Admin getAdminSistema() {
		return adminSistema;
	}

	public static void setAdminSistema(Admin adminSistema) {
		LojaApp.adminSistema = adminSistema;
	}
	
	public static Jogo getJogoSistema() {
		return jogoSistema;
	}
	
	public static void setJogoSistema(Jogo jogoSistema) {
		LojaApp.jogoSistema = jogoSistema;
	}

	public static Usuario getVerificarSistema() {
		return verificarSistema;
	}

	public static void setVerificarSistema(Usuario verificarSistema) {
		LojaApp.verificarSistema = verificarSistema;
	}
	
	

}
