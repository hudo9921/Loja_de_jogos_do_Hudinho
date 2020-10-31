package sistema;

import java.util.List;

import sistema.classesbase.Admin;
import sistema.classesbase.Conta;
import sistema.classesbase.Usuario;
import sistema.controladores.ControladorAdmin;
import sistema.controladores.ControladorConta;
import sistema.dados.RepAdmins;
import sistema.dados.RepContas;

public class FachadaLoja {
	private ControladorConta controladorContas;
	private ControladorAdmin controladorAdmins;
	
	private static FachadaLoja instance;
	
	private FachadaLoja()
	{
		this.controladorContas= new ControladorConta(RepContas.getInstance());
		this.controladorAdmins= new ControladorAdmin(RepAdmins.getInstance());
	}
	
	public static FachadaLoja getInstance() {
		if(instance==null) {
			instance = new FachadaLoja();
		}
		return instance;
	}
	
	//controlador Admins
	public void criarContaAdmin(String username, String senha) {
		this.controladorAdmins.criarContaAdmin(username, senha);
	}
	public List<Admin> listarAdmins() {
		return this.controladorAdmins.getListaAdmins();
	}
	
	public Admin procurarAdmin(String username) {
		return this.controladorAdmins.procurarAdmin(username);
	}
	
	public boolean existeAdmin(String username)
	{
		return this.controladorAdmins.existeAdmin(username);
	}
	
	//controlador Contas
	public void criarConta(String username, String senha) {
		this.controladorContas.criarConta(username, senha);
	}
	public List<Usuario> listar() {
		return this.controladorContas.getListaUsuarios();
	}
	
	public Usuario procurarUsuario(String username) {
		return this.controladorContas.procurar(username);
	}
	
	public boolean existe(String username)
	{
		return this.controladorContas.existe(username);
	}
}
