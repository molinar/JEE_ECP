package es.upm.miw.views.beans.jsp;

import javax.faces.bean.ManagedBean;

import org.apache.logging.log4j.LogManager;

import es.upm.miw.controllers.EliminarTemaController;

@ManagedBean
public class AutorizarView extends ViewBean {

	private String codigo;

	public AutorizarView() {
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public boolean autorizar() {
		EliminarTemaController eliminarTemaController = this
				.getControllerFactory().getEliminarTemaController();
		LogManager.getLogger(this.getClass().getName()).info(
				"--- Autorización pedida ---");
		return eliminarTemaController.autorizar(codigo);
	}

	public String process(){
	    if(autorizar()){	    
	        return "mostrarTema.xhtml";
	    }else{
	        return "noAutorizado.xhtml";
	    }
	}
}
