package br.com.edu.appTransacaoBancaria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.com.edu.appTransacaoBancaria.entities.Cliente;
import br.com.edu.appTransacaoBancaria.entities.ContaInvestimento;
import br.com.edu.appTransacaoBancaria.services.ContaInvestimentoService;

@Controller
public class ContaInvestimentoController {
	
	@Autowired
	private ContaInvestimentoService contaInvestimentoService;
	
	public ContaInvestimento abrirContaInvestimento(Cliente cliente) {
		return contaInvestimentoService.novaConta(cliente);
	}

	
	@GetMapping(value = "/novaContaInvestimento")
	public String novaConta(@SessionAttribute("user") Cliente cliente) {
		abrirContaInvestimento(cliente);
		return "redirect:/contaInvestimentoLogado";
	}
	
	@GetMapping(value = "/contaInvestimentoLogado")
	public String telaContaCorrente(Model model, @SessionAttribute("user") Cliente cliente) {
		if(cliente.getId() != null) {
			model.addAttribute("contas", contaInvestimentoService.listarContaInvestimento(cliente.getId()));
			model.addAttribute("user", cliente);
		}
		return "contaInvestimento";
	}
}
