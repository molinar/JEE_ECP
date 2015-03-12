package es.upm.miw.models.daos;

import es.upm.miw.models.entities.Tema;
import es.upm.miw.models.entities.Votacion;

public interface VotacionDao extends GenericDao<Votacion, Integer>{
	
	void deleteVotosTema(Tema tema);
	
	void deleteTodosVotos();

}
