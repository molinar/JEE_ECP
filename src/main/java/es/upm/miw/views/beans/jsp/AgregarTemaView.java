package es.upm.miw.views.beans.jsp;

import javax.faces.bean.ManagedBean;

import org.apache.logging.log4j.LogManager;

import es.upm.miw.controllers.AgregarTemaController;
import es.upm.miw.models.entities.Tema;

@ManagedBean
public class AgregarTemaView extends ViewBean {

    private Tema tema;

    public AgregarTemaView() {
        this.tema = new Tema();
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
        agregarTemaController.agregarTema(tema);
        LogManager.getLogger(this.getClass().getName()).info("--- Tema creado ---");
        return null;
    }
}
