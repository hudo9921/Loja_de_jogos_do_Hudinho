package negocio.beans;

import java.util.ArrayList;
import java.time.LocalDate;

public class Carrinho {
	
	private ArrayList<Jogo> listaJogos;
	private Conta proprietario;
	private LocalDate dataCompra;
	
	public Carrinho( ArrayList<Jogo> listaJogos, Conta proprietario, LocalDate dataCompra) {
		this.listaJogos = listaJogos;
		LocalDate dataAtual = LocalDate.now();
		this.dataCompra = dataAtual;
		this.proprietario = proprietario;
	}

	public ArrayList<Jogo> getListaJogos() {
		return listaJogos;
	}

	public void setListaJogos(ArrayList<Jogo> listaJogos) {
		this.listaJogos = listaJogos;
	}

	public Conta getProprietario() {
		return proprietario;
	}

	public void setProprietario(Conta proprietario) {
		this.proprietario = proprietario;
	}

	public LocalDate getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(LocalDate dataCompra) {
		this.dataCompra = dataCompra;
	}
	
	public void addCarrinho( Jogo game) {
		ArrayList<Jogo> resultado = new ArrayList<>();
		resultado.add( game);
		this.setListaJogos(resultado);
	}
	
	public void clearCarrinho() {
		ArrayList<Jogo> resultado = this.getListaJogos();
		resultado.clear();
		this.setListaJogos(resultado);
	}
	
	public void  removeGameCarrinho( Jogo game) {
		for (int i = 0; i < this.getListaJogos().size(); i++) 
		{
			if(game.getId()==this.getListaJogos().get(i).getId())
			{
				this.getListaJogos().remove(i);
			}
		}
	}
	

}
