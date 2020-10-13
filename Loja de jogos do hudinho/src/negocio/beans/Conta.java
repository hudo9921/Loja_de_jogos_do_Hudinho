package negocio.beans;

public class Conta {
	
	private String user;
	//revisar o atributo id
	private double id;
	private String senha;
	
	public Conta( String user, double id, String senha) {
		this.setUser(user);
		this.setId(id);
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
