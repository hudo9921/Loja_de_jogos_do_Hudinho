package dados;

import java.util.ArrayList;
import negocio.beans.Pedido;
import negocio.beans.Usuario;
import negocio.beans.Jogo;
import java.time.LocalDate;

public class Repositorio implements IRepositorio{
	
	private ArrayList<Pedido> pedidosFeitos;
	private ArrayList<Jogo> listaJogos;
	private ArrayList<Usuario> listaUsuarios;
	
	public Repositorio() {
		this.pedidosFeitos = new ArrayList<>();
		this.listaJogos = new ArrayList<>();
		this.listaUsuarios = new ArrayList<>();
	}
	
	public ArrayList<Pedido> getPedidosFeitos() {
		return pedidosFeitos;
	}
	public void setPedidosFeitos(ArrayList<Pedido> pedidosFeitos) {
		this.pedidosFeitos = pedidosFeitos;
	}
	public ArrayList<Jogo> getListaJogos() {
		return listaJogos;
	}
	public void setListaJogos(ArrayList<Jogo> listaJogos) {
		this.listaJogos = listaJogos;
	}
	public ArrayList<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}
	public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}
	
	public void relatorio(String filtro) {
		//retornar relatorio de vendas.
	}
	
	public void relatorioData( LocalDate dataI, LocalDate dataF) {
		//retornar relatorio de vendas referente a uma data especifica.
	}
	
	public void criarConta( String nome, double id, String senha) {
		if( nome != null && senha != null) {
			Usuario user01 = new Usuario( nome, id, senha);
			this.listaUsuarios.add(user01);
		}else {
			//exceção
		}
	}
	
	public Jogo procurarJogos( String nomeJogo) {
		Jogo jogo = new Jogo( "", 0);
		if( nomeJogo != null) {
			ArrayList<Jogo> listaJogos = this.getListaJogos();
			for( Jogo x : listaJogos) {
				if( x.getNome() == nomeJogo) {
					jogo = x;
				}
			}
		}else {
			//exceção
		}
		return jogo;
	}
	
	public void addJogo( String nome, float preco) {
		if( nome != null && preco >= 0) {
			Jogo jogo = new Jogo( nome, preco);
			this.listaJogos.add(jogo);
		}else {
			//exceção
		}
	}
	
	public void rmvJogo( String nome, float preco) {
		if( nome != null && preco >= 0) {
			Jogo jogo = new Jogo( nome, preco);
			this.listaJogos.remove(jogo);
		}else {
			//exceção
		}
	}
		
}
