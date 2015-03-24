package es.upm.miw.views.beans.jsp; 

import java.util.List;

import org.apache.logging.log4j.LogManager;

import es.upm.miw.controllers.VotarController;
import es.upm.miw.models.entities.Tema;

public class MostrarTemasVotarView extends ViewBean {
    
    private List<Tema> temas;
    
    public MostrarTemasVotarView(){
    }
    
    public List<Tema> getTemas() {
        return temas;
    }

    public void setTemas(List<Tema> temas) {
        this.temas = temas;
    }

    public void mostrarTemas() {
        VotarController votarController = this.getControllerFactory().getVotarController();
        temas = votarController.listarTemas();
        LogManager.getLogger(this.getClass().getName()).info("--- Temas mostrados ---");
    }

}
