package testes.com.hotel;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;

import org.junit.Test;

import br.com.simvago.SolicitarReserva;
import br.com.simvago.TipoCliente;
import br.com.simvago.TipoTaxa;
import br.com.simvago.hoteis.Hotel;
import br.com.simvago.hoteis.RedeDHoteis;
import br.com.simvago.hoteis.Taxa;

public class RedeDHoteisTeste {

	private ArrayList<Hotel> listaHoteis = null;

	private ArrayList<Taxa> listaTaxas = new ArrayList<>();

	@Test
	public void melhorTaxaSemanalRegular() {
		Taxa semanaRegular = new Taxa(TipoTaxa.SEMANAL, TipoCliente.REGULAR, 110);
		listaTaxas = new ArrayList<Taxa>();
		listaTaxas.add(semanaRegular);
		RedeDHoteis hoteis = new RedeDHoteis((new Hotel("nome do hotel", 5, listaTaxas)));
		assertThat(hoteis.CustoBeneficio(new SolicitarReserva("Regular: 25MJan2019(sex)")), is("nome do hotel"));
	}
	
	private ArrayList<Taxa> listaTaxasHotel1 = new ArrayList<>();
	
	private ArrayList<Taxa> listaTaxasHotel2 = new ArrayList<>();

	@Test
	public void melhorTaxaSemanalParaDoisDiasRegular() {
		Taxa semanaRegular1 = new Taxa(TipoTaxa.SEMANAL, TipoCliente.REGULAR, 100);
		listaTaxasHotel1 = new ArrayList<Taxa>();
		listaTaxasHotel1.add(semanaRegular1);
		Hotel hotel1 = new Hotel("nome do hotel 1", 5, listaTaxasHotel1);
		
		Taxa semanaRegular2 = new Taxa(TipoTaxa.SEMANAL, TipoCliente.REGULAR, 90);
		listaTaxasHotel2 = new ArrayList<Taxa>();
		listaTaxasHotel2.add(semanaRegular2);
		
		Hotel hotel2 = new Hotel("nome do hotel 2", 5, listaTaxasHotel2);
		
		RedeDHoteis hoteis = new RedeDHoteis(hotel1, hotel2);
        assertThat(hoteis.CustoBeneficio(new SolicitarReserva("Regular: 25Jan2019(sex)")), is("nome do hotel 2"));
	}

	@Test
	public void melhorTaxaSemanalParaDoisDiasSemClassificacao() {
		Taxa semanaRegular1 = new Taxa(TipoTaxa.SEMANAL, TipoCliente.REGULAR, 100);
		listaTaxasHotel1 = new ArrayList<Taxa>();
		listaTaxasHotel1.add(semanaRegular1);
		Hotel hotel1 = new Hotel("nome do hotel 1", 5, listaTaxasHotel1);
		
		Taxa semanaRegular2 = new Taxa(TipoTaxa.SEMANAL, TipoCliente.REGULAR, 100);
		listaTaxasHotel2 = new ArrayList<Taxa>();
		listaTaxasHotel2.add(semanaRegular2);
		
		Hotel hotel2 = new Hotel("nome do hotel 2", 5, listaTaxasHotel2);
		
		RedeDHoteis hoteis = new RedeDHoteis(hotel1, hotel2);
        assertThat(hoteis.CustoBeneficio(new SolicitarReserva("Regular: 25Jan2019(sex)")), is("nome do hotel 2"));
	}
	
	private ArrayList<Taxa> totalTaxa = null;
	private ArrayList<Taxa> totalTaxa2 = null;
	@Test
	public void melhorTaxaSemanalEFinalDSemanaRegular() {
		Taxa taxa1 = new Taxa(TipoTaxa.SEMANAL, TipoCliente.REGULAR, 100);
		Taxa taxa2 = new Taxa(TipoTaxa.FIMDSEMANA, TipoCliente.REGULAR, 100);
		totalTaxa = new ArrayList<Taxa>();
		totalTaxa.add(taxa1);
		totalTaxa.add(taxa2);
		
		Taxa taxa3 = new Taxa(TipoTaxa.SEMANAL, TipoCliente.REGULAR, 70);
		Taxa taxa4 = new Taxa(TipoTaxa.FIMDSEMANA, TipoCliente.REGULAR, 120);
		Hotel hotel1 = new Hotel("nome hotel 1", 5, totalTaxa);
		
		totalTaxa2 = new ArrayList<Taxa>();
		totalTaxa2.add(taxa3);
		totalTaxa2.add(taxa4);
		Hotel hotel2 = new Hotel("nome hotel 2", 5, totalTaxa2);

		RedeDHoteis hoteis = new RedeDHoteis(hotel1, hotel2);
        assertThat(hoteis.CustoBeneficio(new SolicitarReserva("Regular: 25Jan2019(sex) 27MJan2019(Dom)")), is("nome do hotel 1"));
	}

	public ArrayList<Hotel> getListaHoteis() {
		return listaHoteis;
	}

	public void setListaHoteis(ArrayList<Hotel> listaHoteis) {
		this.listaHoteis = listaHoteis;
	}
}