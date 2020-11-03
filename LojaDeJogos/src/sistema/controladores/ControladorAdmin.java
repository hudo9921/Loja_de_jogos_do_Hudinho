package sistema.controladores;

import java.util.ArrayList;
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
		this.repAdmins.criarConta(username,senha);
	}
	public ArrayList<Admin> getListaAdmins()
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
	
	public void alterarSenhaAdmin(String username,String novaSenha) {
		this.repAdmins.alterarSenha(username, novaSenha);
	}

}
