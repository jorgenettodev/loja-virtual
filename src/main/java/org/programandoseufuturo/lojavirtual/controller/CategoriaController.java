package org.programandoseufuturo.lojavirtual.controller;

import org.programandoseufuturo.lojavirtual.model.Categoria;
import org.programandoseufuturo.lojavirtual.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private CategoriaService service;

    @Autowired
    public CategoriaController(CategoriaService service) {
        this.service = service;
    }

    @PostMapping

    public ResponseEntity cadastrarCategoria(@RequestBody Categoria categoria) {
        Categoria categoriaCriada = service.cadastrarCategoria(categoria);

        if (categoriaCriada != null) {
            return ResponseEntity.status(HttpStatus.CREATED.value()).body(categoriaCriada);
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).build();
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> listarCategorias() {
        // faz a chamada para o db e pega todas as categorias
        List<Categoria> categorias = service.listaCategorias();

        if (categorias != null) {
            return ResponseEntity.status(HttpStatus.OK.value()).body(categorias);
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).build();

        // se deu bom, retorna a response + a lista de Categorias
        // se deu ruim, retorna build() e badRequest
    }
}
