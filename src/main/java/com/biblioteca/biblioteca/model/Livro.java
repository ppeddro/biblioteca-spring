package com.biblioteca.biblioteca.model;

public class Livro {
    private String titulo;
    private String autor;
    private String imagem;

    public Livro(String titulo, String autor, String imagem) {
        this.titulo = titulo;
        this.autor = autor;
        this.imagem = imagem;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getImagem() {
        return imagem;
    }
}