package es.upm.miw.models.daos.jpa;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.Root;

import es.upm.miw.models.daos.VotacionDao;
import es.upm.miw.models.entities.Tema;
import es.upm.miw.models.entities.Votacion;

public class VotacionDaoJpa extends GenericDaoJpa<Votacion, Integer> implements VotacionDao {
	
	private EntityManager entityManager;

	public VotacionDaoJpa() {
		super(Votacion.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void deleteVotosTema(Tema tema) {
		CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
		CriteriaDelete<Votacion> delete = criteria.createCriteriaDelete(Votacion.class);
		Root e  = delete.from(Votacion.class);
		delete.where(criteria);
		
	}

}
