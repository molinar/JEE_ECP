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
	
	private EliminarTemaController eliminarTemaController;
	
	private AgregarTemaController agregarTemaController;
	
	private VotarController votarController;
	
	private MostrarVotacionesController mostrarVotacionesController;

	@Override
	public EliminarTemaController getEliminarTemaController() {
        if (eliminarTemaController == null) {
        	eliminarTemaController = new EliminarTemaControllerEjb();
        }
        return eliminarTemaController;
	}

	@Override
	public AgregarTemaController getAgregarTemaController() {
        if (agregarTemaController == null) {
        	agregarTemaController = new AgregarTemaControllerEjb();
        }
        return agregarTemaController;
	}

	@Override
	public VotarController getVotarController() {
        if (votarController == null) {
        	votarController = new VotarControllerEjb();
        }
        return votarController;
	}

	@Override
	public MostrarVotacionesController getMostrarVotacionesController() {
        if (mostrarVotacionesController == null) {
        	mostrarVotacionesController = new MostrarVotacionesControllerEjb();
        }
        return mostrarVotacionesController;
	}

}
