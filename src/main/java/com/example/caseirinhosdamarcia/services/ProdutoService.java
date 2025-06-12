package com.example.caseirinhosdamarcia.services;

import com.example.caseirinhosdamarcia.dtos.ProdutoDTO;
import com.example.caseirinhosdamarcia.entities.Produto;
import com.example.caseirinhosdamarcia.mappers.ProdutoMapper;
import com.example.caseirinhosdamarcia.repositories.ProdutoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProdutoService {
    private final ProdutoMapper produtoMapper;
    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoMapper produtoMapper, ProdutoRepository produtoRepository) {
        this.produtoMapper = produtoMapper;
        this.produtoRepository = produtoRepository;
    }

    public Page<ProdutoDTO> getAllProduto(Pageable pageable) {
        Page<Produto> produtoList = produtoRepository.findAll(pageable);
        return produtoList.map(produtoMapper::toDTO);
    }

    public ProdutoDTO getProdutoById(UUID id) {
        Produto produto = produtoRepository.findById(id).orElseThrow(
                () -> new RuntimeException("O produto não existe")
        );
        return produtoMapper.toDTO(produto);
    }

    public ProdutoDTO createProduto(ProdutoDTO produtoDTO) {
        Produto produto = produtoMapper.toEntity(produtoDTO);
        produtoRepository.save(produto);
        return produtoMapper.toDTO(produto);
    }

    public ProdutoDTO updateProduto(UUID id, ProdutoDTO produtoDTO) {
        Produto produto = produtoRepository.findById(id).orElseThrow(
                () -> new RuntimeException("O produto não existe")
        );
        produto.setTitle(produtoDTO.title());
        produto.setPeso(produtoDTO.peso());
        produto.setPrice(produtoDTO.price());
        produto.setType(produtoDTO.type());
        produto.setDescricaoModal(produtoDTO.descricaoModal());
        produto.setImage(produtoDTO.image());
        produtoRepository.save(produto);
        return produtoMapper.toDTO(produto);
    }

    public ProdutoDTO deleteProduto(UUID id) {
        Produto produto = produtoRepository.findById(id).orElseThrow(
                () -> new RuntimeException("O produto não existe")
        );
        produtoRepository.delete(produto);
        return produtoMapper.toDTO(produto);
    }
}
