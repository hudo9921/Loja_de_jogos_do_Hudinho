package negocio;

import dados.ISisPedido;
import negocio.beans.Pedido;

public class ControladorPedido {
	
	private ISisPedido repositorioPedido;
	
	public ControladorPedido(ISisPedido instanciaRepositorio) {
		this.repositorioPedido = instanciaRepositorio;
	}
	
	public void addPedido(Pedido pedido) {
		this.repositorioPedido.addPedido(pedido);
	}

}
