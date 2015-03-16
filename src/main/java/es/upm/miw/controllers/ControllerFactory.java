package es.upm.miw.controllers;

public interface ControllerFactory {
	
	public abstract EliminarTemaController getEliminarTemaController();
	
	public abstract AgregarTemaController getAgregarTemaController();
	
	public abstract VotarController getVotarController();
	
	public abstract MostrarVotacionesController getMostrarVotacionesController();	

}
