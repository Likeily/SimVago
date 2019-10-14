package br.com.testes.hotel;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import br.com.simvago.TipoCliente;
import br.com.simvago.TipoTaxa;
import br.com.simvago.hoteis.Hotel;
import br.com.simvago.hoteis.Taxa;

public class HotelTeste {
	
	private Hotel hotel;

	public void setUp() {
		Taxa semanaRegular = new Taxa(TipoTaxa.SEMANAL, TipoCliente.REGULAR, 100);
		Taxa fimdesemanaRegular = new Taxa(TipoTaxa.FIMDSEMANA, TipoCliente.REGULAR, 150);
		Taxa semanaRewards = new Taxa(TipoTaxa.SEMANAL, TipoCliente.REWARDS, 80);
		Taxa fimdesemanaRewards = new Taxa(TipoTaxa.FIMDSEMANA, TipoCliente.REWARDS, 125);

		hotel = new Hotel("hotel name", 3,
				new ArrayList<E>(semanaRegular, fimdesemanaRegular, semanaRewards, fimdesemanaRewards));
	}

	@Test
	public void classificaClienteSemanalRegular() {
		assertThat(hotel.tabelaPreco(TipoTaxa.SEMANAL, TipoCliente.REGULAR), is(100));
	}

	@Test
	public void classificaClienteFinalDeSemanaRegular() {
		assertThat(hotel.tabelaPreco(TipoTaxa.FIMDSEMANA, TipoCliente.REGULAR), is(150));
	}

	@Test
	public void classificaClienteSemanalRewards() {
		assertThat(hotel.tabelaPreco(TipoTaxa.SEMANAL, TipoCliente.REWARDS), is(80));
	}

	@Test
	public void classificaClienteFinalDeSemanaRewards() {
		assertThat(hotel.tabelaPreco(TipoTaxa.FIMDSEMANA, TipoCliente.REWARDS), is(125));
	}
}