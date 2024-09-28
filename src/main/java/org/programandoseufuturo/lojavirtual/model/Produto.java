package org.programandoseufuturo.lojavirtual.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;
    private String descricao;
    private BigDecimal preco;

    @JsonProperty("esta_disponivel")
    private boolean estaDisponivel;

    @JsonProperty("url_imagem")
    private String urlImagem;

    @JsonProperty("esta_favoritado")
    private boolean estaFavoritado;

    @JsonProperty("quantidade_disponivel")
    private Long quantidadeDisponivel;

    public Produto() {

    }

    public Produto(int id, String nome, String descricao, BigDecimal preco, boolean estaDisponivel, String urlImagem,
            boolean estaFavoritado, Long quantidadeDisponivel) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.estaDisponivel = estaDisponivel;
        this.urlImagem = urlImagem;
        this.estaFavoritado = estaFavoritado;
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public boolean isEstaDisponivel() {
        return estaDisponivel;
    }

    public void setEstaDisponivel(boolean estaDisponivel) {
        this.estaDisponivel = estaDisponivel;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public boolean isEstaFavoritado() {
        return estaFavoritado;
    }

    public void setEstaFavoritado(boolean estaFavoritado) {
        this.estaFavoritado = estaFavoritado;
    }

    public Long getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void setQuantidadeDisponivel(Long quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

}
