package es.upm.miw.models.daos.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import es.upm.miw.models.daos.VotacionDao;
import es.upm.miw.models.entities.Tema;
import es.upm.miw.models.entities.Votacion;
import es.upm.miw.models.utils.NivelEstudios;

public class VotacionDaoJpa extends GenericDaoJpa<Votacion, Integer> implements VotacionDao {

    private EntityManager entityManager = DaoJpaFactory.getEntityManagerFactory().createEntityManager();
    
	public VotacionDaoJpa() {
		super(Votacion.class);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void deleteVotosTema(Tema tema) { 
	    CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
		CriteriaDelete<Votacion> delete = criteria.createCriteriaDelete(Votacion.class);
		Root<Votacion> e  = delete.from(Votacion.class);
		delete.where(criteria.equal(e.get("tema"),tema));
		entityManager.getTransaction().begin();
		entityManager.createQuery(delete).executeUpdate();
		entityManager.getTransaction().commit();
	}

    @Override
    public void deleteTodosVotos() {
        CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
        CriteriaDelete<Votacion> delete = criteria.createCriteriaDelete(Votacion.class);
        entityManager.getTransaction().begin();
        entityManager.createQuery(delete).executeUpdate();
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Votacion> consultaVotosPorTema(Tema tema) { 
        CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
        CriteriaQuery<Votacion> query = criteria.createQuery(Votacion.class);
        Root<Votacion> rootVotacion = query.from(Votacion.class);
        query.where(criteria.equal(rootVotacion.get("tema"),tema));
        TypedQuery<Votacion> votacionQuery = entityManager.createQuery(query);
        return votacionQuery.getResultList();
    }

    @Override
    public double mediaVotosPorTemaNivelEstudio(Tema tema, NivelEstudios nivelEstudios) {
        // TODO Auto-generated method stub
        return 0;
    }
}
