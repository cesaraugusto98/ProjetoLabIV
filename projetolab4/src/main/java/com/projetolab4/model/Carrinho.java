package com.projetolab4.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CRN_CARRINHO")
public class Carrinho {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long crnId;
	
	/*TODO CHAVE ESTRANGEIRA PARA PRODUTO - PRO_ID*/
	
	@Column(name="PRO_QTD", nullable = false)
	private String proQtd;
	
	/*TODO CHAVE ESTRANGEIRA PARA CLIENTE - CLI_ID*/
	
	/*TODO CHAVE ESTRANGEIRA PARA VENDA - VEN_ID*/
	
	/*TODO METODO TOSTRING CONSIDERANDO AS CHAVES ESTRANGEIRAS*/


}
