package sistema.controladores;

import java.util.ArrayList;
import java.util.List;

import sistema.classesbase.Conta;
import sistema.classesbase.Jogo;
import sistema.classesbase.Usuario;
import sistema.dados.IRepContas;

public class ControladorConta {
	private IRepContas repContas;
	public ControladorConta(IRepContas instanciaRepositorio)
	{
		this.repContas = instanciaRepositorio;
	}	
	
	public void criarConta(String username,String senha)
	{
		/*if(!(username!="admin")||username==null||senha==null)
		{
			//exce (grafica se pa) //ver contas repetidas
		}*/
		this.repContas.criarConta(username,senha);
	}
	public ArrayList<Usuario> getListaUsuarios()
	{
		return repContas.getListaUsuarios();
	}
	public boolean existe(String username)
	{
		return this.repContas.existe(username);
	}
	
	public Usuario procurar(String username) {
		return this.repContas.consultar(username);
	}
	
	public void alterarSenhaUsuario(String username,String novaSenha) {
		this.repContas.alterarSenha(username, novaSenha);
	}
	
	public void adicionarJogoUsuario(ArrayList<Jogo> jogos, Usuario user) {
		this.repContas.adicionarJogoUsuario(jogos, user);
	}
	
	public void removerJogoUsuario(Jogo jogo, Usuario user) {
		this.repContas.removerJogoUsuario(jogo, user);
	}
	
	public void removerUsuario(String username) {
		this.repContas.remover(username);
	}

}
