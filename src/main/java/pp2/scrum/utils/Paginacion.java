package pp2.scrum.utils;

import java.util.ArrayList;
import java.util.List;

//Clase para paginar la lista paginada
public class Paginacion<T>
{
    private int Pagina;
    private int ItemsPorPagina;
    private List<T> model;

    public Paginacion(int pagina,int itemsPorPagina,List<T> lista)
    {
        Pagina = pagina;
        ItemsPorPagina = itemsPorPagina;
        model = lista;
    }

    public List<T> getModel() 
    {
        return model;
    }

    public int getPagina()
    {
        return Pagina;
    }

    private void setPagina(int pagina)
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

    public List<T> listarPaginacion()
    {
        int indice = (getPagina() - 1) * getItemsPorPagina();
        List<T> lista = new ArrayList<T>();
        int i = 0;
        while(i < getItemsPorPagina() && (indice + i) < getItemsTotales() && indice >= 0)
        {
            T elemento = model.get(indice + i);
            lista.add(elemento);      
            i++;
        }
        return lista;
    }

    public List<T> paginacionAnterior()
    {        	 
        setPagina(getPagina() - 1);
        return listarPaginacion();
    }

    public List<T> paginacionSiguiente()
    {        	 
        setPagina(getPagina() + 1);
        return listarPaginacion();
    }

    public List<T> paginacionPrimera()
    {        	 
        setPagina(1);
        return listarPaginacion();
    }

    public List<T> paginacionUltima()
    {        	 
        setPagina(getPaginasTotales());
        return listarPaginacion();
    }

}
