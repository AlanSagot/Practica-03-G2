
package com.Practica03.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;



@Data 
@Entity
@Table(name= "arbol")
public class Arbol implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_arbol")
    private Long idArbol; 
    private String rutaImagen;
    private String nombreComun;
    private String tipoFlor;
    private Long dureza;
    private boolean activo;
    
    public Arbol(){}

    public Arbol(String rutaImagen, String nombreComun, String tipoFlor, Long dureza, boolean activo) {
        this.rutaImagen = rutaImagen;
        this.nombreComun = nombreComun;
        this.tipoFlor = tipoFlor;
        this.dureza = dureza;
        this.activo = activo;
    }

    
}
