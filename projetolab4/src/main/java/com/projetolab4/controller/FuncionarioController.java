package com.projetolab4.controller;

import com.projetolab4.model.Funcionario;
import com.projetolab4.repository.FuncionarioRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class FuncionarioController {

    private FuncionarioRepository repository;

    FuncionarioController(FuncionarioRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/funcionario/add")
    Funcionario addFuncionario(@RequestBody Funcionario funcionario) {
        return repository.save(funcionario);
    }

    @GetMapping("/funcionario/getById/{id}")
    Funcionario getFuncionarioById(@PathVariable Long id) {
        return repository.findById(id);
    }

    @GetMapping("/funcionario/deleteById/{id}")
    Boolean deleteFuncionarioById(@PathVariable Long id) {
        return repository.delete(id);
    }

    @PutMapping("/funcionario/updateById/{id}")
    Funcionario updateFuncionarioById(@RequestBody Funcionario funcionario, @PathVariable Long id) {
        return repository.findById(id);
    }
}
