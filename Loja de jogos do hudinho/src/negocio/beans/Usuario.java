package negocio.beans;

import java.util.ArrayList;
import dados.IUserPedido;

public class Usuario extends Conta {
	
	private ArrayList<Jogo> jogosPossuidos;
	private ArrayList<Jogo> carrinho;
	private IUserPedido repositorioPedido;
	
	public Usuario( String user, double id, String senha,IUserPedido repPedido) {
		super(user, id, senha);
		this.jogosPossuidos = new ArrayList<>();
		this.carrinho = new ArrayList<>();
		this.repositorioPedido=repPedido;
	}

	public ArrayList<Jogo> getJogosPossuidos() {
		return jogosPossuidos;
	}

	public void setJogosPossuidos(ArrayList<Jogo> jogosPossuidos) {
		for (int i = 0; i < jogosPossuidos.size(); i++) 
		{
			//modificado para adicionar cada parte do parametro e nao apenas igualar
			if(jogosPossuidos.get(i)!=null)
			{this.jogosPossuidos.add(jogosPossuidos.get(i));}
		}
	}

	public ArrayList<Jogo> getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(ArrayList<Jogo> carrinho) {
		if(carrinho.size()>0)
		{	
			for (int i = 0; i < carrinho.size(); i++) {
				if(carrinho.get(i)!=null)
				{
					this.carrinho.add(carrinho.get(i));
				}
				
			}
		}
		this.carrinho=carrinho;
		
	}
	
	public void alterarSenha( String novaSenha) {
		this.setSenha(novaSenha);
	}
	
	public void comprarCarrinho() {
		this.setJogosPossuidos(this.getCarrinho());
		Pedido pedidoNovo;
		this.repositorioPedido.addPedido(new Usuario(this.getUser(),this.getId(),this.getSenha(),null), carrinho);
		//método para armazenar os pedidos
		ArrayList<Jogo> carrinhoClear = this.getCarrinho();
		carrinhoClear.clear();
		this.setCarrinho( carrinhoClear);
	}
	
	public void addCarrinho( Jogo game) {
		ArrayList<Jogo> resultado = new ArrayList<>();
		resultado.add( game);
		this.setCarrinho(resultado);
	}
	
	public void clearCarrinho() {
		ArrayList<Jogo> resultado = this.getCarrinho();
		resultado.clear();
		this.setCarrinho(resultado);
	}
	
	public void  removeGameCarrinho( Jogo game) {
		for (int i = 0; i < this.getCarrinho().size(); i++) 
		{
			if(game.getId()==this.getCarrinho().get(i).getId())
			{
				this.getCarrinho().remove(i);
			}
		}
	}
	
	public void  removeGameConta( Jogo game) {
		for (int i = 0; i < this.jogosPossuidos.size(); i++) 
		{
			if(game.getId()==this.jogosPossuidos.get(i).getId())
			{
				this.jogosPossuidos.remove(i);
			}
		}
	}

}
