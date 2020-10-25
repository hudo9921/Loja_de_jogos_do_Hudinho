package negocio.beans;

import java.util.ArrayList;

import negocio.*;

public class Admin extends Conta
{
	private int codigoAutenticacao;
		
	public Admin(String user, double id, String senha,int codAut) {
		super(user, id, senha);
		this.setCodigoAutenticacao(codAut);
		
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
