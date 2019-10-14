package br.com.simvago.hoteis;

import java.util.ArrayList;
import java.util.List;

import javax.print.DocFlavor.READER;

import br.com.simvago.TipoCliente;
import br.com.simvago.TipoTaxa;
import static com.google.common.collect.Lists.newArrayList;

//private TipoTaxa tipoTaxa;
//private TipoCliente tipoCliente;
//private Integer custo;
//
//SEMANAL,
//FIMDSEMANA;

public class DescricaoHotel {
	
	    public RedeDHoteis redes() {
	        return new RedeDHoteis(lakewood(), bridgewood(), ridgewood());
	    }

	    private Hotel lakewood() {
	        Taxa semanaRegular = new Taxa(TipoTaxa.SEMANAL, TipoCliente.REGULAR, 110);
	        Taxa fimdesemanaRegular = new Taxa(TipoTaxa.FIMDSEMANA, TipoCliente.REGULAR, 90);
//	        200 for 1+1

	        Taxa semanaRewards = new Taxa(TipoTaxa.SEMANAL, TipoCliente.REWARDS, 80);
	        Taxa fimdesemanaRewards = new Taxa(TipoTaxa.FIMDSEMANA, TipoCliente.REWARDS, 80);
	        
	        return new Hotel("Lakewood", 3, new ArrayList<String>(semanaRegular, fimdesemanaRegular, semanaRewards, fimdesemanaRewards));
	    }

	    private Hotel bridgewood() {
	    	Taxa semanaRegular = new Taxa(TipoTaxa.SEMANAL, TipoCliente.REGULAR, 160);
	    	Taxa fimdesemanaRegular = new Taxa(TipoTaxa.FIMDSEMANA, TipoCliente.REGULAR, 60);
//	        220 for 1+1

	    	Taxa semanaRewards = new Taxa(TipoTaxa.SEMANAL, TipoCliente.REWARDS, 110);
	    	Taxa fimdesemanaRewards = new Taxa(TipoTaxa.FIMDSEMANA, TipoCliente.REWARDS, 50);
//	        160 for 1+1

	        return new Hotel("Bridgewood", 4, newArrayList(semanaRegular, fimdesemanaRegular, semanaRewards, fimdesemanaRewards));
	    }

	    private Hotel ridgewood() {
	    	Taxa semanaRegular = new Taxa(TipoTaxa.SEMANAL, TipoCliente.REGULAR, 220);
	    	Taxa fimdesemanaRegular = new Taxa(TipoTaxa.FIMDSEMANA, TipoCliente.REGULAR, 150);
//	        370 for 1+1

	    	Taxa semanaRewards = new Taxa(TipoTaxa.SEMANAL, TipoCliente.REWARDS, 100);
	    	Taxa fimdesemanaRewards = new Taxa(TipoTaxa.FIMDSEMANA, TipoCliente.REWARDS, 40);
//	        140 for 1+1

	        return new Hotel("Ridgeewood", 5, newArrayList(semanaRegular, fimdesemanaRegular, semanaRewards, fimdesemanaRewards));
	    }
	}
