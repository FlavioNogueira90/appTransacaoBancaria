package br.com.edu.appTransacaoBancaria.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.edu.appTransacaoBancaria.entities.enums.TipoConta;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ContaBancaria implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private int tipoConta;
	private int agencia;
	private int conta;
	private float saldo;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	public ContaBancaria() {

	}
	
	public ContaBancaria(TipoConta tipoConta, int agencia, int conta, Cliente cliente) {
		this.tipoConta = tipoConta.getCod();
		this.agencia = agencia;
		this.conta = conta;
		this.cliente = cliente;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public TipoConta getTipoConta() {
		return TipoConta.toEnum(tipoConta);
	}

	public void setTipoConta(TipoConta tipoConta) {
		this.tipoConta = tipoConta.getCod();
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getConta() {
		return conta;
	}

	public void setConta(int conta) {
		this.conta = conta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	
	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "ContaBancaria [id=" + id + ", tipoConta=" + tipoConta + ", agencia=" + agencia + ", conta=" + conta
				+ ", saldo=" + saldo + ", cliente=" + cliente + "]";
	}


	
	
}
