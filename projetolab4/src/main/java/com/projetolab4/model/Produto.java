package com.projetolab4.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "PRO_PRODUTO")
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long proId;
	
	@Size(max = 50)
	@Column(name="PRO_NOME", nullable = false)
	private String proNome;
	
	@Column(name="PRO_PRECO", nullable = false)
	private Double proPreco;
	
	@Column(name="PRO_CUSTO", nullable = false)
	private Double proCusto;
	
	/*TODO CHAVE ESTRANGEIRA PARA CATEGORIA - CAT_ID*/
	@JoinColumn(name = "cat_id", unique = true, referencedColumnName = "catId", nullable = false)
	private long cat_id;
	
	
	/*TODO CHAVE ESTRANGEIRA PARA ESTOQUE - EST_ID*/
	@JoinColumn(name = "est_id", unique = true, referencedColumnName = "estId", nullable = false)
	private long est_id;
	
	/*TODO METODO TOSTRING CONSIDERANDO A CHAVE ESTRANGEIRA*/
	public String toString(long valor) {
		return Long.toString(valor);
	    }
	

}
