package com.ungs.pp2.scrPP2.Controller;

import java.util.ArrayList;
import java.util.List;

import com.ungs.pp2.scrPP2.Dominio.Paginacion;
import com.ungs.pp2.scrPP2.Dominio.Entidad.UserStory;
import com.ungs.pp2.scrPP2.Dominio.Interfaz.IConsulta;

public class UserStoryPaginadoController extends Controller 
{
	   private List<UserStory> model;
	   private Paginacion paginaDefault;
	   private Paginacion paginaActual;
	   private int itemsTotales;

	   //La consulta se pasa a cada controller para hacer consultas a la base y son pasadas a su padre
	   public UserStoryPaginadoController(IConsulta consulta)
	   {
		   super (consulta);
	      model = consulta.ObtenerUserStoriesDB();
	      paginaDefault = new Paginacion(null, null, 1, 5);
	      paginaActual = paginaDefault;
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
         return itemsTotales / paginaActual.getItemsPorPagina() + (itemsTotales % paginaActual.getItemsPorPagina() == 0 ? 0 : 1);
         //return itemsTotales != 0 ? (itemsTotales / paginaActual.getItemsPorPagina()) + 1 : 0 ;
      }
      
      public Paginacion getPaginaActual()
      {
         return paginaActual;
      }

      public void setModel(List<UserStory> model)
      {
         this.model = model;
      }
	   
      public List<UserStory> ListarUserStories(Paginacion paginacion)
      {
         if (paginacion == null)
         {
            paginacion = paginaDefault;
         }                   
         int itemsTotales = model.size();
         int indice = (paginacion.getPagina() - 1) * paginacion.getItemsPorPagina();
         List<UserStory> historias = new ArrayList<UserStory>();
         int i = 0;
         while(i < paginacion.getItemsPorPagina() && (indice + i) < itemsTotales)
         {
            UserStory story = model.get(indice + i);
            historias.add(new UserStory(story.getTitulo(), story.getDetalle(), story.getAutor(), story.getResponsable(), story.getHorasEstimadas(), story.getStoryPoints(), story.getIteracion(), story.getEstado(), null, null));       
            i++;
         }
         paginaActual = paginacion;
         this.itemsTotales = itemsTotales;
         return historias;
      }

      public List<UserStory> ObtenerPaginaAnterior()
      { 
         return paginaActual.getPagina() == 1 ? getModel() : ListarUserStories(new Paginacion(paginaActual.getOrdenarPor(), paginaActual.getDireccionOrden(), paginaActual.getPagina() - 1, paginaActual.getItemsPorPagina()));  
      }

      public List<UserStory> ObtenerPaginaSiguiente()
      {
         return paginaActual.getPagina() == getPaginasTotales() ? getModel() : ListarUserStories( new Paginacion(paginaActual.getOrdenarPor(), paginaActual.getDireccionOrden(), paginaActual.getPagina() + 1, paginaActual.getItemsPorPagina()));
      }

      public List<UserStory> ObtenerPaginaPrimera()
      {
         return paginaActual.getPagina() == 1 ? getModel() : ListarUserStories( new Paginacion(paginaActual.getOrdenarPor(), paginaActual.getDireccionOrden(), 1, paginaActual.getItemsPorPagina()));
      }

      public List<UserStory> ObtenerPaginaUltima()
      {
         return paginaActual.getPagina() == getPaginasTotales() ? getModel() : ListarUserStories( new Paginacion(paginaActual.getOrdenarPor(), paginaActual.getDireccionOrden(), getPaginasTotales(), paginaActual.getItemsPorPagina()));
      }
      
      public List<UserStory> ObtenerPaginaActual()
      {
         return ListarUserStories( new Paginacion(paginaActual.getOrdenarPor(), paginaActual.getDireccionOrden(), paginaActual.getPagina(), paginaActual.getItemsPorPagina()));
      }

	
}
