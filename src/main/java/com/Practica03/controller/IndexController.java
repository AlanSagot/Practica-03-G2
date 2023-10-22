
package com.Practica03.controller;

import com.Practica03.domain.Arbol;
import com.Practica03.service.ArbolService;
import com.Practica03.serviceimpl.FirebaseStorageServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class IndexController {
    
    @Autowired
    private ArbolService arbolService;
    
    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;
     
    @RequestMapping("/")
    public String page(Model model) {
        model.addAttribute("attribute", "value");
        return "index";
    }
    
    @GetMapping("/")
    public String inicio(Model model) {
        List<Arbol> listadoArboles = arbolService.getArboles(false); // Obtener todos los árboles
        List<Arbol> listadoArbolesInactivos = arbolService.getArbolesInactivos(true); // Obtener solo los árboles inactivos

        model.addAttribute("arboles", listadoArboles);
        model.addAttribute("totalArboles", listadoArboles.size());
        model.addAttribute("totalArbolesInactivos", listadoArbolesInactivos.size()); // Total de árboles inactivos

        return "index";
    }
    
    @GetMapping("/{idArbol}")
    public String arbolEliminar(Arbol arbol) {
        arbolService.delete(arbol);
        return "redirect:/";
    }

    @PostMapping("/guardar")
    public String arbolGuardar(Arbol arbol,
            @RequestParam("imagenFile") MultipartFile imagenFile) {        
        if (!imagenFile.isEmpty()) {
            arbolService.save(arbol);
            arbol.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile, 
                            "arbol", 
                            arbol.getIdArbol()));
        }
        arbolService.save(arbol);
        return "redirect:/";
    }
    
    @GetMapping("/nuevo")
    public String arbolNuevo(Arbol arbol) {
        return "/arboles/modifica";
    }
    
    @GetMapping("/modificar/{idArbol}")
    public String arbolModificar(Arbol arbol, Model model) {
        arbol = arbolService.getArbol(arbol);
        model.addAttribute("arbol", arbol);
        return "/arboles/modifica";
    }
}


