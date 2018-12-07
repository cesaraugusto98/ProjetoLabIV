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

	@OneToMany
	@JoinColumn(name = "CLI_ID", nullable = false)
	private List<Cliente> cliId;

	@OneToOne
	@JoinColumn(name = "PRO_ID", nullable = false)
	private Produto proId;

	@OneToMany(mappedBy = "itvId", fetch = FetchType.LAZY)
	@JoinColumn(name = "itvId", nullable = false)
	private List<ItemVenda> itemVenda;

	@OneToOne
	@JoinColumn(name = "FPG_ID", nullable = false)
	private long fpgId;

	@ManyToOne /* Muitas vendas por funcionario */
	@JoinColumn(name = "FUN_ID", nullable = false)
	private Funcionario funId;

	@Column(name = "VEN_DATA")
	private LocalDateTime venData;
}
