package br.com.edu.appTransacaoBancaria.services;

import java.io.Serializable;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.edu.appTransacaoBancaria.entities.Cliente;
import br.com.edu.appTransacaoBancaria.repositories.ClienteRepository;

@Service
public class ClienteService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Autowired
	private ClienteRepository clienteRepository;
	
	public Collection<Cliente> listarClientes(){
		Collection<Cliente> clientes = clienteRepository.findAll();
		return clientes;
	}
	
	public String buscarNome(String cpf) {
		return clienteRepository.findByCpf(cpf);
	}
	
	public Cliente findById(Integer id) {
		Optional<Cliente> opt = clienteRepository.findById(id);
		Cliente cliente = opt.orElse(new Cliente());
		
		System.out.println(cliente.toString());
		return cliente;
	}
}
