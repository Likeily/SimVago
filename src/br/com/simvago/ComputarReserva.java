package br.com.simvago;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

import br.com.simvago.hoteis.Hotel;
import br.com.simvago.hoteis.RedeDHoteis;
import br.com.simvago.hoteis.Taxa;

public class ComputarReserva {

	private ArrayList<SolicitarReserva> solicitarReservas = null;
    private RedeDHoteis redes;

    public ComputarReserva(List<String> exibe, RedeDHoteis redes) {
        this.redes = redes;
        this.solicitarReservas = (ArrayList<SolicitarReserva>) solicitarReservasPara(exibe);
    }

    private List<SolicitarReserva> solicitarReservasPara(List<String> lines) {
        return newArrayList(Collections2.transform(lines, solicitarReservasParaTipo()));
    }


	private Function<? super String, SolicitarReserva> solicitarReservasParaTipo() {
		return new Function<String, SolicitarReserva>() {
			@Override
			public SolicitarReserva apply(String line) {
				return new SolicitarReserva(line);
			}
		};
	}

	public String exibirReservas() {
		Joiner joiner = Joiner.on("\n");
		return joiner.join(Collections2.transform(solicitarReservas, melhorSolicitacaoPorTaxa()));
	}

	private Function<? super SolicitarReserva, String> melhorSolicitacaoPorTaxa() {
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