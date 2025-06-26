package com.biblioteca.biblioteca.model;

import java.util.List;

public class GoogleBooksResponse {
    private List<Item> items;

    public List<Item> getItems() {
        return items;
    }

    // Você pode adicionar um setter para 'items' se precisar atribuir a lista de itens externamente
    public void setItems(List<Item> items) {
        this.items = items;
    }

    public static class Item {
        private VolumeInfo volumeInfo;
        // Se houver outros campos no JSON de 'item' (ex: id), adicione-os aqui

        public VolumeInfo getVolumeInfo() {
            return volumeInfo;
        }

        // Você pode adicionar um setter para 'volumeInfo' se precisar atribuir externamente
        public void setVolumeInfo(VolumeInfo volumeInfo) {
            this.volumeInfo = volumeInfo;
        }
    }

    public static class VolumeInfo {
        private String title;
        private List<String> authors;
        private ImageLinks imageLinks;
        // --- ADICIONE ESTA LINHA: CAMPO PARA A DESCRIÇÃO ---
        private String description;

        public String getTitle() {
            return title;
        }

        // Opcional: Adicionar setters para os campos existentes se você precisar modificá-los
        public void setTitle(String title) {
            this.title = title;
        }

        public List<String> getAuthors() {
            return authors;
        }

        public void setAuthors(List<String> authors) {
            this.authors = authors;
        }

        public ImageLinks getImageLinks() {
            return imageLinks;
        }

        public void setImageLinks(ImageLinks imageLinks) {
            this.imageLinks = imageLinks;
        }

        // --- ADICIONE ESTES MÉTODOS: GETTER E SETTER PARA A DESCRIÇÃO ---
        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }

    public static class ImageLinks {
        private String thumbnail;
        // A API também pode ter 'smallThumbnail', adicione se precisar
        // private String smallThumbnail;

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        // public String getSmallThumbnail() { return smallThumbnail; }
        // public void setSmallThumbnail(String smallThumbnail) { this.smallThumbnail = smallThumbnail; }
    }
}