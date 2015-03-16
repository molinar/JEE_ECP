package es.upm.miw.views.beans.jsp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.miw.models.entities.Tema;

import es.upm.miw.controllers.*;

@WebServlet("/jsp/*")
public class Dispatcher extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static String PATH_ROOT_VIEW = "/pages/jsp/";
    
    private ControllerFactory controllerFactory;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String view = "home";
        request.setCharacterEncoding("UTF-8");
        if (request.getPathInfo() != null) {
            String action = request.getPathInfo().substring(1);
            switch (action) {
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
            AgregarTemaView agregarTemaView = new AgregarTemaView();
            agregarTemaView.setControllerFactory(controllerFactory);
            request.setAttribute(action, agregarTemaView);
            view = agregarTemaView.process();

            break;
        }
        this.getServletContext().getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
                .forward(request, response);
    }

}
