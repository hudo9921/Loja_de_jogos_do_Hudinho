package dados;
import java.util.ArrayList;

import negocio.beans.*;

public interface IUserPedido {
	
	void addPedido(Usuario comprador, ArrayList<Jogo> carrinho);
}
