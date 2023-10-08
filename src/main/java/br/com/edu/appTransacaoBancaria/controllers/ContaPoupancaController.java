package br.com.edu.appTransacaoBancaria.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.com.edu.appTransacaoBancaria.entities.Cliente;
import br.com.edu.appTransacaoBancaria.entities.ContaPoupanca;
import br.com.edu.appTransacaoBancaria.services.ContaPoupancaService;

@Controller
public class ContaPoupancaController {
	
	@Autowired
	private ContaPoupancaService contaPoupancaService;
	
	public ContaPoupanca abrirContaPoupanca(Cliente cliente) {
		return contaPoupancaService.novaConta(cliente);
	}
	
	@GetMapping(value = "/novaContaPoupanca")
	public String novaConta(@SessionAttribute("user") Cliente cliente) {
		abrirContaPoupanca(cliente);
		return "redirect:/contaPoupancaLogado";
	}
	
	@GetMapping(value = "/contaPoupancaLogado")
	public String telaContaCorrente(Model model, @SessionAttribute("user") Cliente cliente) {
		if(cliente.getId() != null) {
			List<ContaPoupanca> list = new ArrayList<>();
			list = contaPoupancaService.listarContaPoupanca(cliente.getId());
			System.out.println("Retornou: " + list.size());
			
			model.addAttribute("contas",contaPoupancaService.listarContaPoupanca(cliente.getId()));
//			model.addAttribute("contas",contaPoupancaService.listarContaPoupanca(cliente.getId()));
			model.addAttribute("user", cliente);
		}
		return "contaPoupanca";
	}
	
	
}
