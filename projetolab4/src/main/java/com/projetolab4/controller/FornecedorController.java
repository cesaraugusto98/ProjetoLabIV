package com.projetolab4.controller;

import com.projetolab4.model.Endereco;
import com.projetolab4.model.Fornecedor;
import com.projetolab4.services.FornecedorService;
import org.springframework.web.bind.annotation.*;

@RestController
public class FornecedorController {

    private FornecedorService fornecedorService;

    FornecedorController(FornecedorService fornecedor) {
        this.fornecedorService = fornecedor;
    }

    @PostMapping("/fornecedor")
    Fornecedor newFornecedor(@RequestBody Fornecedor newFornecedor) {
        Endereco end = newFornecedor.getEndereco();

        return fornecedorService.save(newFornecedor, end);
    }
}
