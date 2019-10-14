package br.com.simvago.hoteis;

import java.util.ArrayList;
import java.util.List;

import br.com.simvago.SolicitarReserva;
import br.com.simvago.TipoCliente;
import br.com.simvago.TipoTaxa;

public class Hotel {

	private String nome;
	private Integer classificacao;
	private List<Taxa> taxas;

	public Hotel(String nome, Integer classificacao, ArrayList<Taxa> taxas) {
		super();
		this.nome = nome;
		this.classificacao = classificacao;
		this.taxas = taxas;
	}
	
	public Integer tabelaPreco(TipoTaxa tipoTaxa, TipoCliente tipoCliente) {
		for (Taxa taxa : taxas) {
			if (taxa.cobranca(tipoTaxa, tipoCliente)) {
				return taxa.getCusto();
			}
		}
		return null;
	}
	
	public Integer tabelaPreco(SolicitarReserva request) {
		return tabelaPreco(request.getTipoTaxa(), request.getTipoCliente());
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Integer getClassificacao() {
		return classificacao;
	}
	
	public void setClassificacao(Integer classificacao) {
		this.classificacao = classificacao;
	}
	
}
