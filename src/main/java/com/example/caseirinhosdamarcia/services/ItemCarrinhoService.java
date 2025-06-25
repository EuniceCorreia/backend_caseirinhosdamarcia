package com.example.caseirinhosdamarcia.services;

import com.example.caseirinhosdamarcia.dtos.ItemCarrinhoCreateDTO;
import com.example.caseirinhosdamarcia.dtos.ItemCarrinhoDTO;
import com.example.caseirinhosdamarcia.entities.ItemCarrinho;
import com.example.caseirinhosdamarcia.entities.Produto;
import com.example.caseirinhosdamarcia.entities.Usuario;
import com.example.caseirinhosdamarcia.mappers.ItemCarrinhoMapper;
import com.example.caseirinhosdamarcia.repositories.ProdutoRepository;
import org.springframework.stereotype.Service;
import com.example.caseirinhosdamarcia.repositories.ItemCarrinhoRepository;
import com.example.caseirinhosdamarcia.repositories.UsuarioRepository;


import java.util.List;
import java.util.UUID;

@Service
public class ItemCarrinhoService {
    private final ItemCarrinhoMapper itemCarrinhoMapper;
    private final ItemCarrinhoRepository itemCarrinhoRepository;
    private final ProdutoRepository produtoRepository;
    private final UsuarioRepository usuarioRepository;

    public ItemCarrinhoService(ItemCarrinhoMapper itemCarrinhoMapper,
                               ItemCarrinhoRepository itemCarrinhoRepository,
                               ProdutoRepository produtoRepository,
                               UsuarioRepository usuarioRepository) {
        this.itemCarrinhoMapper = itemCarrinhoMapper;
        this.itemCarrinhoRepository = itemCarrinhoRepository;
        this.produtoRepository = produtoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public List<ItemCarrinhoDTO> getAllItemCarrinho() {
        List<ItemCarrinho> itemCarrinhoList = itemCarrinhoRepository.findAll();
        return itemCarrinhoList.stream().map(itemCarrinhoMapper::toDTO).toList();
    }

    public List<ItemCarrinhoDTO> getAllItemCarrinhoPorUsuario(UUID usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        List<ItemCarrinho> itensCarrinho = itemCarrinhoRepository.findByUsuario(usuario);
        return itensCarrinho.stream().map(itemCarrinhoMapper::toDTO).toList();
    }



    public ItemCarrinhoDTO getItemCarrinhoById(UUID id) {
        ItemCarrinho itemCarrinho = itemCarrinhoRepository.findById(id).orElseThrow(
                () -> new RuntimeException("O carrinho não existe")
        );
        return itemCarrinhoMapper.toDTO(itemCarrinho);
    }
    public ItemCarrinhoDTO deleteItemCarrinho(UUID id) {
        ItemCarrinho itemCarrinho = itemCarrinhoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("O carrinho não existe"));
        itemCarrinhoRepository.delete(itemCarrinho);
        return itemCarrinhoMapper.toDTO(itemCarrinho);
    }


    public ItemCarrinhoDTO createItemCarrinho(ItemCarrinhoCreateDTO createDTO) {
        Produto produto = produtoRepository.findById(createDTO.idProduto())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        Usuario usuario = usuarioRepository.findById(createDTO.idUsuario())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        ItemCarrinho item = new ItemCarrinho();
        item.setProduto(produto);
        item.setUsuario(usuario);
        item.setQuantidade(createDTO.quantidade());

        itemCarrinhoRepository.save(item);


        return new ItemCarrinhoDTO(item.getId_item(), produto, item.getQuantidade(), usuario);


    }

    public ItemCarrinhoDTO updateItemCarrinho(UUID id, ItemCarrinhoDTO itemCarrinhoDTO) {
        ItemCarrinho itemCarrinho = itemCarrinhoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("O carrinho não existe"));

        // Buscar Produto e Usuario pelo id do DTO
        Produto produto = produtoRepository.findById(itemCarrinhoDTO.produto().getId_produto())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        Usuario usuario = usuarioRepository.findById(itemCarrinhoDTO.usuario().getId_usuario())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        itemCarrinho.setProduto(produto);
        itemCarrinho.setUsuario(usuario);
        itemCarrinho.setQuantidade(itemCarrinhoDTO.quantidade());

        itemCarrinhoRepository.save(itemCarrinho);
        return itemCarrinhoMapper.toDTO(itemCarrinho);
    }
}