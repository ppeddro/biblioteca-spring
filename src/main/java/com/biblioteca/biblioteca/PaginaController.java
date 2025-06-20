package com.biblioteca.biblioteca;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaginaController {

    @GetMapping("/")
    public String index() {
        return "index";  // Vai procurar em templates/index.html
    }

    @GetMapping("/lista")
    public String lista() {
        return "lista";  // Vai procurar em templates/lista.html
    }
}
