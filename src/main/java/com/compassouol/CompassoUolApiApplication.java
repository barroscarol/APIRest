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

		Cliente cli1 = new Cliente(null, "Maria Carolina","feminino", sdf.parse("20/07/1993"), 27, "Paulista");
		clienteRepository.save(cli1);
		
		Cliente cli2 = new Cliente(null, "João Paulo","masculino", sdf.parse("20/07/1990"), 25, "Olinda");
		clienteRepository.save(cli2);
		
		Cliente clie = new Cliente(null, "Maria ","feminino", sdf.parse("20/07/1991"), 27, "Paulista");
		clienteRepository.save(clie);
		
		Cidade cid1 = new Cidade(null, "Recife", "Pernambuco");
		cidadeRepository.save(cid1);
		
		Cidade cid2 = new Cidade(null, "São Paulo", "São Paulo");
		cidadeRepository.save(cid2);
	}
}
