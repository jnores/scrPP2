package pp2.scrum.dominio.interfaz;

import java.util.List;

import pp2.scrum.controller.UserStoryHelper;
import pp2.scrum.utils.PluginFactory;

public interface IExporter {
			
	//public static final IExporter INSTANCE = (IExporter) PluginFactory.getPlugin(IExporter.class);
	
	public String toString();
	//ver de poner el path del archivo de cfg en cada clase exporter.
	public void export(String path, List<UserStoryHelper> userStoriesHlpr);
}
