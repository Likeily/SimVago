package br.com.simvago.reservas.hoteis;

import br.com.simvago.reservas.TipoCliente;
import br.com.simvago.reservas.TipoTaxa;

public class Taxa {
	
	private TipoTaxa tipoTaxa;
	private TipoCliente tipoCliente;
	private Double custo;
	
	public boolean cobranca(TipoTaxa tipoTaxa, TipoCliente tipoCliente) {
		return this.tipoTaxa.equals(tipoTaxa) && this.tipoCliente.equals(tipoCliente);
	}
	
	public TipoTaxa getTipoTaxa() {
		return tipoTaxa;
	}
	public void setTipoTaxa(TipoTaxa tipoTaxa) {
		this.tipoTaxa = tipoTaxa;
	}
	public TipoCliente getTipoCliente() {
		return tipoCliente;
	}
	public void setTipoCliente(TipoCliente tipoCliente) {
		this.tipoCliente = tipoCliente;
	}
	public Double getCusto() {
		return custo;
	}
	public void setCusto(Double custo) {
		this.custo = custo;
	}
	
	
}
