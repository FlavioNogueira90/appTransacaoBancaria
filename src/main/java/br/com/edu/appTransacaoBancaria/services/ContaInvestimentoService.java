package br.com.edu.appTransacaoBancaria.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.edu.appTransacaoBancaria.entities.Cliente;
import br.com.edu.appTransacaoBancaria.entities.ContaInvestimento;
import br.com.edu.appTransacaoBancaria.entities.enums.TipoConta;
import br.com.edu.appTransacaoBancaria.repositories.ContaBancariaRepository;
import br.com.edu.appTransacaoBancaria.repositories.ContaInvestimentoRepository;

@Service
public class ContaInvestimentoService {

	@Autowired
	private ContaInvestimentoRepository contaInvestimentoRepository;
	@Autowired
	private ContaBancariaRepository contaBancariaRepository;
	
	public Integer numConta() {
		Integer numConta = contaBancariaRepository.findMaxConta() + 1;
		System.out.println(numConta);
		return numConta;
	}
	
	public ContaInvestimento novaConta(Cliente cliente) {
		int novaConta = numConta();
		ContaInvestimento contaInvestimento = new ContaInvestimento(TipoConta.CONTAINVESTIMENTO, 570, novaConta, cliente, 10.0f, 1);
		contaInvestimentoRepository.save(contaInvestimento);
		return contaInvestimento;
	}
	
	public List<ContaInvestimento> listarContaInvestimento(Integer clienteId){
		return contaInvestimentoRepository.listarContaInvestimento(clienteId, TipoConta.CONTAINVESTIMENTO.getCod());
	}
}
