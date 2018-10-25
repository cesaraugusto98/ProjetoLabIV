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
@Table(name = "CLI_CLIENTE")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cliId;
	
	@Size(max = 50)
	@Column(name="CLI_NOME", nullable = false)
	private String cliNome;
	
	@Size(max = 20)
	@Column(name="CLI_CPF", nullable = false)
	private String cliCpf;
	
	@Size(max = 30)
	@Column(name="CLI_LOGIN", nullable = false)
	private String cliLogin;
	
	@Size(max = 12)
	@Column(name="CLI_SENHA", nullable = false)
	private String cliSenha;
	
	/*TODO CHAVE ESTRANGEIRA PARA ENDERECO*/
	
	@Size(max = 12)
	@Column(name="CLI_CONTATO", nullable = false)
	private String cliContato;
	
	/*TODO METODO TO STRING COM O ENDERECO CONFIGURADO*/

}
