package com.ungs.pp2.scrPP2.textUtils;

import java.io.File;
import java.io.IOException;

import com.ungs.pp2.scrPP2.utils.UserStoryMapper;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


public class TextUserStoryMapperTest extends TestCase {
	UserStoryMapper usMapper;
	UserStoryMapper usMapperDefault;
	
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
			File f = new File(System.getProperty("user.home")+"/historiaTest.dat");
			if ( f.exists() ) f.delete();
			usMapperDefault = new TextUserStoryMapper();
			usMapper = new TextUserStoryMapper("historiasTest.dat");
			
		} catch (RuntimeException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Verifico el texto logueado
	 */
	public void testMapper() {
			assertEquals(usMapper.getNextID(),1);
			assertTrue(usMapper.getBacklog().isEmpty());
	}
	
}