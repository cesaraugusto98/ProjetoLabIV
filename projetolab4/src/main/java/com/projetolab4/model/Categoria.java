package com.projetolab4.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.projetolab4.model.Produto;
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
