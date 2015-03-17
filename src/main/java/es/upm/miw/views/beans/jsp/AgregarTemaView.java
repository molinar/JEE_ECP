package es.upm.miw.views.beans.jsp;

import org.apache.logging.log4j.LogManager;

import es.upm.miw.controllers.AgregarTemaController;
import es.upm.miw.models.entities.Tema;

public class AgregarTemaView extends ViewBean {

    private String errorMsg;

    private Tema tema;

    public AgregarTemaView() {
        this.tema = new Tema();
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }

    public String agregarTema() {
        AgregarTemaController agregarTemaController = this.getControllerFactory()
                .getAgregarTemaController();
        System.out.println("bean: " + tema.getNombre());
        agregarTemaController.agregarTema(tema);
        LogManager.getLogger(this.getClass().getName()).info("--- Tema creado ---");
        return null;
    }
}
