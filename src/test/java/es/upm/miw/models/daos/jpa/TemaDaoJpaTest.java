package es.upm.miw.models.daos.jpa;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.upm.miw.models.daos.DaoFactory;
import es.upm.miw.models.daos.TemaDao;
import es.upm.miw.models.entities.Tema;

public class TemaDaoJpaTest {
	
	private TemaDao dao = DaoJpaFactory.getFactory().getTemaDao();
	
	private Tema tema;
	
	@BeforeClass 
	public static void beforeClass(){
	    DaoFactory.setFactory(new DaoJpaFactory());
	    DaoJpaFactory.prepareFactoryWithDropAndCreateTables();
	}
	
	@Before
	public void init(){
	    this.tema = new Tema("Tema 1", "Pregunta 1");
	    dao.create(this.tema);
	}
	
	@Test
	public void testCreateTema(){
        Tema t2 = new Tema("Tema 2", "Pregunta 2");
        dao.create(t2);
		assertEquals(t2, dao.read(t2.getId()));
	}
	
	@Test
	public void testReadTema() {
	    assertEquals(this.tema, dao.read(this.tema.getId()));
	}
	
	@Test
	public void testUpdateTema() {
	    this.tema.setNombre("Primer Tema");
	    dao.update(this.tema);
	    assertEquals(this.tema.getNombre(), dao.read(this.tema.getId()).getNombre());		
	}
	
	@Test
	public void testDeleteTemaByID() {
		dao.deleteById(this.tema.getId());
		assertNull(dao.read(this.tema.getId()));
	}
	
	@Test
    public void testFindAll() {
	    dao.create(new Tema("Tema 3", "Pregunta 3"));
	    assertEquals(2, dao.findAll().size());
	}
	
	@After
	public void after(){
        DaoJpaFactory.prepareFactoryWithDropAndCreateTables();
	}
	

}
