package es.upm.miw.models.daos;

import java.util.List;

import es.upm.miw.models.entities.Tema;
import es.upm.miw.models.entities.Votacion;
import es.upm.miw.models.utils.NivelEstudios;

public interface VotacionDao extends GenericDao<Votacion, Integer>{
	
	void deleteVotosTema(Tema tema);
	
	void deleteTodosVotos();
	
	List<Votacion> consultaVotosPorTema(Tema tema);
	
	double mediaVotosPorTemaNivelEstudio(Tema tema, NivelEstudios nivelEstudios);

}
