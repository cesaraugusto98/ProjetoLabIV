package com.projetolab4.controller;


import org.springframework.web.bind.annotation.*;

import com.projetolab4.model.Funcionario;
import com.projetolab4.repository.FuncionarioDao;

@RestController
public class FuncionarioController {

    private FuncionarioDao repository;

    void FuncioanrioController(FuncionarioDao funcionario) {
        this.repository = funcionario;
    }

    @PostMapping("/funcioanrio")
    Funcionario newFuncionario(@RequestBody Funcionario newFuncionario) {
        return repository.save(newFuncionario);
    }

    @GetMapping("/funcionario/{id}")
    Funcionario getFuncionario(@PathVariable Long id) {
        return repository.findById(id);
    }
}
