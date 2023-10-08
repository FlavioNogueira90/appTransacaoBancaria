package br.com.edu.appTransacaoBancaria.loaders;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import br.com.edu.appTransacaoBancaria.entities.Cliente;
import br.com.edu.appTransacaoBancaria.repositories.ClienteRepository;

public class ClienteLoader implements ApplicationRunner {

	private final static String path = "arquivos/Clientes.txt";
	@Autowired
	ClienteRepository clienteRepository;

	SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
			String linha = "";
			linha = bufferedReader.readLine();

			while (true) {
				if (linha != null) {
					String[] vetor = linha.split(";");

					Cliente cliente = new Cliente();
					cliente.setNome(vetor[1]);
					cliente.setCpf(vetor[2]);
					cliente.setEmail(vetor[3]);
					cliente.setDataNasc(data.parse(vetor[4]));;

					System.out.println(cliente.toString());
					clienteRepository.save(cliente);
				}else {
					break;
				}
				linha = bufferedReader.readLine();
			}

		} catch (Exception e) {
			System.out.println("Erro ao ler arquivo Clientes " + e.getMessage());
		}
	}
	
	public static void gravarCliente(Cliente cliente) {
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {
			bufferedWriter.append(
							  cliente.getId() + ";" 
							+ cliente.getNome() + ";" 
							+ cliente.getCpf() + ";" 
							+ cliente.getEmail());
		} catch (Exception e) {
			System.out.println("Erro ao gravar arquivo Cliente " + e.getMessage());
		}
	}
}
