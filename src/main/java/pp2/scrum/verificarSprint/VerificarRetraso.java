/**
 * 
 */
package pp2.scrum.verificarSprint;

import java.util.Date;
import java.util.List;

import pp2.scrum.busEvent.BusEvent;
import pp2.scrum.dominio.TaskManager;
import pp2.scrum.dominio.entidad.Sprint;
import pp2.scrum.dominio.entidad.UserStory;
import pp2.scrum.dominio.enums.Estado;
import pp2.scrum.utils.Calendario;
import pp2.scrum.utils.Logger;

/**
 * @author yoshknight
 *
 */
public class VerificarRetraso implements Runnable {

    private Sprint sprint;
    private BusEvent busEvent;
    
    public VerificarRetraso(Sprint sprint,BusEvent busEvent) {
        this.sprint = sprint;
        this.busEvent = busEvent;
    }
    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        double porcentajeTranscurrido = getPorcentajeTiempoTranscurrido();
            if ( porcentajeTranscurrido < 50 ) {
                TaskManager.addTask(this, Calendario.DAY );
            } else if (porcentajeTranscurrido < 100) {
                double porcentajeAvance = getPorcentajeAvance();
                if ( porcentajeAvance < porcentajeTranscurrido ) {
                    try {
                        String titulo="Sprint "+sprint.getIdIteracion()+" retrasado";
                        String detalle = "El desarrollo del srprint "+sprint.getIdIteracion()+" se encuentra retrasado.\n"+
                              "Solo el "+porcentajeAvance+"% esta completo.\n"+
                              "El porcentaje de desarrollo terminado es menor que el "+porcentajeAvance+"% de tiempo transcurrido!";
                        
                        busEvent.postEvent( new SprintRetrasadoEvent(this,titulo,detalle) );
                    } catch (InterruptedException e) {
                        Logger.log( "ERROR generando evento de retraso: " + e.getMessage() );
                    }
                } else {
                    TaskManager.addTask(this, Calendario.DAY );
                }
            }
    }
    
    public double getPorcentajeAvance() {
        double storyPointsPactados = sprint.getStoryPointsPactados();
        double storyPointsCompletos = 0;
        List<UserStory> stories = sprint.getUserStories();
        for ( UserStory u : stories ) {
            if ( u.getEstado().equals( Estado.Done ) ) {
                storyPointsCompletos += u.getStoryPoints();
            }
        }
        return 100*storyPointsCompletos/storyPointsPactados;
    }
    
    public double getPorcentajeTiempoTranscurrido() {
        Date today = new Date();
        Date inicio = sprint.getfechaInicio();
        double factorTranscurrido = ((double) Calendario.getDuracion(inicio, today)) / sprint.getDuracion();
        return 100 * factorTranscurrido;
    }
    
}
