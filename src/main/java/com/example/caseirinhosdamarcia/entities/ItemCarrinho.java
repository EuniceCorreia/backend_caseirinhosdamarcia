package com.example.caseirinhosdamarcia.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "itemCarrinho")
public class ItemCarrinho {
    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    private UUID id_item;
    @ManyToOne
    @JoinColumn(name = "id_produto", nullable = false)
    private Produto produto;
    private int quantidade;
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    public UUID getId_item() {
        return id_item;
    }

    public void setId_item(UUID id_item) {
        this.id_item = id_item;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
