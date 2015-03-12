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

public class VotacionDaoJpaTest {
    
    private TemaDao temaDao = DaoJpaFactory.getFactory().getTemaDao();
    private VotacionDao votacionDao = DaoJpaFactory.getFactory().getVotacionDao();
    
    private Tema tema;
    private Votacion v1, v2;
    
    @BeforeClass 
    public static void beforeClass(){
        DaoFactory.setFactory(new DaoJpaFactory());
        DaoJpaFactory.prepareFactoryWithDropAndCreateTables();
    }
    
    @Before
    public void init(){
        this.tema = new Tema("Tema 1", "Pregunta 1");
        temaDao.create(this.tema);
        this.v1 = new Votacion("ip1", NivelEstudios.EDUCACION_PRIMARIA, 3, tema);
        this.v2 = new Votacion("ip2", NivelEstudios.ESTUDIOS_DOCTORADO, 5, tema);
        votacionDao.create(v1);
        votacionDao.create(v2);
    }
    
    @Test
    public void testCreateVotacion(){
        Votacion v3 = new Votacion("ip3", NivelEstudios.EDUCACION_SECUNDARIA, 4, tema);
        votacionDao.create(v3);
        assertEquals(v3, votacionDao.read(v3.getId()));
    }
    
    @Test
    public void testReadVotacion(){
        assertEquals(this.v1, votacionDao.read(v1.getId()));
    }
    
    @Test
    public void testUpdateVotacion(){
        this.v2.setValoracion(4);
        votacionDao.update(v2);
        assertEquals(v2.getValoracion(), votacionDao.read(v2.getId()).getValoracion());
    }
    
    @Test
    public void testDeleteTemaByID() {
        votacionDao.deleteById(this.v2.getId());
        assertNull(votacionDao.read(this.v2.getId()));
    }
    
    @Test
    public void testFindAll() {
        assertEquals(2, votacionDao.findAll().size());
    }
    
    @After
    public void after(){ 
        votacionDao.deleteTodosVotos();
        temaDao.deleteTodosTemas();
    }

}
