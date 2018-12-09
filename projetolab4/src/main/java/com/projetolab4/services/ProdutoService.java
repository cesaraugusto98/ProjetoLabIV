package com.projetolab4.services;

import com.projetolab4.model.*;
import com.projetolab4.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ProdutoService {

    private ProdutoRepository repository;
    private FornecedorRepository fornecedorRepository;
    private CategoriaRepository categoriaRepository;
    private EstoqueRepository estoqueRepository;
    private MovimentoEntradaRepository movimentoEntradaRepository;

    ProdutoService(ProdutoRepository repository,
                   FornecedorRepository fornecedorRepository,
                   CategoriaRepository categoriaRepository,
                   EstoqueRepository estoqueRepository,
                   MovimentoEntradaRepository movimentoEntradaRepository) {
        this.repository = repository;
        this.fornecedorRepository = fornecedorRepository;
        this.categoriaRepository = categoriaRepository;
        this.estoqueRepository = estoqueRepository;
        this.movimentoEntradaRepository = movimentoEntradaRepository;
    }

    public void saveProduto(Produto produto, Integer metQtd, String metDescricao) {
        Fornecedor fn = fornecedorRepository.findById(produto.getFornecedor().getForId());
        Categoria ct = categoriaRepository.findById(produto.getCategoria().getCatId());
        Estoque et = estoqueRepository.findById(produto.getEstoque().getEstId());

        produto.setFornecedor(fn);
        produto.setCategoria(ct);
        produto.setEstoque(et);

        Produto pd = repository.save(produto);

        MovimentoEntrada me = MovimentoEntrada.builder()
                .fornecedor(fn)
                .produto(pd)
                .metQtd(metQtd)
                .metData(LocalDateTime.now())
                .metDescricao(metDescricao)
                .build();

        System.out.println(addMovimento(me));
    }

    public MovimentoEntrada addMovimento(MovimentoEntrada me) {
        return movimentoEntradaRepository.save(me);
    }
}
