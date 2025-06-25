package com.example.caseirinhosdamarcia.controllers;

import com.example.caseirinhosdamarcia.dtos.UsuarioDTO;
import com.example.caseirinhosdamarcia.entities.Usuario;
import com.example.caseirinhosdamarcia.mappers.UsuarioMapper;
import com.example.caseirinhosdamarcia.services.UsuarioService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    private final UsuarioService usuarioService;
    private final UsuarioMapper usuarioMapper;


    public UsuarioController(UsuarioService usuarioService, UsuarioMapper usuarioMapper) {
        this.usuarioService = usuarioService;
        this.usuarioMapper = usuarioMapper;
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

    // ✅ Endpoint de login via GET
    @GetMapping("/login")
    public ResponseEntity<UsuarioDTO> login(
            @RequestParam String login,
            @RequestParam String senha) {

        Usuario usuario = usuarioService.verificarLogin(login, senha);

        if (usuario != null) {
            UsuarioDTO usuarioDTO = usuarioMapper.toDTO(usuario);
            return ResponseEntity.ok(usuarioDTO);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
