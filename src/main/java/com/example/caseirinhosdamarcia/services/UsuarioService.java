package com.example.caseirinhosdamarcia.services;

import com.example.caseirinhosdamarcia.dtos.UsuarioDTO;
import com.example.caseirinhosdamarcia.entities.Usuario;
import com.example.caseirinhosdamarcia.mappers.UsuarioMapper;
import com.example.caseirinhosdamarcia.repositories.UsuarioRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UsuarioService {
    private final UsuarioMapper usuarioMapper;
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioMapper usuarioMapper, UsuarioRepository usuarioRepository) {
        this.usuarioMapper = usuarioMapper;
        this.usuarioRepository = usuarioRepository;
    }

    public Page<UsuarioDTO> getAllUsuario(Pageable pageable) {
        Page<Usuario> usuarioList = usuarioRepository.findAll(pageable);
        return usuarioList.map(usuarioMapper::toDTO);
    }

    public UsuarioDTO getUsuarioById(UUID id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(
                () -> new RuntimeException("O Usuário não existe")
        );
        return usuarioMapper.toDTO(usuario);
    }

    public UsuarioDTO createUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioMapper.toEntity(usuarioDTO);
        usuarioRepository.save(usuario);
        return usuarioMapper.toDTO(usuario);
    }

    public UsuarioDTO updateUsuario(UUID id, UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(
                () -> new RuntimeException("O usuario não existe")
        );
        usuario.setName(usuarioDTO.name());
        usuario.setLogin(usuarioDTO.login());
        usuario.setSenha(usuarioDTO.senha());
        usuarioRepository.save(usuario);
        return usuarioMapper.toDTO(usuario);
    }

    public UsuarioDTO deleteUsuario(UUID id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(
                () -> new RuntimeException("O usuario não existe")
        );
        usuarioRepository.delete(usuario);
        return usuarioMapper.toDTO(usuario);
    }
}
