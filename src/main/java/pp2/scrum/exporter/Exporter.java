package pp2.scrum.exporter;

import java.util.List;

import pp2.scrum.controller.UserStoryHelper;

public interface Exporter {
			
	//public static final IExporter INSTANCE = (IExporter) PluginFactory.getPlugin(IExporter.class);
	
	public String toString();
	
	public void export(String path, List<UserStoryHelper> userStoriesHlpr);
}
