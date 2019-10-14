package br.com.simvago;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

import br.com.simvago.hoteis.RedeDHoteis;

public class ComputarReserva {

	private List<SolicitarReserva> solicitarReservas = new ArrayList<SolicitarReserva>();
	private RedeDHoteis redes;

	public ComputarReserva(List<String> tipoDeReserva, RedeDHoteis redes) {
		super();
		this.solicitarReservas = solicitarReservasPara(tipoDeReserva);
		this.redes = redes;
	}

	private List<SolicitarReserva> solicitarReservasPara(List<String> tipoDeReserva) {
		return new ArrayList<SolicitarReserva>(Collection(tipoDeReserva, solicitarReservasParaTipo()));
	}

	private Function<? super String, SolicitarReserva> solicitarReservasParaTipo() {
		return new Function<String, SolicitarReserva>() {
			@Override
			public SolicitarReserva aplicar(String tipoDeReserva) {
				return new SolicitarReserva(tipoDeReserva);
			}
		};
	}

	public String mostrarReservas() {
		Joiner joiner = Joiner.on("\n");
		return joiner.join(Collection.transform(solicitarReservas, toHotelsWithBestRateForRequest()));
	}

	private Function<? super SolicitarReserva, String> toHotelsWithBestRateForRequest() {
		return new Function<SolicitarReserva, String>() {
			@Override
			public String apply(SolicitarReserva solicitarReserva) {
				return redes.hotelWithBestRateFor(solicitarReserva);
			}
		};
	}

}
