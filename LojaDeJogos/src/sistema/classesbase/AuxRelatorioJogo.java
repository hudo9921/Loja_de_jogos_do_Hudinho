package sistema.classesbase;

import java.util.ArrayList;

public class AuxRelatorioJogo {
	
	private String jogos;
	private float quantiaVendida;
	
	public AuxRelatorioJogo( String jogos, float quantiaVendida) {
		this.jogos = jogos;
		this.quantiaVendida = quantiaVendida;
	}

	public float getQuantiaVendida() {
		return quantiaVendida;
	}
	

	public String getJogos() {
		return jogos;
	}

	public void setQuantiaVendida(float quantiaVendida) {
		this.quantiaVendida = quantiaVendida;
	}

}
