package testes.com.hotel;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

import br.com.simvago.SolicitarReserva;
import br.com.simvago.TipoCliente;
import br.com.simvago.TipoTaxa;
import br.com.simvago.hoteis.Hotel;
import br.com.simvago.hoteis.RedeDHoteis;
import br.com.simvago.hoteis.Taxa;

public class RedeDHoteisTeste {
	
	private ArrayList<Hotel> listaHoteis = null;
	
	 @Test
	    public void melhorTaxaSemanalRegular() {
	    	Taxa semanaRegular = new Taxa(TipoTaxa.SEMANAL, TipoCliente.REGULAR, 110);
	        RedeDHoteis redes = new RedeDHoteis(new Hotel("hotel name", 5, semanaRegular));
	        assertThat(redes.CustoBeneficio(new SolicitarReserva("Regular: 20Mar2009(fri)")), is("hotel name"));
	    }

	    @Test
	    public void melhorTaxaSemanalParaDoisDiasRegular() {
	    	Taxa semanaRegular = new Taxa(TipoTaxa.SEMANAL, TipoCliente.REGULAR, 110);
	        Taxa fimdesemanaRegular = new Taxa(TipoTaxa.FIMDSEMANA, TipoCliente.REGULAR, 90);
	        listaHoteis = new ArrayList<Hotel>();
	        Hotel hotel1 = new Hotel("hotel name 1", 5, semanaRegular);
	        Hotel hotel2 = new Hotel("hotel name 2", 5, fimdesemanaRegular);
	        listaHoteis.add(hotel1);
	        listaHoteis.add(hotel2);
	        RedeDHoteis hotels = new RedeDHoteis(hotel1, hotel2);
	        assertThat(hotels.CustoBeneficio(new SolicitarReserva("Regular: 20Mar2009(fri)")), is("hotel name 2"));
	    }

	@Ignore("save this for later")
	@Test
	public void shouldFindBestRateForRegularWeekdayWithTwoChoicesEqualExceptForRating() {
		Hotel hotel1 = new Hotel("hotel name 1", 4,
				new ArrayList(new Taxa(TipoTaxa.SEMANAL, TipoCliente.Regular, 100)));
		Hotel hotel2 = new Hotel("hotel name 2", 5,
				new ArrayList(new Taxa(TipoTaxa.SEMANAL, TipoCliente.Regular, 100)));
		RedeDHoteis redes = new RedeDHoteis(hotel1, hotel2);
		assertThat(redes.CustoBeneficio(new SolicitarReserva("Regular: 20Mar2009(fri)")), is("hotel name 2"));
	}

	@Test
	public void shouldFindBestRateForOneWeekendAndOneWeekdayForRegularCustomer() {
		taxaPorHotel = new ArrayList<Taxa>();
		Taxa taxa1 = new Taxa(TipoTaxa.SEMANAL, TipoCliente.REGULAR, 100);
		Taxa taxa2 = new Taxa(TipoTaxa.FIMDSEMANA, TipoCliente.REGULAR, 100);

		Taxa taxa3 = new Taxa(TipoTaxa.SEMANAL, TipoCliente.REGULAR, 70);
		Taxa taxa4 = new Taxa(TipoTaxa.FIMDSEMANA, TipoCliente.REGULAR, 120);

		Hotel hotel1 = new Hotel("hotel name 1", 5, new ArrayList(taxa1, taxa2));
		Hotel hotel2 = new Hotel("hotel name 2", 5, new ArrayList(taxa3, taxa4));

		RedeDHoteis redes = new RedeDHoteis(hotel1, hotel2);

		assertThat(redes.CustoBeneficio(new SolicitarReserva("Regular: 20Mar2009(fri) 21Mar2009(sat)")),
				is("hotel name 1"));
	}
}