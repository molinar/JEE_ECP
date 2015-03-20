package es.upm.miw.views.beans.jsp;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import es.upm.miw.controllers.VotarController;
import es.upm.miw.models.entities.Tema;
import es.upm.miw.models.utils.NivelEstudios;

public class VotarTemaView extends ViewBean {

    public Tema tema;

    public int id;

    public List<NivelEstudios> nivelEstudios = new ArrayList<NivelEstudios>(EnumSet.allOf(NivelEstudios.class));

    public List<Integer> valoracion = new ArrayList<Integer>();

    public VotarTemaView() {
    }

    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<NivelEstudios> getNivelEstudios() {
        return nivelEstudios;
    }

    public List<Integer> getValoracion() {
        for(int i=1; i<=10; i++){
            valoracion.add(i);
        }
        return valoracion;
    }

    public void setNivelEstudios(List<NivelEstudios> nivelEstudios) {
        this.nivelEstudios = nivelEstudios;
    }

    public void setValoracion(List<Integer> valoracion) {
        this.valoracion = valoracion;
    }

    public void mostrar() {
        VotarController votarController = this.getControllerFactory().getVotarController();
        this.tema = votarController.getTema(id);
    }

    public void votarTema() {

    }

}
