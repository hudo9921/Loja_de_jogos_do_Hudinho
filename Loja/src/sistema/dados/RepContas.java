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
import sistema.classesbase.Usuario;

public class RepContas implements IRepContas, Serializable {
	
	private List<Usuario> contas;
	
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
			fos = new FileOutputStream(out,true);
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
	public void criarConta(String username, String senha) {
		// TODO Auto-generated method stub
		Usuario contaU = new Usuario(username,0, senha);
		contas.add(contaU);
		this.salvarNoArquivo();
	}

	@Override
	public List<Usuario> getListaUsuarios() {
		RepContas.lerDoArquivo();		
		return this.contas;
	}
	@Override
	public Usuario consultar(String username) {
		return contas.stream()
				.filter(c -> c.getUser().equals(username))
				.findFirst()
				.orElse(null);
	}
	@Override
	public boolean existe(String username) {
		return this.consultar(username)!=null;
	}
	

}
