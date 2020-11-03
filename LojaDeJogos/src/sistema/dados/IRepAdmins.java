package sistema.dados;

import java.util.ArrayList;
import java.util.List;

import sistema.classesbase.Admin;
import sistema.classesbase.Conta;
import sistema.classesbase.Usuario;

public interface IRepAdmins {
	void criarConta(String username,String senha);
	ArrayList<Admin> getListaAdmins();	
	Admin consultar(String username);
	boolean existe(String username);
	void alterarSenha(String username, String novaSenha);
}
