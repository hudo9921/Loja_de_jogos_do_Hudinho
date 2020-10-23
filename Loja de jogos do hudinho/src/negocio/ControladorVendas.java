package negocio;
import java.util.ArrayList;

import dados.IAdmSis;
import dados.ISisConta;
import dados.ISisJogo;
import negocio.beans.Jogo;
import negocio.beans.Usuario;
import negocio.beans.Admin;
import negocio.beans.Conta;

public class ControladorVendas implements IAdmSis {
	
	private ISisConta repositorioConta;
	private ISisJogo repositorioJogo;
	
	public ControladorVendas(ISisConta contaBanco,ISisJogo repJogo)
	{
		this.repositorioConta=contaBanco;
		this.repositorioJogo=repJogo;
	}
	//SISTEMA E JOGO
	public void addJogo(String nome, float preco, Conta currentUser) {
		if( currentUser instanceof Admin) {
			this.repositorioJogo.addJogo(nome,preco);
		}
		else {
			//exceção
		}
	}
	public void rmvJogo(int id, Conta currentUser)
	{
		if( currentUser instanceof Admin) {
			this.repositorioJogo.rmvJogo(id);
		}
		else {
			//exceção
		}	
	}
	public void modJogo(int id,float newPreco, Conta currentUser)
	{
		if( currentUser instanceof Admin) {
			this.repositorioJogo.modJogo(id, newPreco);
		}
		else {
			//exceção
		}
	}
	public ArrayList<Jogo> getListaJogos(Conta currentUser)
	{
		ArrayList<Jogo> lista = new ArrayList<>();
		if( currentUser instanceof Admin) {
			lista = this.repositorioJogo.getListaJogos();
		}
		else {
			//exceção
		}
		return lista;
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
