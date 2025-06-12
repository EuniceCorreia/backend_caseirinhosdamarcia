package com.example.caseirinhosdamarcia.services;

import com.example.caseirinhosdamarcia.dtos.ItemCarrinhoDTO;
import com.example.caseirinhosdamarcia.entities.ItemCarrinho;
import com.example.caseirinhosdamarcia.mappers.ItemCarrinhoMapper;
import org.springframework.stereotype.Service;
import com.example.caseirinhosdamarcia.repositories.ItemCarrinhoRepository;

import java.util.List;
import java.util.UUID;

@Service
public class ItemCarrinhoService {
    private final ItemCarrinhoMapper itemCarrinhoMapper;
    private final ItemCarrinhoRepository itemCarrinhoRepository;

    public ItemCarrinhoService(ItemCarrinhoMapper itemCarrinhoMapper, ItemCarrinhoRepository itemCarrinhoRepository) {
        this.itemCarrinhoMapper = itemCarrinhoMapper;
        this.itemCarrinhoRepository = itemCarrinhoRepository;
    }

    public List<ItemCarrinhoDTO> getAllItemCarrinho() {
        List<ItemCarrinho> itemCarrinhoList = itemCarrinhoRepository.findAll();
        return itemCarrinhoList.stream().map(itemCarrinhoMapper::toDTO).toList();
    }

    public List<ItemCarrinhoDTO> getAllItemCarrinhoPorUsuario(UUID id_usuario) {
        List<ItemCarrinho> itensCarrinho = itemCarrinhoRepository.findAll();
        return itensCarrinho.stream().map(itemCarrinhoMapper::toDTO).toList();

    }

    public ItemCarrinhoDTO getItemCarrinhoById(UUID id) {
        ItemCarrinho itemCarrinho = itemCarrinhoRepository.findById(id).orElseThrow(
                () -> new RuntimeException("O carrinho não existe")
        );
        return itemCarrinhoMapper.toDTO(itemCarrinho);
    }

    public ItemCarrinhoDTO createItemCarrinho(ItemCarrinhoDTO itemCarrinhoDTO) {
        ItemCarrinho itemCarrinho = itemCarrinhoMapper.toEntity(itemCarrinhoDTO);
        itemCarrinhoRepository.save(itemCarrinho);
        return itemCarrinhoMapper.toDTO(itemCarrinho);
    }

    public ItemCarrinhoDTO updateItemCarrinho(UUID id, ItemCarrinhoDTO itemCarrinhoDTO) {
        ItemCarrinho itemCarrinho = itemCarrinhoRepository.findById(id).orElseThrow(
                () -> new RuntimeException("O carrinho não existe")
        );
        itemCarrinho.setUsuario(itemCarrinhoDTO.usuario());
        itemCarrinho.setProduto(itemCarrinhoDTO.produto());
        itemCarrinho.setQuantidade(itemCarrinhoDTO.quantidade());
        itemCarrinhoRepository.save(itemCarrinho);
        return itemCarrinhoMapper.toDTO(itemCarrinho);
    }

    public ItemCarrinhoDTO deleteItemCarrinho(UUID id) {
        ItemCarrinho itemCarrinho = itemCarrinhoRepository.findById(id).orElseThrow(
                () -> new RuntimeException("O carrinho não existe")
        );
        itemCarrinhoRepository.delete(itemCarrinho);
        return itemCarrinhoMapper.toDTO(itemCarrinho);
    }
}
