/**
 * 
 */
package pp2.scrum.controller;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;

import pp2.scrum.utils.Logger;

/**
 * @author yoshknight
 *
 */
public class ComponentFactory {

	private Map<String,Object> loadedComponents = new HashMap<String,Object>();
	private Properties properties;

	@SuppressWarnings("unused")
	private ComponentFactory(){}

	public ComponentFactory(Properties properties) {
		if (properties == null)
			throw new NullPointerException("ERROR Instanciando ComponentFactory, El argumento no puede ser nulo.");
		this.properties = properties;
	}

	/**
	 * Intancia el componente solicitado con la informacion que este en el archivo de configuracion.
	 * Trbaja con un Registry para instanciar el componente solo una vez.
	 * 
	 * @param componente
	 * @return Instancia del componente solicitado.
	 * @throws NoSuchElementException
	 * @throws InstantiationException
	 */
	@SuppressWarnings("rawtypes")
	public Object getComponentByName(String componente) throws NoSuchElementException,InstantiationException {

		Object objTemp=null;

		if ( loadedComponents.containsKey(componente) )
			objTemp = loadedComponents.get(componente);
		else {
			if ( !properties.containsKey(componente) )
				throw new NoSuchElementException("No existe configuracion para componente solicitado: "+componente);

			String className = properties.getProperty(componente).trim();

			if ( className.length()==0 )
				throw new NoSuchElementException( "Error iniciando componente: "+componente+". El valor configurado no puede ser vacio" );


			try {
				try {
					Constructor constructor = Class.forName(className).getConstructor(Properties.class);
					objTemp = constructor.newInstance(properties);
				} catch (Exception e) {
					Logger.log("No tiene constructor con parametro Properties");
				}
				
				if (objTemp == null)
					objTemp = Class.forName(className).newInstance();

			} catch (ClassNotFoundException | IllegalAccessException e) {
				InstantiationError ex = new InstantiationError("Error iniciando componente: "+componente+". No se pudo instanciar el componente.");
				ex.addSuppressed(e);
				throw ex;
			}

			if (objTemp == null )
				throw new InstantiationError("Error iniciando componente: "+componente+". No se pudo instanciar el componente.");

			loadedComponents.put(componente, objTemp);
		}
		return objTemp;
	}

}

