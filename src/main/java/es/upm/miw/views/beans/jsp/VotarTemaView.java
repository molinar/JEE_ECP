package es.upm.miw.views.beans.jsp;

import es.upm.miw.controllers.VotarController;
import es.upm.miw.models.entities.Tema;
import es.upm.miw.models.utils.NivelEstudios;

public class VotarTemaView extends ViewBean{
    
    public Tema tema;
    
    public NivelEstudios[] nivelEstudios;
    
    public int valoracion, id;
    
    public VotarTemaView(){
        this.nivelEstudios = NivelEstudios.values();
    }

    public Tema getTema() {
        return tema;
    }

    public NivelEstudios[] getNivelEstudios() {
        return nivelEstudios;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }

    public void setNivelEstudios(NivelEstudios[] nivelEstudios) {
        this.nivelEstudios = nivelEstudios;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public void update(){
        VotarController votarController = this.getControllerFactory().getVotarController();
        this.tema = votarController.getTema(id);
    }
    
    public void votarTema(){
        
    }

}
