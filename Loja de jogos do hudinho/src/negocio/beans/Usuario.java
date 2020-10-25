package negocio.beans;

import java.util.ArrayList;
import dados.ISisPedido;

public class Usuario extends Conta {
	
	private ArrayList<Jogo> jogosPossuidos;
	
	public Usuario( String user, double id, String senha,ISisPedido repPedido) {
		super(user, id, senha);
		this.jogosPossuidos = new ArrayList<>();
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
	
	public void alterarSenha( String novaSenha) {
		this.setSenha(novaSenha);
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
