package es.upm.miw.views.beans.jsp;

import org.apache.logging.log4j.LogManager;

import es.upm.miw.controllers.EliminarTemaController;

public class EliminarTemaView extends ViewBean{
	
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
    public void eliminarTema() {
    	EliminarTemaController eliminarTemaController = this.getControllerFactory()
                .getEliminarTemaController();
        eliminarTemaController.eliminarTema(id);
        LogManager.getLogger(this.getClass().getName()).info("--- Tema eliminado ---");
    }




}
