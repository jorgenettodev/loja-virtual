package org.programandoseufuturo.lojavirtual.service;

import java.util.List;
import java.util.Optional;

import org.programandoseufuturo.lojavirtual.model.Produto;
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

    // cria um metodo que pega todos produtos
    public List<Produto> obterTodosProdutos() {
        return repository.findAll();
    }

    // criar metodo para cadastrar novo produto
    // verifica se o id já existe no db
    // se existe -> retorna null
    // senao -> retorna save

    public Produto cadastrarProduto(Produto produto) {
        return repository.save(produto);
    }

    // obter produto especifico pelo id
    public Produto obterProdutoPeloId(int id) {
        Optional<Produto> optional = repository.findById(id);

        if (optional.isPresent()) {
            return optional.get();
        }
        throw new RuntimeException("Produto nao encontrado");
    }

    // criar metodo que deleta produto
    public Produto deletarProduto(int id) {
        Optional<Produto> optional = repository.findById(id);

        if (optional.isPresent()) {
            repository.deleteById(id);
            return optional.get();
        }
        throw new RuntimeException("Produto nao encontrado.");
    }

}
