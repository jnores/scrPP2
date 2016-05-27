package pp2.scrum.dominio.entidad;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

 
public class GestorSugerencias {
	
	private final HashMap<String,String> sugerencias;
	private Properties propiedades;
	private final String path="src/main/resources/file/Sugerencias.txt";
	
	private static GestorSugerencias catalogo;
	
	private GestorSugerencias(){
		sugerencias=new HashMap<String,String> ();
		propiedades = new Properties();
		cargarSugerencias();
	}
	
	public static GestorSugerencias getCatalogo(){
		if(catalogo==null){
			catalogo=new GestorSugerencias();
		}
		return catalogo;
	}
	
	private void cargarSugerencias(){
		InputStream inputStream = null; 
		try {
			inputStream = new FileInputStream(path);
			propiedades.load(inputStream);
		} catch(Exception e) {
			return ;
		}
		Enumeration<Object> enumeracion = propiedades.keys();
		while (enumeracion.hasMoreElements())
		{
			String clave = enumeracion.nextElement().toString();
			String dato = propiedades.getProperty(clave);
			sugerencias.put(clave, dato);
		}
	}
	
	public String getSugerencia(String clave){
		return sugerencias.get(clave);
	}
	
}