package com.example.caseirinhosdamarcia.dtos;

import com.example.caseirinhosdamarcia.entities.Produto;
import com.example.caseirinhosdamarcia.entities.Usuario;

import java.util.UUID;

public record ItemCarrinhoDTO(
        UUID id_item,
        Produto produto,
        int quantidade,
        Usuario usuario


) {
}
