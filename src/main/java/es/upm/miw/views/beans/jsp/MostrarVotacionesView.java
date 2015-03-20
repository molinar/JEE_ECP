package es.upm.miw.views.beans.jsp;

import java.util.List;

import org.apache.logging.log4j.LogManager;

import es.upm.miw.controllers.MostrarVotacionesController;
import es.upm.miw.models.utils.RecopilacionVotos;

public class MostrarVotacionesView extends ViewBean{
    
    public List<RecopilacionVotos> votos;
    
    public MostrarVotacionesView(){
    }

    public List<RecopilacionVotos> getVotos() {
        return votos;
    }

    public void setVotos(List<RecopilacionVotos> votos) {
        this.votos = votos;
    }

    public void mostrarVotos() {
        MostrarVotacionesController mostrarVotacionesController = this.getControllerFactory().getMostrarVotacionesController();
        votos = mostrarVotacionesController.listarVotaciones();
        LogManager.getLogger(this.getClass().getName()).info("--- Votos mostrados ---");
    }

}
