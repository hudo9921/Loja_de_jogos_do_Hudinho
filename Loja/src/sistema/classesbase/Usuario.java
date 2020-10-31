package sistema.classesbase;

import java.io.Serializable;
import java.util.ArrayList;

public class Usuario extends Conta implements Serializable {
	
	private ArrayList<Jogo> JogosPossuidos;

	public Usuario(String user, double id, String senha) {
		super(user, id, senha);
		this.JogosPossuidos = new ArrayList();
	}
	
	public void setJogosPossuidos(ArrayList<Jogo> JogosPossuidos)
	{
		for (int i = 0; i <JogosPossuidos.size(); i++) {
			if(JogosPossuidos.get(i)!=null)
			{
				this.JogosPossuidos.add(JogosPossuidos.get(i));
			}
		}
	}
	public void alterarSenha(String novaSenha)
	{
		this.setSenha(novaSenha);
	}
	public void removeGameConta(Jogo game)
	{
		for (int i = 0; i <JogosPossuidos.size(); i++) {
				if(game.getId()==this.JogosPossuidos.get(i).getId())
				{
					this.JogosPossuidos.remove(i);
				}
		}
	}
	public String toString() {
		String resultado = "";
		resultado += "Nome:" + this.getUser() + "/Senha:" + this.getSenha(); 
		return resultado;
	}

	public ArrayList<Jogo> getJogosPossuidos() {
		return JogosPossuidos;
	}
	
	
}
