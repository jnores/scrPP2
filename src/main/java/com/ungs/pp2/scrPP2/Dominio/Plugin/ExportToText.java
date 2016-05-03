package com.ungs.pp2.scrPP2.Dominio.Plugin;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ExportToText implements Exporter {

	@Override
	public void export() {
		// TODO Auto-generated method stub
		try {

			String content = "Aca va la frula";

			File file = new File("c:/archivo_txt");

			//si no existe el archivo, lo creo
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();	

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
