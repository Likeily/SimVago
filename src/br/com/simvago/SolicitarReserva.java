package br.com.simvago;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SolicitarReserva {

	private TipoCliente tipoCliente;
	
	private TipoTaxa tipoTaxa;
	
	private List<LocalDate> datas = new ArrayList<LocalDate>();
	
//	public SolicitarReserva(String solicitacao) {
//		this.tipoCliente =  tipoCliente.from(solicitacao);
//		this.tipoTaxa = tipoTaxa.from(solicitacao);
//		this.datas = datas(solicitacao);
//	}
//	
//	private List<LocalDate> datasPedido(String solicitacao){
//		List<LocalDate> datasEntrada = new ArrayList<LocalDate>();
//		
//		String re
//	}

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
