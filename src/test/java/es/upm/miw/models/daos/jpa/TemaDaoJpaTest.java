package es.upm.miw.models.daos.jpa;

import org.junit.Before;

import es.upm.miw.models.daos.TemaDao;

public class TemaDaoJpaTest {
	
	private TemaDao dao = DaoJpaFactory.getFactory().getTemaDao();
	
	private TemaDaoJpaTestData data;
	
	@Before
	public voud init(){
		data = new TemaDaoJpaTest();
	} 
	
	

}
