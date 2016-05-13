package com.ungs.pp2.scrPP2.Controller;

import com.ungs.pp2.scrPP2.Dominio.Entidad.CorrectorDeSintaxis;
import com.ungs.pp2.scrPP2.Dominio.Entidad.UserStory;
import com.ungs.pp2.scrPP2.Dominio.Interfaz.IConsulta;

public class AltaUserStoryController extends Controller {
	private CorrectorDeSintaxis modeloCorrector;
	private UserStory modelo;
	private ProyectoController proyectoController;

	public AltaUserStoryController(IConsulta consulta,ProyectoController proyecto){
		super(consulta);
		modeloCorrector=CorrectorDeSintaxis.getCorrector();
		proyectoController = proyecto;
	}
	
	public void altaUserStory(String titulo, String detalle, String criterios,String responsable, Integer hs, Integer puntos){
		//Falta lo importante
		UserStory us = new UserStory(proyectoController.getSiguienteStoryID(),titulo,detalle,"");
		proyectoController.agregarUserStory(us);
	}
	
	public String obtenerSugerencia(String frase){
		return modeloCorrector.analizarFrase(frase);
	}
}
