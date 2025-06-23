package com.biblioteca.biblioteca.model;

import java.util.List;

public class GoogleBooksResponse {
    private List<Item> items;

    public List<Item> getItems() {
        return items;
    }

    public static class Item {
        private VolumeInfo volumeInfo;

        public VolumeInfo getVolumeInfo() {
            return volumeInfo;
        }
    }

    public static class VolumeInfo {
        private String title;
        private List<String> authors;
        private ImageLinks imageLinks;

        public String getTitle() {
            return title;
        }

        public List<String> getAuthors() {
            return authors;
        }

        public ImageLinks getImageLinks() {
            return imageLinks;
        }
    }

    public static class ImageLinks {
        private String thumbnail;

        public String getThumbnail() {
            return thumbnail;
        }
    }
}