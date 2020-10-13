package negocio.beans;
import java.util.ArrayList;

import dados.IAdmSis;
import dados.ISisConta;
import dados.ISisJogo;

public class Sistema implements IAdmSis {
	
	private ISisConta repositorioConta;
	private ISisJogo repositorioJogo;
	
	public Sistema(ISisConta contaBanco,ISisJogo repJogo)
	{
		this.repositorioConta=contaBanco;
		this.repositorioJogo=repJogo;
	}
	//SISTEMA E JOGO
	public void addJogo(String nome, float preco) {
		this.repositorioJogo.addJogo(nome,preco);
	}
	public void rmvJogo(int id)
	{
		this.repositorioJogo.rmvJogo(id);
	}
	public void modJogo(int id,float newPreco)
	{
		this.repositorioJogo.modJogo(id, newPreco);
	}
	public ArrayList<Jogo> getListaJogos()
	{
		return this.repositorioJogo.getListaJogos();
	}
	// FIM DE SISTEMA E JOGO	
	
	//SISTEMA E CONTA
	 void criarConta(String username,String senha)
	{
		this.repositorioConta.criarConta(username,senha);
	}
	
	 ArrayList<Usuario> getListaUsuarios()
	{
		return this.repositorioConta.getListaUsuarios();
	}
	 //FIM DE SISTEMA E CONTA

}
