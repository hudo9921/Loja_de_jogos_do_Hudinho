package sistema.controladores;

import java.time.LocalDate;
import java.util.ArrayList;

import sistema.classesbase.Carrinho;
import sistema.classesbase.Pedido;
import sistema.dados.IRepPedido;

public class ControladorPedidos {
	private IRepPedido repPedidos;
	public ControladorPedidos(IRepPedido instanciaRepPed)
	{
		this.repPedidos=instanciaRepPed;
	}
	public void inserirPedido(Carrinho carro)
	{
		this.repPedidos.inserirPedido(carro);
	}
	public float lucroTotal()
	{
		return this.repPedidos.lucroTotal();
	}
	public ArrayList<Pedido> getListaPedido()
	{
		return this.repPedidos.getListaPedido();
	}
	public float lucroData(LocalDate date1, LocalDate date2) {
		return this.repPedidos.lucroData(date1, date2);
	}

}
