package negocio.beans;

public class Conta {
	
	private String user;
	private double id;
	private String senha;
	////quando o programa for encerrado o ultimo contador precisar ser armazenado.
	private static int contador;
	
	public Conta( String user, double id, String senha) {
		this.setUser(user);
		contador++;
		this.setId(contador);
		this.setSenha(senha);
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		if( user != null) {
			this.user = user;
		}else {
			//exceção
		}	
	}

	public double getId() {
		return id;
	}

	public void setId(double id) {
		this.id = 4000+id;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		if( senha != null) {
			this.senha = senha;
		}else {
			//exceção
		}
	}
	
	
}
