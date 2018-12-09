package com.projetolab4.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

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
	private Cliente cliente;

	@OneToMany(mappedBy = "venda", cascade = CascadeType.PERSIST)
	private List<ItemVenda> itemVenda;

	@OneToOne
	@JoinColumn(name = "FPG_ID", nullable = false)
	private FormaPagamento formaPagamento;

	@ManyToOne /* Muitas vendas por funcionario */
	private Funcionario funcionario;

	@Column(name = "VEN_DATA")
	private LocalDateTime venData;
}
