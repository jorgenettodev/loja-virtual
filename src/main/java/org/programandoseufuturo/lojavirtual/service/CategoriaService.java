package org.programandoseufuturo.lojavirtual.service;

import org.programandoseufuturo.lojavirtual.model.Categoria;
import org.programandoseufuturo.lojavirtual.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    private CategoriaRepository repository;
    
    @Autowired
    public CategoriaService(CategoriaRepository repository) {
        this.repository = repository;
    }
    
    // metodo para cadastrar Categoria
    public Categoria cadastrarCategoria(Categoria categoria) {
        return repository.save(categoria);
    }

    // metodo para pegar todas Categorias
    public List<Categoria> listarCategorias() {
        return repository.findAll();
    }

    // obter categoria pelo id
    public Categoria getCategoriaById(int id) {

        Optional<Categoria> categoriaBuscada = repository.findById(id);


        if (categoriaBuscada.isPresent()) {
            return categoriaBuscada.get();
        }
        throw new RuntimeException("Categoria nao encontrada");
    }
}
