package br.com.edu.appTransacaoBancaria.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.edu.appTransacaoBancaria.entities.ContaCorrente;

public interface ContaCorrenteRepository extends JpaRepository<ContaCorrente, Integer> {

	@Query(nativeQuery = true, value = "SELECT * FROM CONTA_BANCARIA A"
									 + " INNER JOIN CONTA_CORRENTE B"
									 + " WHERE A.ID = B.ID"
									 + " AND A.CLIENTE_ID = :idCliente"
									 + " AND A.TIPO_CONTA = :tpConta")
	List<ContaCorrente> listarContaCorrente(Integer idCliente, Integer tpConta);
}
