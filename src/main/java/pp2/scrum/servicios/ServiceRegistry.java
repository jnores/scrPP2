/**
 * 
 */
package pp2.scrum.servicios;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yoshknight
 *
 */
public class ServiceRegistry {
    static private ServiceRegistry _instance = new ServiceRegistry();
    private Map<String, Service> servicios; 
    
    private ServiceRegistry() {
        servicios = new HashMap<>();
    }
    
    public static ServiceRegistry getInstance() {
        return _instance;
    }
    
    public void registerService(Service service) {
        servicios.put(service.getName(), service);
    }
    
    public boolean hasService(String serviceName) {
        return servicios.containsKey(serviceName);
    }
    
    public Service getService(String serviceName) {
        return servicios.get(serviceName);
    }

}
