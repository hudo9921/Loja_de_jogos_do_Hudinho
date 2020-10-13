package dados;

import java.util.ArrayList;

import negocio.beans.Jogo;

public interface ISisJogo 
{

	void addJogo(String nome,float preco);
	void rmvJogo(int id);
	void modJogo(int id,float newPreco);
	ArrayList<Jogo> getListaJogos();
}
