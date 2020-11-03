package sistema.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

import sistema.classesbase.Carrinho;
import sistema.classesbase.Jogo;
import sistema.classesbase.Pedido;

public class RepPedidos implements IRepPedido, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Pedido> listaPedidos;
	
	private static RepPedidos instance;
	
	private RepPedidos(int tamanho)
	{
		this.listaPedidos = new ArrayList<Pedido>();
	}
	
	public static IRepPedido getInstance()
	{
		if(instance==null) {
			instance = lerDoArquivo();
		}
		return instance;
	}
	
	private static RepPedidos lerDoArquivo()
	{
		RepPedidos instanciaLocal = null;
		File in = new File("pedidos.dat");
		
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try{
			fis = new FileInputStream(in);
			ois = new  ObjectInputStream(fis);
			Object o = ois.readObject();
			instanciaLocal = (RepPedidos) o;
		} catch(Exception e) {
			instanciaLocal = new RepPedidos(1000);
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
		File out = new File("pedidos.dat");
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
	public void inserirPedido(Carrinho carro) {
		Pedido pedidoU = new Pedido(carro);
		listaPedidos.add(pedidoU);
		this.salvarNoArquivo();
		
	}
	
	@Override
	public ArrayList<Pedido> getListaPedido() {
		return this.listaPedidos;
	}
	 
	@Override
	public float lucroTotal() {
		ArrayList<Pedido> tempLista = this.getListaPedido();
		float lucroTotalPedidos=0;
		for(Pedido ped : tempLista)
		{
			lucroTotalPedidos+=ped.getValorTotal();
		}
		return lucroTotalPedidos;
	}
	
	@Override
	public float lucroData(LocalDate date1, LocalDate date2) {
		float resultado = 0;
		ArrayList<Pedido> pedidos = new ArrayList<>();
		if( date1.isEqual(date2)) {
			for( Pedido pedido : this.listaPedidos) {
				if( pedido.getDataVenda().isEqual(date1)) {
					pedidos.add(pedido);
				}
			}
		}else if( date1.isBefore(date2)) {
			for( Pedido pedido : this.listaPedidos) {
				if( pedido.getDataVenda().isAfter(date1) && pedido.getDataVenda().isBefore(date2)) {
					pedidos.add(pedido);
					
				}else if( pedido.getDataVenda().isEqual(date1)) {
					pedidos.add(pedido);
					
				}else if( pedido.getDataVenda().isEqual(date2)) {
					pedidos.add(pedido);
				}
			}
		}else if( date2.isBefore(date1)) {
			for( Pedido pedido : this.listaPedidos) {
				if( pedido.getDataVenda().isAfter(date2) && pedido.getDataVenda().isBefore(date1)) {
					pedidos.add(pedido);
					
				}else if( pedido.getDataVenda().isEqual(date1)) {
					pedidos.add(pedido);
					
				}else if( pedido.getDataVenda().isEqual(date2)) {
					pedidos.add(pedido);
				}
			}
		}
		for( Pedido pedido : pedidos) {
			resultado += pedido.getValorTotal();
		}
		return resultado;
	}

	
	
	

	
}
