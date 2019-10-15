package br.com.simvago;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public enum TipoTaxa {

	SEMANAL, 
	FIMDSEMANA;

	private List<Integer> diasDaSemana;

	private TipoTaxa(ArrayList<LocalDate> diasDaSemana) {
		this.diasDaSemana = diasDaSemana;
	}

	private static boolean finalDeSemana(LocalDate calendario) {
		return calendario.getDayOfWeek().equals(DayOfWeek.SATURDAY)
				|| calendario.getDayOfWeek().equals(DayOfWeek.SUNDAY);
	}

	public static TipoTaxa from(String pedidoTaxa) {
		LocalDate.parse("dMMMy");
		LocalDate calendario = LocalDate
				.parse(pedidoTaxa.split(" ")[1].split("\\(")[0]);
		if (finalDeSemana(calendario)) {
			return FIMDSEMANA;
		}
		return SEMANAL;
	}

	public List<Integer> getDiasDaSemana() {
		return diasDaSemana;
	}

}