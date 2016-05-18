package com.ungs.pp2.scrPP2.Dominio.Entidad;

import java.text.Normalizer;
import java.util.ArrayList;

public class CorrectorDeSintaxis {

	private ArrayList<Indicador> indicadores;
	private gestorDeDiccionario gestorDatos;
	private DiccionarioSintactico diccionario;
	private CatalogoDeSugerencias sugerencias;

	public CorrectorDeSintaxis(){
		gestorDatos=gestorDeDiccionario.getGestor();
		this.sugerencias=gestorDatos.getSugerencias();
	}

	public String analizarCriterios(String frase){
		diccionario = gestorDatos.getDiccionarioCriterios();
		return analizarFrase(frase);
	}

	public String analizarTituloUserStory(String frase){
		diccionario = gestorDatos.getDiccionarioUserStory();
		return analizarFrase(frase);
	}

	private static String textoNormalizado(String texto){
		texto = Normalizer.normalize(texto, Normalizer.Form.NFD);// Cambio las tildes y demás símbolos raros XD   
		texto = texto.toLowerCase(); // Podría usar mayúsculas pero da lo mismo
		return texto;
	}
	
	private void evaluarIndicados(String frase){
		String fraseUsuario=textoNormalizado(frase);
		//Me baso en las posiciones relativas
		Indicador indicadorInicial=this.indicadores.get(0);
		Indicador indicadorMedio=this.indicadores.get(1);
		Indicador indicadorFinal=this.indicadores.get(2);
		
		String inicial=textoNormalizado(this.indicadores.get(0).getFrase());
		String medio=textoNormalizado(this.indicadores.get(1).getFrase());
		String ultimo=textoNormalizado(this.indicadores.get(2).getFrase());
		String aux;
		
		
		//La frase termina con el último indicador, el indicador no marca nada.
		if(!ultimo.isEmpty() && fraseUsuario.trim().endsWith(ultimo)){
			indicadorFinal.setSugerencia(this.sugerencias.getSugerenciaIndicado(indicadorFinal.getIdentificador()));
		}
		
		
		//La frase esta a la mitad, el indicador no marca nada.|
		if(!medio.isEmpty() && fraseUsuario.endsWith(medio)){

			indicadorMedio.setSugerencia(this.sugerencias.getSugerenciaIndicado(indicadorMedio.getIdentificador()));
		}
		
		//La frase tiene indicador final y medio, pero no hay nada entre ellos.
		if(!ultimo.isEmpty() && !medio.isEmpty()){
			//Tomo la parte de la frase entre el indicador medio y final, descartando el final y luego el comienzo
			aux=fraseUsuario.substring(0,fraseUsuario.indexOf(ultimo));
			aux=aux.substring(aux.indexOf(medio));
			aux=aux.replace(medio,"").trim();
			if(aux.isEmpty()){
				indicadorMedio.setSugerencia(this.sugerencias.getSugerenciaIndicado(indicadorMedio.getIdentificador()));
			}
			
		}

		//La frase tiene indicador inicial y medio, pero no hay nada entre ellos.|
		if(!inicial.isEmpty() && !medio.isEmpty()){
			//Descarto el indicador inicial y todo desde el indicador medio hacia atrás
			aux=fraseUsuario.replace(inicial,"").trim();
			aux=aux.substring(0,aux.indexOf(medio)).trim();
			if(aux.isEmpty()){
			indicadorInicial.setSugerencia(this.sugerencias.getSugerenciaIndicado(indicadorInicial.getIdentificador()));
			}
		}
		//La frase comienza con el indicador intermedio
		if(!medio.isEmpty() && fraseUsuario.startsWith(medio)){
			indicadorInicial.setSugerencia(this.sugerencias.getSugerenciaIndicado(indicadorInicial.getIdentificador()));
			
		}
	}
	
	private void identificarIndicadores(String frase){
		this.indicadores=new ArrayList<Indicador>();
		final String fraseAuxiliarUsuario=textoNormalizado(frase);
		//Tomo las entradas en el orden sintáctico del diccionario
		Indicador indicador;
		for(String identificador: diccionario.getOrden()) {
			indicador=new Indicador(identificador);
			ArrayList<String> palabrasAceptadas=diccionario.getAceptadas(identificador);
			for(String aceptada:palabrasAceptadas){
				String fraseAuxAceptada=textoNormalizado(aceptada);
				if(fraseAuxiliarUsuario.contains(fraseAuxAceptada)){
					indicador.setFrase(fraseAuxAceptada);
				}
			}
			if(indicador.getFrase().isEmpty()){
				String sugerencia=sugerencias.getSugerencia(identificador);
				indicador.setSugerencia(sugerencia);
			}
			this.indicadores.add(indicador);
		}
	}
	private String obtenerSugerencia(){
		String sugerenciaFinal="";

		for (Indicador indicador:this.indicadores){
			sugerenciaFinal=sugerenciaFinal.concat(indicador.getSugerencia()+"\n");
		};
		return sugerenciaFinal;
	}

	private String analizarFrase(String frase){
		if(frase.isEmpty()){
			return "";
		}
		identificarIndicadores(frase);
		evaluarIndicados(frase);
		return obtenerSugerencia();
	}		
}
