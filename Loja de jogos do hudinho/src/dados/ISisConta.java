package dados;

import java.util.ArrayList;

import negocio.beans.Usuario;

public interface ISisConta 
{
	void criarConta(String username,String senha);
	ArrayList<Usuario> getListaUsuarios();
}
