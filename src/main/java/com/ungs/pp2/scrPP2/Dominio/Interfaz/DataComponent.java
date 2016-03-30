package com.ungs.pp2.scrPP2.Dominio.Interfaz;

import org.jfree.data.xy.*; 
import com.ungs.pp2.scrPP2.Dominio.Entidad.Iteracion;
/**
 * Define el comportamiento base de los componentes
 * que permiten crear un chart. 
 * Devuelve conjuntos de pares ordenados, 
 * con los puntos de historia en función del día. 
 **/ 

public interface DataComponent
{
   
   public XYSeriesCollection getData(Iteracion iteracion);

   //Si no se especifica una iteracion toma todas las iteraciones
   public XYSeriesCollection getData();

}
