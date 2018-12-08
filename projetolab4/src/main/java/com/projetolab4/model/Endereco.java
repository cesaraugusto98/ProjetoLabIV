package com.projetolab4.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "END_ENDERECO")
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator="native")
	@GenericGenerator(name = "native", strategy="native")
	private Long endId;

	@Size(max = 8)
	@Column(name="END_CEP", nullable = false)
	private String endCep;
	
	@Size(max = 50)
	@Column(name="END_COMPLEMENTO", nullable = false)
	private String endComplemento;
}
