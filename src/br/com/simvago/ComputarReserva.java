package br.com.simvago;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;
import java.util.function.Function;

import br.com.simvago.hoteis.RedeDHoteis;

public class ComputarReserva {

    private RedeDHoteis redes;
    
    private List<SolicitarReserva> solicitarReservas = new ArrayList<SolicitarReserva>();

    public ComputarReserva(String tipos, RedeDHoteis redes) {
        this.redes = redes;
        this.solicitarReservas = solicitarReservasPara(tipos);
    }

	private List<SolicitarReserva> solicitarReservasPara(String tipos) {
		 return newArrayList(Collections.addAll(tipos, solicitarReservasParaTipo()));
    }

	@SuppressWarnings("unused")
	private Function<? super String, SolicitarReserva> solicitarReservasParaTipo() {
		return new Function<String, SolicitarReserva>() {
			@Override
			public SolicitarReserva apply(String tipo) {
				return new SolicitarReserva(tipo);
			}
		};
	}

	public String exibirReservas() {
		List<SolicitarReserva> mainList = new ArrayList<SolicitarReserva>(); 
		List<Function<SolicitarReserva, String>> melhorTaxa = Arrays.asList(hotelComMelhorTaxaDeReserva());  
		StringJoiner joiner = new StringJoiner(", ");
		for (Function<SolicitarReserva, String> s : melhorTaxa) {
		    joiner.add((CharSequence) s);
		}
		return mainList.add(joiner.toString());
    }

    private Function<SolicitarReserva, String> hotelComMelhorTaxaDeReserva() {
        return new Function<SolicitarReserva, String>() {
            @Override
            public String apply(SolicitarReserva solicitarReserva) {
                return redes.CustoBeneficio(solicitarReserva);
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