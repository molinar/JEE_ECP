package es.upm.miw.views.beans.jsp;

import org.apache.logging.log4j.LogManager;

import es.upm.miw.controllers.EliminarTemaController;

public class AutorizarView extends ViewBean{
	
	private String codigo;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public boolean autorizar() {
		EliminarTemaController eliminarTemaController = this.getControllerFactory().getEliminarTemaController();
		LogManager.getLogger(this.getClass().getName()).info("--- Autorización pedida ---");
		return eliminarTemaController.autorizar(codigo);
	}
}
