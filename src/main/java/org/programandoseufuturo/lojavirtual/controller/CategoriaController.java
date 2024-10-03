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
}
