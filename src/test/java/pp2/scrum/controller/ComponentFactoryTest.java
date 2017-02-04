package pp2.scrum.controller;

import java.util.NoSuchElementException;
import java.util.Properties;

import junit.framework.TestCase;

/**
 * @author yoshknight
 *
 */
public class ComponentFactoryTest extends TestCase {

    Properties properties;

    public ComponentFactoryTest(String name) {
        super(name);
    }

    protected void setUp() throws Exception {
        super.setUp();

        properties = new Properties();

    }

    public void testContructionWithNullParameter() {
        try {
            new ComponentFactory(null);
            assertTrue(false);
        } catch (Exception e) {

        }
    }

    public void testContructionWithoutConfig() {

        ComponentFactory factory = new ComponentFactory(properties);
        try {
            factory.getComponentByName("dummyComponenet");
            assertTrue(false);
        } catch (NoSuchElementException | InstantiationException e) {

        }

    }

}
