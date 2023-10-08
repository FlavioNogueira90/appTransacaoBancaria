package br.com.edu.appTransacaoBancaria.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.edu.appTransacaoBancaria.entities.Cliente;
import br.com.edu.appTransacaoBancaria.entities.Usuario;
import br.com.edu.appTransacaoBancaria.repositories.ClienteRepository;
import br.com.edu.appTransacaoBancaria.services.ClienteService;

@Controller
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private ContaBancariaController contaBancariaController;
	@Autowired
	private UsuarioController usuarioController;
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	
	@GetMapping(value = "/cliente/cadastroCliente")
	public String telaCadastroCliente() {
		return "cliente/cadastroCliente";
	}
	
	@GetMapping(value = "/cliente/clienteLista")
	public String clienteLista(Model model) {
		Collection<Cliente> list = clienteService.listarClientes();
		model.addAttribute("listaCliente", list);
		
		return "cliente/clienteLista";
	}
	
	public void cadastrarCliente(Cliente cliente) {
		clienteRepository.save(cliente);
	}
	
	@PostMapping(value = "/cliente/novoCliente")
	public String novoCliente(@RequestParam String nome,
							@RequestParam String cpf,
							@RequestParam String email,
							@RequestParam String tpConta,
							@RequestParam String senha,
							@RequestParam String dtNasc) throws ParseException {
		Cliente cliente = new Cliente(cpf, nome, email, sdf.parse(dtNasc));
		cadastrarCliente(cliente);

		usuarioController.cadastrarUsuario( new Usuario(senha, cliente));
		
		String[] tpContas =  tpConta.split(",");
		
		if (!tpContas[0].isEmpty()) {
			contaBancariaController.abrirConta(cliente, tpContas);
		}else {
			System.out.println("Tipo de conta inválido!");
		}
		return "redirect:/cliente/cadastroCliente";
	}
	
}
