package sistema.classesbase;

import java.time.LocalDate;
import java.util.ArrayList;

public class AuxRelatorioDate {
	
	private LocalDate data;
	private float valorData;
	
	public AuxRelatorioDate( LocalDate data, float valorData) {
		this.data = data;
		this.valorData = valorData;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public float getValorData() {
		return valorData;
	}

	public void setValorData(float valorData) {
		this.valorData = valorData;
	}
	

}
