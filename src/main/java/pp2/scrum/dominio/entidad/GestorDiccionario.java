package pp2.scrum.dominio.entidad;

import java.io.FileReader;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

public class GestorDiccionario {

	private static final String path="src/main/resources/file/DataDiccionario.json";
	private final DiccionarioSintactico diccionarioUserStory,diccionarioCriterios;


	private static GestorDiccionario gestor;

	private GestorDiccionario(){
		diccionarioUserStory=new DiccionarioSintactico();
		diccionarioCriterios=new DiccionarioSintactico();
		extraerData();
	}

	public static GestorDiccionario getGestor(){
		if(gestor==null){
			gestor=new GestorDiccionario();
		}
		return gestor;
	}

	private void extraerDataDiccionario(JsonArray diccionario, final DiccionarioSintactico diccionarioS){
		for(JsonElement elemento: diccionario){
			ArrayList<String> palabrasAceptadas=new Gson().fromJson(elemento.toString(), new TypeToken<ArrayList<String>>(){}.getType());
			diccionarioS.addPalabras(palabrasAceptadas);
		}
	}

	private void extraerData(){
		JsonParser parser = new JsonParser();
		try {
			JsonArray diccionarios = (JsonArray) parser.parse(new FileReader(path));
			
			//don't worry be happy :D
			JsonArray diccionarioHistorias=diccionarios.get(0).getAsJsonArray();
			JsonArray diccionarioCriterios=diccionarios.get(1).getAsJsonArray();
			extraerDataDiccionario(diccionarioHistorias, this.diccionarioUserStory);
			extraerDataDiccionario(diccionarioCriterios, this.diccionarioCriterios);
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
	}

	public DiccionarioSintactico getDiccionarioUserStory(){
		return this.diccionarioUserStory;
	}

	public DiccionarioSintactico getDiccionarioCriterios(){
		return this.diccionarioCriterios;
	}
}
