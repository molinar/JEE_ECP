package es.upm.miw.views.beans.jsp;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import org.apache.logging.log4j.LogManager;

import es.upm.miw.controllers.MostrarVotacionesController;
import es.upm.miw.models.utils.RecopilacionVotos;

@ManagedBean
public class MostrarVotacionesView extends ViewBean {

    private List<RecopilacionVotos> votos = new ArrayList<RecopilacionVotos>();
   
    public MostrarVotacionesView() {
    }

    public List<RecopilacionVotos> getVotos() {
        return votos;
    }

    public void setVotos(List<RecopilacionVotos> votos) {
        this.votos = votos;
    }

    public String mostrarVotos() {
        MostrarVotacionesController mostrarVotacionesController = this.getControllerFactory()
                .getMostrarVotacionesController();
        votos = mostrarVotacionesController.listarVotaciones();
        LogManager.getLogger(this.getClass().getName()).info("--- Votos mostrados ---");
        return null;
    }

}
