package es.upm.miw.views.beans.jsp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.miw.models.entities.Tema;
import es.upm.miw.models.entities.Votacion;
import es.upm.miw.models.utils.NivelEstudios;
import es.upm.miw.controllers.*;
import es.upm.miw.controllersEjb.ControllerEjbFactory;

@WebServlet("/jsp/*")
public class Dispatcher extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static String PATH_ROOT_VIEW = "/pages/jsp/";

    private ControllerFactory controllerFactory;

    @Override
    public void init() throws ServletException {
        controllerFactory = new ControllerEjbFactory();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String view = "home";
        request.setCharacterEncoding("UTF-8");
        if (request.getPathInfo() != null) {
            String action = request.getPathInfo().substring(1);
            System.out.println(action);
            switch (action) {
            case "agregarTema":
                AgregarTemaView agregarTemaView = new AgregarTemaView();
                request.setAttribute("agregarTema", agregarTemaView);
                view = action;
                break;
            case "autorizar":
                AutorizarView autorizarView = new AutorizarView();
                request.setAttribute("autorizar", autorizarView);
                view = action;
                break;
            case "mostrarTemasVotar":
                MostrarTemasView mostrarTemasVotarView = new MostrarTemasView();
                mostrarTemasVotarView.setControllerFactory(controllerFactory);
                request.setAttribute("mostrarTemasVotar", mostrarTemasVotarView);
                mostrarTemasVotarView.mostrarTemasVotar();
                view = action;
                break;
            case "mostrarVotaciones":
                MostrarVotacionesView mostrarVotacionesView = new MostrarVotacionesView();
                mostrarVotacionesView.setControllerFactory(controllerFactory);
                request.setAttribute("mostrarVotos", mostrarVotacionesView);
                mostrarVotacionesView.mostrarVotos();
                view = "mostrarVotaciones";
                break;
            default:
                view = "home";
            }

        }
        System.out.println(PATH_ROOT_VIEW + view + ".jsp");
        this.getServletContext().getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
                .forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getPathInfo().substring(1);
        String view = "home";
        request.setCharacterEncoding("UTF-8");
        switch (action) {
        case "agregarTema":
            Tema tema = new Tema();
            tema.setNombre(request.getParameter("nombre"));
            tema.setPregunta(request.getParameter("pregunta"));
            AgregarTemaView agregarTemaView = new AgregarTemaView();
            agregarTemaView.setControllerFactory(controllerFactory);
            agregarTemaView.setTema(tema);
            request.setAttribute("agregarTema", agregarTemaView);
            agregarTemaView.agregarTema();
            view = "temaAgregado";
            break;
        case "autorizar":
            AutorizarView autorizarView = new AutorizarView();
            autorizarView.setControllerFactory(controllerFactory);
            request.setAttribute("autorizar", autorizarView);
            autorizarView.setCodigo(request.getParameter("codigo"));
            if (autorizarView.autorizar()) {
                MostrarTemasView mostrarTemasView = new MostrarTemasView();
                mostrarTemasView.setControllerFactory(controllerFactory);
                request.setAttribute("mostrarTemasBorrar", mostrarTemasView);
                mostrarTemasView.mostrarTemas();
                view = "mostrarTema";
            } else {
                view = "noAutorizado";
            }
            break;
        case "eliminarTema":
            EliminarTemaView eliminarTemaView = new EliminarTemaView();
            eliminarTemaView.setId(Integer.parseInt(request.getParameter("id")));
            eliminarTemaView.setControllerFactory(controllerFactory);
            request.setAttribute("eliminarTemas", eliminarTemaView);
            eliminarTemaView.eliminarTema();
            view = "temaEliminado";
            break;
        case "mostrarFormularioVotacion":
            VotarTemaView votarTemaView = new VotarTemaView();
            votarTemaView.setControllerFactory(controllerFactory);
            votarTemaView.setId(Integer.valueOf(request.getParameter("tema")));
            request.setAttribute("mostrarTema", votarTemaView);
            votarTemaView.mostrar();
            view = "votar";
            break;
        case "votar":
            Votacion votacion = new Votacion();
            VotarTemaView votarTemaView2 = new VotarTemaView();
            votarTemaView2.setId(Integer.parseInt(request.getParameter("id")));
            votarTemaView2.setControllerFactory(controllerFactory);
            votacion.setNivelStudios(NivelEstudios.valueOf(request.getParameter("nivelEstudios")));
            votacion.setValoracion(Integer.parseInt(request.getParameter("valoracion")));
            votacion.setIpUsuario(votarTemaView2.getIpUsuario(request));
            votarTemaView2.setVotacion(votacion);
            request.setAttribute("votarTema", votarTemaView2);
            votarTemaView2.votarTema();
            view = "temaVotado";
            break;
        }
        this.getServletContext().getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
                .forward(request, response);
    }
}
