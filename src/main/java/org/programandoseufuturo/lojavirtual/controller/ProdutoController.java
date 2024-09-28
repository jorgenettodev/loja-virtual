package org.programandoseufuturo.lojavirtual.controller;

import java.util.List;
import java.util.Optional;

import org.programandoseufuturo.lojavirtual.model.Produto;
import org.programandoseufuturo.lojavirtual.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@CrossOrigin("*")
@RequestMapping("/produtos")
public class ProdutoController {
    // adiciona as dependencias
    private ProdutoService service;

    @Autowired
    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Produto>> buscaProdutos() {
        List<Produto> produtos = service.obterTodosProdutos();
        return ResponseEntity.status(HttpStatus.OK.value()).body(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> getById(@PathVariable int id) {

        return ResponseEntity.status(HttpStatus.OK.value()).body(service.obterProdutoPeloId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Produto> deletarProduto(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.OK.value()).body(service.deletarProduto(id));
    }
    
    @PostMapping
    public ResponseEntity<Produto> cadastrarProduto(@RequestBody Produto produto) {
        Produto produtoCriado = service.cadastrarProduto(produto);
        return ResponseEntity.status(HttpStatus.CREATED.value()).body(produtoCriado);
    }

}
