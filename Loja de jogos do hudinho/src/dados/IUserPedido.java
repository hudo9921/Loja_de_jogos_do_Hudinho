package dados;
import java.util.ArrayList;

import negocio.*;
import negocio.beans.Jogo;
import negocio.beans.Usuario;

public interface IUserPedido {
	
	void addPedido(Usuario comprador, ArrayList<Jogo> carrinho);
}
