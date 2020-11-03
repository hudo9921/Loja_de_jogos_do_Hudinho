package sistema.classesbase;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Pedido implements Serializable {
	
	private Conta comprador;
	private float valorTotal;
	private ArrayList<Jogo> listaJogosPedido;
	private LocalDate dataVenda;
	
	public Pedido (Carrinho carrinho)
	{
		this.setComprador(carrinho.getProprietario());
		ArrayList<Jogo> listaJogos = carrinho.getListaJogos();
		float valor = 0;
		for(Jogo game : listaJogos)
		{
			valor+=game.getPreco();
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

	public ArrayList<Jogo> getListaJogosPedido() {
		return listaJogosPedido;
	}

	public void setListaJogosPedido(ArrayList<Jogo> listaJogosPedido) {
		this.listaJogosPedido = listaJogosPedido;
	}

	public LocalDate getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(LocalDate dataVenda) {
		this.dataVenda = dataVenda;
	}
	

}
