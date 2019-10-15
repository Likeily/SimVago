package testes.com;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.awt.List;
import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Test;

import br.com.simvago.SolicitarReserva;
import br.com.simvago.TipoCliente;
import br.com.simvago.TipoTaxa;

public class SolicitarReservaTeste {
	@Test
    public void shouldHaveDayTypeWeekday() {
        SolicitarReserva request = new SolicitarReserva("Regular: 20Mar2009(fri)");
        assertThat(request.getTipoTaxa(), is(TipoTaxa.SEMANAL));
    }

    @Test
    public void shouldHaveDayTypeWeekend() {
    	SolicitarReserva request = new SolicitarReserva("Regular: 21Mar2009(sat)");
        assertThat(request.getTipoTaxa(), is(TipoTaxa.FIMDSEMANA));
    }
    @Test
    public void shouldHaveCustomerTypeRegular() {
    	SolicitarReserva request = new SolicitarReserva("Regular: 20Mar2009(fri)");
        assertThat(request.getTipoCliente(), is(TipoCliente.REGULAR));
    }

    @Test
    public void shouldHaveCustomerTypeRewards() {
    	SolicitarReserva request = new SolicitarReserva("Rewards: 20Mar2009(fri)");
        assertThat(request.getTipoCliente(), is(TipoCliente.REWARDS));
    }

    @Test
    public void shouldHaveMultipleRateTypesPerRequestWhenRequestHasWeekdaysAndWeekendDays(){
    	SolicitarReserva request = new SolicitarReserva("Rewards: 20Mar2009(fri) 21Mar2009(sat)");
        List<LocalDate> dates = new ArrayList(new LocalDate(2009, 3, 20), new LocalDate(2009, 3, 21));
        assertThat(request.getDatas(), is(dates));
    }
}
