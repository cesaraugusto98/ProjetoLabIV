package com.projetolab4.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "FOR_FORNECEDOR")
public class Fornecedor implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator="native")
	@GenericGenerator(name = "native", strategy="native")
	private Long forId;
	
	@Size(max = 16)
	@Column(name="FOR_CNPJ", nullable = false)
	private String forCnpj;
	
	@Size(max = 12)
	@Column(name="FOR_CONTATO", nullable = false)
	private String forContato;
	
	@Size(max = 50)
	@Column(name="FOR_NOME_FANTASIA", nullable = false)
	private String forNomeFantasia;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "END_ID")
	private Endereco endereco;
}
