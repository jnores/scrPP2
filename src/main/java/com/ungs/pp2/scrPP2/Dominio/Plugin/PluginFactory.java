package com.ungs.pp2.scrPP2.Dominio.Plugin;

import java.util.Properties;

class PluginFactory
{
	private static Properties props = new Properties();
	
	static{
		try
		{
			//Carga el archivo para saber de que forma linkear las clases despues
			//props.load(PluginFactory.class.getResourceAsStream("/com/ungs/pp2/scrPP2/Dominio/Plugin/properties"));
			props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("config/properties"));
			
		}
		catch(Exception e)
		{
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static Object getPlugin(Class iface) 
	{
		//Busca el nombre de la implementacion
		String implName = props.getProperty(iface.getName());
		if (implName == null) {
			throw new RuntimeException("implementation not specified for " + iface.getName() + " in PluginFactory propeties.");
		}
		try {
			//retorna nueva instancia de la implementacion de la clase
			return Class.forName(implName).newInstance();
		} catch (Exception ex) {
			throw new RuntimeException("factory unable to construct instance of " + iface.getName());
		}
	}
}