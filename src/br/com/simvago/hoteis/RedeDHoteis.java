package br.com.simvago.hoteis;

import br.com.simvago.SolicitarReserva;

public class RedeDHoteis {
	
	 private Hotel[] hoteis;

	 public RedeDHoteis(Hotel... hoteis) {
	        this.hoteis = hoteis;
	    }


	    public String CustoBeneficio(SolicitarReserva request) {
	        Hotel hotelMaiorValor = hoteis[0];
	        for (Hotel hotel : hoteis) {
	            if (hotel.tabelaPreco(request) > hotelMaiorValor.tabelaPreco(request)) {
	            	hotelMaiorValor = hotel;
	            }
	        }
	        return hotelMaiorValor.getNome();
	    }
}
