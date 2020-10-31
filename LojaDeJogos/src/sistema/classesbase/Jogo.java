package sistema.classesbase;

public class Jogo {
	private String nome;
	private double id;
	private float preco;
	private static int contador;
	
	public Jogo (String nome, float preco)
	{
		this.nome = nome;
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if(nome!=null)
		this.nome = nome;
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
		if(preco>=0)
		this.preco = preco;
	}
	
	public String toString()
	{
		String resultado="";
		resultado = "jogo( Nome:"+this.getNome()+", Preco: "+this.getPreco()+"id: "+this.getId();
		return resultado;
				
	}

}
