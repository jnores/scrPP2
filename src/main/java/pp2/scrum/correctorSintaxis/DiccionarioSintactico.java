package pp2.scrum.correctorSintaxis;

import java.util.ArrayList;

public class DiccionarioSintactico{

	private ArrayList<ArrayList<String>> palabrasAceptadas;
	
	public DiccionarioSintactico(){

		palabrasAceptadas=new ArrayList<ArrayList<String>>();
	}
	
	public void addPalabras(ArrayList<String> aceptadas){
		this.palabrasAceptadas.add(aceptadas);
	}
	
	public ArrayList<String> getPalabrasIniciales(){
		return this.palabrasAceptadas.get(0);
	}
	
	public ArrayList<String> getPalabrasIntermedias(){
		return this.palabrasAceptadas.get(1);
	}
	
	public ArrayList<String> getPalabrasFinales(){
		return this.palabrasAceptadas.get(2);
	}
}