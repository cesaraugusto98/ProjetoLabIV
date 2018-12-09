package com.projetolab4.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.Collection;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "FUN_FUNCIONARIO")
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator="native")
	@GenericGenerator(name = "native", strategy="native")
	private Long funId;
	
	@Size(max = 50)
	@Column(name="FUN_NOME", nullable = false)
	private String funNome;
	
	@Size(max = 20)
	@Column(name="FUN_CPF", nullable = false)
	private String funCpf;
	
	@Size(max = 30)
	@Column(name="FUN_LOGIN", nullable = false)
	private String funLogin;
	
	@Size(max = 12)
	@Column(name="FUN_SENHA", nullable = false)
	private String funSenha;
	
	@Size(max = 12)
	@Column(name="FUN_CONTATO", nullable = false)
	private String funContato;
	
	@Column(name="FUN_SALARIO", nullable = false)
	private Double funSalario;
	
	@Size(max = 40)
	@Column(name="FUN_CARGO", nullable = false)
	private String funCargo;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "END_ID")
	private Endereco endereco;

	//@OneToMany(mappedBy = "funcionario")
	//private List<Venda> vendas;
}
