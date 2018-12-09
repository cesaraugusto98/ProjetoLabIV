package com.projetolab4.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.projetolab4.model.MovimentoEntrada;
import com.projetolab4.repository.MovimentoEntradaRepository;

public class MovimentoEntradaController {

	private MovimentoEntradaRepository repository;
	
	MovimentoEntradaController(MovimentoEntradaRepository repository) {
	        this.repository = repository;
	    }

	    @PostMapping("/movimentoentrada/add")
	    MovimentoEntrada addMovimentoEntrada(@RequestBody MovimentoEntrada movEntrada) {
	        return repository.save(movEntrada);
	    }

	    @GetMapping("/movimentoentrada/getById/{id}")
	    MovimentoEntrada getMovimentoEntradaById(@PathVariable Long id) {
	        return repository.findById(id);
	    }

	    @GetMapping("movimentoentrada/deleteById/{id}")
	    Boolean deleteMovimentoEntradaById(@PathVariable Long id) {
	        return repository.delete(id);
	    }

	    @PutMapping("movimentoentrada/updateById/{id}")
	    MovimentoEntrada updateMovimentoEntradaById(@RequestBody MovimentoEntrada movEntrada, @PathVariable Long id) {
	        return repository.findById(id);
	    }
}
