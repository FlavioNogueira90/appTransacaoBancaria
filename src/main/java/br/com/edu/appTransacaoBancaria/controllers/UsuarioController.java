package br.com.edu.appTransacaoBancaria.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import br.com.edu.appTransacaoBancaria.entities.Usuario;
import br.com.edu.appTransacaoBancaria.services.ClienteService;
import br.com.edu.appTransacaoBancaria.services.UsuarioService;

@SessionAttributes("user")
@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private ContaBancariaController contaBancariaController;
	
	public void cadastrarUsuario(Usuario usuario) {
		usuarioService.criarUsuario(usuario);
	}
	
	@PostMapping(value = "/logar")
	public String validaLogin(Model model, @RequestParam String cpf, @RequestParam String senha) {
		try {
			Usuario usuario = usuarioService.validarUsuario(cpf, senha);

			if (usuario.getSenha().equalsIgnoreCase(senha)) {
				model.addAttribute("nome", clienteService.buscarNome(cpf));
				model.addAttribute("user", clienteService.findById(usuario.getId()));
				model.addAttribute("listagem", contaBancariaController.listarContas(usuario.getId()));

				return "/areaLogada/homeLogado";
			} else {
				return "login";
			}
		} catch (Exception e) {
			System.out.println(e);
			return "login";
		}
	}

	@GetMapping(value = "/logout")
	public String logout(HttpSession session, SessionStatus status) {
		
		status.setComplete();
		
		session.removeAttribute("user");
		
		return "redirect:/home";
	}
	
}
