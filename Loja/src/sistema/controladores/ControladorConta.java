package sistema.controladores;

import java.util.List;

import sistema.classesbase.Conta;
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
	public List<Usuario> getListaUsuarios()
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

}
