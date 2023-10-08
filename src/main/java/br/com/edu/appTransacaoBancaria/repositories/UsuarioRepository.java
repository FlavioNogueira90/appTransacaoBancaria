package br.com.edu.appTransacaoBancaria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.edu.appTransacaoBancaria.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	@Query(nativeQuery = true, value = "SELECT * FROM USUARIO WHERE CPF = :cpf")
	Usuario findSenha(String cpf); 
}
