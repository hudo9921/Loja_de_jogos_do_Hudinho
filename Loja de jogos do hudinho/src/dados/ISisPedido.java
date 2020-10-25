package dados;
import java.util.ArrayList;

import negocio.*;
import negocio.beans.Jogo;
import negocio.beans.Pedido;
import negocio.beans.Usuario;

public interface ISisPedido {
	
	void addPedido(Pedido pedido);
}
