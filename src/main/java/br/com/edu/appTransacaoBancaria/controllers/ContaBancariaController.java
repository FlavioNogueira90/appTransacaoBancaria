package br.com.edu.appTransacaoBancaria.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.edu.appTransacaoBancaria.entities.Cliente;
import br.com.edu.appTransacaoBancaria.entities.ContaBancaria;
import br.com.edu.appTransacaoBancaria.entities.ContaCorrente;
import br.com.edu.appTransacaoBancaria.entities.ContaInvestimento;
import br.com.edu.appTransacaoBancaria.entities.ContaPoupanca;
import br.com.edu.appTransacaoBancaria.services.ContaBancariaService;

@Controller
public class ContaBancariaController {
	
	@Autowired
	private ContaCorrenteController contaCorrenteController;
	@Autowired
	private ContaPoupancaController contaPoupancaController;
	@Autowired
	private ContaInvestimentoController contaInvestimentoController;
	@Autowired
	private ContaBancariaService contaBancariaService;
	
	public void abrirConta(Cliente cliente, String[] tpContas) {
		
		for(int i = 0; i < tpContas.length; i++) {
			
			switch (tpContas[i]) {
			case "CONTACORRENTE": 
				ContaCorrente contaCorrente = contaCorrenteController.abrirContaCorrente(cliente);
				cliente.getContas().add(contaCorrente);
				break;
			case "CONTAPOUPANCA": 
				ContaPoupanca contaPoupanca = contaPoupancaController.abrirContaPoupanca(cliente);
				cliente.getContas().add(contaPoupanca);
				break;
			case "CONTAINVESTIMENTO": 
				ContaInvestimento contaInvestimento = contaInvestimentoController.abrirContaInvestimento(cliente);
				cliente.getContas().add(contaInvestimento);
				break;
			default:
				System.out.println("Tipo conta inválido");
			}
		}
	}
	
	public List<ContaBancaria> listarContas(Integer clienteId) {
		System.out.println("classe ContaBancariaController: " + clienteId);
		return contaBancariaService.listarContas(clienteId);
	}
	
	@GetMapping(value = "/conta/{id}/excluir")
	public String excluirConta(@PathVariable Integer id) {
		contaBancariaService.excluirConta(id);
		return "redirect:/homeLogado";
	}
}
