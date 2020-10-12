package negocio.beans;

public class Jogo {
	
	private String nome;
	//revisar id
	private double id;
	private float preco;
	private int qntVendido;
	
	public Jogo( String nome, float preco) {
		this.setNome(nome);
		this.setPreco(preco);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if( nome != null) {
			this.nome = nome;
		}else {
			//exceção
		}
	}

	public double getId() {
		return id;
	}

	public void setId(double id) {
		this.id = id;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		if( preco >= 0) {
			this.preco = preco;
		}else{
			//exceção
		}
	}

	public int getQntVendido() {
		return qntVendido;
	}

	public void setQntVendido(int qntVendido) {
		this.qntVendido = qntVendido;
	}
	
	public String toString() {
		String resultado = "";
		resultado = "Jogo( Nome: " + this.getNome() + ", Preço: " + this.getPreco() + ")";
		return resultado;
	}
	
}
