
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
@RequestMapping("/arbol")
public class ArbolController {

    @Autowired
    private ArbolService arbolService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        List<Arbol> listadoArboles = arbolService.getArboles(false);
        model.addAttribute("arboles", listadoArboles);
        model.addAttribute("totalArboles", listadoArboles.size());

        return "/arbol/listado";
    }
}
    

