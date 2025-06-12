package com.example.caseirinhosdamarcia.controllers;
import com.example.caseirinhosdamarcia.dtos.UsuarioDTO;
import org.springframework.web.bind.annotation.*;
import com.example.caseirinhosdamarcia.services.UsuarioService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.UUID;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public Page<UsuarioDTO> getAllUsuario(Pageable pageable) {
        return usuarioService.getAllUsuario(pageable);
    }

    @GetMapping("/{id}")
    public UsuarioDTO getUsuarioById(@PathVariable UUID id) {
        return usuarioService.getUsuarioById(id);
    }

    @PostMapping
    public UsuarioDTO createUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        return usuarioService.createUsuario(usuarioDTO);
    }

    @PutMapping("/{id}")
    public UsuarioDTO updateUsuario(@PathVariable UUID id, @RequestBody UsuarioDTO usuarioDTO){
        return usuarioService.updateUsuario(id, usuarioDTO);
    }

    @DeleteMapping("/{id}")
    public UsuarioDTO deleteUsuario(@PathVariable UUID id) {
        return usuarioService.deleteUsuario(id);
    }
}