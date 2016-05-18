package com.ungs.pp2.scrPP2.Dominio.Entidad;

import java.util.ArrayList;
import java.util.HashMap;

public class DiccionarioSintactico{

	private HashMap<String,ArrayList<String>> palabrasAceptadas;
	private ArrayList<String> orden;
	
	public DiccionarioSintactico(){

		palabrasAceptadas=new HashMap<String,ArrayList<String>>();
		orden=new ArrayList<String>();
	}
	
	public void addElemento(String identificador){
		this.orden.add(identificador);
	}
	
	public ArrayList<String> getOrden(){
		return this.orden;
	}
	
	public void setPalabrasAceptadas(String clave,ArrayList<String> aceptadas){
		this.palabrasAceptadas.put(clave,aceptadas);
	}

	
	public ArrayList<String> getAceptadas(String clave){
		return this.palabrasAceptadas.get(clave);
	}
}