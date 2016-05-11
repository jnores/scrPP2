package com.ungs.pp2.scrPP2.Dominio.Entidad;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.regex.Pattern;

public class CorrectorDeSintaxis {

	private static CorrectorDeSintaxis corrector;
	private final static String archivoSugerencias = "src/main/resources/file/Aceptadas.txt",
			rol="Rol:", meta="Meta:",finalidad="Finalidad:",
			indRol="marcaRol",indMeta="marcaMeta",indFinalidad="marcaProposito",noident="NoIdentificado";
	private static ArrayList<String> indicadoresRol,indicadoresMeta,indicadoresProposito;
	private TreeMap<String,String> analizadas;
	

	private CorrectorDeSintaxis() {
		FileReader fileReader = null;
		BufferedReader bufferedReader=null;
		try {

			fileReader = new FileReader(new File(archivoSugerencias));
			bufferedReader = new BufferedReader(fileReader);
			String linea;
			while ((linea = bufferedReader.readLine()) != null) {
				crearListasPalabrasSugeridas(linea);
			}
		} catch (Exception e) {System.out.println("error");} 
		finally {
			try {
				if (bufferedReader!=null){bufferedReader.close();}
				if (fileReader != null) {fileReader.close();}
			} catch (Exception e2) {System.out.println("no habia archivo");}
		}
	}
	
	private void crearListasPalabrasSugeridas(String linea){
		String [] palabras = linea.split(Pattern.quote("*"));
		ArrayList<String> listaAux=new ArrayList<String>();
		for(int i=1;i<palabras.length;i++){
				listaAux.add(neutralizar(palabras[i]));
		}
		if(palabras[0].contains(rol)){
			this.indicadoresRol=listaAux;
		}
		if(palabras[0].contains(meta)){
			this.indicadoresMeta=listaAux;
		}
		if(palabras[0].contains(finalidad)){
			this.indicadoresProposito=listaAux;
		}
	}

	public static CorrectorDeSintaxis getCorrector(){
		if(corrector==null){
			corrector=new CorrectorDeSintaxis();
		}
		return corrector;
	}
	
	public String analizarFrase(String frase) {
		if(frase.isEmpty()){
			return "";
		}
		analizadas=new TreeMap<String,String>();
		String fraseUsuario=frase;
		fraseUsuario=neutralizar(fraseUsuario);
		identificarIndicadores(fraseUsuario);
		identificarPalabraInvocacion(fraseUsuario);
		fraseUsuario=frase;
		fraseUsuario=neutralizar(fraseUsuario);
		return generarSugerencia();
	}
	
	private String neutralizar(String frase){
		frase=frase.replaceAll("á", "a");frase=frase.replaceAll("à", "a");
		frase=frase.replaceAll("é", "e");frase=frase.replaceAll("è", "e");
		frase=frase.replaceAll("í", "i");frase=frase.replaceAll("ì", "i");
		frase=frase.replaceAll("ó", "o");frase=frase.replaceAll("ò", "o");
		frase=frase.replaceAll("ú", "u");frase=frase.replaceAll("ù", "u");
		frase=frase.toLowerCase();
		return frase;
	}
	
	//Precondición: El Archivo de origen debe estar ordenado por cantidad de palabras en el indicador.
	private void identificarIndicadores(String frase){
		for(String indicadorRol:indicadoresRol){
			if(frase.contains(indicadorRol.toLowerCase())){
				frase=frase.replace(indicadorRol.toLowerCase(), "");
				analizadas.put(indRol,indicadorRol.toLowerCase());
			}
		}
		for(String indicadorMeta:indicadoresMeta){
			if(frase.contains(indicadorMeta)){
				frase=frase.replace(indicadorMeta, "");
				analizadas.put(indMeta,indicadorMeta);
			}
		}
		for(String indicadorProposito:indicadoresProposito){
			if(frase.contains(indicadorProposito)){
				frase=frase.replace(indicadorProposito, "");
				analizadas.put(indFinalidad,indicadorProposito);
			}
		}
	}
	
	private void identificarPalabra(String frase,String clave,String indicadorI,String indicadorF){//clave es rol,meta,etc; el indicadorI o F ej como, para
		String auxFrase=frase;
		String auxPalabra="";
		int indiceInicio=0;
		if(indicadorI!=null && indicadorF!=null){ 
			auxFrase=auxFrase.substring(frase.indexOf(indicadorI));		//remuevo lo que esta adelante del indicador
			auxFrase=auxFrase.replace(indicadorI,""); 					//remuevo el indicador
			try{
				auxPalabra=auxFrase.substring(indiceInicio, auxFrase.indexOf(indicadorF));	//Remuevo lo que esta detras 
				if(!(auxPalabra.trim()).isEmpty()){
					analizadas.put(clave, auxPalabra); //Si la frase final no esta vacia la guardo
				}	
			}catch(Exception e){}
		}else{
			if(indicadorI!=null && indicadorF==null){
				auxPalabra=frase.replace(indicadorI, "");
				if(!(auxPalabra.trim()).isEmpty()){
					analizadas.put(clave, auxPalabra);
				}
			}
		}
	}
	 
	private void identificarPalabraInvocacion(String frase){
		identificarPalabra(frase,this.rol,analizadas.get(indRol),analizadas.get(this.indMeta));
		identificarPalabra(frase,this.meta,this.analizadas.get(indMeta),analizadas.get(this.indFinalidad));
		identificarPalabra(frase,this.finalidad,this.analizadas.get(indFinalidad),null);
	}
	
	private String generarSugerencia(){
		String nada="";
		String indicadorRol=analizadas.get(indRol),indicadorMeta=analizadas.get(indMeta),indicadorProposito=analizadas.get(indFinalidad),
				rol=analizadas.get(this.rol),meta=analizadas.get(this.meta),finalidad=analizadas.get(this.finalidad);
		
		String formato="Recuerde que el formato de una user story es \"Como un <ROL> necesito <META> para <PROPÓSITO>.\"\n"
				+ "Ejemplo: Como <moderador>, necesito <poder crear nuevas salas de juego>, para <invitar a los usuarios>.";
		String faltaRol="Recuerde indicar a quién va dirigida la User Story";
		String faltaIndRol="En general una user story empieza con la palabra \"Como\"";
		String faltaMeta="Recuerde indicar la meta de la user story, tras "+indicadorMeta;
		String faltaIndMeta="Recuerde marcar la meta, \"necesito, requiero, quiero, etc.\"";
				System.out.println("indRol: "+indicadorRol+" rol"+rol);
		if(analizadas.isEmpty()){
			return formato;
		}
		if(indicadorRol!=null && indicadorMeta!=null && indicadorRol!=null){
			if(rol!=null && meta!=null){
				return nada;
			}else{
				if(rol==null && meta!=null){
					return faltaRol;
				}else{
					return faltaMeta;
				}
			}
		}
		if(indicadorRol==null && indicadorMeta==null && indicadorRol==null){
			return formato;
		}
		if(indicadorRol!=null && indicadorMeta!=null){
			if(rol!=null && meta!=null){
				return nada;
			}else{
				if(rol!=null && meta==null){
					return nada;
				}else{
					return faltaIndRol;
				}
			}
		}
		if(indicadorMeta!=null && indicadorProposito!=null){
			if(rol!=null && meta!=null){
				return faltaIndRol;
			}else{
				if(rol!=null && meta==null){
					return faltaMeta;
				}else{
					return faltaIndRol+faltaRol;
				}
			}
		}
		if(indicadorRol!=null && indicadorProposito!=null){
			return faltaIndMeta;
		}
		if(indicadorRol!=null){
			return nada;
		}
		if(indicadorMeta!=null){
			return faltaIndRol.concat("\n"+faltaRol);
		}
		if(indicadorProposito!=null){
			return formato;
		}
		return "";
	}

}
