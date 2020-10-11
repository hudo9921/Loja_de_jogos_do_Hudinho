package package01;

import java.time.LocalDate;

public class Pedido {
	
	private String comprador;
	private float valorTotal;
	private Jogo carrinho[];
	private LocalDate dataVenda;
	
	public Pedido( String comprador, float valorTotal, Jogo carrinho[]) {
		this.setComprador(comprador);
		this.setCarrinho(carrinho);
		LocalDate dataAtual = LocalDate.now();
		this.setDataVenda(dataAtual);
		//falta valorTotal
	}

	public String getComprador() {
		return comprador;
	}

	public void setComprador(String comprador) {
		this.comprador = comprador;
	}

	public float getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Jogo[] getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(Jogo[] carrinho) {
		this.carrinho = carrinho;
	}

	public LocalDate getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(LocalDate dataVenda) {
		this.dataVenda = dataVenda;
	}

}
