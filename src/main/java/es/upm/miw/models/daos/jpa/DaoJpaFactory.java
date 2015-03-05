package es.upm.miw.models.daos.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;

import es.upm.miw.models.daos.DaoFactory;
import es.upm.miw.models.daos.TemaDao;
import es.upm.miw.models.daos.VotacionDao;

public class DaoJpaFactory extends DaoFactory{
	
	private static final String PERSISTENCE_UNIT = "votaciones";

	private static EntityManagerFactory entityManagerFactory = Persistence
            .createEntityManagerFactory(PERSISTENCE_UNIT);
	
	public DaoJpaFactory() {
        LogManager.getLogger(DaoJpaFactory.class).debug("create Entity Manager Factory");
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

	@Override
	public TemaDao getTemaDao() {
		// TODO Auto-generated method stub
		return new TemaDaoJpa();
	}

	@Override
	public VotacionDao getVotacionDao() {
		// TODO Auto-generated method stub
		return new VotacionDaoJpa();
	}

}
