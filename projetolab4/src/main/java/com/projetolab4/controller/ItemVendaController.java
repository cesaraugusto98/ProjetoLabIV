package com.projetolab4.controller;

import org.springframework.web.bind.annotation.*;

import com.projetolab4.model.ItemVenda;
import com.projetolab4.repository.ItemVendaRepository;

@RestController
public class ItemVendaController {
	
	private ItemVendaRepository repository;
	
	ItemVendaController(ItemVendaRepository repository) {
        this.repository = repository;
    }
	
	@PostMapping("/itemvenda/add")
    ItemVenda addItemVenda(@RequestBody ItemVenda itvd) {
        return repository.save(itvd);
    }

    @GetMapping("/itemvenda/getById/{id}")
    ItemVenda getItemVendaById(@PathVariable Long id) {
        return repository.findById(id);
    }

    @GetMapping("/itemvenda/deleteById/{id}")
    Boolean deleteItemVendaById(@PathVariable Long id) {
        return repository.delete(id);
    }

    @PutMapping("/itemvenda/updateById/{id}")
    ItemVenda updateItemVendaById(@RequestBody ItemVenda itvd, @PathVariable Long id) {
        return repository.findById(id);
    }

}
