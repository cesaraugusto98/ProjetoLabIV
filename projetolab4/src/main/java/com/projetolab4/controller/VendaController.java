package com.projetolab4.controller;

import com.projetolab4.service.VendaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projetolab4.model.Venda;
import com.projetolab4.repository.VendaRepository;

@RestController
public class VendaController {

	private VendaRepository repository;
	private VendaService service;

    VendaController (VendaRepository repository, VendaService service) {
        this.repository = repository;
        this.service = service;
    }

    @PostMapping("/venda/add")
    void addFornecedor(@RequestBody Venda venda) {
        service.addVenda(venda);
    }

    @GetMapping("/venda/getById/{id}")
    Venda getVendaById(@PathVariable Long id) {
        return repository.findById(id);
    }

    @GetMapping("/venda/deleteById/{id}")
    Boolean deleteVendaById(@PathVariable Long id) {
        return repository.delete(id);
    }

    @PutMapping("/venda/updateById/{id}")
    Venda updateVendaById(@RequestBody Venda venda, @PathVariable Long id) {
        return repository.findById(id);
    }
	
}
