package br.com.edu.appTransacaoBancaria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.edu.appTransacaoBancaria.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

	@Query(nativeQuery = true,  value = "SELECT NOME FROM CLIENTE WHERE CPF = :cpf")
	String findByCpf(String cpf);
}
