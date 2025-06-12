package com.example.caseirinhosdamarcia.mappers;

import com.example.caseirinhosdamarcia.dtos.ItemCarrinhoDTO;
import com.example.caseirinhosdamarcia.entities.ItemCarrinho;
import org.springframework.stereotype.Component;

@Component
public class ItemCarrinhoMapper {
    public ItemCarrinhoDTO toDTO(ItemCarrinho itemcarrinho) {
        return new ItemCarrinhoDTO(
                itemcarrinho.getId_item(),
                itemcarrinho.getProduto(),
                itemcarrinho.getQuantidade(),
                itemcarrinho.getUsuario()
        );
    }

    public ItemCarrinho toEntity(ItemCarrinhoDTO itemcarrinhoDTO) {
        ItemCarrinho itemcarrinho = new ItemCarrinho();
        itemcarrinho.setId_item(itemcarrinhoDTO.id_item());
        itemcarrinho.setProduto(itemcarrinhoDTO.produto());
        itemcarrinho.setQuantidade(itemcarrinhoDTO.quantidade());
        itemcarrinho.setUsuario(itemcarrinhoDTO.usuario());
        return itemcarrinho;
    }
}