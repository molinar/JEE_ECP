package es.upm.miw.controllers;

public interface EliminarTemaController extends ListarTemasController{
    
    void eliminarTema(Integer id);
    
    boolean autorizar(String codigo);

}
