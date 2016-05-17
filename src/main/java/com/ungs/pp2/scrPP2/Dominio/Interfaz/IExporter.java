package com.ungs.pp2.scrPP2.Dominio.Interfaz;

import java.util.List;

import com.ungs.pp2.scrPP2.Controller.UserStoryHelper;
import com.ungs.pp2.scrPP2.utils.PluginFactory;

public interface IExporter {
			
	//public static final IExporter INSTANCE = (IExporter) PluginFactory.getPlugin(IExporter.class);
	
	public String toString();
	//ver de poner el path del archivo de cfg en cada clase exporter.
	public void export(String path, List<UserStoryHelper> userStoriesHlpr);
}
