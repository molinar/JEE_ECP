package es.upm.miw.controllersEjb;

import es.upm.miw.controllers.EliminarTemaController;
import es.upm.miw.models.daos.TemaDao;
import es.upm.miw.models.daos.jpa.DaoJpaFactory;

public class EliminarTemaControllerEjb implements EliminarTemaController {

    @Override
    public void eliminarTema(Integer id) {
        TemaDao temaDao = DaoJpaFactory.getFactory().getTemaDao();
        temaDao.deleteById(id);
    }

}
