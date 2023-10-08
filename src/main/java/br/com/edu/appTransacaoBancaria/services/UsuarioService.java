package br.com.edu.appTransacaoBancaria.services;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.edu.appTransacaoBancaria.entities.Usuario;
import br.com.edu.appTransacaoBancaria.repositories.UsuarioRepository;

@Service
public class UsuarioService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public void criarUsuario(Usuario usuario){
		usuarioRepository.save(usuario);
	}
	
	public Usuario validarUsuario(String cpf, String senhaLogin) {
		Usuario usuario = usuarioRepository.findSenha(cpf);
		
		System.out.println(senhaLogin);
		System.out.println(usuario.getSenha());
		
		return usuario;
		//return senhaLogin.equalsIgnoreCase(senha) ? true : false;
	}
}
