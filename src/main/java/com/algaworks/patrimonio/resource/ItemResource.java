package com.algaworks.patrimonio.resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.algaworks.patrimonio.model.Item;
import com.algaworks.patrimonio.repository.ItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * ItemResource
 */
@RestController
@CrossOrigin("${origem-permitida}")
public class ItemResource {

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/items")
    public List<Item> listar() {
        return itemRepository.findAll();
    }

    @PostMapping("/items")
    public Item adicionar(@RequestBody @Valid Item item) {
        return itemRepository.save(item);
    }
}