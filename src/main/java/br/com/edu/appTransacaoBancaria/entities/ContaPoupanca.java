package br.com.edu.appTransacaoBancaria.entities;

import java.time.LocalDate;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.edu.appTransacaoBancaria.entities.enums.TipoConta;
@Entity
public class ContaPoupanca extends ContaBancaria {
	private static final long serialVersionUID = 1L;
	private float taxaRendimento;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate aniversarioConta;
	private int limiteSaqueMensal;

	public ContaPoupanca() {
	}
	
	public ContaPoupanca(TipoConta tipoConta, int agencia, int conta, Cliente cliente, float taxaRendimento, LocalDate aniversarioConta, int limiteSaqueMensal) {
		super(tipoConta, agencia, conta, cliente);
		this.taxaRendimento = taxaRendimento;
		this.aniversarioConta = aniversarioConta;
		this.limiteSaqueMensal = limiteSaqueMensal;
	}
	

	public float getTaxaRendimento() {
		return taxaRendimento;
	}


	public void setTaxaRendimento(float taxaRendimento) {
		this.taxaRendimento = taxaRendimento;
	}


	public LocalDate getAniversarioConta() {
		return aniversarioConta;
	}


	public void setAniversarioConta(LocalDate aniversarioConta) {
		this.aniversarioConta = aniversarioConta;
	}


	public int getLimiteSaqueMensal() {
		return limiteSaqueMensal;
	}


	public void setLimiteSaqueMensal(int limiteSaqueMensal) {
		this.limiteSaqueMensal = limiteSaqueMensal;
	}


	@Override
	public String toString() {
		return "ContaPoupanca [taxaRendimento=" + taxaRendimento + ", aniversarioConta=" + aniversarioConta
				+ ", limiteSaqueMensal=" + limiteSaqueMensal + "]";
	}

	
}
