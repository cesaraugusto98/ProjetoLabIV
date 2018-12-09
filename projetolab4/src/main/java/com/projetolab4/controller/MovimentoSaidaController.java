package com.projetolab4.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projetolab4.model.MovimentoSaida;
import com.projetolab4.repository.MovimentoSaidaRepository;

@RestController
public class MovimentoSaidaController {

	 private MovimentoSaidaRepository repository;

	 MovimentoSaidaController(MovimentoSaidaRepository repository) {
	        this.repository = repository;
	    }

	    @PostMapping("/movimentosaida/add")
	    MovimentoSaida addMovimentoSaida(@RequestBody MovimentoSaida mvSaida) {
	        return repository.save(mvSaida);
	    }

	    @GetMapping("/movimentosaida/getById/{id}")
	    MovimentoSaida getMovimentoSaidaById(@PathVariable Long id) {
	        return repository.findById(id);
	    }

	    @GetMapping("movimentosaida/deleteById/{id}")
	    Boolean deleteMovimentoSaidaById(@PathVariable Long id) {
	        return repository.delete(id);
	    }

	    @PutMapping("movimentosaida/updateById/{id}")
	    MovimentoSaida updateMovimentoSaidaById(@RequestBody MovimentoSaida mvSaida, @PathVariable Long id) {
	        return repository.findById(id);
	    }
	
}
