package es.upm.miw.controllersEjb;

import es.upm.miw.controllers.AgregarTemaController;
import es.upm.miw.models.daos.TemaDao;
import es.upm.miw.models.daos.jpa.DaoJpaFactory;
import es.upm.miw.models.entities.Tema;

public class AgregarTemaControllerEjb implements AgregarTemaController {

	@Override
	public void agregarTema(Tema tema) {
		TemaDao temaDao = DaoJpaFactory.getFactory().getTemaDao();
		temaDao.create(tema);		
	}
}
