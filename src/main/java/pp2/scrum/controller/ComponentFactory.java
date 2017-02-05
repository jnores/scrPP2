/**
 * 
 */
package pp2.scrum.controller;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;

/**
 * @author yoshknight
 *
 */
public class ComponentFactory {

    private Map<String,Object> loadedComponents = new HashMap<String,Object>();
    private Properties properties;

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
    public Object getComponentByName(String componente) throws NoSuchElementException,InstantiationException {

        Object objTemp=null;

        if ( loadedComponents.containsKey(componente) )
            objTemp = loadedComponents.get(componente);
        else {
            if ( !properties.containsKey(componente) )
                throw new NoSuchElementException("No existe configuracion para el componente solicitado: "+componente);

            String className = properties.getProperty(componente).trim();

            if ( className.length()==0 )
                throw new NoSuchElementException( "Error iniciando componente: "+componente+". El valor configurado no puede ser vacio" );

            objTemp = createComponent(className);

            loadedComponents.put(componente, objTemp);
        }
        return objTemp;
    }

    private Object createComponent(String className) {
        Object objTemp=null;
        
        try {
            Constructor<?> constructor = null;
            boolean hasVoidConstructor=false;
            boolean hasConstructorWithParameter=false;
    
            Constructor<?>[] constructors = Class.forName(className).getConstructors();
    
            for (Constructor<?> tmpConstructor : constructors) {
                if ( tmpConstructor.getParameterTypes().length == 0 
                        && !hasConstructorWithParameter) {
                    constructor=tmpConstructor;
                    hasVoidConstructor = true;
                } else if (isConstructorWithProperties(tmpConstructor)) {
                    constructor=tmpConstructor;
                    hasConstructorWithParameter= true;
                }
            }
    
            if (hasConstructorWithParameter)
                objTemp = constructor.newInstance(properties);
            else if (hasVoidConstructor)
                objTemp = constructor.newInstance();
            else
                new InstantiationError("Error iniciando componente: La clase "
                        + className
                        +". no posee un constructor público válido.");
    
    
        } catch (ClassNotFoundException | IllegalAccessException 
                | InstantiationException | IllegalArgumentException 
                | InvocationTargetException e) {
            InstantiationError ex = new InstantiationError("Error iniciando componente: "+className+". No se pudo instanciar el componente.");
            ex.addSuppressed(e);
            throw ex;
        }
        return objTemp;

    }
    
    private boolean isConstructorWithProperties(Constructor<?> constructor) {
        return constructor.getParameterTypes().length == 1 
                && constructor.getParameterTypes()[0].equals(Properties.class);
    }
}

