package sistema.controladores;

import java.util.List;

import sistema.classesbase.Admin;
import sistema.classesbase.Conta;
import sistema.classesbase.Usuario;
import sistema.dados.IRepAdmins;
import sistema.dados.IRepContas;

public class ControladorAdmin {
	private IRepAdmins repAdmins;
	public ControladorAdmin(IRepAdmins instanciaRepositorio)
	{
		this.repAdmins = instanciaRepositorio;
	}	
	
	public void criarContaAdmin(String username,String senha)
	{
		/*if(!(username!="admin")||username==null||senha==null)
		{
			//exce (grafica se pa) //ver contas repetidas
		}*/
		this.repAdmins.criarConta(username,senha);
	}
	public List<Admin> getListaAdmins()
	{
		return repAdmins.getListaAdmins();
	}
	public boolean existeAdmin(String username)
	{
		return this.repAdmins.existe(username);
	}
	
	public Admin procurarAdmin(String username) {
		return this.repAdmins.consultar(username);
	}

}
