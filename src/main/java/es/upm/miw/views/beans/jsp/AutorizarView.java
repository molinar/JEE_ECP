package es.upm.miw.views.beans.jsp;

import org.apache.logging.log4j.LogManager;

import es.upm.miw.controllers.EliminarTemaController;

public class AutorizarView extends ViewBean{
	
	String codigo;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void autorizar() {
		EliminarTemaController eliminarTemaController = this.getControllerFactory().getEliminarTemaController();
		eliminarTemaController.autorizar(codigo);
		LogManager.getLogger(this.getClass().getName()).info("--- Autorización pedida ---");
	}
}
