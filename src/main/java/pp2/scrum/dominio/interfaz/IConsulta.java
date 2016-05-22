package pp2.scrum.dominio.interfaz;

import java.util.List;

import pp2.scrum.dominio.ListaPaginada;
import pp2.scrum.dominio.Paginacion;
import pp2.scrum.dominio.entidad.UserStory;

//Interfaz para posteriores consultas a la Base Datos
public interface IConsulta 
{  
   public ListaPaginada<UserStory> ListarPaginadoUserStories(Paginacion paginacion);
   
   public List<UserStory> ObtenerUserStoriesDB();
}
