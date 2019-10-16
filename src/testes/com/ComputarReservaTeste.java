package testes.com;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;

import org.junit.Test;

import br.com.simvago.ComputarReserva;
import br.com.simvago.hoteis.RedeDHoteis;

public class ComputarReservaTeste {
	
	private ArrayList<ComputarReserva> infoReserva = null;
	  @Test
	    public void reservaDeQuartoMaisBaratoNaSemana(){
		    RedeDHoteis redes = new RedeDHoteis();
	        ComputarReserva computarReserva = new ComputarReserva("Regular: 11Out2019(Sex)", redes);
	        assertThat(computarReserva.exibirReservas(), is("Lakewood"));
	    }

	    @Test
	    public void reservaDeQuartoMaisBaratoNoFimDeSemana(){
	    	RedeDHoteis redes = new RedeDHoteis();
	    	ComputarReserva computarReserva = new ComputarReserva("Regular: 12Out2019(sab)", redes);
	        assertThat(computarReserva.exibirReservas(), is("Bridgewood"));
	    }

	    @Test
	    public void reservaDeQuartoMaisBaratoEmUmDiaDaSemanaEUmDiaDoFinalDSemanaRegular(){
	    	RedeDHoteis redes = new RedeDHoteis();
	    	ComputarReserva computarReserva = new ComputarReserva("Regular: 20Mar2009(fri) 12Out2019(Sab)", redes);
	        assertThat(computarReserva.exibirReservas(), is("Lakewood"));
	    }

	    @Test
	    public void reservaDeQuartoMaisBaratoEmUmDiaDaSemanaEUmDiaDoFinalDSemanaRewards(){
	    	RedeDHoteis redes = new RedeDHoteis();
	    	ComputarReserva computarReserva = new ComputarReserva("Rewards: 11Out2019(Sex) 12Out2019(Sab)", redes);
	        assertThat(computarReserva.exibirReservas(), is("Ridgewood"));
	    }

		public ArrayList<ComputarReserva> getInfoReserva() {
			return infoReserva;
		}

		public void setInfoReserva(ArrayList<ComputarReserva> infoReserva) {
			this.infoReserva = infoReserva;
		}
	}
