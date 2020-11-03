package sistema;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import sistema.classesbase.Admin;
import sistema.classesbase.Carrinho;
import sistema.classesbase.Conta;
import sistema.classesbase.Jogo;
import sistema.classesbase.Pedido;
import sistema.classesbase.Usuario;
import sistema.controladores.ControladorAdmin;
import sistema.controladores.ControladorConta;
import sistema.controladores.ControladorJogos;
import sistema.controladores.ControladorPedidos;
import sistema.dados.RepAdmins;
import sistema.dados.RepContas;
import sistema.dados.RepJogos;
import sistema.dados.RepPedidos;

public class FachadaLoja {
	private ControladorConta controladorContas;
	private ControladorAdmin controladorAdmins;
	private ControladorJogos controladorJogos;
	private ControladorPedidos controladorPedidos;
	
	private static FachadaLoja instance;
	
	private FachadaLoja()
	{
		this.controladorContas= new ControladorConta(RepContas.getInstance());
		this.controladorAdmins= new ControladorAdmin(RepAdmins.getInstance());
		this.controladorJogos = new ControladorJogos(RepJogos.getInstance());
		this.controladorPedidos= new ControladorPedidos(RepPedidos.getInstance());
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
	public ArrayList<Admin> listarAdmins() {
		return this.controladorAdmins.getListaAdmins();
	}
	
	public Admin procurarAdmin(String username) {
		return this.controladorAdmins.procurarAdmin(username);
	}
	
	public boolean existeAdmin(String username)
	{
		return this.controladorAdmins.existeAdmin(username);
	}
	
	public void alterarSenhaAdmin(String username,String novaSenha) {
		this.controladorAdmins.alterarSenhaAdmin(username, novaSenha);
	}
	
	//controlador Contas
	public void criarConta(String username, String senha) {
		this.controladorContas.criarConta(username, senha);
	}
	public ArrayList<Usuario> listar() {
		return this.controladorContas.getListaUsuarios();
	}
	
	public Usuario procurarUsuario(String username) {
		return this.controladorContas.procurar(username);
	}
	
	public boolean existe(String username)
	{
		return this.controladorContas.existe(username);
	}
	
	public void alterarSenhaUsuario(String username,String novaSenha) {
		this.controladorContas.alterarSenhaUsuario(username, novaSenha);
	}
	
	public void adicionarJogoUsuario(ArrayList<Jogo> jogos, Usuario user) {
		this.controladorContas.adicionarJogoUsuario(jogos, user);
	}
	
	public void removerJogoUsuario(Jogo jogo, Usuario user) {
		this.controladorContas.removerJogoUsuario(jogo, user);
	}
	
	public void removerUsuario(String username) {
		this.controladorContas.removerUsuario(username);
	}
	
	//Controlador Jogos
		public void cadastrarJogo(String nome,float preco)
		{
			this.controladorJogos.cadastrarJogo(nome, preco);
		}
		
		public ArrayList<Jogo> getListaJogo()
		{
			return this.controladorJogos.getListaJogo();
		}
		
		public Jogo consultarJogo(String nome)
		{
			return this.controladorJogos.consultarJogo(nome);
		}
		
		public boolean existeJogo(String nome)
		{
			return this.controladorJogos.existeJogo(nome);
		}
		
		public void rmvJogo(String nome)
		{
			this.controladorJogos.rmvJogo(nome);
		}
		
		public void editarJogo(String targetNome,float tagetPreco, String originalName)
		{
			this.controladorJogos.editarJogo(targetNome, tagetPreco, originalName);
		}
		
		//Controlador pedidos
		public void inserirPedido(Carrinho carro)
		{
			this.controladorPedidos.inserirPedido(carro);
		}
		public float lucroTotal()
		{
			return this.controladorPedidos.lucroTotal();
		}
		public ArrayList<Pedido> getListaPedido()
		{
			return this.controladorPedidos.getListaPedido();
		}
		public float lucroData(LocalDate date1, LocalDate date2) {
			
			return this.controladorPedidos.lucroData(date1, date2);
		}
}
