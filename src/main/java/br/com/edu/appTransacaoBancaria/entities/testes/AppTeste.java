package br.com.edu.appTransacaoBancaria.entities.testes;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.com.edu.appTransacaoBancaria.entities.Cliente;
import br.com.edu.appTransacaoBancaria.entities.ContaCorrente;
import br.com.edu.appTransacaoBancaria.entities.ContaInvestimento;
import br.com.edu.appTransacaoBancaria.entities.ContaPoupanca;
import br.com.edu.appTransacaoBancaria.entities.enums.TipoConta;
import br.com.edu.appTransacaoBancaria.repositories.ClienteRepository;
import br.com.edu.appTransacaoBancaria.repositories.ContaBancariaRepository;
import br.com.edu.appTransacaoBancaria.repositories.ContaCorrenteRepository;
import br.com.edu.appTransacaoBancaria.repositories.ContaInvestimentoRepository;
import br.com.edu.appTransacaoBancaria.repositories.ContaPoupancaRepository;

@Component
public class AppTeste implements ApplicationRunner {

	//private final String pathCliente = "arquivos/Clientes.txt";
	private final String pathContaCorrente = "arquivos/ContaCorrente.txt";
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ContaCorrenteRepository contaCorrenteRepository;
	@Autowired
	private ContaPoupancaRepository contaPoupancaRepository;
	@Autowired
	private ContaInvestimentoRepository contaInvestimentoRepository;
	@Autowired
	private ContaBancariaRepository contaBancariaRepository;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
		
		Cliente clie1 = new Cliente("40261731866", "Flavio Nogueira", "flavio@gmail.com", data.parse("14/07/1990"));
		Cliente clie2 = new Cliente("39466633899", "Patricia Pereira", "patty@gmail.com", data.parse("31/03/1992"));
		Cliente clie3 = new Cliente("45635786822", "Wanderley Nogueira", "vando@gmail.com", data.parse("19/04/1995"));


		
		ContaCorrente conta1 = new ContaCorrente(TipoConta.CONTACORRENTE, 570, 599191, clie1, 150.0f, 5.6f, false);
		ContaPoupanca conta2 = new ContaPoupanca(TipoConta.CONTAPOUPANCA, 570, 612345, clie1, 0.04f, LocalDate.now(), 3);
		ContaInvestimento conta3 = new ContaInvestimento(TipoConta.CONTAINVESTIMENTO, 570, 700005, clie1, 1.0f, 3);
		clie1.getContas().addAll(Arrays.asList(conta1, conta2, conta3));
		
		clienteRepository.save(clie1);
		clienteRepository.save(clie2);
		clienteRepository.save(clie3);
		
		
		contaBancariaRepository.save(conta1);
		contaBancariaRepository.save(conta2);
		contaBancariaRepository.save(conta3);
		
		
		System.out.println(clie1);
		
		//ClienteLoader.gravarCliente(clie1);
//		ContaCorrenteLoader.gravarContaCorrente(conta1, pathContaCorrente);
	}

}
