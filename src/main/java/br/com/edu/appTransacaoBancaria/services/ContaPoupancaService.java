package br.com.edu.appTransacaoBancaria.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.edu.appTransacaoBancaria.entities.Cliente;
import br.com.edu.appTransacaoBancaria.entities.ContaPoupanca;
import br.com.edu.appTransacaoBancaria.entities.enums.TipoConta;
import br.com.edu.appTransacaoBancaria.repositories.ContaBancariaRepository;
import br.com.edu.appTransacaoBancaria.repositories.ContaPoupancaRepository;

@Service
public class ContaPoupancaService {

	@Autowired
	private ContaPoupancaRepository contaPoupancaRepository;
	@Autowired
	private ContaBancariaRepository contaBancariaRepository;
	
	public Integer numConta() {
		Integer numConta = contaBancariaRepository.findMaxConta() + 1;
		return numConta;
	}
	
	public ContaPoupanca novaConta(Cliente cliente) {
		int novaConta = numConta();
		ContaPoupanca contaPoupanca = new ContaPoupanca(TipoConta.CONTAPOUPANCA, 0570, novaConta, cliente, 0.04f, LocalDate.now(), 3);
		contaPoupancaRepository.save(contaPoupanca);
		return contaPoupanca;
	}
	
	public List<ContaPoupanca> listarContaPoupanca(Integer clienteId){
		System.out.println("ClienteId: " + clienteId + " TipoConta: " + TipoConta.CONTAPOUPANCA.getCod());
		return contaPoupancaRepository.listarContaPoupanca(clienteId, TipoConta.CONTAPOUPANCA.getCod());
	}
}
