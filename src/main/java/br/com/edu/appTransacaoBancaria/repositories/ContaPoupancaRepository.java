package br.com.edu.appTransacaoBancaria.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.edu.appTransacaoBancaria.entities.ContaPoupanca;

public interface ContaPoupancaRepository extends JpaRepository<ContaPoupanca, Integer> {

	@Query(nativeQuery = true, value = "SELECT * FROM CONTA_BANCARIA A"
									 + " INNER JOIN CONTA_POUPANCA B"
									 + " WHERE A.ID = B.ID"
									 + " AND A.CLIENTE_ID = :idCliente"
									 + " AND A.TIPO_CONTA = :tpConta")
	List<ContaPoupanca> listarContaPoupanca(Integer idCliente, Integer tpConta);
}
