package br.com.edu.appTransacaoBancaria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.com.edu.appTransacaoBancaria.entities.Cliente;
import br.com.edu.appTransacaoBancaria.entities.ContaCorrente;
import br.com.edu.appTransacaoBancaria.services.ContaCorrenteService;

@Controller
public class ContaCorrenteController {
	
	@Autowired
	private ContaCorrenteService contaCorrenteService;

	public ContaCorrente abrirContaCorrente(Cliente cliente) {
		return contaCorrenteService.novaConta(cliente);
	}
	
	@GetMapping(value = "/novaContaCorrente")
	public String novaConta(@SessionAttribute("user") Cliente cliente) {
		abrirContaCorrente(cliente);
		return "redirect:/contaCorrenteLogado";
	}

	
	@GetMapping(value = "/contaCorrenteLogado")
	public String telaContaCorrente(Model model, @SessionAttribute("user") Cliente cliente) {
		if(cliente.getId() != null) {
			model.addAttribute("contas", contaCorrenteService.listarContaCorrente(cliente.getId()));
			model.addAttribute("user", cliente);
		}
		return "contaCorrente";
	}
	
	@GetMapping(value = "/contaCorrente")
	public String telaContaCorrente() {
		return "contaCorrente";
	}
}
