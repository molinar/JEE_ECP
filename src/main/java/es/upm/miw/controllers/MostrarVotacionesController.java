package es.upm.miw.controllers;

import java.util.List;

import es.upm.miw.models.utils.RecopilacionVotos;

public interface MostrarVotacionesController extends ListarTemasController{
	
	List<RecopilacionVotos> listarVotaciones();

}
