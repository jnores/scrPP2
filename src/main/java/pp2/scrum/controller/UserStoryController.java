package pp2.scrum.controller;

import java.util.ArrayList;

import pp2.scrum.correctorSintaxis.CorrectorSintaxis;
import pp2.scrum.model.CriterioAceptacion;
import pp2.scrum.model.Proyecto;
import pp2.scrum.model.Tarea;
import pp2.scrum.model.UserStory;

public class UserStoryController {
    private CorrectorSintaxis modeloCorrector;
    private ProyectoController proyectoController; 

    public UserStoryController(Proyecto proyecto){
       modeloCorrector=new CorrectorSintaxis();
       proyectoController = new ProyectoController(proyecto,null);
   }

    public void altaUserStory(String titulo, String detalle, String criterios,Integer puntos) {
        //Falta lo importante
        //		if (hs==null)
        //			throw new InvalidParameterException("Se esperaba una cantidad de horas mayor a cero y se recibio un elemento nulo.");
        //		if (puntos==null)
        //			throw new InvalidParameterException("Se esperaba una cantidad de puntos mayor a cero y se recibio un elemento nulo.");
        CriterioAceptacion criterio = new CriterioAceptacion(criterios);
    	UserStory us = new UserStory(titulo, detalle, puntos, criterio,new ArrayList<Tarea>() );
        proyectoController.agregarUserStory(us);

    }

    public String obtenerSugerenciaTitulo(String frase){
        return modeloCorrector.analizarTituloUserStory(frase,false);
    }

    public String obtenerSugerenciaCriterio(String frase){
        return modeloCorrector.analizarCriterios(frase,false);
    }
}
