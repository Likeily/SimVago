package testes.com.hotel;

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
	
	private ArrayList<Taxa> listaTaxas = null;

	public void setUp() {
		Taxa semanaRegular = new Taxa(TipoTaxa.SEMANAL, TipoCliente.REGULAR, 100);
		Taxa fimdesemanaRegular = new Taxa(TipoTaxa.FIMDSEMANA, TipoCliente.REGULAR, 150);
		Taxa semanaRewards = new Taxa(TipoTaxa.SEMANAL, TipoCliente.REWARDS, 80);
		Taxa fimdesemanaRewards = new Taxa(TipoTaxa.FIMDSEMANA, TipoCliente.REWARDS, 125);

	    listaTaxas = new ArrayList<Taxa>();
        listaTaxas.add(semanaRegular);
        listaTaxas.add(fimdesemanaRegular);
        listaTaxas.add(semanaRewards);
        listaTaxas.add(fimdesemanaRewards);
        
		hotel = new Hotel("nome do hotel", 3, listaTaxas);
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