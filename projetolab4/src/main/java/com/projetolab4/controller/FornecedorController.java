package com.projetolab4.controller;

import com.projetolab4.model.Fornecedor;
import com.projetolab4.repository.FornecedorRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class FornecedorController {

    private FornecedorRepository repository;

    FornecedorController(FornecedorRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/fornecedor/add")
    Fornecedor addFornecedor(@RequestBody Fornecedor fornecedor) {
        return repository.save(fornecedor);
    }

    @GetMapping("/fornecedor/getById/{id}")
    Fornecedor getFornecedorById(@PathVariable Long id) {
        return repository.findById(id);
    }

    @GetMapping("fornecedor/deleteById/{id}")
    Boolean deleteFornecedorById(@PathVariable Long id) {
        return repository.delete(id);
    }

    @PutMapping("fornecedor/updateById/{id}")
    Fornecedor updateFornecedorById(@RequestBody Fornecedor fornecedor, @PathVariable Long id) {
        return repository.findById(id);
    }
}
