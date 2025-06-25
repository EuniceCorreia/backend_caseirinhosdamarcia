package com.example.caseirinhosdamarcia.dtos;

import java.util.UUID;

public record ItemCarrinhoCreateDTO(
        UUID idProduto,
        UUID idUsuario,
        int quantidade
) {}

