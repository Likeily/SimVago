package testes.com;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import br.com.simvago.SolicitarReserva;
import br.com.simvago.TipoCliente;
import br.com.simvago.TipoTaxa;

public class SolicitarReservaTeste {
	
	@Test
    public void exibeDiaDaSemana() {
        SolicitarReserva solicitacao = new SolicitarReserva("Regular: 25MJan2019(sex)");
        assertThat(solicitacao.getTipoTaxa(), is(TipoTaxa.SEMANAL));
    }

    @Test
    public void exibeDiaDoFinalDeSemana() {
    	SolicitarReserva solicitacao = new SolicitarReserva("Regular: 27MJan2019(Dom)");
        assertThat(solicitacao.getTipoTaxa(), is(TipoTaxa.FIMDSEMANA));
    }
    @Test
    public void exibeClienteRegular() {
    	SolicitarReserva solicitacao = new SolicitarReserva("Regular: 25Jan2019(sex)");
        assertThat(solicitacao.getTipoCliente(), is(TipoCliente.REGULAR));
    }

    @Test
    public void exibeClienteRewards() {
    	SolicitarReserva solicitacao = new SolicitarReserva("Rewards: 11Fev2020(Ter)");
        assertThat(solicitacao.getTipoCliente(), is(TipoCliente.REWARDS));
    }

}
