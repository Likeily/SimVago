package testes.com.hotel;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Ignore;
import org.junit.Test;

import br.com.simvago.SolicitarReserva;
import br.com.simvago.TipoCliente;
import br.com.simvago.TipoTaxa;
import br.com.simvago.hoteis.Hotel;
import br.com.simvago.hoteis.RedeDHoteis;
import br.com.simvago.hoteis.Taxa;

public class RedeDHoteisTeste {
	
	@Test
	public void shouldFindBestRateForRegularWeekday() {
		RedeDHoteisTeste redes = new RedeDHoteisTeste(
				new Hotel("hotel name", 5, newArrayList(new Taxa(TipoTaxa.SEMANAL, TipoCliente.REGULAR, 100)));
		assertThat(redes.CustoBeneficio(new ReservationRequest("Regular: 20Mar2009(fri)")), is("hotel name"));
	}

	@Test
	public void shouldFindBestRateForRegularWeekdayWithTwoChoices() {
		Hotel hotel1 = new Hotel("hotel name 1", 5,
				new ArrayList(new Taxa(TipoTaxa.SEMANAL, TipoCliente.REGULAR, 100)));
		Hotel hotel2 = new Hotel("hotel name 2", 5, new ArrayList(new Taxa(TipoTaxa.SEMANAL, TipoCliente.REGULAR, 90)));
		RedeDHoteis redes = new RedeDHoteis(hotel1, hotel2);
		assertThat(redes.CustoBeneficio(new SolicitarReserva("Regular: 20Mar2009(fri)")), is("hotel name 2"));
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