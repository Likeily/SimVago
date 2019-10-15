package br.com.simvago;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import br.com.simvago.hoteis.RedeDHoteis;

public class ComputarReserva {

	private ArrayList<SolicitarReserva> solicitarReservas = null;
	private RedeDHoteis redes;

	public ComputarReserva(List<String> lines, RedeDHoteis redes) {
		this.redes = redes;
		this.solicitarReservas = (ArrayList<SolicitarReserva>) solicitarReservasPara(lines);
	}

	private List<SolicitarReserva> solicitarReservasPara(List<String> lines) {
		return newArrayList(Collections2.transform(lines, reservationRequestFromLine()));
	}

	private Function<? super String, SolicitarReserva> reservationRequestFromLine() {
		return new Function<String, SolicitarReserva>() {
			@Override
			public SolicitarReserva apply(String line) {
				return new SolicitarReserva(line);
			}
		};
	}

	public String reservationResults() {
		Joiner joiner = Joiner.on("\n");
		return joiner.join(Collections2.transform(solicitarReservas, toHotelsWithBestRateForRequest()));
	}

	private Function<? super SolicitarReserva, String> toHotelsWithBestRateForRequest() {
		return new Function<SolicitarReserva, String>() {
			@Override
			public String apply(SolicitarReserva) {
				return redes.hotelWithBestRateFor(solicitarReservas);
			}
		};
	}

	public List<SolicitarReserva> getSolicitarReservas() {
		return solicitarReservas;
	}

	public void setSolicitarReservas(List<SolicitarReserva> solicitarReservas) {
		this.solicitarReservas = (ArrayList<SolicitarReserva>) solicitarReservas;
	}

	public RedeDHoteis getRedes() {
		return redes;
	}

	public void setRedes(RedeDHoteis redes) {
		this.redes = redes;
	}
}