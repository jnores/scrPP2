package pp2.scrum.utils;

import java.util.ArrayList;
import java.util.List;

import pp2.scrum.domain.UserStory;

//Clase para paginar la lista paginada
public class Paginacion
{
         private int Pagina;
         private int ItemsPorPagina;
         private List<UserStory> model;

         public Paginacion(int pagina,int itemsPorPagina,List<UserStory> lista)
         {
             Pagina = pagina;
             ItemsPorPagina = itemsPorPagina;
             model = lista;
         }
         
         public Paginacion()
         {
             Pagina = 1;
             ItemsPorPagina = 5;
             model = new ArrayList<UserStory>();
         }

         public List<UserStory> getModel() {
			return model;
		 }

		 public void setModel(List<UserStory> model) {
			this.model = model;
		 }

		 public int getPagina()
         {
            return Pagina;
         }

         public void setPagina(int pagina)
         {
            Pagina = pagina;
         }

         public int getItemsPorPagina()
         {
            return ItemsPorPagina;
         }
         
         public int getItemsTotales()
         {
            return model.size();
         }
         
         public int getPaginasTotales()
         {
        	 return getItemsTotales() / getItemsPorPagina() + (getItemsTotales() % getItemsPorPagina() == 0 ? 0 : 1);
         }

         public void setItemsPorPagina(int itemsPorPagina)
         {
            ItemsPorPagina = itemsPorPagina;
         }
         
         public List<UserStory> listarUserStories()
         {
        	 int itemsTotales = getItemsTotales();
             int indice = (getPagina() - 1) * getItemsPorPagina();
             List<UserStory> historias = new ArrayList<UserStory>();
             int i = 0;
             while(i < getItemsPorPagina() && (indice + i) < itemsTotales && indice >= 0)
             {
                 UserStory story = model.get(indice + i);
                 historias.add(story);      
                 i++;
             }
             return historias;
         }
         
         public List<UserStory> paginacionAnterior()
         {        	 
        	 setPagina(getPagina() - 1);
             return listarUserStories();
         }
         
         public List<UserStory> paginacionSiguiente()
         {        	 
        	 setPagina(getPagina() + 1);
             return listarUserStories();
         }
         
         public List<UserStory> paginacionPrimera()
         {        	 
        	 setPagina(1);
             return listarUserStories();
         }
         
         public List<UserStory> paginacionUltima()
         {        	 
        	 setPagina(getPaginasTotales());
             return listarUserStories();
         }

}
