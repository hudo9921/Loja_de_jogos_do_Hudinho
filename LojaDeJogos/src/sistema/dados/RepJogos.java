package sistema.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import sistema.classesbase.Jogo;

public class RepJogos implements IRepJogos, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Jogo> bancoJogos;
	
	private static RepJogos instance;
	
	private RepJogos(int tamanho)
	{
		this.bancoJogos = new ArrayList<Jogo>();
	}
	
	public static IRepJogos getInstance()
	{
		if(instance==null)
		{
			instance = lerDoArquivo();
		}
		return instance;
	}
	
	private static RepJogos lerDoArquivo()
	{
		RepJogos instanciaLocal = null;
		File in = new File("jogos.dat");
		
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try{
			fis = new FileInputStream(in);
			ois = new  ObjectInputStream(fis);
			Object o = ois.readObject();
			instanciaLocal = (RepJogos) o;
		} catch(Exception e) {
			instanciaLocal = new RepJogos(1000);
		} finally {
			if(ois!=null)
			{ try {
				ois.close();
			}catch(IOException e) {
			}
			}
		}
		return instanciaLocal;
	}
	
	public void salvarNoArquivo() 
	{	
		if(instance==null)
		{
			return;
		}
		File out = new File("jogos.dat");
		if(!out.exists())
		{
			try {
				out.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try{
			fos = new FileOutputStream(out);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(instance);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(oos!=null) {
				try {oos.close();}catch(IOException e) {}
			}
		}
		
	}
	
	@Override
	public void cadastrarJogo(String nome, float preco) {
		Jogo jogoU = new Jogo(nome,preco);
		bancoJogos.add(jogoU);
		this.salvarNoArquivo();
		
	}

	@Override
	public ArrayList<Jogo> getListaJogo() {
		return this.bancoJogos;
	}

	@Override
	public Jogo consultar(String nome) {
		return bancoJogos.stream()
				.filter(c -> c.getNome().equals(nome))
				.findFirst()
				.orElse(null);
	}

	@Override
	public boolean existe(String nome) {
		// TODO Auto-generated method stub
		return this.consultar(nome)!=null;
	}

	@Override
	public void removerJogo(String nome) {
		this.bancoJogos.remove(this.consultar(nome));
    	this.salvarNoArquivo();
	}

	@Override
	public void editarJogo(String targetNome, float tagetPreco, String originalName) {
		Jogo jogo = this.consultar(originalName);
		int posicao = this.bancoJogos.indexOf(jogo);
		jogo.setNome(targetNome);
		jogo.setPreco(tagetPreco);
		this.bancoJogos.set(posicao, jogo);
		this.salvarNoArquivo();
	}

}
