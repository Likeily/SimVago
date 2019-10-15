package br.com.simvago;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SolicitarReserva {

	private TipoCliente tipoCliente;

	private TipoTaxa tipoTaxa;

	private List<LocalDate> datas = new ArrayList<LocalDate>();

	public SolicitarReserva(String pedido) {
	        this.tipoTaxa = TipoTaxa.from(pedido);
	        this.tipoCliente = TipoCliente.from(pedido);
	        this.datas = datesFrom(pedido);
	    }

	private List<LocalDate> datesFrom(String pedido) {
		List<LocalDate> pedidoDatas = new ArrayList<LocalDate>();

		String regex = ".*(\\d+\\s{3}\\d{4}).*";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(pedido);
		boolean matches = matcher.matches();

		if (matches) {
			for (int i = 0; i < matcher.groupCount(); i++) {
				pedidoDatas.add(dateFrom(matcher.group(i)));
			}
		}

		return pedidoDatas;
	}

	private LocalDate dateFrom(String group) {
		return new LocalDate(LocalDate.parse("dMMMy").parse(group));
	}

	public TipoCliente getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(TipoCliente tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public TipoTaxa getTipoTaxa() {
		return tipoTaxa;
	}

	public void setTipoTaxa(TipoTaxa tipoTaxa) {
		this.tipoTaxa = tipoTaxa;
	}

	public List<LocalDate> getDatas() {
		return datas;
	}

	public void setDatas(List<LocalDate> datas) {
		this.datas = datas;
	}

}
