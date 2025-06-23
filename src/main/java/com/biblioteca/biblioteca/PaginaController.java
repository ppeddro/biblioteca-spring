package com.biblioteca.biblioteca;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.biblioteca.biblioteca.model.GoogleBooksResponse;
import com.biblioteca.biblioteca.model.Livro;

@Controller
public class PaginaController {

    @GetMapping("/")
    public String buscarLivros(@RequestParam(name = "q", required = false, defaultValue = "machado de assis") String termo, Model model) {
        String url = "https://www.googleapis.com/books/v1/volumes?q=" + termo;

        RestTemplate restTemplate = new RestTemplate();
        GoogleBooksResponse resposta = restTemplate.getForObject(url, GoogleBooksResponse.class);

        List<Livro> livros = resposta.getItems().stream()
            .map(item -> {
                var info = item.getVolumeInfo();
                String titulo = info.getTitle();
                String autor = (info.getAuthors() != null) ? String.join(", ", info.getAuthors()) : "Autor desconhecido";
                String imagem = (info.getImageLinks() != null) ? info.getImageLinks().getThumbnail() : "";
                return new Livro(titulo, autor, imagem);
            })
            .collect(Collectors.toList());

        model.addAttribute("livros", livros);
        return "index";
    }

}