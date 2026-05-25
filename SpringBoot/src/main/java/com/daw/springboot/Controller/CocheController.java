package com.daw.springboot.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.daw.springboot.model.Coche;
import com.daw.springboot.model.CocheRepository;

@Controller
public class CocheController {

    @Autowired
    public CocheRepository cocheRepository;

    @GetMapping("/")
    public String getCoches(Model model) {
        // Cargamos todos los coches de la bd con findall
        List<Coche> listaCoches = cocheRepository.findAll();
        // Añadimos los datos al modelo para que le lleguen a la vista
        model.addAttribute("listacoches", listaCoches);

        return "listado";
    }

}
