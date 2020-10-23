package dados;

import java.util.ArrayList;
import negocio.beans.Conta;

import negocio.beans.Jogo;

public interface IAdmSis {
	
	void addJogo(String nome,float preco, Conta currentUser);
	void rmvJogo(int id, Conta currentUser);
	void modJogo(int id, float newPreco, Conta currentUser);
	ArrayList<Jogo> getListaJogos(Conta currentUser);
	
}
