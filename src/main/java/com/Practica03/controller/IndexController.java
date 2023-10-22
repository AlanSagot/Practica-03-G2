
package com.Practica03.controller;

import com.Practica03.domain.Arbol;
import com.Practica03.service.ArbolService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    
     
    @RequestMapping("/")
    public String page(Model model) {
        model.addAttribute("attribute", "value");
        return "index";
    }
    
    @Autowired
    private ArbolService arbolService;

    
    @GetMapping("/")
    public String inicio(Model model) {
        List<Arbol> listadoArboles = arbolService.getArboles(false); // Obtener todos los árboles
        List<Arbol> listadoArbolesInactivos = arbolService.getArbolesInactivos(true); // Obtener solo los árboles inactivos

        model.addAttribute("arboles", listadoArboles);
        model.addAttribute("totalArboles", listadoArboles.size());
        model.addAttribute("totalArbolesInactivos", listadoArbolesInactivos.size()); // Total de árboles inactivos

        return "index";
    }
}


