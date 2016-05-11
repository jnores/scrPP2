package com.ungs.pp2.scrPP2.Controller;

import com.ungs.pp2.scrPP2.Dominio.Entidad.CorrectorDeSintaxis;
import com.ungs.pp2.scrPP2.Dominio.Entidad.UserStory;
import com.ungs.pp2.scrPP2.Dominio.Interfaz.IConsulta;

public class AltaUserStoryController extends Controller {
	private CorrectorDeSintaxis modeloCorrector;
	private UserStory modelo;

	public AltaUserStoryController(IConsulta consulta){
		super(consulta);
		modeloCorrector=CorrectorDeSintaxis.getCorrector();
	}
	
	public void altaUserStory(String titulo, String detalle, String criterios,String responsable, Integer hs, Integer puntos){
		//Falta lo importante
	}
	
	public String obtenerSugerencia(String frase){
		return modeloCorrector.analizarFrase(frase);
	}
}
