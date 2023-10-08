package br.com.edu.appTransacaoBancaria.entities;

import javax.persistence.Entity;

import br.com.edu.appTransacaoBancaria.entities.enums.TipoConta;

@Entity
public class ContaInvestimento extends ContaBancaria {
	private static final long serialVersionUID = 1L;
	private float taxaJuros;
	private int prazoInvestimento;
	
	public ContaInvestimento() {
	}
	
	public ContaInvestimento(TipoConta tipoConta, int agencia, int conta, Cliente cliente, float taxaJuros, int prazoInvestimento) {
		super(tipoConta, agencia, conta, cliente);
		this.taxaJuros = taxaJuros;
		this.prazoInvestimento = prazoInvestimento;
	}
	

	public float getTaxaJuros() {
		return taxaJuros;
	}


	public void setTaxaJuros(float taxaJuros) {
		this.taxaJuros = taxaJuros;
	}


	public int getPrazoInvestimento() {
		return prazoInvestimento;
	}


	public void setPrazoInvestimento(int prazoInvestimento) {
		this.prazoInvestimento = prazoInvestimento;
	}



	@Override
	public String toString() {
		return "ContaInvestimento [taxaJuros=" + taxaJuros + ", prazoInvestimento=" + prazoInvestimento
				+ ", valorInvestido=" + "]";
	}
	
	
}
