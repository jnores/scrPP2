package pp2.scrum.dominio.entidad;

import java.util.HashMap;

public class CatalogoDeSugerencias {
	
	private HashMap<String,String> catalogo;
	
	public CatalogoDeSugerencias(){
		catalogo=new HashMap<String,String> ();
	}
	
	public void setSugerencia(String clave,String dato){
		catalogo.put(clave, dato);
	}
	
	public String getSugerencia(String clave){
		return catalogo.get("Identificador"+clave);
	}
	
	public String getSugerenciaIndicado(String clave){
		return catalogo.get(clave);
	}
}