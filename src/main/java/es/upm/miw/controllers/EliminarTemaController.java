package es.upm.miw.controllers;

public interface EliminarTemaController {
    
    void eliminarTema(Integer id);
    
    boolean autorizar(String codigo);

}
