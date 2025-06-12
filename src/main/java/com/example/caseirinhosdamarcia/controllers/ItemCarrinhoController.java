package com.example.caseirinhosdamarcia.controllers;

import com.example.caseirinhosdamarcia.dtos.ItemCarrinhoDTO;
import org.springframework.web.bind.annotation.*;
import com.example.caseirinhosdamarcia.services.ItemCarrinhoService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/itemCarrinho")
public class ItemCarrinhoController {
    private final ItemCarrinhoService itemCarrinhoService;

    public ItemCarrinhoController(ItemCarrinhoService itemCarrinhoService){
        this.itemCarrinhoService = itemCarrinhoService;
    }

    @GetMapping()
    public List<ItemCarrinhoDTO> getAllItemCarrinho() {
        return itemCarrinhoService.getAllItemCarrinho();
    }

    @GetMapping("/usuario/{id_usuario}")
    public List<ItemCarrinhoDTO> getAllItemCarrinho(@PathVariable UUID id_usuario) {
        return itemCarrinhoService.getAllItemCarrinhoPorUsuario(id_usuario);
    }

    @GetMapping("/{id}")
    public ItemCarrinhoDTO getItemCarrinhoById(@PathVariable UUID id) {
        return itemCarrinhoService.getItemCarrinhoById(id);
    }

    @PostMapping
    public ItemCarrinhoDTO createItemCarrinho(@RequestBody ItemCarrinhoDTO itemCarrinhoDTO) {
        return itemCarrinhoService.createItemCarrinho(itemCarrinhoDTO);
    }

    @PutMapping("/{id}")
    public ItemCarrinhoDTO updateItemCarrinho(@PathVariable UUID id, @RequestBody ItemCarrinhoDTO itemCarrinhoDTO){
        return itemCarrinhoService.updateItemCarrinho(id, itemCarrinhoDTO);
    }

    @DeleteMapping("/{id}")
    public ItemCarrinhoDTO deleteItemCarrinho(@PathVariable UUID id) {
        return itemCarrinhoService.deleteItemCarrinho(id);
    }
}

