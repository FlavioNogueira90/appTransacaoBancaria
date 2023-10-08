package br.com.edu.appTransacaoBancaria.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.edu.appTransacaoBancaria.entities.Cliente;
import br.com.edu.appTransacaoBancaria.entities.ContaCorrente;
import br.com.edu.appTransacaoBancaria.entities.enums.TipoConta;
import br.com.edu.appTransacaoBancaria.repositories.ContaBancariaRepository;
import br.com.edu.appTransacaoBancaria.repositories.ContaCorrenteRepository;

@Service
public class ContaCorrenteService {

	@Autowired
	private ContaCorrenteRepository contaCorrenteRepository;
	@Autowired
	private ContaBancariaRepository contaBancariaRepository;
	
	public Integer numConta() {
		Integer numConta = contaBancariaRepository.findMaxConta() + 1;
		System.out.println(numConta);
		return numConta;
	}
	
	public ContaCorrente novaConta(Cliente cliente) {
		int novaConta = numConta();
		ContaCorrente contaCorrente = new ContaCorrente(TipoConta.CONTACORRENTE, 570, novaConta, cliente, 10.0f, 5.6f, false);
		contaCorrenteRepository.save(contaCorrente);
		return contaCorrente;
	}
	
	public List<ContaCorrente> listarContaCorrente(Integer clienteId){
		return contaCorrenteRepository.listarContaCorrente(clienteId, TipoConta.CONTACORRENTE.getCod());
	}
}
