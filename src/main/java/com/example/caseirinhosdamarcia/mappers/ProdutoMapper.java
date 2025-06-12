package com.example.caseirinhosdamarcia.mappers;

import com.example.caseirinhosdamarcia.dtos.ProdutoDTO;
import com.example.caseirinhosdamarcia.entities.Produto;
import org.springframework.stereotype.Component;

@Component
public class ProdutoMapper {
    public ProdutoDTO toDTO(Produto produto) {
        return new ProdutoDTO(
                produto.getId_produto(),
                produto.getTitle(),
                produto.getType(),
                produto.getPeso(),
                produto.getPrice(),
                produto.getDescricaoModal(),
                produto.getImage()
        );
    }

    public Produto toEntity(ProdutoDTO produtoDTO) {
        Produto produto = new Produto();
        produto.setId_produto(produtoDTO.id_produto());
        produto.setTitle(produtoDTO.title());
        produto.setType(produtoDTO.type());
        produto.setPeso(produtoDTO.peso());
        produto.setPrice(produtoDTO.price());
        produto.setDescricaoModal(produtoDTO.descricaoModal());
        produto.setImage(produtoDTO.image());
        return produto;
    }
}
