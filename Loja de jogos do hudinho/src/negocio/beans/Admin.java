package negocio.beans;
import java.util.ArrayList;

import dados.IAdmSis;
import negocio.beans.*;

public class Admin extends Conta
{
		private int codigoAutenticacao;
		private IAdmSis interSis; 
		
	public Admin(String user, double id, String senha,int codAut, IAdmSis repositorio) {
		super(user, id, senha);
		this.setCodigoAutenticacao(codAut);
		this.interSis=repositorio;
		
		// TODO Auto-generated constructor stub
	}
	
	public int getCodigoAutenticacao() {
		return codigoAutenticacao;
		
	}
	public void setCodigoAutenticacao(int codigoAutenticacao) {
		if(!(codigoAutenticacao<0))
		{
			this.codigoAutenticacao=codigoAutenticacao;
		}
	}
	
	
	
}
