package br.com.edu.appTransacaoBancaria.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.edu.appTransacaoBancaria.entities.ContaInvestimento;

public interface ContaInvestimentoRepository extends JpaRepository<ContaInvestimento, Integer> {

	@Query(nativeQuery = true, value = "SELECT * FROM CONTA_BANCARIA A"
									 + " INNER JOIN CONTA_INVESTIMENTO B"
									 + " WHERE A.ID = B.ID"
									 + " AND A.CLIENTE_ID = :idCliente"
									 + " AND A.TIPO_CONTA = :tpConta")
	List<ContaInvestimento> listarContaInvestimento(Integer idCliente, Integer tpConta);
}
