package com.example.caseirinhosdamarcia.dtos;

import java.util.UUID;

public record UsuarioDTO(
        UUID id_usuario,
        String name,
        String login,
        String senha
) {

}
