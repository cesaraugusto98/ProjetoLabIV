package com.projetolab4.controller;

import com.projetolab4.model.Fornecedor;
import com.projetolab4.repository.FornecedorDao;
import org.springframework.web.bind.annotation.*;

@RestController
public class FornecedorController {

    private final FornecedorDao repository;

    FornecedorController(FornecedorDao fornecedor) {
        this.repository = fornecedor;
    }

    @PostMapping("/fornecedor")
    Fornecedor newFornecedor(@RequestBody Fornecedor newFornecedor) {
        return repository.save(newFornecedor);
    }

    @GetMapping("/fornecedor/{id}")
    Fornecedor getFornecedor(@PathVariable Long id) {
        return repository.findById(id);
    }
}
