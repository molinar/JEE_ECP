package es.upm.miw.controllersEjb;

import es.upm.miw.controllers.VotarController;
import es.upm.miw.models.daos.VotacionDao;
import es.upm.miw.models.daos.jpa.DaoJpaFactory;
import es.upm.miw.models.entities.Votacion;

public class VotarControllerEjb extends ListarTemasControllerEjb implements VotarController {

	@Override
	public void votar(Votacion votacion) {
		VotacionDao votacionDao = DaoJpaFactory.getFactory().getVotacionDao();
		votacionDao.create(votacion);
	}

}
