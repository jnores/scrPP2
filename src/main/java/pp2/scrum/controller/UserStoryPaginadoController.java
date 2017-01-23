package pp2.scrum.controller;

import java.util.ArrayList;
import java.util.List;

import pp2.scrum.model.Estado;
import pp2.scrum.model.Tarea;
import pp2.scrum.model.UserStory;
import pp2.scrum.utils.Paginacion;

public class UserStoryPaginadoController extends Controller 
{
    private Paginacion<UserStory> paginacionActual;

    public UserStoryPaginadoController()
    {
        this( new Paginacion<UserStory>( 1, 5,new ArrayList<UserStory>()) );
    }
    public UserStoryPaginadoController(Paginacion<UserStory> paginacion)
    {
        paginacionActual = paginacion;

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

    public Paginacion<UserStory> getPaginacionActual()
    {
        return paginacionActual;
    }

    public void actualizarPaginacion(List<UserStory> model)
    {
    	paginacionActual = new Paginacion<UserStory>(paginacionActual.getPagina(), paginacionActual.getItemsPorPagina(), model);
    }

    public List<UserStory> listarUserStories(Paginacion<UserStory> paginacion)
    {               
        paginacionActual = paginacion;
        return paginacionActual.listarPaginacion();
    }

    public List<UserStory> obtenerPaginacionAnterior()
    { 
        return paginacionActual.getPagina() == 1 ? paginacionActual.listarPaginacion() : paginacionActual.paginacionAnterior();  
    }

    public List<UserStory> obtenerPaginacionSiguiente()
    {
        return paginacionActual.getPagina() == paginacionActual.getPaginasTotales() ? paginacionActual.listarPaginacion() : paginacionActual.paginacionSiguiente();
    }

    public List<UserStory> obtenerPaginacionPrimera()
    {
        return paginacionActual.paginacionPrimera();
    }

    public List<UserStory> obtenerPaginacionUltima()
    {
        return paginacionActual.paginacionUltima();
    }

    public List<UserStory> obtenerPaginacionActual()
    {
        return paginacionActual.listarPaginacion();
    }

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
    public boolean isEnabled() {
        return paginacionActual.getModel().size() > 0;
    }
    public boolean hasNext() {
        return isEnabled() && 
            paginacionActual.getPagina() < paginacionActual.getPaginasTotales();
    }
    public boolean hasPrev() {
        return isEnabled() && 
                paginacionActual.getPagina() > 1;
    }

    @Override
    public String toString() {
        String retValue = "-";
        if ( isEnabled() )
            retValue = paginacionActual.getPagina()
                    +" / "
                    +paginacionActual.getPaginasTotales();
        
        return retValue;
    }
    public int getPaginaActual() {
        return paginacionActual.getPagina();
    }
}
