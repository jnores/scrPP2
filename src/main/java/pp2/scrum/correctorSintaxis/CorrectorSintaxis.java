package pp2.scrum.correctorSintaxis;

public class CorrectorSintaxis {

	private GestorDiccionario gestorDatos;
	private DiccionarioSintactico diccionario;
	private GestorSugerencias sugerencias;

	private boolean hayIndInicio, hayIndMedio,hayIndFinal;
	private boolean hayInicio,hayMedio,hayFin;
	
	private final String codigoDiccionarioUserStory="1";
	private final String codigoDiccionarioCriterios="2";
	
	public CorrectorSintaxis(){
		gestorDatos=GestorDiccionario.getGestor();
		sugerencias=GestorSugerencias.getCatalogo();
	}

	public String analizarCriterios(String frase, boolean analisisCompleto){
		diccionario = gestorDatos.getDiccionarioCriterios();
		if(analisisCompleto){
			return generarSugerenciaGeneral(frase,codigoDiccionarioCriterios);
		}
		return getSugerenciaParcial(frase,codigoDiccionarioCriterios);
	}

	public String analizarTituloUserStory(String frase, boolean completa){
		diccionario = gestorDatos.getDiccionarioUserStory();
		if(completa){
			return generarSugerenciaGeneral(frase,codigoDiccionarioUserStory);
		}
		return getSugerenciaParcial(frase,codigoDiccionarioUserStory);
	}
	
	private String identificarIndInicio(String frase){
		// comprueba que empiece con una frase o palabra aceptada
		String auxAceptada="";
		for(String aceptada:diccionario.getPalabrasIniciales()){ 
			auxAceptada=RegexFacilities.normalizarTexto(aceptada);
			if(RegexFacilities.existeEnElTexto("^\\W*"+auxAceptada+"\\s+",frase)){
				hayIndInicio=true;
				return RegexFacilities.removerPatronTexto("^\\W*"+auxAceptada+"\\s+",frase);
			}
		}
		return frase;
	}
	
	private String identificarIndIntermedio(String frase){
		// comprueba que haya algún indicador intermedio, 
		//de haberlo y de haber un indicador inicial 
		//indentifica lo que hay entre ellos como el inicio 
		String auxAceptada="";
		for(String aceptada:diccionario.getPalabrasIntermedias()){
			auxAceptada=RegexFacilities.normalizarTexto(aceptada);
			if(RegexFacilities.existeEnElTexto("((^"+auxAceptada+")|(\\W+)"+auxAceptada+")\\W+",frase)){
				hayIndMedio=true;
				if(hayIndInicio && RegexFacilities.existeEnElTexto("\\w+\\W+"+auxAceptada+"\\W+",frase)){
					hayInicio=true;
					return RegexFacilities.removerPatronTexto("\\w+\\W+"+auxAceptada+"\\W+",frase);
				}
				return RegexFacilities.removerPatronTexto("^\\w*\\W*"+auxAceptada+"\\W+",frase);
			}
		}
		
		return frase;
	}
	
	private void identificarIndFinal(String frase){
		String auxAceptada="";
		for(String aceptada:diccionario.getPalabrasFinales()){
			auxAceptada=RegexFacilities.normalizarTexto(aceptada);
			if(!hayIndMedio && !hayIndInicio && RegexFacilities.existeEnElTexto("((^"+auxAceptada+")|(\\W+"+auxAceptada+"))\\W*",frase)){
					hayIndFinal=true;
			}else{
				if(RegexFacilities.existeEnElTexto("(\\w+\\W+)"+auxAceptada+"\\W*",frase)){
					hayIndFinal=true;
					if(hayIndMedio){
						hayMedio=true;
					}else{
						hayInicio=true;
					}
				}
				if(RegexFacilities.existeEnElTexto("^"+auxAceptada+"\\W*",frase)){

					hayIndFinal=true;
				}
			}
			if(hayIndFinal && RegexFacilities.existeEnElTexto(auxAceptada+"\\s+\\w+",frase)){
				hayFin=true;
				return;
			}	
		}
		if(!hayIndFinal){
			if(hayIndMedio && !frase.trim().isEmpty()){
				hayMedio=true; //La frase no esta vacía y no tengo indicador de fin...
			}else if(hayIndInicio && !frase.trim().isEmpty()){
				hayInicio=true;
			}
		}
	}
	
	//Evalua que indicadores posee 
	private void identificarIndicadores(String frase){
		hayIndInicio=false; hayIndMedio=false; hayIndFinal=false;
		hayInicio=false; hayMedio=false; hayFin=false;
		String auxFrase=RegexFacilities.normalizarTexto(frase);
		auxFrase=identificarIndInicio(auxFrase);
		if(!auxFrase.isEmpty()){
			auxFrase=identificarIndIntermedio(auxFrase);
		}
		if(!auxFrase.isEmpty()){
			identificarIndFinal(auxFrase);
		}
	}
	
	private boolean necesitoEvaluar(String frase){
		String auxFrase=frase.trim();
		if(auxFrase.isEmpty()){
			return false;
		}
		return true;
	}
	
	//Genera sugerencias, considerando que la frase esta terminada
	private String generarSugerenciaGeneral(String frase,String codigoDiccionario){
		if(necesitoEvaluar(frase)){
			identificarIndicadores(frase);
			if(hayIndInicio && hayInicio && hayIndMedio && hayMedio && hayIndFinal && hayFin){
				return "";
			}
			if((!hayIndInicio && !hayIndMedio && !hayIndFinal)||
					(hayIndInicio && hayIndMedio && hayIndFinal && !hayInicio && !hayMedio && !hayFin)){
				return sugerencias.getSugerencia(codigoDiccionario.concat("7"));
			}
			if(((hayIndInicio && !hayInicio)|| !hayIndInicio) && hayIndMedio && 
					hayMedio && hayIndFinal && hayFin){
				return sugerencias.getSugerencia(codigoDiccionario.concat("1"));
			}
			if(hayIndInicio  && hayInicio && ((hayIndMedio && !hayMedio)||(!hayIndMedio)) 
					&& hayIndFinal && hayFin){
				return sugerencias.getSugerencia(codigoDiccionario.concat("2"));
			}
			if(hayIndInicio  && hayInicio && hayIndMedio && hayMedio  
					&& ((hayIndFinal && !hayFin) || !hayIndFinal)){
				return sugerencias.getSugerencia(codigoDiccionario.concat("3"));
			}
			if(((hayIndInicio && !hayInicio)||(!hayIndInicio)) && 
					((hayIndMedio && !hayMedio)||(!hayIndMedio)) && hayIndFinal && hayFin){
				return sugerencias.getSugerencia(codigoDiccionario.concat("4"));
			}
			if(((hayIndInicio && !hayInicio)||(!hayIndInicio)) && hayIndMedio && hayMedio && 
					((hayIndFinal && !hayFin)||(!hayIndFinal)) ){
				return sugerencias.getSugerencia(codigoDiccionario.concat("5"));
			}
			if(((hayIndInicio && !hayInicio)||(!hayIndInicio)) && hayIndMedio && hayMedio && 
					((hayIndFinal && !hayFin)||(!hayIndFinal)) ){
				return sugerencias.getSugerencia(codigoDiccionario.concat("6"));
			}
			
		}
		return sugerencias.getSugerencia(codigoDiccionario.concat("7"));
	}
	
	//genera sugerencias solo hasta lo que va leyendo...
	private String getSugerenciaParcial(String frase,String codigoDiccionario){
		String sugerencia="";
		if(necesitoEvaluar(frase)){
			identificarIndicadores(frase);
			if((!hayIndInicio  || (hayIndInicio && !hayInicio))&& (!hayIndMedio || (hayIndMedio && !hayMedio)) && hayIndFinal){
				return sugerencias.getSugerencia(codigoDiccionario.concat("4"));
			}
			if(hayIndInicio  && hayInicio && hayIndFinal && ((hayIndMedio && !hayMedio) ||(!hayIndMedio)) ){
				return sugerencias.getSugerencia(codigoDiccionario.concat("2"));
			}
			if((!hayIndInicio ||(hayIndInicio && !hayInicio))&& (hayIndMedio || (hayIndMedio && hayMedio && hayIndFinal))){
				return sugerencias.getSugerencia(codigoDiccionario.concat("1"));
			}
			if(!hayIndInicio  && !hayIndMedio && !hayIndFinal && RegexFacilities.existeEnElTexto("\\w+",frase)){
				return sugerencias.getSugerencia(codigoDiccionario.concat("7"));
			}
		}
		return sugerencia;
	}
}
