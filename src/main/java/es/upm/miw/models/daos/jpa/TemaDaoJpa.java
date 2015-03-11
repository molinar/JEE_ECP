package es.upm.miw.models.daos.jpa;

import es.upm.miw.models.daos.DaoFactory;
import es.upm.miw.models.daos.TemaDao;
import es.upm.miw.models.daos.VotacionDao;
import es.upm.miw.models.entities.Tema;

public class TemaDaoJpa extends GenericDaoJpa<Tema, Integer> implements TemaDao {

    public TemaDaoJpa() {
		super(Tema.class);
		// TODO Auto-generated constructor stub
	}

    @Override //Revisar, algo va mal
    public void deleteById(Integer id) {
        Tema tema = this.read(id);
        if(tema != null){
            DaoFactory.setFactory(new DaoJpaFactory());
            VotacionDao dao = DaoJpaFactory.getFactory().getVotacionDao();
            dao.deleteVotosTema(tema);
            super.deleteById(id);    
        } 
    }	
}
