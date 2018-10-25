package com.projetolab4.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "FUN_FUNCIONARIO")
public class Funcionario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	/*TODO CHAVE ESTRANGEIRA PARA ENDERECO END_ID*/
	
	@Size(max = 12)
	@Column(name="FUN_CONTATO", nullable = false)
	private String funContato;
	
	@Column(name="FUN_SALARIO", nullable = false)
	private Double funSalario;
	
	@Size(max = 40)
	@Column(name="FUN_CARGO", nullable = false)
	private String funCargo;
	
	/*TODO METODO TOSTRING CONSIDERANDO A CHAVE ESTRANGEIRA DE ENDERECO*/
	

}
