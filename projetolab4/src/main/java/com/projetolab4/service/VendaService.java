package com.projetolab4.service;

import com.projetolab4.model.*;
import com.projetolab4.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class VendaService {

    private VendaRepository vendaRepository;
    private ClienteRepository clienteRepository;
    private FormaPagamentoRepository formaPagamentoRepository;
    private FuncionarioRepository funcionarioRepository;
    private ProdutoRepository produtoRepository;


    VendaService(VendaRepository vendaRepository,
                 ClienteRepository clienteRepository,
                 FormaPagamentoRepository formaPagamentoRepository,
                 FuncionarioRepository funcionarioRepository,
                 ProdutoRepository produtoRepository) {
        this.vendaRepository = vendaRepository;
        this.clienteRepository = clienteRepository;
        this.formaPagamentoRepository = formaPagamentoRepository;
        this.funcionarioRepository = funcionarioRepository;
        this.produtoRepository = produtoRepository;
    }

    /*public void addVenda(Venda venda) {
        Cliente cl = clienteRepository.findById(venda.getCliente().getCliId());
        FormaPagamento fp = formaPagamentoRepository.findById(venda.getFormaPagamento().getFpgId());
        Funcionario fn = funcionarioRepository.findById(venda.getFuncionario().getFunId());

        venda.setCliente(cl);
        venda.setFormaPagamento(fp);
        venda.setFuncionario(fn);
        venda.setVenData(LocalDateTime.now());

        Venda vd = getProdutosObjectForItemVenda(venda);


        vendaRepository.save(vd);
    }

    public Venda getProdutosObjectForItemVenda(Venda venda) {
        int i;

        for(i = 0; i < venda.getItemVenda().size(); i++) {
            Produto pd = produtoRepository.findById(
                    venda.getItemVenda().get(i).getProduto().getProId()
            );

            System.out.println(pd);

            venda.getItemVenda().get(i).setProduto(pd);
        }

        return venda;
    }*/
}
