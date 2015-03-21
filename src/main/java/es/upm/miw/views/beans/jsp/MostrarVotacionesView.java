package es.upm.miw.views.beans.jsp;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;

import es.upm.miw.controllers.MostrarVotacionesController;
import es.upm.miw.models.utils.RecopilacionMedias;
import es.upm.miw.models.utils.RecopilacionVotos;

public class MostrarVotacionesView extends ViewBean {

    private List<RecopilacionVotos> votos = new ArrayList<RecopilacionVotos>();

    private List<RecopilacionMedias> medias = new ArrayList<RecopilacionMedias>();
    
    public MostrarVotacionesView() {
    }

    public List<RecopilacionVotos> getVotos() {
        return votos;
    }

    public void setVotos(List<RecopilacionVotos> votos) {
        this.votos = votos;
    }

    public List<RecopilacionMedias> getMedias() {
        return medias;
    }

    public void setMedias(List<RecopilacionMedias> medias) {
        this.medias = medias;
    }

    public void mostrarVotos() {
        MostrarVotacionesController mostrarVotacionesController = this.getControllerFactory()
                .getMostrarVotacionesController();
        votos = mostrarVotacionesController.listarVotaciones();
        LogManager.getLogger(this.getClass().getName()).info("--- Votos mostrados ---");
    }

}
