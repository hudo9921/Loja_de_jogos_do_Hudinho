package sistema.dados;

import java.util.ArrayList;
import java.util.List;

import sistema.classesbase.Conta;
import sistema.classesbase.Usuario;

public interface IRepContas {
	void criarConta(String username,String senha);
	List<Usuario> getListaUsuarios();	
	Usuario consultar(String username);
	boolean existe(String username);
}
