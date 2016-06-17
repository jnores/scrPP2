package pp2.scrum.utils;

//Clase para paginar la lista paginada
public class Paginacion
{
         private String OrdenarPor ;
         private DirOrden DireccionOrden;
         private int Pagina;
         private int ItemsPorPagina;

         public Paginacion(String ordenarPor,DirOrden direccionOrden,int pagina,int itemsPorPagina)
         {
             OrdenarPor = ordenarPor;
             DireccionOrden = direccionOrden;
             Pagina = pagina;
             ItemsPorPagina = itemsPorPagina;
         }
         
         public Paginacion()
         {
             OrdenarPor = null;
             DireccionOrden = null;
             Pagina = 1;
             ItemsPorPagina = 5;
         }

         public String getOrdenarPor()
         {
            return OrdenarPor;
         }

         public void setOrdenarPor(String ordenarPor)
         {
            OrdenarPor = ordenarPor;
         }

         public DirOrden getDireccionOrden()
         {
            return DireccionOrden;
         }

         public void setDireccionOrden(DirOrden direccionOrden)
         {
            DireccionOrden = direccionOrden;
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

         public void setItemsPorPagina(int itemsPorPagina)
         {
            ItemsPorPagina = itemsPorPagina;
         }

}
