/**
 * 
 */
package pp2.scrum.verificarSprint;

import java.util.Date;
import java.util.List;

import pp2.scrum.calendario.Calendario;
import pp2.scrum.calendario.CalendarioService;
import pp2.scrum.controller.EventBus;
import pp2.scrum.logger.Logger;
import pp2.scrum.model.Sprint;
import pp2.scrum.model.UserStory;
import pp2.scrum.servicios.ServiceRegistry;

/**
 * @author yoshknight
 *
 */
public class VerificarRetraso implements Runnable {

    private Sprint sprint;
    private EventBus busEvent;
    
    public VerificarRetraso(Sprint sprint,EventBus busEvent) {
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
                TaskManager.addTask(this, CalendarioService.DAY );
            } else if (porcentajeTranscurrido < 100) {
                double porcentajeAvance = getPorcentajeAvance();
                if ( porcentajeAvance < porcentajeTranscurrido ) {
                    try {
                        String titulo="Sprint "+sprint.getIdIteracion()+" retrasado";
                        String detalle = "El desarrollo del sprint "+sprint.getIdIteracion()+" se encuentra retrasado.\n"+
                              "Solo el "+porcentajeAvance+"% esta completo.\n"+
                              "El porcentaje de desarrollo terminado es menor que el "+porcentajeTranscurrido+"% de tiempo transcurrido!";
                        
                        busEvent.postEvent( new SprintRetrasadoEvent(this,titulo,detalle) );
                    } catch (InterruptedException e) {
                        Logger.log( "ERROR generando evento de retraso: " + e.getMessage() );
                    }
                } else {
                    TaskManager.addTask(this, CalendarioService.DAY );
                }
            }
    }
    
    public double getPorcentajeAvance() {
        double storyPointsPactados = sprint.getStoryPointsPactados();
        double storyPointsCompletos = 0;
        List<UserStory> stories = sprint.getBacklog().getList();
        for ( UserStory us : stories ) {
            if ( sprint.isUserStoryDone(us) ) {
                storyPointsCompletos += us.getStoryPoints();
            }
        }
        return 100*storyPointsCompletos/storyPointsPactados;
    }
    
    public double getPorcentajeTiempoTranscurrido() {
        Date today = new Date();
        Date inicio = sprint.getfechaInicio();
        if (!ServiceRegistry.getInstance().hasService("calendario"))
            throw new RuntimeException(
                    "El servicio Calendario no fue inicializado.");
        
        Calendario calendario = (Calendario) ServiceRegistry.getInstance()
                .getService("calendario");
        double factorTranscurrido = ((double) calendario.getDuracion(inicio, today)) / sprint.getDuracion();
        return 100 * factorTranscurrido;
    }
    
}
