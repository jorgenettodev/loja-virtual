package org.programandoseufuturo.lojavirtual.service;

import org.programandoseufuturo.lojavirtual.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    private ProdutoRepository repository;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.repository = produtoRepository;
    }
}
