package com.ungs.pp2.scrPP2.Dominio.Plugin;

import java.util.List;

import com.ungs.pp2.scrPP2.Controller.UserStoryHelper;

public interface Exporter {
		
	//Singleton, separated interface, plugin
	public static final Exporter INSTANCE = (Exporter) PluginFactory.getPlugin(Exporter.class);
	
	public void export(String path, List<UserStoryHelper> userStoriesHlpr);
}
