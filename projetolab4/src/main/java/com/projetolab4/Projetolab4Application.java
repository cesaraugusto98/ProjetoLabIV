package com.projetolab4;

import com.projetolab4.model.Endereco;
import com.projetolab4.model.Fornecedor;
import com.projetolab4.repositories.EnderecoRepository;
import com.projetolab4.repositories.FornecedorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Projetolab4Application implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	FornecedorRepository repository2;

	@Autowired
	EnderecoRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Projetolab4Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repository.getOne(1L);

		logger.info("Endereco: id 1 -> {}", repository.findById(1L));

		//logger.info("Endereco persist: {}", repositories.save(new Endereco(null, "123", "dshauhf")));

		Endereco end = repository.save(new Endereco(null, "123", "dshauhf"));

		//logger.info("Address: -> {}", repositories.getOne(end.getEndId()));

		logger.info("Fornecedor persist: {}", repository2.save(new Fornecedor(null, end,
				"123", "(12)89898989", "Carrega macaco LTDA")));
	}
}
