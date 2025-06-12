package com.example.caseirinhosdamarcia.repositories;

import com.example.caseirinhosdamarcia.entities.ItemCarrinho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ItemCarrinhoRepository extends JpaRepository<ItemCarrinho, UUID> {
}
