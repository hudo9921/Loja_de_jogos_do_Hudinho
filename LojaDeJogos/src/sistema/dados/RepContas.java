package sistema.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import sistema.classesbase.Conta;
import sistema.classesbase.Jogo;
import sistema.classesbase.Usuario;

public class RepContas implements IRepContas, Serializable {
	
	private ArrayList<Usuario> contas;
	
	private static RepContas instance;
	
	private RepContas(int tamanho)
	{
		this.contas = new ArrayList<Usuario>();
	}
	public static IRepContas getInstance()
	{
		if(instance==null)
		{
			instance = lerDoArquivo();
		}
		
		return instance;
	}
	
	private static RepContas lerDoArquivo()
	{
		RepContas instanciaLocal = null;
		
		File in = new File("contasUser.dat");
		/*try {
			in.createNewFile();
			System.out.println(in.exists());
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			instanciaLocal = (RepContas) o;
		} catch (Exception e) {
			instanciaLocal = new RepContas(100);
		} finally {
			if(ois!=null)
			{ try {
				ois.close();
			}catch (IOException e) {
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
		File out = new File("contasUser.dat");
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
	public void remover(String username){
    	this.contas.remove(this.consultar(username));
    	this.salvarNoArquivo();
    }
	
	@Override
	public void criarConta(String username, String senha) {
		// TODO Auto-generated method stub
		Usuario contaU = new Usuario(username,0, senha);
		contas.add(contaU);
		this.salvarNoArquivo();
	}

	@Override
	public ArrayList<Usuario> getListaUsuarios() {
		RepContas.lerDoArquivo();		
		return this.contas;
	}
	@Override
	public Usuario consultar(String username) {
		//System.out.println(contas);
		return contas.stream()
				.filter(c -> c.getUser().equals(username))
				.findFirst()
				.orElse(null);
	}
	@Override
	public boolean existe(String username) {
		return this.consultar(username)!=null;
	}
	@Override
	public void alterarSenha(String username, String novaSenha) {
		Usuario user = this.consultar(username);
		int posicao = this.contas.indexOf(user);
		user.alterarSenha(novaSenha);
		this.contas.set(posicao, user);
		System.out.println(this.contas);
		this.salvarNoArquivo();
	}
	
	@Override
	public void adicionarJogoUsuario(ArrayList<Jogo> jogos, Usuario user) {
		int posicao = this.contas.indexOf(user);
		ArrayList<Jogo> lista = user.getJogosPossuidos();
		for( Jogo jogo : jogos) {
			lista.add(jogo);
		}
		user.setJogosPossuidos(lista);
		this.contas.set(posicao, user);
		this.salvarNoArquivo();
	}
	
	@Override
	public void removerJogoUsuario(Jogo jogo, Usuario user) {
		int posicao = this.contas.indexOf(user);
		int x = 0;
		ArrayList<Jogo> lista = user.getJogosPossuidos();
		for( Jogo jogo1 : lista) {
			if(jogo1.getNome().equals(jogo.getNome())) {
				x = lista.indexOf(jogo1);
			}
		}
		lista.remove(x);
		//System.out.println(lista);
		user.setJogosPossuidos(lista);
		this.contas.set(posicao, user);
		//System.out.println(user.getJogosPossuidos());
		this.salvarNoArquivo();
	}
	
	public List<Usuario> getContas() {
		return contas;
	}
	public void setContas(ArrayList<Usuario> contas) {
		this.contas = contas;
	}
	public static void setInstance(RepContas instance) {
		RepContas.instance = instance;
	}
	
	
	
	

}
