package es.upm.miw.controllers;

import java.util.List;

import es.upm.miw.models.entities.Votacion;

public interface MostrarVotacionesController extends ListarTemasController{
	
	List<Votacion> listarVotaciones();

}
