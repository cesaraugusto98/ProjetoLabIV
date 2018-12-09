package com.projetolab4.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projetolab4.model.Produto;
import com.projetolab4.repository.ProdutoRepository;

@RestController
public class ProdutoController {
	
	 private ProdutoRepository repository;

	    ProdutoController(ProdutoRepository repository) {
	        this.repository = repository;
	    }

	    @PostMapping("/produto/add")
	    Produto addProduto(@RequestBody Produto produto) {
	        return repository.save(produto);
	    }

	    @GetMapping("/produto/getById/{id}")
	    Produto getProdutoById(@PathVariable Long id) {
	        return repository.findById(id);
	    }

	    @GetMapping("produto/deleteById/{id}")
	    Boolean deleteProdutoById(@PathVariable Long id) {
	        return repository.delete(id);
	    }

	    @PutMapping("produto/updateById/{id}")
	    Produto updateProdutoById(@RequestBody Produto produto, @PathVariable Long id) {
	        return repository.findById(id);
	    }
}
