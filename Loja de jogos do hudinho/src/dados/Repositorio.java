package dados;

import java.util.ArrayList;

import negocio.beans.Jogo;
import negocio.beans.Pedido;
import negocio.beans.Usuario;

import java.time.LocalDate;

public class Repositorio implements ISisConta,ISisJogo,ISisPedido{
	
	private ArrayList<Pedido> pedidosFeitos;
	private ArrayList<Jogo> listaJogos;
	private ArrayList<Usuario> listaUsuarios;
	
	private int idJogo=0;
	private int idUsers=0;
	
	public Repositorio() {
		this.pedidosFeitos = new ArrayList<>();
		this.listaJogos = new ArrayList<>();
		this.listaUsuarios = new ArrayList<>();
	}
	
	public ArrayList<Pedido> getPedidosFeitos() {
		return pedidosFeitos;
	}
	public void setPedidosFeitos(ArrayList<Pedido> pedidosFeitos) {
		this.pedidosFeitos.addAll(pedidosFeitos);
	}
	
	public void relatorio(String filtro) {
		//retornar relatorio de vendas.
	}
	
	public void relatorioData( LocalDate dataI, LocalDate dataF) {
		//retornar relatorio de vendas referente a uma data especifica.
	}
	
	/* public Jogo procurarJogos( String nomeJogo) {
		Jogo jogo = new Jogo( "", 0);
		if( nomeJogo != null) {
			ArrayList<Jogo> listaJogos = this.getListaJogos();
			for( Jogo x : listaJogos) {
				if( x.getNome() == nomeJogo) {
					jogo = x;
				}
			}
		}else {
			//exceção
		}
		return jogo;  VER COM SAMUEL COMO FUNCIONA E QUEM FAZ
	}*/
	//INTERFACE ADMIN JOGO COMECO
	@Override
	public void addJogo(String nome,float preco) {
		if(!(nome.isBlank()&&preco<0))
		{
			Jogo j = new Jogo(nome,preco);
			listaJogos.add(j);
		}
	}

	@Override
	public void rmvJogo(int id) {
		if(listaJogos.size()==1)
		{
			if(listaJogos.get(0).getId()==id)
			{
				listaJogos.remove(0);
			}
		}
		else
		for (Jogo j1 : listaJogos)
		{
			if(j1.getId()==id)
			{
				listaJogos.remove(j1);
			}
		}
		
	}

	@Override
	public void modJogo(int id, float newPreco) {
		for (Jogo j1 : listaJogos)
		{
			if(j1.getId()==id&&newPreco>=0.0)
			{
				j1.setPreco(newPreco);
			}
		}
		
	}
	
	public ArrayList<Jogo> getListaJogos() 
	{
		return listaJogos;
	}
	
	//FINAL INTERFACE ADMIN JOGO
	
	
	//INTERFACE SISTEMA CONTA COMECO
		/*public void criarConta( String nome, double id, String senha) {
			if( nome != null && senha != null) {
				Usuario user01 = new Usuario( nome, id, senha);
				this.listaUsuarios.add(user01);
			}else {
				//exceção
			}
		}*/
		public void criarConta(String username,String senha)
		{
			if(!(username.isBlank()&&senha.isBlank()))
			{
				Usuario user = new Usuario(username,this.idUsers++,senha, null);
				listaUsuarios.add(user);
			}
			
		}
		public ArrayList<Usuario> getListaUsuarios() {
			return listaUsuarios;
		}
		//INTERFACE SISTEMA CONTA FINAL
		
		//INTERFACE USUARIO PEDIDO
		@Override
		public void addPedido(Usuario comprador, ArrayList<Jogo> carrinho) {
			ArrayList<Pedido> pedidosFeitos = new ArrayList<>();
			Pedido newPedido = new Pedido(comprador, carrinho);
			pedidosFeitos.add(newPedido);
			this.setPedidosFeitos(pedidosFeitos);
			
		}
		
		
}
