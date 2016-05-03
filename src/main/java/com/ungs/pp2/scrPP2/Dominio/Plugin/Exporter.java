package com.ungs.pp2.scrPP2.Dominio.Plugin;

public interface Exporter {
	
	//Singleton, separated interface, plugin
	public static final Exporter INSTANCE = (Exporter) PluginFactory.getPlugin(Exporter.class);
	
	public void export();
}
