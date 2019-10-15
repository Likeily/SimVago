package br.com.simvago.hoteis;

import java.util.ArrayList;

import br.com.simvago.TipoCliente;
import br.com.simvago.TipoTaxa;

public class DescricaoHotel {
	
		private ArrayList<Taxa> listaTaxas = null;
		
	    public RedeDHoteis redes() {
	        return new RedeDHoteis(lakewood(), bridgewood(), ridgewood());
	    }

	    private Hotel lakewood() {
	        Taxa semanaRegular = new Taxa(TipoTaxa.SEMANAL, TipoCliente.REGULAR, 110);
	        Taxa fimdesemanaRegular = new Taxa(TipoTaxa.FIMDSEMANA, TipoCliente.REGULAR, 90);

	        Taxa semanaRewards = new Taxa(TipoTaxa.SEMANAL, TipoCliente.REWARDS, 80);
	        Taxa fimdesemanaRewards = new Taxa(TipoTaxa.FIMDSEMANA, TipoCliente.REWARDS, 80);
	        
	        listaTaxas = new ArrayList<Taxa>();
	        listaTaxas.add(semanaRegular);
	        listaTaxas.add(fimdesemanaRegular);
	        listaTaxas.add(semanaRewards);
	        listaTaxas.add(fimdesemanaRewards);
	        return new Hotel("Lakewood", 3, listaTaxas);
	    }

	    private Hotel bridgewood() {
	    	Taxa semanaRegular = new Taxa(TipoTaxa.SEMANAL, TipoCliente.REGULAR, 160);
	    	Taxa fimdesemanaRegular = new Taxa(TipoTaxa.FIMDSEMANA, TipoCliente.REGULAR, 60);

	    	Taxa semanaRewards = new Taxa(TipoTaxa.SEMANAL, TipoCliente.REWARDS, 110);
	    	Taxa fimdesemanaRewards = new Taxa(TipoTaxa.FIMDSEMANA, TipoCliente.REWARDS, 50);

	    	listaTaxas = new ArrayList<Taxa>();
	        listaTaxas.add(semanaRegular);
	        listaTaxas.add(fimdesemanaRegular);
	        listaTaxas.add(semanaRewards);
	        listaTaxas.add(fimdesemanaRewards);
	        
	        return new Hotel("Bridgewood", 4, listaTaxas);
	    }

	    private Hotel ridgewood() {
	    	Taxa semanaRegular = new Taxa(TipoTaxa.SEMANAL, TipoCliente.REGULAR, 220);
	    	Taxa fimdesemanaRegular = new Taxa(TipoTaxa.FIMDSEMANA, TipoCliente.REGULAR, 150);

	    	Taxa semanaRewards = new Taxa(TipoTaxa.SEMANAL, TipoCliente.REWARDS, 100);
	    	Taxa fimdesemanaRewards = new Taxa(TipoTaxa.FIMDSEMANA, TipoCliente.REWARDS, 40);

	    	listaTaxas = new ArrayList<Taxa>();
	        listaTaxas.add(semanaRegular);
	        listaTaxas.add(fimdesemanaRegular);
	        listaTaxas.add(semanaRewards);
	        listaTaxas.add(fimdesemanaRewards);
	        
	        return new Hotel("Ridgeewood", 5, listaTaxas);
	    }
	}
