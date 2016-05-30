/**
 * 
 */
package pp2.scrum.busEvent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import junit.framework.TestCase;

/**
 * @author yoshknight
 *
 */
public class BusEventSyncTest extends TestCase implements ActionListener{
    BusEventSync bus;
    boolean test1;
    /**
     * @param name
     */
    public BusEventSyncTest(String name) {
        super(name);
    }

    /* (non-Javadoc)
     * @see junit.framework.TestCase#setUp()
     */
    protected void setUp() throws Exception {
        super.setUp();
        bus= new BusEventSync();
        test1=false;
    }

    /**
     * Test method for {@link pp2.scrum.busEvent.BusEventSync#BusEvent()}.
     */
    public final void testBusEvent() {
        new BusEventSync();
    }

    /**
     * Test method for {@link pp2.scrum.busEvent.BusEventSync#register(java.awt.event.ActionListener)}.
     */
    public final void testRegister() {
        bus.register(this);
    }

    /**
     * Test method for {@link pp2.scrum.busEvent.BusEventSync#unregister(java.awt.event.ActionListener)}.
     */
    public final void testUnregister() {
        bus.register(this);
        bus.unregister(this);
    }

    /**
     * Test method for {@link pp2.scrum.busEvent.BusEventSync#postEvent(java.awt.event.ActionEvent)}.
     */
    public final void testPostEvent() {
        bus.register(this);
        try {
            assertFalse(test1);
            bus.postEvent(new ActionEvent(this, 1, "test1"));
            assertTrue(test1);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            fail("Fallo el posteo del evento por interrupcion del tread");
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("test1") )
            test1=true;
    }

}
