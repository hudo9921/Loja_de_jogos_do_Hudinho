package sistema.dados;

import java.time.LocalDate;
import java.util.ArrayList;

import sistema.classesbase.Carrinho;
import sistema.classesbase.Pedido;

public interface IRepPedido {
	void inserirPedido(Carrinho carro);
	float lucroTotal();
	ArrayList<Pedido> getListaPedido();
	float lucroData(LocalDate date1, LocalDate date2);
	
}
