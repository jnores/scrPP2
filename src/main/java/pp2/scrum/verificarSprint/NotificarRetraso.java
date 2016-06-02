/**
 * 
 */
package pp2.scrum.verificarSprint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import pp2.scrum.dominio.interfaz.Notificador;

/**
 * @author yoshknight
 *
 */
public class NotificarRetraso implements ActionListener {
    
    private Notificador notificador;
    
    public NotificarRetraso(Notificador notificador) {
        this.notificador=notificador;
    }

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e instanceof SprintRetrasadoEvent) {
            SprintRetrasadoEvent event = (SprintRetrasadoEvent)e;
            notificador.sendMail("team@dominio",event.getTitulo(),event.getDetalle());
        }

    }

}
