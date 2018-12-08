package com.projetolab4.services;

import com.projetolab4.model.Endereco;
import com.projetolab4.model.Fornecedor;
import com.projetolab4.repositories.EnderecoRepository;
import com.projetolab4.repositories.FornecedorRepository;

@org.springframework.stereotype.Service
public class FornecedorService implements Service<Fornecedor, Endereco> {

    private final FornecedorRepository fornecedorRepository;
    private final EnderecoRepository enderecoRepository;

    FornecedorService(FornecedorRepository fornecedor, EnderecoRepository endereco) {
        this.fornecedorRepository = fornecedor;
        this.enderecoRepository = endereco;
    }

    @Override
    public Fornecedor save(Fornecedor fornecedor, Endereco endereco) {
        Endereco end = enderecoRepository.save(endereco);
        fornecedor.setEndereco(end);
        Long forId = fornecedorRepository.save(fornecedor).getForId();

        return fornecedorRepository.getOne(forId);
    }
}
