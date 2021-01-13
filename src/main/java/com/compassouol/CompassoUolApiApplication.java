package com.compassouol;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.compassouol.domain.Cliente;
import com.compassouol.repositories.ClienteRepository;

@SpringBootApplication
public class CompassoUolApiApplication implements CommandLineRunner {

	@Autowired
	private ClienteRepository clienteRepository;

	public static void main(String[] args) {
		SpringApplication.run(CompassoUolApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");

		Cliente cli1 = new Cliente(null, "Maria Carolina","feminino", sdf.parse("20/07/1993"), 27, "Paulista");
		clienteRepository.save(cli1);

	}
}
