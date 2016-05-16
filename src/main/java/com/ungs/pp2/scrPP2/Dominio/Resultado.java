package com.ungs.pp2.scrPP2.Dominio;

import java.util.Dictionary;
import java.util.Hashtable;

public class Resultado
{
    // TODO Esto debera ser un Map.
	// ¿Porque tengo un diccionario string=>string??
	// No seria mejor tener una lista de codigos de error?
	// Asi y al inicar la app se cargue un registry con todo los codigos de error desde algun archivo de configuracion o algo asi?
	// De este modtenemos codigos de error y luego el texto se puede modificar, traducir o cualquier cosas sin tocar esto!
   private Dictionary<String, String> errores = new Hashtable<String, String>();;

   public Dictionary<String, String> Errores() 
   {
       return errores;
   }

   public boolean HayErrores()
   {
       return !errores.isEmpty();
   }

   public void AgregarError(String clave, String descripcion)
   {
       errores.put(clave, descripcion);
   }

}
