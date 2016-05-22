package pp2.scrum.dominio;

import java.util.Iterator;
import java.util.List;

//Lista paginada para hacer el listado lazy load desde la vista que usen listados paginados genericos
public class ListaPaginada<T> implements Iterable<T>
{
   private int Pagina;
   private int ItemsPorPagina;
   private int ItemsTotales;
   private List<T> Items ;

   public ListaPaginada(List<T> items, int pagina, int itemsPorPagina, int itemsTotales)
   {
       Items = items;
       Pagina = pagina;
       ItemsPorPagina = itemsPorPagina;
       ItemsTotales = itemsPorPagina == 0 ? items.size() : itemsTotales;
   }

   @Override
   public Iterator<T> iterator()
   {
      return Items.iterator();
   }

   public int getPagina()
   {
      return Pagina;
   }

   public int getItemsPorPagina()
   {
      return ItemsPorPagina;
   }

   public int getItemsTotales()
   {
      return ItemsTotales;
   }

   public List<T> getItems()
   {
      return Items;
   }
}
