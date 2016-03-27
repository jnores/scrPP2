package com.ungs.pp2.scrPP2;

import com.ungs.pp2.scrPP2.MainUserStory;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( MainUserStory.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void doCreate()
    {
    	MainUserStory main = new MainUserStory();
    	boolean ret=true;
        assertTrue( ret );
    }
    
    /**
     * Rigourous Test :-P
     */
    public void doMain()
    {
    	String[] args= {"parametro","parametro"};
    	MainUserStory.main(args);
        assertTrue( true );
    }
}
