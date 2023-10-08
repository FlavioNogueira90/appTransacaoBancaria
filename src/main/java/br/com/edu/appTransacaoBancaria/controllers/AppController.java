package br.com.edu.appTransacaoBancaria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.com.edu.appTransacaoBancaria.entities.Cliente;
import br.com.edu.appTransacaoBancaria.services.ClienteService;

@Controller
public class AppController {
	
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private ContaBancariaController contaBancariaController;
	
	@GetMapping(value = "/homeLogado")
	public String telaHome(Model model, @SessionAttribute("user") Cliente cliente) {
		if(cliente.getId() != null) {
			model.addAttribute("nome", clienteService.buscarNome(cliente.getCpf()));
			model.addAttribute("user", clienteService.findById(cliente.getId()));
			model.addAttribute("listagem", contaBancariaController.listarContas(cliente.getId()));
		}
		return "/areaLogada/homeLogado";
	}
	@GetMapping(value = "/home")
	public String telaHome() {
		return "home";
	}
	
	@GetMapping(value = "/sobre")
	public String telaSobre() {
		return "sobre";
	}
	@GetMapping(value = "/login")
	public String telaLogin() {
		return "login";
	}
	
/*	@PostMapping(value = "/logar")
	public String telaLoginComDados(@RequestParam String agencia, @RequestParam String conta) {
		System.out.println("Agencia: " + agencia + " Conta:" + conta);
		
		return "redirect:/login";
	}*/

	@GetMapping(value = "/contaPoupanca")
	public String telaContaPoupanca() {
		return "contaPoupanca";
	}
	@GetMapping(value = "/contaInvestimento")
	public String telaContaInvestimento() {
		return "contaInvestimento";
	}

}
