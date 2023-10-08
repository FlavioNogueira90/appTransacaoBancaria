package br.com.edu.appTransacaoBancaria.loaders;

import java.io.BufferedWriter;
import java.io.FileWriter;

import br.com.edu.appTransacaoBancaria.entities.ContaCorrente;

public class ContaCorrenteLoader {
	//private final String path = "/Operacoes_Bancaria/arquivos/Clientes.txt";

	public static void gravarContaCorrente(ContaCorrente contaBancaria, String path) {
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))){
			//bufferedWriter.newLine();
			
			bufferedWriter.append(contaBancaria.getTipoConta() + ";"
								+ contaBancaria.getAgencia() + ";"
								+ contaBancaria.getConta() + ";"
								+ contaBancaria.getSaldo() + ";"
								+ contaBancaria.getLimiteChequeEspecial() + ";"
								+ contaBancaria.getTaxaManutencao() + ";"
								+ contaBancaria.isTalonarioCheque() + ";"
								+ contaBancaria.getCliente().getId());
			
		} catch (Exception e) {
			System.out.println("Erro ao gravar arquivo ContaBancaria " + e.getMessage());
		}
	}
}
