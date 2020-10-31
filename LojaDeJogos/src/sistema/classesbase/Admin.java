package sistema.classesbase;

public class Admin extends Conta {
	
	private int codigoAutenticacao;

	public Admin(String user, double id, String senha, int codAut) {
		super(user, id, senha);
		this.setCodigoAutenticacao(codAut);
	}

	public int getCodigoAutenticacao() {
		return codigoAutenticacao;
	}

	public void setCodigoAutenticacao(int codigoAutenticacao) {
		if(!(codigoAutenticacao<0))
			this.codigoAutenticacao = codigoAutenticacao;
	}
	

}
