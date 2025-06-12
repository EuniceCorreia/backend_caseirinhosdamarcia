package com.example.caseirinhosdamarcia.dtos;

import java.util.UUID;

public record ProdutoDTO(
        UUID id_produto,
        String title,
        String type,
        Double peso,
        Double price,
        String descricaoModal,
        String image
) {
}
