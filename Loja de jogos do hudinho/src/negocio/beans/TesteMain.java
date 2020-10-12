package negocio.beans;

public class TesteMain {

	public static void main(String[] args) {
		Usuario user01 = new Usuario( "samuel", 1, "123");
		
		Jogo jogo01 = new Jogo( "vava", 10);
		Jogo jogo02 = new Jogo( "lolzin", 200000);
		user01.addCarrinho(jogo01);
		user01.addCarrinho(jogo02);
		
		user01.comprarCarrinho();
		
		System.out.println( user01.getJogosPossuidos());

	}

}
