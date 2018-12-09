package com.projetolab4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
//import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.projetolab4.model.Categoria;
import com.projetolab4.model.Cliente;
import com.projetolab4.model.Endereco;
import com.projetolab4.model.Estoque;
import com.projetolab4.model.FormaPagamento;
import com.projetolab4.model.Fornecedor;
import com.projetolab4.model.Funcionario;
import com.projetolab4.model.ItemVenda;
import com.projetolab4.model.MovimentoEntrada;
import com.projetolab4.model.MovimentoSaida;
import com.projetolab4.model.Produto;
import com.projetolab4.model.Venda;
import com.projetolab4.repository.CategoriaRepository;
import com.projetolab4.repository.ClienteRepository;
import com.projetolab4.repository.EnderecoRepository;
import com.projetolab4.repository.EstoqueRepository;
import com.projetolab4.repository.FornecedorRepository;
import com.projetolab4.repository.FuncionarioRepository;
import com.projetolab4.repository.ItemVendaRepository;
import com.projetolab4.repository.MovimentoEntradaRepository;
import com.projetolab4.repository.MovimentoSaidaRepository;
import com.projetolab4.repository.ProdutoRepository;
import com.projetolab4.repository.VendaRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Projetolab4ApplicationTests {

    CategoriaRepository categoriaRepository;

    Projetolab4ApplicationTests(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }
	
	EstoqueRepository est_repository;
	Estoque estoque_Obj = new Estoque(null, 10L, "EstoqueTeste_1");
	
	CategoriaRepository rep_reposiroty;
	Categoria categoria_Obj = new Categoria(4L, "Teste");
	
	EnderecoRepository end_repository;
	Endereco endereco_Obj = new Endereco(null, "111", "Vantuiude Jose Brandao") ;
	
	ClienteRepository cli_repository;
	Cliente cliente_Obj = new Cliente(null,"TesteNome","111CPF","222CONTATO", endereco_Obj);
	
	FornecedorRepository for_repository;
	Fornecedor fornecedor_Obj = new Fornecedor(null,"111CNPJ","Contato_teste","Nome_Fantasia_Teste", endereco_Obj);
	
	ProdutoRepository pro_repository;
	Produto produto_Obj = new Produto(null,"TesteProdutoNome", 10D,20D,fornecedor_Obj,categoria_Obj,estoque_Obj, null );
	
	FuncionarioRepository fun_repository;
	Funcionario funcionario_Obj = new Funcionario(null,"NomeTesteFuncionario", "111CPF", "222LoginTeste", "333SenhaTeste","ContatoFuncionarioTeste",2000D,"GerenteTeste",endereco_Obj);
	
	VendaRepository ven_repository;
	Venda venda_Obj = new Venda(null, cliente_Obj ,produto_Obj , new FormaPagamento(),funcionario_Obj, LocalDateTime.of(1, 1, 1, 1, 1) );
	
	ItemVendaRepository itv_repository;
	ItemVenda itemvenda_Obj = new ItemVenda(null,  produto_Obj, venda_Obj, 10 );
	
	MovimentoEntradaRepository mve_repository;
	MovimentoEntrada movimentoEntrada_Obj = new MovimentoEntrada(null, fornecedor_Obj, produto_Obj, 10, LocalDateTime.of(1, 1, 1, 1, 1), "TesteDescricao");
	
	MovimentoSaidaRepository mvs_repository;
	MovimentoSaida movimentoSaida_Obj = new MovimentoSaida(null, venda_Obj, LocalDateTime.of(1, 1, 1, 1, 1), "TesteDescricaoEntrada");
	
	@Test
	public void Save_Categoria() {
		assertEquals(categoria_Obj, rep_reposiroty.save(categoria_Obj));
	}
	
	@Test
	public void Save_Cliente() {
		assertEquals(cliente_Obj, cli_repository.save(cliente_Obj));
	}
	
	@Test
	public void Save_Endereco() {
		assertEquals(endereco_Obj, end_repository.save(endereco_Obj));
	}
	
	@Test
	public void Save_Estoque() {
		assertEquals(estoque_Obj, est_repository.save(estoque_Obj));
	}
	
	@Test
	public void Save_Fornecedor() {
		assertEquals(fornecedor_Obj, for_repository.save(fornecedor_Obj));
	}
	
	@Test
	public void Save_Funcionario() {
		assertEquals(funcionario_Obj, fun_repository.save(funcionario_Obj));
	}
	
	@Test
	public void Save_ItemVenda() {
		assertEquals(itemvenda_Obj, itv_repository.save(itemvenda_Obj));
	}
	
	@Test
	public void Save_MovimentoEntrada() {
		assertEquals(movimentoEntrada_Obj, mve_repository.save(movimentoEntrada_Obj));
	}
	
	@Test
	public void Save_MovimentoSaida() {
		assertEquals(movimentoSaida_Obj, mvs_repository.save(movimentoSaida_Obj));
	}
	
	@Test
	public void Save_Produto() {
		assertEquals(produto_Obj, pro_repository.save(produto_Obj));
	}
	
	@Test
	public void Save_Venda() {
		assertEquals(venda_Obj, ven_repository.save(venda_Obj));
	}
	
	@Test
	public void Delete_Categoria() {
		assertEquals(true, rep_reposiroty.delete(categoria_Obj.getCatId()));
	}
	
	@Test
	public void Delete_Cliente() {
		assertEquals(true, cli_repository.delete(cliente_Obj.getCliId()));
	}
	
	@Test
	public void Delete_Endereco() {
		assertEquals(true, end_repository.delete(endereco_Obj.getEndId()));
	}
	
	@Test
	public void Delete_Estoque() {
		assertEquals(true, est_repository.delete(estoque_Obj.getEstId()));
	}
	
	@Test
	public void Delete_Fornecedor() {
		assertEquals(true, for_repository.delete(fornecedor_Obj.getForId()));
	}
	
	@Test
	public void Delete_Funcionario() {
		assertEquals(true, fun_repository.delete(funcionario_Obj.getFunId()));
	}
	
	@Test
	public void Delete_ItemVenda() {
		assertEquals(true, itv_repository.delete(itemvenda_Obj.getItvId()));
	}
	
	@Test
	public void Delete_MovimentoEntrada() {
		assertEquals(true, mve_repository.delete(movimentoEntrada_Obj.getMetId()));
	}
	
	@Test
	public void Delete_MovimentoSaida() {
		assertEquals(true, mvs_repository.delete(movimentoSaida_Obj.getMesId()));
	}
	
	@Test
	public void Delete_Produto() {
		assertEquals(true, pro_repository.delete(produto_Obj.getProId()));
	}
	
	@Test
	public void Delete_Venda() {
		assertEquals(true, ven_repository.delete(venda_Obj.getVenId()));
	}
	
	@Test
	public void Update_Categoria() {
		assertEquals(true, rep_reposiroty.update(categoria_Obj));
	}
	
	@Test
	public void Update_Cliente() {
		assertEquals(true, cli_repository.update(cliente_Obj));
	}
	
	@Test
	public void Update_Endereco() {
		assertEquals(true, end_repository.update(endereco_Obj));
	}
	
	@Test
	public void Update_Estoque() {
		assertEquals(true, est_repository.update(estoque_Obj));
	}
	
	@Test
	public void Update_Fornecedor() {
		assertEquals(true, for_repository.update(fornecedor_Obj));
	}
	
	@Test
	public void Update_Funcionario() {
		assertEquals(true, fun_repository.update(funcionario_Obj));
	}
	
	@Test
	public void Update_ItemVenda() {
		assertEquals(true, itv_repository.update(itemvenda_Obj));
	}
	
	@Test
	public void Update_MovimentoEntrada() {
		assertEquals(true, mve_repository.update(movimentoEntrada_Obj));
	}
	
	@Test
	public void Update_MovimentoSaida() {
		assertEquals(true, mvs_repository.update(movimentoSaida_Obj));
	}
	
	@Test
	public void Update_Produto() {
		assertEquals(true, pro_repository.update(produto_Obj));
	}
	
	@Test
	public void Update_Venda() {
		assertEquals(true, ven_repository.update(venda_Obj));
	}
	
	@Test
	public void FindById_Categoria() {
		assertEquals(categoria_Obj, rep_reposiroty.findById(1L));
	}
	
	@Test
	public void FindById_Cliente() {
		assertEquals(cliente_Obj, cli_repository.findById(1L));
	}
	
	@Test
	public void FindById_Endereco() {
		assertEquals(endereco_Obj, end_repository.findById(1L));
	}
	
	@Test
	public void FindById_Estoque() {
		assertEquals(estoque_Obj, est_repository.findById(1L));
	}
	
	@Test
	public void FindById_Fornecedor() {
		assertEquals(fornecedor_Obj, for_repository.findById(1L));
	}
	
	@Test
	public void FindById_Funcionario() {
		assertEquals(funcionario_Obj, fun_repository.findById(1L));
	}
	
	public void FindById_ItemVenda() {
		assertEquals(itemvenda_Obj, itv_repository.findById(1L));
	}
	
	@Test
	public void FindById_MovimentoEntrada() {
		assertEquals(movimentoEntrada_Obj, mve_repository.findById(1L));
	}
	
	@Test
	public void FindById_MovimentoSaida() {
		assertEquals(movimentoSaida_Obj, mvs_repository.findById(1L));
	}
	
	@Test
	public void FindById_Produto() {
		assertEquals(produto_Obj, pro_repository.findById(1L));
	}
	
	@Test
	public void FindById_Venda() {
		assertEquals(venda_Obj, ven_repository.findById(1L));
	}
	
}
