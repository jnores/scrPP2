package pp2.scrum.controller;

import java.util.ArrayList;
import java.util.List;

import pp2.scrum.domain.CriterioAceptacion;
import pp2.scrum.domain.Estado;
import pp2.scrum.domain.Tarea;
import pp2.scrum.domain.UserStory;
import pp2.scrum.utils.Logger;
import pp2.scrum.utils.Paginacion;

public class UserStoryPaginadoController extends Controller 
{
    private Paginacion paginacionActual;

    public UserStoryPaginadoController(MailGateway mailGateway)
    {
        super (mailGateway);
        paginacionActual = new Paginacion( 1, 5,new ArrayList<UserStory>());
    }

    public List<UserStory> getModel()
    {
        return paginacionActual.getModel();
    }

    public int getItemsTotales()
    {
        return paginacionActual.getItemsTotales();
    }

    public int getPaginasTotales()
    {
        return paginacionActual.getPaginasTotales();
    }

    public Paginacion getPaginacionActual()
    {
        return paginacionActual;
    }

    public void setModel(List<UserStory> model)
    {
    	paginacionActual.setModel(model);
    }

    public List<UserStory> listarUserStories(Paginacion paginacion)
    {               
        paginacionActual = paginacion;
        return paginacionActual.listarUserStories();
    }

    public List<UserStory> obtenerPaginacionAnterior()
    { 
        return paginacionActual.getPagina() == 1 ? paginacionActual.getModel() : paginacionActual.paginacionAnterior();  
    }

    public List<UserStory> obtenerPaginacionSiguiente()
    {
        return paginacionActual.getPagina() == paginacionActual.getPaginasTotales() ? paginacionActual.getModel() : paginacionActual.paginacionSiguiente();
    }

    public List<UserStory> obtenerPaginacionPrimera()
    {
        return paginacionActual.getPagina() == 1 ? paginacionActual.getModel() : paginacionActual.paginacionPrimera();
    }

    public List<UserStory> obtenerPaginacionUltima()
    {
        return paginacionActual.getPagina() == paginacionActual.getPaginasTotales() ? paginacionActual.getModel() : paginacionActual.paginacionUltima();
    }

    public List<UserStory> obtenerPaginacionActual()
    {
        return paginacionActual.listarUserStories();
    }

   //Tercera Iteracion
    public void finalizarStory(UserStory story)
    {
        List<Tarea> tareas = story.getTareas();

        for (Tarea tarea : tareas)
        {
            while (tarea.getEstado() != Estado.Done)
            {
               tarea.avanzarEstado();
            }          
        }

    }
    
    //Tercera Iteracion
    public Resultado enviarHistoriaMail(String destino , UserStory story)
    {        
        String nuevaLinea = System.lineSeparator();
        String criterios="";
        for (CriterioAceptacion criterio : story.getCriterios())
        {
           criterios+="* "+ criterio.getDescripcion() + nuevaLinea;        
        }
                
        String cuerpo = "Detalle:" + nuevaLinea;
        cuerpo += story.getDetalle() + nuevaLinea;
        cuerpo += "Criterios:" + nuevaLinea;
        cuerpo += criterios;
        //cuerpo += "Autor:" + nuevaLinea;
        //cuerpo += story.getAutor() + nuevaLinea;
        cuerpo += "Puntos:" + nuevaLinea;
        cuerpo += story.getStoryPoints() + nuevaLinea;
        
        Mail mail = new Mail(destino, "Historia finalizada: " +  story.getTitulo(),cuerpo);
        Logger.init();
        Resultado respuesta = mailGateway.enviar(mail);
        for (String comment : respuesta.Errores().values())
        {
           Logger.log(comment);
        }
        Logger.close();
        return respuesta;
    }


}
