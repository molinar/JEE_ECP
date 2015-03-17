package es.upm.miw.controllers;

import es.upm.miw.models.entities.Votacion;

public interface VotarController extends ListarTemasController {

	void votar(Votacion votacion);
}
