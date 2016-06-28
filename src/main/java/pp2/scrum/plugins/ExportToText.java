package pp2.scrum.plugins;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import pp2.scrum.controller.Exporter;
import pp2.scrum.controller.UserStoryHelper;

public class ExportToText implements Exporter {
	private String rutaTxt;
	private String extension = ".txt"; 
	
	@Override
	public void export(String ruta, List<UserStoryHelper> userStoriesHlpr) {
		this.rutaTxt = ruta + extension;
		if (userStoriesHlpr.size()==0)
			throw new RuntimeException("No existen historias de usuario para exportar.");
		try {

			String content = userStoriesHlpr.toString();

			File file = new File(rutaTxt);

			//si no existe el archivo, lo creo
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();	

		} catch (IOException e) {
//			e.printStackTrace();
		}

	
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Exportar a texto";
	}
}
