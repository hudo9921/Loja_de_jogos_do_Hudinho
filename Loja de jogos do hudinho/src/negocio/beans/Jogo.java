package negocio.beans;

public class Jogo {
	
	private String nome;
	//revisar id
	private int id;
	private float preco;
	private int qntVendido;
	private int contador;
	
	public Jogo( String nome, float preco,int contador) {
		this.setNome(nome);
		this.setPreco(preco);
		this.id=6000+contador;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
		resultado = "Jogo( Nome: " + this.getNome() + ", Preço: " + this.getPreco() + ")" + "id:"+ this.getId();
		return resultado;
	}
	
}
