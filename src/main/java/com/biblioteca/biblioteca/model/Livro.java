package com.biblioteca.biblioteca.model;

public class Livro {
    private String titulo;
    private String autor;
    private String imagem;
    private String descricao; // <<< ADICIONE ESTA LINHA

    // Construtor atualizado para incluir 'descricao'
    public Livro(String titulo, String autor, String imagem, String descricao) { // <<< MUDANÇA AQUI
        this.titulo = titulo;
        this.autor = autor;
        this.imagem = imagem;
        this.descricao = descricao; // <<< ATRIBUINDO AQUI
    }

    // Você também pode adicionar um construtor vazio, se necessário para frameworks ou ORMs
    public Livro() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) { // Adicione o setter se for manipular o título depois de criar
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) { // Adicione o setter
        this.autor = autor;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) { // Adicione o setter
        this.imagem = imagem;
    }

    // GETTER E SETTER PARA DESCRICAO <<< ADICIONE ESTES MÉTODOS
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}