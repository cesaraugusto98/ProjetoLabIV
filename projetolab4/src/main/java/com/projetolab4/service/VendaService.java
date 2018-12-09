package com.projetolab4.service;

import com.projetolab4.model.*;
import com.projetolab4.repository.ClienteRepository;
import com.projetolab4.repository.FormaPagamentoRepository;
import com.projetolab4.repository.ProdutoRepository;
import com.projetolab4.repository.VendaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VendaService {

    private VendaRepository vendaRepository;
    private ClienteRepository clienteRepository;
    private FormaPagamentoRepository formaPagamentoRepository;
    private ProdutoRepository produtoRepository;


    VendaService(VendaRepository vendaRepository,
                 ClienteRepository clienteRepository,
                 FormaPagamentoRepository formaPagamentoRepository,
                 ProdutoRepository produtoRepository) {
        this.vendaRepository = vendaRepository;
        this.clienteRepository = clienteRepository;
        this.formaPagamentoRepository = formaPagamentoRepository;
        this.produtoRepository = produtoRepository;
    }

    public void addVenda(Venda venda) {
        Cliente cl = clienteRepository.findById(venda.getCliente().getCliId());
        FormaPagamento fp = formaPagamentoRepository.findById(venda.getFormaPagamento().getFpgId());

        venda.setCliente(cl);
        venda.setFormaPagamento(fp);

        vendaRepository.save(getProdutosObjectForItemVenda(venda));
    }

    public Venda getProdutosObjectForItemVenda(Venda venda) {
        int i = 1;


        for(i = 1; i <= venda.getItemVenda().size(); i++) {
            Produto pd = produtoRepository.findById(venda.getItemVenda().get(i).getProduto().getProId());

            System.out.println(pd);

            //venda.getItemVenda().get(i).setProduto(pd);
        }
        System.out.println(venda);
        return venda;
    }
}
