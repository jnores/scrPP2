package com.ungs.pp2.scrPP2.Dominio.Interfaz;

import com.ungs.pp2.scrPP2.Dominio.ListaPaginada;
import com.ungs.pp2.scrPP2.Dominio.Paginacion;
import com.ungs.pp2.scrPP2.Dominio.Entidad.UserStory;

//Interfaz para posteriores consultas a la Base Datos
public interface IConsulta 
{  
   public ListaPaginada<UserStory> ListarPaginadoUserStories(Paginacion paginacion);
}
