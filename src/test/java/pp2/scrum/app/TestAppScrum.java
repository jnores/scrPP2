/**
 * 
 */
package pp2.scrum.app;

import junit.framework.TestCase;

/**
 * @author yoshknight
 *
 */
public class TestAppScrum extends TestCase {

    /**
     * @param name
     */
    public TestAppScrum(String name) {
        super(name);
    }

    /* (non-Javadoc)
     * @see junit.framework.TestCase#setUp()
     */
    protected void setUp() throws Exception {
        super.setUp();
    }

    /**
     * Test method for {@link pp2.scrum.app.AppScrum#main(java.lang.String[])}.
     */
    public final void testMain() {
        AppScrum.main(null);
    }

}
