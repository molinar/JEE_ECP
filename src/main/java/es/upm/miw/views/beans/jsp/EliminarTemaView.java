package es.upm.miw.views.beans.jsp;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.apache.logging.log4j.LogManager;

import es.upm.miw.controllers.EliminarTemaController;

@ManagedBean
public class EliminarTemaView extends ViewBean {
    
    @ManagedProperty(value = "#{param.id}")
    private int id;
    
    public EliminarTemaView() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String eliminarTema() {
        EliminarTemaController eliminarTemaController = this.getControllerFactory()
                .getEliminarTemaController();
        eliminarTemaController.eliminarTema(id);
        LogManager.getLogger(this.getClass().getName()).info("--- Tema eliminado ---");
        return "temaEliminado.xhtml";
    }

}
