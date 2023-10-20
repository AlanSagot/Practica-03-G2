package com.Practica03.serviceimpl;

import com.Practica03.dao.ArbolDao;
import com.Practica03.domain.Arbol;
import com.Practica03.service.ArbolService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArbolServiceImpl implements ArbolService {

    @Autowired
    private ArbolDao arbolDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Arbol> getArboles(boolean activos) {
        List<Arbol> arboles = arbolDao.findAll();

        if (activos) {
            arboles.removeIf(c -> !c.isActivo());
        }

        return arboles;
    }

    @Override
    public Arbol getArbol(Arbol arbol) {
       return arbolDao.findById(arbol.getIdArbol()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Arbol arbol) {
        arbolDao.save(arbol);
    }

    @Override
    @Transactional
    public void delete(Arbol arbol) {
        arbolDao.delete(arbol);
    }

    

    

}
