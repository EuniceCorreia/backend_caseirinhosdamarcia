package com.example.caseirinhosdamarcia.repositories;

import com.example.caseirinhosdamarcia.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,UUID>{
    Optional<Usuario> findByLoginAndSenha(String login, String senha);
}
