
package com.Practica03.service;



import com.Practica03.domain.Arbol;
import java.util.List;

public interface ArbolService {
    
    public List<Arbol> getArboles(boolean activos);
 
    public Arbol getArbol(Arbol arbol);
    
    public void save(Arbol arbol);
    
    public void delete(Arbol arbol);
    
}
