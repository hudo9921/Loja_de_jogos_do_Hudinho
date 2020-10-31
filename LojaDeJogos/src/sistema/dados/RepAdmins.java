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

import sistema.classesbase.Admin;
import sistema.classesbase.Conta;
import sistema.classesbase.Usuario;

public class RepAdmins implements IRepAdmins, Serializable {
	
	private List<Admin> admins;
	
	private static RepAdmins instance;
	
	private RepAdmins(int tamanho)
	{
		this.admins = new ArrayList<Admin>();
	}
	public static IRepAdmins getInstance()
	{
		if(instance==null)
		{
			instance = lerDoArquivo();
		}
		return instance;
	}
	
	private static RepAdmins lerDoArquivo()
	{
		RepAdmins instanciaLocal = null;
		
		File in = new File("contasAdmin.dat");
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
			instanciaLocal = (RepAdmins) o;
		} catch (Exception e) {
			instanciaLocal = new RepAdmins(100);
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
		File out = new File("contasAdmin.dat");
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
		Admin contaU = new Admin(username,0, senha,0);
		admins.add(contaU);
		this.salvarNoArquivo();
	}

	@Override
	public List<Admin> getListaAdmins() {
		RepAdmins.lerDoArquivo();		
		return this.admins;
	}
	@Override
	public Admin consultar(String username) {
		return admins.stream()
				.filter(c -> c.getUser().equals(username))
				.findFirst()
				.orElse(null);
	}
	@Override
	public boolean existe(String username) {
		return this.consultar(username)!=null;
	}
	

}
