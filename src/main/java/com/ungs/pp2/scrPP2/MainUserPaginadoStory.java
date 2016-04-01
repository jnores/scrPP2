package com.ungs.pp2.scrPP2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ungs.pp2.scrPP2.Controller.UserStoryPaginadoController;
import com.ungs.pp2.scrPP2.Dominio.ListaPaginada;
import com.ungs.pp2.scrPP2.Dominio.Paginacion;
import com.ungs.pp2.scrPP2.Dominio.Entidad.UserStory;
import com.ungs.pp2.scrPP2.Dominio.Enums.Estado;
import com.ungs.pp2.scrPP2.Dominio.Interfaz.IConsulta;
import com.ungs.pp2.scrPP2.View.UserStoryPaginadoView;

public class MainUserPaginadoStory

{
   
   static List<UserStory> stories  = obtenerUserStoriesDB();

	public static void main(String[] args) {

		//fetch student record based on his roll no from the database
		

		//Create a view : to write student details on console
		

		//Creo el controlador y le envío el modelo
	   Paginacion paginacion = new Paginacion(null, null, 1, 5);
		UserStoryPaginadoController controller = new UserStoryPaginadoController(null, ListarPaginadoUserStories(paginacion));
		
		//La vista recibe el controlador
		UserStoryPaginadoView view = new UserStoryPaginadoView(controller);
		
		//Agrego la vista que es un observador del modelo
		for (UserStory story : controller.getModel())
		{
		   story.addObserver(view);
		}
		
		//Seteo un cliente por defecto al modelo
		//customerModel.setCustomer(ctm);
		//Muestro la ventana
		view.showWindow(true);
		
	}
	private static List<UserStory> obtenerUserStoriesDB(){
	   
	   List<UserStory> stories = new ArrayList<UserStory>();
		stories.add(new UserStory("Titulo1", "Detalle1", "Autor1", "Responsable1", 10, 40, 1, Estado.ToDo, null, null));
		stories.add(new UserStory("Titulo2", "Detalle2", "Autor2", "Responsable2", 10, 40, 1, Estado.ToDo, null, null));
		stories.add(new UserStory("Titulo3", "Detalle3", "Autor3", "Responsable3", 10, 40, 1, Estado.ToDo, null, null));
		stories.add(new UserStory("Titulo4", "Detalle4", "Autor4", "Responsable4", 10, 40, 1, Estado.ToDo, null, null));
		stories.add(new UserStory("Titulo5", "Detalle5", "Autor5", "Responsable5", 10, 40, 1, Estado.ToDo, null, null));
		stories.add(new UserStory("Titulo6", "Detalle6", "Autor6", "Responsable6", 10, 40, 1, Estado.ToDo, null, null));
		stories.add(new UserStory("Titulo7", "Detalle7", "Autor7", "Responsable7", 10, 40, 1, Estado.ToDo, null, null));
		return stories;
	}

	private static ListaPaginada<UserStory> ListarPaginadoUserStories(Paginacion paginacion)
   {
      int itemsTotales = stories.size();
      int indice = (paginacion.getPagina() - 1) * paginacion.getItemsPorPagina();
      List<UserStory> historias = new ArrayList<UserStory>();
      int i = 0;
      while(i < paginacion.getItemsPorPagina() && (indice + i) < itemsTotales)
      {
         UserStory story = stories.get(indice + i);
         historias.add(new UserStory(story.getTitulo(), story.getDetalle(), story.getAutor(), story.getResponsable(), story.getHorasEstimadas(), story.getStoryPoints(), story.getIteracion(), story.getEstado(), null, null));       
         i++;
      }
      
      return new ListaPaginada<UserStory>(historias, paginacion.getPagina(), paginacion.getItemsPorPagina(), itemsTotales);
   }
}