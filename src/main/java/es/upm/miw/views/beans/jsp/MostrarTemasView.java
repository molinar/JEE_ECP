package es.upm.miw.views.beans.jsp;

import org.apache.logging.log4j.LogManager;

import es.upm.miw.controllers.EliminarTemaController;
import es.upm.miw.models.entities.Tema;

public class MostrarTemasView extends ViewBean{

    private String errorMsg;

    private Tema tema;

    public MostrarTemasView() {
        this.tema = new Tema();
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public Tema getTema() {
        return tema;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }
    
    public String mostrarTemas() {
        EliminarTemaController eliminarTemaController = this.getControllerFactory().getEliminarTemaController();
        eliminarTemaController.listarTemas();
        LogManager.getLogger(this.getClass().getName()).info("--- Temas mostrados ---");
        return null;
    }

}
