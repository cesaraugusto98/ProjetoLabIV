package com.projetolab4.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PRO_PRODUTO")
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long proId;
	
	@Size(max = 50)
	@Column(name = "PRO_NOME", nullable = false)
	private String proNome;
	
	@Column(name = "PRO_PRECO", nullable = false)
	private Double proPreco;
	
	@Column(name = "PRO_CUSTO", nullable = false)
	private Double proCusto;

	@OneToOne
	@JoinColumn(name = "FOR_ID", nullable = false)
	private Fornecedor forId;

	@ManyToOne /* Muitos produtos por categoria */
	@JoinColumn(name = "CAT_ID", nullable = false)
	private Categoria catId;

	@ManyToOne /* Muitos produtos pra um estoque */
	@JoinColumn(name = "EST_ID", nullable = false)
	private Estoque estId;

}
