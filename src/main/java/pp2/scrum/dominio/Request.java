/**
 * 
 */
package pp2.scrum.dominio;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;

/**
 * Clase utilizada para enviar las peticiones al homeController.
 * 
 * @author yoshknight
 *
 */
public class Request {
	
	private Map<String,String> parametros=null;
	
	/**
	 * Constructor por defarult
	 */
	public Request() {
		parametros = new HashMap<String,String> ();
	}
	
	/**
	 * Metodo para agregar parametros al request. si el parametro ya existe sera actualizado.
	 * 
	 * @param parametro parametro a definir del request
	 * @param valor valor del parametro que se esta definiendo
	 */
	public void agregarParametro(String parametro, String valor) throws NullPointerException{
		if (parametro == null )
			throw new NullPointerException("El parametro a agregar no puede ser null");
		if (valor == null )
			throw new NullPointerException("El valor asociado al parametro no puede ser null");
		parametros.put(parametro, valor);
	}
	
	/**
	 * Funcion usada para consultar si esta definido un parametro en particular en el request.
	 * 
	 * @param parametro
	 * @return True si contiene el parametro pasado por parametro o false en caso contrario.
	 */
	public boolean contieneParametro(String parametro) throws NullPointerException{
		if (parametro == null )
			throw new NullPointerException("El parametro a buscar no puede ser null");
		return parametros.containsKey(parametro);
	}
	
	/**
	 * Funcion encargada de buscar el valor asociado al parametro solicitado
	 * 
	 * @param parametro
	 * @return
	 */
	public String obtenerParametro(String parametro) {
		if (!contieneParametro(parametro))
			throw new InvalidParameterException("El parametro solicitad no puede ser un elemento null");
		
		return parametros.get(parametro);
	}
	
	
}

