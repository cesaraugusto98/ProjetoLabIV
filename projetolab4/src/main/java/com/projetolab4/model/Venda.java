package com.projetolab4.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	@JoinColumn(name = "crn_id", unique = true, referencedColumnName = "crnId", nullable = false)
	private long crn_id;
	
	/*TODO CHAVE ESTRANGEIRA PARA FORMA_PAGAMENTO FPG_ID*/
	@JoinColumn(name = "fpg_id", unique = true, referencedColumnName = "fpgId", nullable = false)
	private long fpg_id;
	
	/*TODO METODO TOSTRING CONSIDERANDO AS CHAVES ESTRANGEIRAS*/
	 public String toString(long valor) {
			return Long.toString(valor);
		    }

}
