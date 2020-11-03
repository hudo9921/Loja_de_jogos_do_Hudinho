package sistema.controladores;

import sistema.classesbase.Jogo;
import sistema.dados.IRepJogos;

import java.util.ArrayList;

public class ControladorJogos {
	private IRepJogos repJogos;
	public ControladorJogos(IRepJogos instanciaRepJogos) 
	{
		this.repJogos = instanciaRepJogos;
	}
	
	public void cadastrarJogo(String nome,float preco)
	{
		this.repJogos.cadastrarJogo(nome, preco);
	}
	
	public ArrayList<Jogo> getListaJogo()
	{
		return this.repJogos.getListaJogo();
	}
	
	public Jogo consultarJogo(String nome)
	{
		return this.repJogos.consultar(nome);
	}
	
	public boolean existeJogo(String nome)
	{
		return this.repJogos.existe(nome);
	}
	
	public void rmvJogo(String nome)
	{
		this.repJogos.removerJogo(nome);
	}
	
	public void editarJogo(String targetNome,float tagetPreco, String originalName)
	{
		this.repJogos.editarJogo(targetNome, tagetPreco, originalName);
	}
}
