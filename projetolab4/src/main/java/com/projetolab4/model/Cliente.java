package com.projetolab4.model;

import javax.persistence.*;
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

	@OneToOne
	@JoinColumn(name = "END_ID", nullable = false)
	private Endereco endId;

	@Size(max = 12)
	@Column(name="CLI_CONTATO", nullable = false)
	private String cliContato;


}
