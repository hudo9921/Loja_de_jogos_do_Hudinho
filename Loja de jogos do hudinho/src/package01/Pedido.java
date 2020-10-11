package package01;

import java.time.LocalDate;
import java.util.ArrayList;

public class Pedido {
	
	private String comprador;
	private float valorTotal;
	private Jogo carrinho[];
	private LocalDate dataVenda;
	
	public Pedido( String comprador, ArrayList<Jogo> carrinho) {
		this.setComprador(comprador);
		LocalDate dataAtual = LocalDate.now();
		this.setDataVenda(dataAtual);
		
		Jogo[] carrinhoNew = carrinho.toArray(new Jogo[0]);		
		this.setCarrinho( carrinhoNew);
		float num = 0;
		for( Jogo c : this.getCarrinho()) {
			num += c.getPreco();
		}
		this.setValorTotal( num);
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
