package com.projetolab4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Projetolab4Application {
//implements CommandLineRunner
	//private Logger logger = LoggerFactory.getLogger(this.getClass());

	//@Autowired
	//FornecedorRepository repository2;

	//@Autowired
	//EnderecoRepository JpaRepository;

	public static void main(String[] args) {
		SpringApplication.run(Projetolab4Application.class, args);
	}

	/*@Override
	public void run(String... args) throws Exception {
		JpaRepository.findById(1L);

		logger.info("Endereco: id 1 -> {}", JpaRepository.findById(1L));

		//logger.info("Endereco persist: {}", repository.save(new Endereco(null, "123", "dshauhf")));

		Endereco end = JpaRepository.save(new Endereco(null, "123", "dshauhf"));

		//logger.info("Address: -> {}", repository.getOne(end.getEndId()));

		logger.info("Fornecedor persist: {}", repository2.save(new Fornecedor(null, end,
				"123", "(12)89898989", "Carrega macaco LTDA")));
	}*/
}
