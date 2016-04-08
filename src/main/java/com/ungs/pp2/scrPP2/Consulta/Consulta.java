package com.ungs.pp2.scrPP2.Consulta;

import java.util.ArrayList;
import java.util.List;

import com.ungs.pp2.scrPP2.Dominio.ListaPaginada;
import com.ungs.pp2.scrPP2.Dominio.Paginacion;
import com.ungs.pp2.scrPP2.Dominio.Entidad.UserStory;
import com.ungs.pp2.scrPP2.Dominio.Enums.Estado;
import com.ungs.pp2.scrPP2.Dominio.Interfaz.IConsulta;

public class Consulta implements IConsulta
{

   @Override
   public ListaPaginada<UserStory> ListarPaginadoUserStories(Paginacion paginacion)
   {
      return null;
   }   
   public List<UserStory> ObtenerUserStoriesDB()
   {
      
      List<UserStory> stories = new ArrayList<UserStory>();
      stories.add(new UserStory("Titulo1", "Detalle1", "Autor1", "Responsable1", 10, 40, 1, Estado.ToDo, null, null));
      stories.add(new UserStory("Titulo2", "Detalle2", "Autor2", "Responsable2", 10, 40, 1, Estado.ToDo, null, null));
      stories.add(new UserStory("Titulo3", "Detalle3", "Autor3", "Responsable3", 10, 40, 1, Estado.ToDo, null, null));
      stories.add(new UserStory("Titulo4", "Detalle4", "Autor4", "Responsable4", 10, 40, 1, Estado.ToDo, null, null));
      stories.add(new UserStory("Titulo5", "Detalle5", "Autor5", "Responsable5", 10, 40, 1, Estado.ToDo, null, null));
      stories.add(new UserStory("Titulo6", "Detalle6", "Autor6", "Responsable6", 10, 40, 1, Estado.ToDo, null, null));
      stories.add(new UserStory("Titulo7", "Detalle7", "Autor7", "Responsable7", 10, 40, 1, Estado.ToDo, null, null));
      stories.add(new UserStory("Titulo8", "Detalle8", "Autor8", "Responsable8", 10, 40, 1, Estado.ToDo, null, null));
      stories.add(new UserStory("Titulo9", "Detalle9", "Autor9", "Responsable9", 10, 40, 1, Estado.ToDo, null, null));
      stories.add(new UserStory("Titulo10", "Detalle10", "Autor10", "Responsable10", 10, 40, 1, Estado.ToDo, null, null));
      stories.add(new UserStory("Titulo11", "Detalle11", "Autor11", "Responsable11", 10, 40, 1, Estado.ToDo, null, null));
      
      return stories;
      //return new ArrayList<UserStory>();
   }

}
