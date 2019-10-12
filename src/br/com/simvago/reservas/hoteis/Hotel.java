package br.com.simvago.reservas.hoteis;

import java.beans.Customizer;
import java.util.List;

import org.omg.CORBA.portable.CustomValue;

import br.com.simvago.reservas.TipoCliente;
import br.com.simvago.reservas.TipoTaxa;

public class Hotel {

	private String nome;
	private Integer classificacao;
	private List<TipoTaxa> taxas;

	public Hotel(String nome, Integer classificacao, List<TipoTaxa> taxas) {
		super();
		this.nome = nome;
		this.classificacao = classificacao;
		this.taxas = taxas;
	}
	
	public Double tabelaPreco(List<TipoTaxa> tipoTaxa, TipoCliente tipoCliente) {
		for (TipoTaxa taxa : taxas) {
			if (taxa.cobranca(tipoTaxa, tipoCliente)) {
				return taxa.getCusto();
			}
		}
		return null;
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
	
	public List<TipoTaxa> getTaxas() {
		return taxas;
	}
	
	public void setTaxas(List<TipoTaxa> taxas) {
		this.taxas = taxas;
	}
	
}
