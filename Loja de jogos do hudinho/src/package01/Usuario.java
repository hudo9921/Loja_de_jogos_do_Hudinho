package package01;

import java.util.ArrayList;

public class Usuario extends Conta {
	
	private ArrayList<Jogo> jogosPossuidos;
	private ArrayList<Jogo> carrinho;
	
	public Usuario( String user, double id, String senha) {
		super(user, id, senha);
		this.jogosPossuidos = new ArrayList<>();
		this.carrinho = new ArrayList<>();
	}

	public ArrayList<Jogo> getJogosPossuidos() {
		return jogosPossuidos;
	}

	public void setJogosPossuidos(ArrayList<Jogo> jogosPossuidos) {
		this.jogosPossuidos = jogosPossuidos;
	}

	public ArrayList<Jogo> getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(ArrayList<Jogo> carrinho) {
		this.carrinho = carrinho;
	}
	
	public void alterarSenha( String novaSenha) {
		this.setSenha(novaSenha);
	}
	
	public void comprarCarrinho() {
		ArrayList<Jogo> resultado = this.getJogosPossuidos();
		resultado.addAll( this.getCarrinho());
		this.setJogosPossuidos(resultado);
		Pedido pedidoNovo = new Pedido( this.getUser(), resultado);
		//método para armazenar os pedidos
		ArrayList<Jogo> carrinhoClear = this.getCarrinho();
		carrinhoClear.clear();
		this.setCarrinho( carrinhoClear);
	}
	
	public void addCarrinho( Jogo game) {
		ArrayList<Jogo> resultado = this.getCarrinho();
		resultado.add( game);
		this.setCarrinho(resultado);
	}
	
	public void clearCarrinho() {
		ArrayList<Jogo> resultado = this.getCarrinho();
		resultado.clear();
		this.setCarrinho(resultado);
	}
	
	public void  removeGameCarrinho( Jogo game) {
		ArrayList<Jogo> resultado = this.getCarrinho();
		if( resultado.contains( game)) {
			resultado.remove( game);
		}else {
			//exceção
		}
		this.setCarrinho(resultado);
	}
	
	public void  removeGameConta( Jogo game) {
		ArrayList<Jogo> resultado = this.getJogosPossuidos();
		if( resultado.contains( game)) {
			resultado.remove( game);
		}else {
			//exceção
		}
		this.setJogosPossuidos( resultado);
	}

}
