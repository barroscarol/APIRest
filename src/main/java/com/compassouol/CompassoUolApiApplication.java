package com.compassouol;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.compassouol.domain.Cidade;
import com.compassouol.domain.Cliente;
import com.compassouol.repositories.CidadeRepository;
import com.compassouol.repositories.ClienteRepository;

@SpringBootApplication
public class CompassoUolApiApplication implements CommandLineRunner {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;

	public static void main(String[] args) {
		SpringApplication.run(CompassoUolApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");

		Cliente cli1 = new Cliente(null, "Maria Carolina Barros","feminino", sdf.parse("20/07/1993"), 27, "Paulista");
		clienteRepository.save(cli1);
		
		Cliente cli2 = new Cliente(null, "José Barros","masculino", sdf.parse("13/01/1990"), 31, "Olinda");
		clienteRepository.save(cli2);
		
		Cliente cli3 = new Cliente(null, "Maria ","feminino", sdf.parse("10/07/1993"), 27, "Natal");
		clienteRepository.save(cli3);
		
		Cliente cli4 = new Cliente(null, "João ","Masculino", sdf.parse("10/07/1992"), 28, "Rio de Janeiro");
		clienteRepository.save(cli4);
		
		Cidade cid1 = new Cidade(null, "Recife", "Pernambuco");
		cidadeRepository.save(cid1);
		
		Cidade cid2 = new Cidade(null, "São Paulo", "São Paulo");
		cidadeRepository.save(cid2);
		
		Cidade cid3 = new Cidade(null, "Belo Horizonte", "Minas Gerais");
		cidadeRepository.save(cid3);
		
		Cidade cid4 = new Cidade(null, "Salvador", "Bahia");
		cidadeRepository.save(cid4);
		
		Cidade cid5 = new Cidade(null, "Recife", "Pernambuco");
		cidadeRepository.save(cid5);
	
	}
}
