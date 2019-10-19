package br.com.simvago;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.function.Function;

import br.com.simvago.hoteis.RedeDHoteis;

public class ComputarReserva {

    private RedeDHoteis redes;
    
    private List<SolicitarReserva> solicitarReservas = new ArrayList<SolicitarReserva>();

    @SuppressWarnings("unchecked")
	public ComputarReserva(String tipos, RedeDHoteis redes) {
        this.redes = redes;
        this.solicitarReservas = (List<SolicitarReserva>) solicitarReservasPara(tipos);
    }

	private Map<String, ComputarReserva> solicitarReservasPara(String tipos){
		Map<String, ComputarReserva> melhorReserva = new HashMap<>();
		melhorReserva.put(tipos, (ComputarReserva) solicitarReservas);
		return melhorReserva;	
		
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
		List<Function<SolicitarReserva, String>> melhorTaxa = Arrays.asList(hotelComMelhorTaxaDeReserva());  
		StringJoiner joiner = new StringJoiner(", ");
		for (Function<SolicitarReserva, String> s : melhorTaxa) {
		    joiner.add((CharSequence) s);
		}
		return joiner.toString();
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