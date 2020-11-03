package sistema.classesbase;

public class AuxRelatorioUsuario {
	
	private String user;
	private float valorGasto;
	
	public AuxRelatorioUsuario( String user, float valorGasto) {
		this.user = user;
		this.valorGasto = valorGasto;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public float getValorGasto() {
		return valorGasto;
	}

	public void setValorGasto(float valorGasto) {
		this.valorGasto = valorGasto;
	}
	

}
