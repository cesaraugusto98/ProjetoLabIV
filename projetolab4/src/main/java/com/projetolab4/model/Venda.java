package com.projetolab4.model;

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
@Table(name = "VEN_VENDA")
public class Venda {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long venId;
	
	/*TODO CHAVE ESTRANGEIRA PARA CARRINHO CRN_ID*/
	
	/*TODO CHAVE ESTRANGEIRA PARA FORMA_PAGAMENTO FPG_ID*/
	
	/*TODO METODO TOSTRING CONSIDERANDO AS CHAVES ESTRANGEIRAS*/

}
