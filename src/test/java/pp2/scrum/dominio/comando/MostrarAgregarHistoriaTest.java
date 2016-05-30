package pp2.scrum.dominio.comando;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import junit.framework.TestCase;
import pp2.scrum.dominio.comando.MostrarAgregarHistoria;

public class MostrarAgregarHistoriaTest extends TestCase implements ActionListener{
    MostrarAgregarHistoria command;
    public MostrarAgregarHistoriaTest(String name) {
        super(name);
        command = new MostrarAgregarHistoria();
    }

    protected void setUp() throws Exception {
        super.setUp();
    }
    
    public final void testExecuteHomeControllerActionListener() {
        command.Execute(null, this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }

}
