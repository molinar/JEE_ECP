package es.upm.miw.views.beans.jsp;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.apache.logging.log4j.LogManager;

import es.upm.miw.controllers.EliminarTemaController;
import es.upm.miw.controllers.VotarController;
import es.upm.miw.models.entities.Tema;

@ManagedBean
public class MostrarTemasView extends ViewBean {

    private String id;

    private List<Tema> temas;

    public MostrarTemasView() {
    }

    public List<Tema> getTemas() {
        return temas;
    }

    public void setTemas(List<Tema> temas) {
        this.temas = temas;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
 
    @PostConstruct
    public void init() {
        this.mostrarTemas();
    }

    public String mostrarTemas() {
        EliminarTemaController eliminarTemaController = this.getControllerFactory()
                .getEliminarTemaController();
        temas = eliminarTemaController.listarTemas();
        LogManager.getLogger(this.getClass().getName()).info("--- Temas mostrados ---");
        return null;
    }

    public String mostrarTemasVotar() {
        VotarController votarController = this.getControllerFactory().getVotarController();
        temas = votarController.listarTemas();
        LogManager.getLogger(this.getClass().getName()).info("--- Temas mostrados ---");
        return null;
    }

}
