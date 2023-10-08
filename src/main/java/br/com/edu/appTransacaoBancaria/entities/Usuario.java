package br.com.edu.appTransacaoBancaria.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class Usuario {

	@Id
	private Integer id;
	private String senha;
	private String cpf;
	@OneToOne
	@JoinColumn(name="cliente_id")
	@MapsId
	private Cliente cliente;
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public Usuario(String senha, Cliente cliente) {
		super();
		this.senha = senha;
		this.cpf = cliente.getCpf();
		this.cliente = cliente;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
