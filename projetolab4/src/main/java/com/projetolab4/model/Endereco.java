package com.projetolab4.model;

import javax.persistence.*;
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
@Table(name = "END_ENDERECO")
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long endId;

	@Size(max = 8)
	@Column(name="END_CEP", nullable = false)
	private String endCep;
	
	@Size(max = 50)
	@Column(name="END_COMPLEMENTO", nullable = false)
	private String endComplemento;

	@Override
	public String toString() {
		return String.format("Endereco[id=%d, endCep='%s', endComplemento='%s']", getEndId(), getEndCep(), getEndComplemento());
	}	

}
