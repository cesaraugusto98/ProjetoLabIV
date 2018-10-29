package com.projetolab4.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "FPG_FORMA_PAGAMENTO")
public class FormaPagamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long fpgId;
	
	@Size(max = 40)
	@Column(name="FPG_FORMA_PAGAMENTO", nullable = false)
	private String fpgFormaPagamento;
	
	@Column(name="FPG_DESCONTO_PAGAMENTO", nullable = false)
	private Double fpgDescontoPagamento;
	
	@Override
	public String toString() {
		return String.format("FormaPagamento[id=%d, fpgFormaPagamento='%s', fpgDescontoPagamento='%d']", getFpgId(), getFpgFormaPagamento(), getFpgDescontoPagamento());
	}

}
