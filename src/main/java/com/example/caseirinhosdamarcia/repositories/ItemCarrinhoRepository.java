package com.example.caseirinhosdamarcia.repositories;

import com.example.caseirinhosdamarcia.entities.ItemCarrinho;
import com.example.caseirinhosdamarcia.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ItemCarrinhoRepository extends JpaRepository<ItemCarrinho, UUID> {
    List<ItemCarrinho> findByUsuario(Usuario usuario);
}
