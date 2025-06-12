package com.example.caseirinhosdamarcia.mappers;

import com.example.caseirinhosdamarcia.dtos.UsuarioDTO;
import com.example.caseirinhosdamarcia.entities.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {
    public UsuarioDTO toDTO(Usuario usuario) {
        return new UsuarioDTO(
                usuario.getId_usuario(),
                usuario.getName(),
                usuario.getLogin(),
                usuario.getSenha()
        );
    }

    public Usuario toEntity(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setId_usuario(usuarioDTO.id_usuario());
        usuario.setName(usuarioDTO.name());
        usuario.setLogin(usuarioDTO.login());
        usuario.setSenha(usuarioDTO.senha());
        return usuario;
    }

}
