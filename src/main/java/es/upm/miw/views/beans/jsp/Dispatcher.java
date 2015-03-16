package es.upm.miw.views.beans.jsp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jsp/*")
public class Dispatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String PATH_ROOT_VIEW = "/pages/jsp/";

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String view = "home";
		System.out.println(request.getPathInfo());
		
		if (request.getPathInfo() != null) {
			String action = request.getPathInfo().substring(1);
			switch (action) {
			case "verTemas":
				VerTemasView verTemasView = new VerTemasView();
				request.setAttribute(action, verTemasView);
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

		this.getServletContext()
				.getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
				.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo().substring(1);
		String view = "home";
		switch (action) {
		case "votar":

			break;
		case "agregarTema":

			break;
		}
		this.getServletContext()
				.getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
				.forward(request, response);
	}

}
