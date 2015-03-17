package es.upm.miw.controllersEjb;

import java.util.List;

import es.upm.miw.controllers.ListarTemasController;
import es.upm.miw.models.daos.TemaDao;
import es.upm.miw.models.daos.jpa.DaoJpaFactory;
import es.upm.miw.models.entities.Tema;

public class ListarTemasControllerEjb implements ListarTemasController{

	@Override
	public List<Tema> listarTemas() {
		TemaDao temaDao = DaoJpaFactory.getFactory().getTemaDao();
		return temaDao.findAll();
	}
}
