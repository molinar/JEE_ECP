package es.upm.miw.controllersEjb;

import java.util.ArrayList;
import java.util.List;

import es.upm.miw.controllers.MostrarVotacionesController;
import es.upm.miw.models.daos.TemaDao;
import es.upm.miw.models.daos.VotacionDao;
import es.upm.miw.models.daos.jpa.DaoJpaFactory;
import es.upm.miw.models.entities.Tema;
import es.upm.miw.models.utils.NivelEstudios;
import es.upm.miw.models.utils.RecopilacionMedias;
import es.upm.miw.models.utils.RecopilacionVotos;

public class MostrarVotacionesControllerEjb extends ListarTemasControllerEjb implements MostrarVotacionesController {

	@Override
	public List<RecopilacionVotos> listarVotaciones() {
		VotacionDao votacionDao = DaoJpaFactory.getFactory().getVotacionDao();
		TemaDao temaDao = DaoJpaFactory.getFactory().getTemaDao();
		List<RecopilacionVotos> recopilacionVotos = new ArrayList<RecopilacionVotos>();
		List<Tema> temas = temaDao.findAll();
	    for(Tema tema : temas){
	        RecopilacionVotos votos = new RecopilacionVotos();
	        votos.setTema(tema);
	        votos.setNumeroVotos(votacionDao.consultaVotosPorTema(tema).size());
	        for(NivelEstudios nivelEstudios : NivelEstudios.values()){
	            RecopilacionMedias medias = new RecopilacionMedias();
	            medias.setNivelEstudios(nivelEstudios);
	            medias.setMediaVotos(votacionDao.mediaVotosPorTemaNivelEstudio(tema, nivelEstudios));
	            votos.getRecopilacionMedias().add(medias);
	        }
	        recopilacionVotos.add(votos);
	    }
	    return recopilacionVotos;
	}
}