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
@Table(name = "CAT_CATEGORIA")
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long catId;
	
	@Size(max = 30)
	@Column(name="CAT_NOME", nullable = false)
	private String catNome;
	
	@Override
	public String toString() {
		return String.format("Categoria[id=%d, catNome='%s']", getCatId(), getCatNome());
	}

}
