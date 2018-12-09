package com.projetolab4.services;

import com.projetolab4.model.Produto;
import com.projetolab4.repository.FornecedorRepository;
import com.projetolab4.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    private ProdutoRepository repository;
    private FornecedorRepository fornecedorRepository;
    private ProdutoRepository produtoRepository;
    //private EstoqueRepository estoqueRepository;

    ProdutoService(ProdutoRepository repository, FornecedorRepository fornecedorRepository) {
        this.repository = repository;
        this.fornecedorRepository = fornecedorRepository;
    }

    public Produto saveProduto(Produto produto) {
        produto.setFornecedor(fornecedorRepository.findById(produto.getFornecedor().getForId()));
        return repository.save(produto);
    }
}
