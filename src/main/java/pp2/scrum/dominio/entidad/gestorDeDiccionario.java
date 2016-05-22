package pp2.scrum.dominio.entidad;

import java.io.FileReader;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

public class gestorDeDiccionario {

	private static final String path="src/main/resources/file/Data.json";
	private final DiccionarioSintactico diccionarioUserStory,diccionarioCriterios;
	private final CatalogoDeSugerencias sugerencias;

	private static gestorDeDiccionario gestor;
	
	private gestorDeDiccionario(){
		diccionarioUserStory=new DiccionarioSintactico();
		diccionarioCriterios=new DiccionarioSintactico();
		sugerencias=new CatalogoDeSugerencias(); 
		extraerData();
	}
	
	public static gestorDeDiccionario getGestor(){
		if(gestor==null){
			gestor=new gestorDeDiccionario();
		}
		return gestor;
	}
	
	private void extraerDataDiccionario(JsonObject objeto, final DiccionarioSintactico diccionario){
		String indicador;
		JsonArray listaJson;
		ArrayList<String> lista;

		JsonArray diccionarioJson=objeto.getAsJsonArray("Aceptadas");
		for(JsonElement elemento:diccionarioJson){
			JsonObject elementoReal=elemento.getAsJsonObject();
			indicador=elementoReal.get("Indicador").getAsString();
			listaJson=elementoReal.getAsJsonArray("Palabras Aceptadas");
			lista= new Gson().fromJson(listaJson.toString(), new TypeToken<ArrayList<String>>(){}.getType());
			diccionario.setPalabrasAceptadas(indicador,lista);
		}
		listaJson=objeto.getAsJsonArray("Orden");
		for(JsonElement elemento:listaJson){
			JsonObject elementoReal=elemento.getAsJsonObject();
			indicador=elementoReal.get("Indicador").getAsString();
			diccionario.addElemento(indicador);

		}
	}
	
	private void extraerData(){
	
	JsonParser parser = new JsonParser();
	try {
		JsonObject objeto = (JsonObject) parser.parse(new FileReader(path));
		
		
		JsonArray diccionarios = objeto.getAsJsonArray("Diccionarios");

		JsonObject diccionario1 = (JsonObject) diccionarios.get(0);
		JsonObject diccionario2 = (JsonObject) diccionarios.get(1);		

		extraerDataDiccionario(diccionario1,this.diccionarioUserStory);
		extraerDataDiccionario(diccionario2,this.diccionarioCriterios);
		JsonArray catalogo = objeto.getAsJsonArray("Catalogo");
		for(JsonElement elemento:catalogo){
			JsonObject elementoReal=elemento.getAsJsonObject();
			String indicador=elementoReal.get("Indicador").getAsString();
			String sugerencia=elementoReal.get("Sugerencia").getAsString();
			this.sugerencias.setSugerencia(indicador, sugerencia);

		}
		
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
	
	public CatalogoDeSugerencias getSugerencias(){
		return this.sugerencias;
	}
	
}
