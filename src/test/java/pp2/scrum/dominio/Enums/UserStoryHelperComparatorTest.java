package pp2.scrum.dominio.Enums;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import pp2.scrum.controller.UserStoryHelper;
import pp2.scrum.dominio.Estado;
import pp2.scrum.dominio.entidad.Miembro;
import pp2.scrum.dominio.entidad.UserStory;
import pp2.scrum.utils.UserStoryHelperComparator;


public class UserStoryHelperComparatorTest extends TestCase {
	List<UserStoryHelper> stories;
	Miembro miembro1
	   ,miembro2
	   ,miembro3
	   ,miembro4
	   ;
	UserStory userStory1
			 ,userStory2
			 ,userStory3
			 ,userStory4
			 ;
	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public UserStoryHelperComparatorTest( String testName ) {
	    super( testName );
	}
	
	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
	    return new TestSuite( UserStoryHelperComparatorTest.class );
	}
	
	public void  setUp() {
		stories = new ArrayList<UserStoryHelper>();
		miembro1 = new Miembro("Victoria");
		miembro2 = new Miembro("Ivo");
		miembro3 = new Miembro("Jualian");
		miembro4 = new Miembro("Nores");
		
		userStory1 =  new UserStory("Como Recepcionista ...", "Detalle1", "Autor1");
		userStory1.setId(1);
		userStory1.setEstado(Estado.Done);
		userStory2 =  new UserStory("Como Administrador ...", "Detalle2", "Autor2");
		userStory2.setId(2);
		userStory2.setEstado(Estado.Doing);
		userStory3 =  new UserStory("Como Gerente ...", "Detalle3", "Autor3");
		userStory3.setId(3);
		userStory3.setEstado(Estado.ToDo);
		userStory4 =  new UserStory("Como Vendedor ...", "Detalle4", "Autor4");
		userStory4.setId(4);
		userStory4.setEstado(Estado.ToDo);
		
		stories.add(new UserStoryHelper(userStory3, miembro2));
		stories.add(new UserStoryHelper(userStory2, miembro1));
		stories.add(new UserStoryHelper(userStory4, miembro4));
		stories.add(new UserStoryHelper(userStory1, miembro3));
	}
	
	/**
	 * Verifico El orden en que estan cargadas
	 */
	public void testUserStoryHelperComparator() {
		UserStoryHelper ush = stories.get(0);
		assertEquals(ush.getId(),userStory3.getId());
		assertEquals(ush.getResponsable(),miembro2.getNombre());
		
		ush = stories.get(1);
		assertEquals(ush.getId(),userStory2.getId());
		assertEquals(ush.getResponsable(),miembro1.getNombre());

		ush = stories.get(2);
		assertEquals(ush.getId(),userStory4.getId());
		assertEquals(ush.getResponsable(),miembro4.getNombre());

		ush = stories.get(3);
		assertEquals(ush.getId(),userStory1.getId());
		assertEquals(ush.getResponsable(),miembro3.getNombre());
		
	}
	
	/**
	 * Verifico que Se ordenen por ID
	 */
	public void testUserStoryHelperComparatorById() {
		Collections.sort(stories, UserStoryHelperComparator.NUMERO_SORT);
		UserStoryHelper ush;
		
		assertEquals(UserStoryHelperComparator.NUMERO_SORT.toString(),"Número");
		
		ush = stories.get(0);
		assertEquals(ush.getId(),userStory1.getId());
		assertEquals(ush.getResponsable(),miembro3.getNombre());

		ush = stories.get(1);
		assertEquals(ush.getId(),userStory2.getId());
		assertEquals(ush.getResponsable(),miembro1.getNombre());

		ush = stories.get(2);
		assertEquals(ush.getId(),userStory3.getId());
		assertEquals(ush.getResponsable(),miembro2.getNombre());
		
		ush = stories.get(3);
		assertEquals(ush.getId(),userStory4.getId());
		assertEquals(ush.getResponsable(),miembro4.getNombre());		
	}
	
	/**
	 * Verifico que Se ordenen por ID
	 */
	public void testUserStoryHelperComparatorByIdDesc() {
		Collections.sort(stories, UserStoryHelperComparator.decending(UserStoryHelperComparator.NUMERO_SORT ));
		UserStoryHelper ush;
		
		assertEquals(UserStoryHelperComparator.NUMERO_SORT.toString(),"Número");
		
		ush = stories.get(3);
		assertEquals(ush.getId(),userStory1.getId());
		assertEquals(ush.getResponsable(),miembro3.getNombre());

		ush = stories.get(2);
		assertEquals(ush.getId(),userStory2.getId());
		assertEquals(ush.getResponsable(),miembro1.getNombre());

		ush = stories.get(1);
		assertEquals(ush.getId(),userStory3.getId());
		assertEquals(ush.getResponsable(),miembro2.getNombre());
		
		ush = stories.get(0);
		assertEquals(ush.getId(),userStory4.getId());
		assertEquals(ush.getResponsable(),miembro4.getNombre());		
	}
	
	/**
	 * Verifico que Se ordenen por titulo
	 */
	public void testUserStoryHelperComparatorByTitulo() {
		Collections.sort(stories, UserStoryHelperComparator.TITULO_SORT);
		UserStoryHelper ush;
		

		assertEquals(UserStoryHelperComparator.TITULO_SORT.toString(),"Título");
		
		ush = stories.get(0);
		assertEquals(ush.getId(),userStory2.getId());
		assertEquals(ush.getResponsable(),miembro1.getNombre());

		ush = stories.get(1);
		assertEquals(ush.getId(),userStory3.getId());
		assertEquals(ush.getResponsable(),miembro2.getNombre());

		ush = stories.get(2);
		assertEquals(ush.getId(),userStory1.getId());
		assertEquals(ush.getResponsable(),miembro3.getNombre());
		
		ush = stories.get(3);
		assertEquals(ush.getId(),userStory4.getId());
		assertEquals(ush.getResponsable(),miembro4.getNombre());		
	}
	
	/**
	 * Verifico que Se ordenen por titulo desc
	 */
	public void testUserStoryHelperComparatorByTituloDesc() {
		Collections.sort(stories, UserStoryHelperComparator.decending(UserStoryHelperComparator.TITULO_SORT) );
		UserStoryHelper ush;
		
		assertEquals(UserStoryHelperComparator.TITULO_SORT.toString(),"Título");
		
		ush = stories.get(3);
		assertEquals(ush.getId(),userStory2.getId());
		assertEquals(ush.getResponsable(),miembro1.getNombre());

		ush = stories.get(2);
		assertEquals(ush.getId(),userStory3.getId());
		assertEquals(ush.getResponsable(),miembro2.getNombre());

		ush = stories.get(1);
		assertEquals(ush.getId(),userStory1.getId());
		assertEquals(ush.getResponsable(),miembro3.getNombre());
		
		ush = stories.get(0);
		assertEquals(ush.getId(),userStory4.getId());
		assertEquals(ush.getResponsable(),miembro4.getNombre());		
	}
	
	/**
	 * Verifico que Se ordenen por Estado y ID
	 */
	public void testUserStoryHelperComparatorByEstado() {
		Collections.sort(stories, UserStoryHelperComparator.getComparator( UserStoryHelperComparator.ESTADO_SORT ) );
		Collections.sort(stories, UserStoryHelperComparator.getComparator( UserStoryHelperComparator.ESTADO_SORT, UserStoryHelperComparator.NUMERO_SORT) );
		UserStoryHelper ush;
		
		assertEquals(UserStoryHelperComparator.ESTADO_SORT.toString(),"Estado");
		
		ush = stories.get(0);
		assertEquals(ush.getId(),userStory3.getId());
		assertEquals(ush.getResponsable(),miembro2.getNombre());

		ush = stories.get(1);
		assertEquals(ush.getId(),userStory4.getId());
		assertEquals(ush.getResponsable(),miembro4.getNombre());

		ush = stories.get(2);
		assertEquals(ush.getId(),userStory2.getId());
		assertEquals(ush.getResponsable(),miembro1.getNombre());
		
		ush = stories.get(3);
		assertEquals(ush.getId(),userStory1.getId());
		assertEquals(ush.getResponsable(),miembro3.getNombre());		
	}

	/**
	 * Verifico que Se ordenen por Estado y ID Desc
	 */
	public void testUserStoryHelperComparatorByEstadoDesc() {
		Collections.sort(stories, UserStoryHelperComparator.decending(UserStoryHelperComparator.getComparator( UserStoryHelperComparator.ESTADO_SORT, UserStoryHelperComparator.NUMERO_SORT) ) );
		UserStoryHelper ush;
		
		assertEquals(UserStoryHelperComparator.ESTADO_SORT.toString(),"Estado");
		
		ush = stories.get(3);
		assertEquals(ush.getId(),userStory3.getId());
		assertEquals(ush.getResponsable(),miembro2.getNombre());

		ush = stories.get(2);
		assertEquals(ush.getId(),userStory4.getId());
		assertEquals(ush.getResponsable(),miembro4.getNombre());

		ush = stories.get(1);
		assertEquals(ush.getId(),userStory2.getId());
		assertEquals(ush.getResponsable(),miembro1.getNombre());
		
		ush = stories.get(0);
		assertEquals(ush.getId(),userStory1.getId());
		assertEquals(ush.getResponsable(),miembro3.getNombre());		
	}
	
	/**
	 * Verifico que Se ordenen por Responsable y ID
	 */
	public void testUserStoryHelperComparatorByResponsable() {
		Collections.sort(stories, UserStoryHelperComparator.getComparator( UserStoryHelperComparator.RESPONSABLE_SORT, UserStoryHelperComparator.NUMERO_SORT) );
		UserStoryHelper ush;
		
		assertEquals(UserStoryHelperComparator.RESPONSABLE_SORT.toString(),"Responsable");
		
		ush = stories.get(0);
		assertEquals(ush.getId(),userStory3.getId());
		assertEquals(ush.getResponsable(),miembro2.getNombre());

		ush = stories.get(1);
		assertEquals(ush.getId(),userStory1.getId());
		assertEquals(ush.getResponsable(),miembro3.getNombre());

		ush = stories.get(2);
		assertEquals(ush.getId(),userStory4.getId());
		assertEquals(ush.getResponsable(),miembro4.getNombre());
		
		ush = stories.get(3);
		assertEquals(ush.getId(),userStory2.getId());
		assertEquals(ush.getResponsable(),miembro1.getNombre());		
	}
	

	/**
	 * Verifico que Se ordenen por Responsable y ID Desc
	 */
	public void testUserStoryHelperComparatorByResponsableDesc() {
		Collections.sort(stories, UserStoryHelperComparator.decending( UserStoryHelperComparator.getComparator( UserStoryHelperComparator.RESPONSABLE_SORT, UserStoryHelperComparator.NUMERO_SORT) ) );
		UserStoryHelper ush;
		
		assertEquals(UserStoryHelperComparator.RESPONSABLE_SORT.toString(),"Responsable");
		
		ush = stories.get(3);
		assertEquals(ush.getId(),userStory3.getId());
		assertEquals(ush.getResponsable(),miembro2.getNombre());

		ush = stories.get(2);
		assertEquals(ush.getId(),userStory1.getId());
		assertEquals(ush.getResponsable(),miembro3.getNombre());

		ush = stories.get(1);
		assertEquals(ush.getId(),userStory4.getId());
		assertEquals(ush.getResponsable(),miembro4.getNombre());
		
		ush = stories.get(0);
		assertEquals(ush.getId(),userStory2.getId());
		assertEquals(ush.getResponsable(),miembro1.getNombre());		
	}
	
	
}