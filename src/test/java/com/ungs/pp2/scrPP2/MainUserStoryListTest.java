package com.ungs.pp2.scrPP2;


import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class MainUserStoryListTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public MainUserStoryListTest( String testName ) {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite( MainUserStoryListTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testMainUserStoryist() {
    	@SuppressWarnings("unused")
		MainUserStoryList main = new MainUserStoryList();
        assertTrue( true );
    }
    
    /**
     * Rigourous Test :-P
     */
    public void testMainUserStoryListMain() {
    	String[] args= {"parametro","parametro"};
    	MainUserStoryList.main(args);
        assertTrue( true );
    }
    
    }
