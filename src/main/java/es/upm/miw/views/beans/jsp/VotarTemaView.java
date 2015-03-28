package es.upm.miw.views.beans.jsp;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;

import es.upm.miw.controllers.VotarController;
import es.upm.miw.models.entities.Tema;
import es.upm.miw.models.entities.Votacion;
import es.upm.miw.models.utils.NivelEstudios;

@ManagedBean
public class VotarTemaView extends ViewBean {

    private Tema tema;

    private int id;

    private List<NivelEstudios> nivelEstudios = new ArrayList<NivelEstudios>(
            EnumSet.allOf(NivelEstudios.class));

    private String estudios;

    private List<Integer> valoracion = new ArrayList<Integer>();

    private Integer valor;

    private String ipUsuario;

    private Votacion votacion;

    public VotarTemaView() {
        this.votacion = new Votacion();
    }

    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }

    public int getId() {
        return id;
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

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public String getEstudios() {
        return estudios;
    }

    public void setEstudios(String estudios) {
        this.estudios = estudios;
    }

    public String getIpUsuario(HttpServletRequest request) throws UnknownHostException {
        ipUsuario = request.getHeader("X-Forwarded-For");
        if (ipUsuario == null || ipUsuario.length() == 0 || "unknown".equalsIgnoreCase(ipUsuario)) {
            ipUsuario = request.getHeader("Proxy-Client-IP");
        }
        if (ipUsuario == null || ipUsuario.length() == 0 || "unknown".equalsIgnoreCase(ipUsuario)) {
            ipUsuario = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ipUsuario == null || ipUsuario.length() == 0 || "unknown".equalsIgnoreCase(ipUsuario)) {
            ipUsuario = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ipUsuario == null || ipUsuario.length() == 0 || "unknown".equalsIgnoreCase(ipUsuario)) {
            ipUsuario = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ipUsuario == null || ipUsuario.length() == 0 || "unknown".equalsIgnoreCase(ipUsuario)) {
            ipUsuario = request.getRemoteAddr();
        }
        return ipUsuario;
    }
    
    public String getRemoteAddr() {
        HttpServletRequest request = (HttpServletRequest) FacesContext
                .getCurrentInstance().getExternalContext().getRequest();
        String ipAddress = request.getHeader("X-FORWARDED-FOR");
        if (ipAddress == null) {
            ipAddress = request.getRemoteAddr();
        }
        return ipAddress;
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

    public String mostrar() {
        VotarController votarController = this.getControllerFactory().getVotarController();
        this.tema = votarController.getTema(id);
        return "votar.xhtml";
    }

    public String process() {
        this.votacion.setNivelStudios(NivelEstudios.valueOf(estudios));
        this.votacion.setValoracion(valor);
        this.votacion.setIpUsuario(getRemoteAddr());
        votarTema();
        return "home.xhtml";
    }

    public void votarTema() {
        VotarController votarController = this.getControllerFactory().getVotarController();
        this.tema = votarController.getTema(this.id);
        this.votacion.setTema(this.tema);
        votarController.votar(votacion);
        LogManager.getLogger(this.getClass().getName()).info("--- Votación realizada ---");
    }

}
