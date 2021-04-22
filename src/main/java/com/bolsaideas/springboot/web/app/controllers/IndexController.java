package com.bolsaideas.springboot.web.app.controllers;

import com.bolsaideas.springboot.web.app.models.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/app")
public class IndexController {

    @GetMapping({"/index", "/", "/home"})
    public String index(Model model) {
        model.addAttribute("titulo", "Hola Spring Framework Model!");
        return "index";
    }

    @GetMapping("/perfil")
    public String perfil(Model model) {

        Usuario usuario = new Usuario();
        usuario.setNombre("Sebastian");
        usuario.setApellido("Agudelo Marin");
        usuario.setEmail("sebascarman@gmail.com");
        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", "Perfil del usuario: ".concat(usuario.getNombre()));

        return "perfil";
    }

    @GetMapping("/listar")
    public String listar(Model model) {
        List<Usuario> usuarios = Arrays.asList(new Usuario("Sebastian", "Agudelo Marin", "sebascarman@gmail.com"),
                new Usuario("John", "Doe", "john@gmail.com"),
                new Usuario("Jane", "Doe", "jane@gmail.com"),
                new Usuario("Dani", "Ayala", "dani@gmail.com"));
        model.addAttribute("titulo", "Listado de usuarios");
        model.addAttribute("usuarios", usuarios);
        return "listar";
    }
}
