package testes.com;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;

import org.junit.Test;

import br.com.simvago.ComputarReserva;
import br.com.simvago.SolicitarReserva;
import br.com.simvago.TipoCliente;
import br.com.simvago.TipoTaxa;
import br.com.simvago.hoteis.Hotel;
import br.com.simvago.hoteis.RedeDHoteis;
import br.com.simvago.hoteis.Taxa;

public class ComputarReservaTeste {
	
	  @Test
	    public void reservaDeQuartoMaisBaratoNaSemana(){
	        RedeDHoteis redes = new RedeDHoteis();
	        ComputarReserva computarReserva = new ComputarReserva(new ArrayList("Regular: 20Mar2009(fri)"), redes);
	        assertThat(computarReserva.reservationResults(), is("Lakewood"));
	    }

	    @Test
	    public void shouldReserveCheapestRoomForOneRegularWeekendDay(){
	    	RedeDHoteis redes = new RedeDHoteis();
	        ComputarReserva computarReserva = new ComputarReserva(new ArrayList("Regular: 21Mar2009(sat)"), redes);
	        assertThat(computarReserva.reservationResults(), is("Bridgewood"));
	    }

	    @Test
	    public void shouldReserveCheapestRoomForRegularForOneWeekdayAndOneWeekendDay(){
	    	RedeDHoteis redes = new RedeDHoteis();
	        ComputarReserva computarReserva = new ComputarReserva(new ArrayList("Regular: 20Mar2009(fri) 21Mar2009(sat)"), redes);
	        assertThat(computarReserva.reservationResults(), is("Lakewood"));
	    }

	    @Test
	    public void shouldReserveCheapestRoomForRewardsForOneWeekdayAndOneWeekendDay(){
	    	RedeDHoteis redes = new RedeDHoteis();
	        ComputarReserva computarReserva = new ComputarReserva(new ArrayList("Rewards: 20Mar2009(fri) 21Mar2009(sat)"), redes);
	        assertThat(computarReserva.reservationResults(), is("Ridgewood"));
	    }
	}
