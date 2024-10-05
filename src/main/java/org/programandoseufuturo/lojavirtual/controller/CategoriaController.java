package org.programandoseufuturo.lojavirtual.controller;

import org.programandoseufuturo.lojavirtual.model.Categoria;
import org.programandoseufuturo.lojavirtual.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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

import java.util.List;
import java.util.Optional;

@Controller
@RestController
@CrossOrigin("*")
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
        List<Categoria> categorias = service.listarCategorias();

        if (categorias != null) {
            return ResponseEntity.status(HttpStatus.OK.value()).body(categorias);
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).build();

        // se deu bom, retorna a response + a lista de Categorias
        // se deu ruim, retorna build() e badRequest
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> getCategoriaById(@PathVariable("id") int id) {
        return ResponseEntity.status(200).body(service.getCategoriaById(id));
    }

    // cria uma rota para deletar uma categoria por id
    @DeleteMapping("/{id}")
    public ResponseEntity<Categoria> deleteCategoriaById(@PathVariable("id") int id) {

        return ResponseEntity.ok(service.deleteCategoriaById(id));

    }
}
