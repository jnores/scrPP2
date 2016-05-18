package com.ungs.pp2.scrPP2.Dominio.Entidad;


public class Indicador {
	private String tipoIndicador;		//Que tipo de indicador es
	private String frase; 			//La frase aceptada que se encontro, o vacio si no se hallo nada.
	private String sugerencia;		//Sugerencias relativas al indicador y lo que indica.
	
	public Indicador(String indicador){
		this.tipoIndicador=indicador;
		this.frase="";
		sugerencia="";
	}
	
	public String getIdentificador(){
		return tipoIndicador;
	}
	
	public void setFrase(String frase){
		this.frase=frase;
	}
	
	public String getFrase(){
		return frase;
	}
	
	public String getSugerencia(){
		return this.sugerencia;
	}
	
	public void setSugerencia(String sugerencia){
		this.sugerencia=this.sugerencia.concat(sugerencia+"\n");
	}
}
