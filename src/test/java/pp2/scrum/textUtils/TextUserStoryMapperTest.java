package pp2.scrum.textUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import pp2.scrum.dominio.entidad.UserStory;
import pp2.scrum.dominio.entidad.UserStoryMapper;
import pp2.scrum.textUtils.TextUserStoryMapper;


public class TextUserStoryMapperTest extends TestCase {
	UserStoryMapper usMapper;
	UserStoryMapper usMapperDefault;
	
	File f ;
	
	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public TextUserStoryMapperTest( String testName ) {
	    super( testName );
	}
	
	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
	    return new TestSuite( TextUserStoryMapperTest.class );
	}
	
	public void  setUp() {
		try {
			f = new File(System.getProperty("user.home")+"/historiasTest.dat");
			if ( f.exists() ) f.delete();
			usMapperDefault = new TextUserStoryMapper();
			usMapper = new TextUserStoryMapper("historiasTest.dat");
			
		} catch (RuntimeException | IOException e) {
		}
	}
	
	/**
	 * Verifico el texto logueado
	 */
	public void testMapper() {
			long id=usMapper.getNextID();
			assertEquals(id,1);
			assertTrue(usMapper.getBacklog().isEmpty());
			String titulo = "como ROL necesito ...",
				   detalle = "Detalle de la;  jajaj \nnecesidad",
				   autor = "Jose";
			UserStory us = new UserStory(id,titulo, detalle, autor);
			usMapper.insert(us);
			List<UserStory> stories = usMapper.getBacklog(); 
			assertEquals(usMapper.getNextID(),2);
			assertEquals(stories.size(),1);
			
			UserStory readStory = stories.get(0);
			assertEquals(readStory.getId(), id);
			assertEquals(readStory.getTitulo(), titulo );
			assertEquals(readStory.getDetalle(), detalle );
			//assertEquals(readStory.getAutor(), autor );
			//System.out.println("ID="+readStory.getId()+"|Titulo="+readStory.getTitulo()+"|Detalle="+readStory.getDetalle());			
	}
	
	/**
	 * Verifico que se genere un  cuando el filePath es un directorio
	 */
	public void testMapperDir() {
		f.delete();
		f.mkdir();
		
		try {
			UserStoryMapper usMapper = new TextUserStoryMapper("historiasTest.dat");
		} catch (RuntimeException e) {
			
		} catch (IOException e) {
			fail("no se genero la excepcion cuando el path corresponde a un directorio");
		}
	}
}