package es.upm.miw.controllersEjb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import es.upm.miw.controllers.AgregarTemaController;
import es.upm.miw.controllers.ControllerFactory;
import es.upm.miw.controllers.EliminarTemaController;
import es.upm.miw.controllers.MostrarVotacionesController;
import es.upm.miw.controllers.VotarController;

@ManagedBean(name = "controllerFactory")
@SessionScoped
public class ControllerEjbFactory extends ControllerFactory {

	@Override
	public EliminarTemaController getEliminarTemaController() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AgregarTemaController getAgregarTemaController() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VotarController getVotarController() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MostrarVotacionesController getMostrarVotacionesController() {
		// TODO Auto-generated method stub
		return null;
	}

}
