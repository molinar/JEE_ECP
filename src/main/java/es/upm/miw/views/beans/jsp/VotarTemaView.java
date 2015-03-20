package es.upm.miw.views.beans.jsp;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;

import es.upm.miw.controllers.VotarController;
import es.upm.miw.models.entities.Tema;
import es.upm.miw.models.entities.Votacion;
import es.upm.miw.models.utils.NivelEstudios;

public class VotarTemaView extends ViewBean {

    public Tema tema;

    public int id;

    public List<NivelEstudios> nivelEstudios = new ArrayList<NivelEstudios>(
            EnumSet.allOf(NivelEstudios.class));

    public List<Integer> valoracion = new ArrayList<Integer>();

    public String ipUsuario;

    public Votacion votacion;

    public VotarTemaView() {
        this.votacion = new Votacion();
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
        for (int i = 1; i <= 10; i++) {
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

    public String getIpUsuario(HttpServletRequest request) throws UnknownHostException {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    public void setIpUsuario(String ipUsuario) {
        this.ipUsuario = ipUsuario;
    }

    public Votacion getVotacion() {
        return votacion;
    }

    public void setVotacion(Votacion votacion) {
        this.votacion = votacion;
    }

    public void mostrar() {
        VotarController votarController = this.getControllerFactory().getVotarController();
        this.tema = votarController.getTema(id);
    }

    public void votarTema() {
        VotarController votarController = this.getControllerFactory().getVotarController();
        this.tema = votarController.getTema(this.id);
        this.votacion.setTema(this.tema);
        votarController.votar(votacion);
        LogManager.getLogger(this.getClass().getName()).info("--- Votación realizada ---");
    }

}
