package negocio.beans;

import java.time.LocalDate;
import java.util.ArrayList;

public class Pedido {
	
	private Conta comprador;
	private float valorTotal;
	private Jogo listaJogosPedido[];
	private LocalDate dataVenda;
	
	public Pedido( Carrinho carrinho) {
		this.setComprador(carrinho.getProprietario());
	
		Jogo[] listaJogos = new Jogo[carrinho.getListaJogos().size()];
		listaJogos = (Jogo[])carrinho.getListaJogos().toArray();
		float valor = 0;
		for( Jogo game : listaJogos) {
			valor += game.getPreco();
		}
		this.setValorTotal(valor);
		this.setListaJogosPedido(listaJogos);
		this.setDataVenda(carrinho.getDataCompra());
	}

	public Conta getComprador() {
		return comprador;
	}

	public void setComprador(Conta comprador) {
		this.comprador = comprador;
	}

	public float getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Jogo[] getListaJogosPedido() {
		return listaJogosPedido;
	}

	public void setListaJogosPedido(Jogo[] listaJogos) {
		this.listaJogosPedido = listaJogos;
	}

	public LocalDate getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(LocalDate dataVenda) {
		this.dataVenda = dataVenda;
	}
	

}
