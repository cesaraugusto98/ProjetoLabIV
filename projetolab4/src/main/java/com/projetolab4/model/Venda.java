package com.projetolab4.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "VEN_VENDA")
public class Venda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long venId;

	@ManyToOne
	@JoinColumn(name = "CLI_ID", nullable = false)
	private Cliente cliId;

	@OneToOne
	@JoinColumn(name = "PRO_ID", nullable = false)
	private Produto proId;

	@OneToOne
	@JoinColumn(name = "FPG_ID", nullable = false)
	private FormaPagamento fpgId;

	@ManyToOne /* Muitas vendas por funcionario */
	@JoinColumn(name = "FUN_ID", nullable = false)
	private Funcionario funId;

	@Column(name = "VEN_DATA")
	private LocalDateTime venData;
}
