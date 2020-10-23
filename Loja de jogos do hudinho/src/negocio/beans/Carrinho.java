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
	

}
