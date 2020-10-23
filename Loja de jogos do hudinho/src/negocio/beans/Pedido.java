package negocio.beans;

import java.time.LocalDate;
import java.util.ArrayList;

public class Pedido {
	
	private Usuario comprador;
	private float valorTotal;
	private Jogo carrinho[];
	private LocalDate dataVenda;
	
	public Pedido( Usuario comprador, ArrayList<Jogo> carrinho) {
		this.setComprador(comprador);
		LocalDate dataAtual = LocalDate.now();
		this.setDataVenda(dataAtual);
		
		Jogo[] carrinhoNew = new Jogo[carrinho.size()];
		carrinho.toArray(carrinhoNew);
		this.setCarrinho(carrinhoNew);
		
		float num = 0;
		for( Jogo c : this.getCarrinho()) {
			num += c.getPreco();
		}
		this.setValorTotal( num);
	}

	public Usuario getComprador() {
		return comprador;
	}

	public void setComprador(Usuario comprador) {
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
