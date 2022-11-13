package br.com.project.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
public class UserController {
    
    @GetMapping("")
    public String main() {
        return "Rota principal pública.";
    }

    @PostMapping("")
    public String post() {
        return "Rota de postagens.";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(value="/admin")
    public String admin() {
        return "Rota exclusiva para administradores.";
    }
    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping(value="/user")
    public String user() {
        return "Rota exclusiva para usuários comuns.";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping(value="/all")
    public String all() {
        return "Rota para todos os usuários autenticados.";
    }
    

}
