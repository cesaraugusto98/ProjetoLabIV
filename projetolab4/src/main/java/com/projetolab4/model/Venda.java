package com.projetolab4.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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

	@OneToOne
	@Column(name = "CLI_ID")
	private Cliente cliId;

	@OneToOne
	@Column(name = "PRO_ID")
	private Produto proId;

	@Column(name = "VEN_PRO_ID")
	private Integer vendProQtd;

	@Column(name = "FPG_ID")
	private long fpgId;

	@OneToOne
	@Column(name = "FUN_ID")
	private Funcionario funId;

	@Column(name = "VEN_DATA")
	private LocalDateTime venData;
}
