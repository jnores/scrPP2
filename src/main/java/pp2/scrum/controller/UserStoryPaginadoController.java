package pp2.scrum.controller;

import java.util.ArrayList;
import java.util.List;

import pp2.scrum.dominio.Paginacion;
import pp2.scrum.dominio.Resultado;
import pp2.scrum.dominio.entidad.CriterioAceptacion;
import pp2.scrum.dominio.entidad.Mail;
import pp2.scrum.dominio.entidad.Tarea;
import pp2.scrum.dominio.entidad.UserStory;
import pp2.scrum.dominio.enums.Estado;
import pp2.scrum.dominio.interfaz.MailGateway;
import pp2.scrum.utils.Logger;

public class UserStoryPaginadoController extends Controller 
{
    private List<UserStory> model;
    private Paginacion paginacionDefault;
    private Paginacion paginacionActual;
    private int itemsTotales;

    public UserStoryPaginadoController(MailGateway mailGateway)
    {
        super (mailGateway);
        model = new ArrayList<UserStory>();
        paginacionDefault = new Paginacion(null, null, 1, 5);
        paginacionActual = paginacionDefault;
        itemsTotales = model.size();
    }

    public List<UserStory> getModel()
    {
        return model;
    }

    public int getItemsTotales()
    {
        return itemsTotales;
    }

    public int getPaginasTotales()
    {
        return itemsTotales / paginacionActual.getItemsPorPagina() + (itemsTotales % paginacionActual.getItemsPorPagina() == 0 ? 0 : 1);
    }

    public Paginacion getPaginaActual()
    {
        return paginacionActual;
    }

    public void setModel(List<UserStory> model)
    {
        this.model = model;
    }

    public List<UserStory> ListarUserStories(Paginacion paginacion)
    {
        if (paginacion == null)
        {
            paginacion = paginacionDefault;
        }                   
        int itemsTotales = model.size();
        int indice = (paginacion.getPagina() - 1) * paginacion.getItemsPorPagina();
        List<UserStory> historias = new ArrayList<UserStory>();
        int i = 0;
        while(i < paginacion.getItemsPorPagina() && (indice + i) < itemsTotales && indice >= 0)
        {
            UserStory story = model.get(indice + i);
            historias.add(new UserStory(story.getTitulo(), story.getDetalle(), story.getAutor(), story.getResponsable(), story.getHorasEstimadas(), story.getStoryPoints(), story.getIteracion(), story.getEstado(), null, null));       
            i++;
        }
        paginacionActual = paginacion;
        this.itemsTotales = itemsTotales;
        return historias;
    }

    public List<UserStory> ObtenerPaginaAnterior()
    { 
        return paginacionActual.getPagina() == 1 ? getModel() : ListarUserStories(new Paginacion(paginacionActual.getOrdenarPor(), paginacionActual.getDireccionOrden(), paginacionActual.getPagina() - 1, paginacionActual.getItemsPorPagina()));  
    }

    public List<UserStory> ObtenerPaginaSiguiente()
    {
        return paginacionActual.getPagina() == getPaginasTotales() ? getModel() : ListarUserStories( new Paginacion(paginacionActual.getOrdenarPor(), paginacionActual.getDireccionOrden(), paginacionActual.getPagina() + 1, paginacionActual.getItemsPorPagina()));
    }

    public List<UserStory> ObtenerPaginaPrimera()
    {
        return paginacionActual.getPagina() == 1 ? getModel() : ListarUserStories( new Paginacion(paginacionActual.getOrdenarPor(), paginacionActual.getDireccionOrden(), 1, paginacionActual.getItemsPorPagina()));
    }

    public List<UserStory> ObtenerPaginaUltima()
    {
        return paginacionActual.getPagina() == getPaginasTotales() ? getModel() : ListarUserStories( new Paginacion(paginacionActual.getOrdenarPor(), paginacionActual.getDireccionOrden(), getPaginasTotales(), paginacionActual.getItemsPorPagina()));
    }

    public List<UserStory> ObtenerPaginaActual()
    {
        return ListarUserStories( new Paginacion(paginacionActual.getOrdenarPor(), paginacionActual.getDireccionOrden(), paginacionActual.getPagina(), paginacionActual.getItemsPorPagina()));
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
        cuerpo += "Autor:" + nuevaLinea;
        cuerpo += story.getAutor() + nuevaLinea;
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
