package sistema.dados;

import java.util.ArrayList;

import sistema.classesbase.Jogo;

public interface IRepJogos {
	void cadastrarJogo(String nome,float preco);
	ArrayList<Jogo> getListaJogo();
	Jogo consultar (String nome);
	boolean existe(String nome);
	void removerJogo(String nome);
	void editarJogo(String targetNome,float tagetPreco, String originalName);
	
}
