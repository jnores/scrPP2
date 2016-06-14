package pp2.scrum.dominio.entidad;

import org.jfree.data.xy.*;
/**
 * Define el comportamiento base de los componentes
 * que permiten crear un chart. 
 * Devuelve conjuntos de pares ordenados, 
 * con los puntos de historia en función del día. 
 **/ 

public interface DataComponent
{
   
   public XYSeriesCollection getData(Sprint iteracion);

   //Si no se especifica una iteracion toma todas las iteraciones
   public XYSeriesCollection getData();

}
