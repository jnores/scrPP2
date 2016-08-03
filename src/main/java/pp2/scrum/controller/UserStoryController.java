package pp2.scrum.controller;

import pp2.scrum.correctorSintaxis.CorrectorSintaxis;
import pp2.scrum.model.Proyecto;
import pp2.scrum.model.UserStory;

public class UserStoryController {
    private CorrectorSintaxis modeloCorrector;
    private Proyecto modelo;
    private ProyectoController proyectoController; 

    public UserStoryController(Proyecto proyecto,ProyectoController pController){
        modeloCorrector=new CorrectorSintaxis(); 
        modelo = proyecto;
        proyectoController = pController;
    }

    public void altaUserStory(String titulo, String detalle, String criterios,Integer puntos) {
        //Falta lo importante
        //		if (hs==null)
        //			throw new InvalidParameterException("Se esperaba una cantidad de horas mayor a cero y se recibio un elemento nulo.");
        //		if (puntos==null)
        //			throw new InvalidParameterException("Se esperaba una cantidad de puntos mayor a cero y se recibio un elemento nulo.");
    	UserStory us = new UserStory(titulo,detalle);
        proyectoController.agregarUserStory(us);

    }

    public String obtenerSugerenciaTitulo(String frase){
        return modeloCorrector.analizarTituloUserStory(frase,false);
    }

    public String obtenerSugerenciaCriterio(String frase){
        return modeloCorrector.analizarCriterios(frase,false);
    }
}
