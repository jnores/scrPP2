package pp2.scrum.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Lector {
	
	private String cadena;
	private FileReader lector;
	private BufferedReader buffered;
	
	
	public String leerArchivo(String archivo) {
		String texto="";
		try {
			lector = new FileReader(archivo);
			buffered = new BufferedReader(lector);

			while((cadena = buffered.readLine())!=null) {
				texto=texto.concat(cadena+"\n");
			}
			buffered.close();
			lector.close();
		}  catch (FileNotFoundException excepcion){
			excepcion.getLocalizedMessage ();
		}catch (IOException excepcion) {
			excepcion.getLocalizedMessage();
		}
		return texto;
	}
	
}
