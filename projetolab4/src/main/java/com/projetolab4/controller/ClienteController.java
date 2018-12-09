package com.projetolab4.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projetolab4.model.Cliente;
import com.projetolab4.repository.ClienteRepository;

@RestController
public class ClienteController {
	
	 private ClienteRepository repository;

	    ClienteController(ClienteRepository repository) {
	        this.repository = repository;
	    }

	    @PostMapping("/cliente/add")
	    Cliente addFornecedor(@RequestBody Cliente cliente) {
	        return repository.save(cliente);
	    }

	    @GetMapping("/cliente/getById/{id}")
	    Cliente getClienteById(@PathVariable Long id) {
	        return repository.findById(id);
	    }

	    @GetMapping("/cliente/deleteById/{id}")
	    Boolean deleteClienteById(@PathVariable Long id) {
	        return repository.delete(id);
	    }

	    @PutMapping("/cliente/updateById/{id}")
	    Cliente updateClienteById(@RequestBody Cliente cliente, @PathVariable Long id) {
	        return repository.findById(id);
	    }
}
