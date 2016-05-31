package pp2.scrum.dominio.comando;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import junit.framework.TestCase;
import pp2.scrum.view.events.ViewUpdateEvent;

public class MostrarAgregarHistoriaTest extends TestCase implements ActionListener{
    MostrarAgregarHistoria command;
    JPanel panel;
    public MostrarAgregarHistoriaTest(String name) {
        super(name);
        command = new MostrarAgregarHistoria();
        panel=null;
    }

    protected void setUp() throws Exception {
        super.setUp();
    }
    
    public final void testExecuteHomeControllerActionListener() {
        command.Execute(null, this);
        assertNotNull(panel);     
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e instanceof ViewUpdateEvent){
            panel= (JPanel)e.getSource();
        }        
    }

}
