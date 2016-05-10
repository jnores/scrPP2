package com.ungs.pp2.scrPP2.Dominio;

import java.util.Dictionary;
import java.util.Hashtable;

public class Resultado
{
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
