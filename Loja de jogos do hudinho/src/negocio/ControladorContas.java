package negocio;

import java.util.ArrayList;

import dados.ISisConta;
import negocio.beans.Admin;
import negocio.beans.Conta;
import negocio.beans.Usuario;

public class ControladorContas {
	
	private ISisConta repositorioConta;
	
	public ControladorContas(ISisConta contaBanco)
	{
		this.repositorioConta=contaBanco;
	}
	
	void criarConta(String username,String senha){
		
		this.repositorioConta.criarConta(username,senha);
	}
	
	ArrayList<Usuario> getListaUsuarios(Conta currentUser){
		
		ArrayList<Usuario> lista = new ArrayList<>();
		if( currentUser instanceof Admin) {
			lista = this.repositorioConta.getListaUsuarios();
		}
		return lista;
	}

}
