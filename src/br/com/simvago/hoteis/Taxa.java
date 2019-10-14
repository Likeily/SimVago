package br.com.simvago.hoteis;

import br.com.simvago.TipoCliente;
import br.com.simvago.TipoTaxa;

public class Taxa {
	
	private TipoTaxa tipoTaxa;
	private TipoCliente tipoCliente;
	private Integer custo;

	public boolean cobranca(TipoTaxa tipoTaxa, TipoCliente tipoCliente) {
		return this.tipoTaxa.equals(tipoTaxa) && this.tipoCliente.equals(tipoCliente);
	}
	
	public Taxa(TipoTaxa tipoTaxa, TipoCliente tipoCliente, Integer custo) {
		this.tipoTaxa = tipoTaxa;
		this.tipoCliente = tipoCliente;
		this.custo = custo;
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
	public Integer getCusto() {
		return custo;
	}
	public void setCusto(Integer custo) {
		this.custo = custo;
	}
	
	
}
