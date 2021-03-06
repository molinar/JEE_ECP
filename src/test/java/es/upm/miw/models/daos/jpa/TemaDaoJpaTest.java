package es.upm.miw.models.daos.jpa;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.upm.miw.models.daos.DaoFactory;
import es.upm.miw.models.daos.TemaDao;
import es.upm.miw.models.daos.VotacionDao;
import es.upm.miw.models.entities.Tema;
import es.upm.miw.models.entities.Votacion;
import es.upm.miw.models.utils.NivelEstudios;

public class TemaDaoJpaTest {
	
	private TemaDao dao = DaoJpaFactory.getFactory().getTemaDao();
	private VotacionDao votacionDao = DaoJpaFactory.getFactory().getVotacionDao();
	
	private Tema tema;
	private Votacion v1, v2, v3;
	
	@BeforeClass 
	public static void beforeClass(){
	    DaoFactory.setFactory(new DaoJpaFactory());
	    DaoJpaFactory.prepareFactoryWithDropAndCreateTables();
	}
	
	@Before
	public void init(){
	    this.tema = new Tema("Tema 1", "Pregunta 1");
	    dao.create(this.tema);
	    this.v1 = new Votacion("ip1", NivelEstudios.EDUCACION_PRIMARIA, 3, tema);
	    this.v2 = new Votacion("ip2", NivelEstudios.ESTUDIOS_DOCTORADO, 5, tema);
	    this.v3 = new Votacion("ip3", NivelEstudios.EDUCACION_SECUNDARIA, 4, tema);
	    votacionDao.create(v1);
	    votacionDao.create(v2);
	    votacionDao.create(v3);
	}
	
	@Test
	public void testCreateTema(){
        Tema t2 = new Tema("Tema 2", "Pregunta 2");
        dao.create(t2);
        Votacion v4 = new Votacion("ip4", NivelEstudios.EDUCACION_SECUNDARIA, 4, t2);
        votacionDao.create(v4);
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
		assertNull(votacionDao.read(this.v1.getId()));
		assertNull(votacionDao.read(this.v2.getId()));
		assertNull(votacionDao.read(this.v3.getId()));
	}
	
	@Test
    public void testFindAll() {
	    dao.create(new Tema("Tema 3", "Pregunta 3"));
	    dao.create(new Tema("Tema 3", "Pregunta 3"));
	    dao.create(new Tema("Tema 3", "Pregunta 4"));
	    dao.create(new Tema("Tema 4", "Pregunta 4"));
	    assertEquals(3, dao.findAll().size());
	}
	
	@After
	public void after(){ 
	    votacionDao.deleteTodosVotos();
	    dao.deleteTodosTemas();
	}
	

}
