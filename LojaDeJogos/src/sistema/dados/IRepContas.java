package sistema.dados;

import java.util.ArrayList;
import java.util.List;

import sistema.classesbase.Conta;
import sistema.classesbase.Jogo;
import sistema.classesbase.Usuario;

public interface IRepContas {
	void criarConta(String username,String senha);
	ArrayList<Usuario> getListaUsuarios();	
	Usuario consultar(String username);
	boolean existe(String username);
	void alterarSenha(String username,String senha);
	void adicionarJogoUsuario(ArrayList<Jogo> jogos, Usuario user);
	void removerJogoUsuario(Jogo jogo, Usuario user);
	void remover(String username);
}
