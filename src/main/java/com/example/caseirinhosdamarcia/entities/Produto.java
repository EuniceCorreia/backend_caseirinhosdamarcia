package com.example.caseirinhosdamarcia.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id_produto;
    private String title;
    private String type;
    private Double peso;
    private Double price;
    private String descricaoModal;
    private String image;

    public UUID getId_produto() {
        return id_produto;
    }

    public void setId_produto(UUID id_produto) {
        this.id_produto = id_produto;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescricaoModal() {
        return descricaoModal;
    }

    public void setDescricaoModal(String descricaoModal) {
        this.descricaoModal = descricaoModal;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
