package es.upm.miw.views.beans.jsp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.miw.models.entities.Tema;
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
                
/*
             * case "verVotos":
             * 
             * view = action; break;
             * 
             * case "borrarTema":
             * 
             * view = action; break;
             */
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
        case "votar":

            break;
        case "agregarTema":
            Tema tema = new Tema();
            tema.setNombre(request.getParameter("nombre"));
            tema.setPregunta(request.getParameter("pregunta"));
            System.out.println(tema.getNombre());
            System.out.println(request.getParameter("nombre"));
            AgregarTemaView agregarTemaView = new AgregarTemaView();
            agregarTemaView.setControllerFactory(controllerFactory);
            agregarTemaView.setTema(tema);
            request.setAttribute("agregarTema", agregarTemaView);
            agregarTemaView.agregarTema();
            view = "home";
            break;
        }
        this.getServletContext().getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
                .forward(request, response);
    }

}
