package pp2.scrum.controller;

import java.security.InvalidParameterException;

import pp2.scrum.dominio.entidad.CorrectorDeSintaxis;
import pp2.scrum.dominio.entidad.UserStory;
import pp2.scrum.dominio.interfaz.IConsulta;

public class AltaUserStoryController extends Controller {
	private CorrectorDeSintaxis modeloCorrector;
	private UserStory modelo;
	private ProyectoController proyectoController;

	public AltaUserStoryController(IConsulta consulta,ProyectoController proyecto){
		super(consulta);
		modeloCorrector=new CorrectorDeSintaxis(); 
		proyectoController = proyecto;
	}
	
	public void altaUserStory(String titulo, String detalle, String criterios,Integer puntos) {
	//public void altaUserStory(String titulo, String detalle, String criterios,String responsable, Integer hs, Integer puntos) {
		//Falta lo importante
//		if (hs==null)
//			throw new InvalidParameterException("Se esperaba una cantidad de horas mayor a cero y se recibio un elemento nulo.");
//		if (puntos==null)
//			throw new InvalidParameterException("Se esperaba una cantidad de puntos mayor a cero y se recibio un elemento nulo.");
		UserStory us = new UserStory(proyectoController.getSiguienteStoryID(),titulo,detalle,"");
		proyectoController.agregarUserStory(us);
	}
	
	public String obtenerSugerenciaTitulo(String frase){
		return modeloCorrector.analizarTituloUserStory(frase);
	}
	
	public String obtenerSugerenciaCriterio(String frase){
		return modeloCorrector.analizarCriterios(frase);
	}
}
