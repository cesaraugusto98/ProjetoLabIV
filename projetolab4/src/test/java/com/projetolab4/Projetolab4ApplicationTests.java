package com.projetolab4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
//import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.projetolab4.model.Categoria;
import com.projetolab4.repository.CategoriaRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Projetolab4ApplicationTests {
	
	CategoriaRepository repCategoria;
	Categoria categoria_Obj = new Categoria(null, "Teste");
	
	@Test
	public void Save_Categoria() {
		assertEquals(categoria_Obj, repCategoria.save(categoria_Obj));
		
	}
	

}
