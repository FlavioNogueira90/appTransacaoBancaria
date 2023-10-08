package br.com.edu.appTransacaoBancaria.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.edu.appTransacaoBancaria.entities.ContaBancaria;
import br.com.edu.appTransacaoBancaria.repositories.ContaBancariaRepository;

@Service
public class ContaBancariaService {

	@Autowired
	private ContaBancariaRepository contaBancariaRepository;
	
	public List<ContaBancaria> listarContas(Integer clienteId){
		List<ContaBancaria> list = new ArrayList<>();
		List<ContaBancaria> contas = new ArrayList<>();
		list = contaBancariaRepository.findAll();
		
		for (ContaBancaria contaBancaria : list) {
			if (contaBancaria.getCliente().getId().equals(clienteId)){
				contas.add(contaBancaria);
			}
		}
		return contas;
	}
	
	public void excluirConta(Integer id) {
		contaBancariaRepository.deleteById(id);
	}
}
