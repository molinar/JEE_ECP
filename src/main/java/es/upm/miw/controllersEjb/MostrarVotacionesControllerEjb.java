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
		List<RecopilacionMedias> recopilacionMedias = new ArrayList<RecopilacionMedias>();
		for(int i=0; i>= temas.size(); i++){
			RecopilacionVotos votos = new RecopilacionVotos();
			votos.setTema(temas.get(i));
			votos.setNumeroVotos(votacionDao.consultaVotosPorTema(temas.get(i)).size());
			for(NivelEstudios nivelEstudios : NivelEstudios.values()){
				RecopilacionMedias medias = new RecopilacionMedias();
				medias.setNivelEstudios(nivelEstudios);
				medias.setMediaVotos(votacionDao.mediaVotosPorTemaNivelEstudio(temas.get(i), nivelEstudios));
				recopilacionMedias.add(medias);
			}
			votos.setRecopilacionMedias(recopilacionMedias);
			recopilacionVotos.add(votos);
		}
		return recopilacionVotos;
	}
}