package br.com.edu.appTransacaoBancaria.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.edu.appTransacaoBancaria.entities.ContaBancaria;

public interface ContaBancariaRepository extends JpaRepository<ContaBancaria, Integer>{

	@Query(nativeQuery = true, value = "SELECT MAX(conta) FROM conta_bancaria")
	Integer findMaxConta(); 

	@Query(nativeQuery = true, value = "SELECT * FROM CONTA_BANCARIA WHERE CLIENTE_ID = :clienteId")
	List<ContaBancaria> listarContasUsuario(Integer clienteId);
}
