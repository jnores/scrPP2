package pp2.scrum.utils;

import java.text.Normalizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexFacilities {
	
	public static String normalizarTexto(String texto){
		texto = texto.toLowerCase(); // Podría usar mayúsculas pero da lo mismo
		texto = Normalizer.normalize(texto, Normalizer.Form.NFKD);
		return texto.replaceAll("[^\\p{ASCII}]","");// Cambio las tildes y demás símbolos raros XD
	}
	
	public static boolean existeEnElTexto(String patron,String texto){
		Pattern pattern;
		Matcher matcher;
		pattern = Pattern.compile(patron);
		matcher = pattern.matcher(texto);
		return matcher.find();
	}
	
	public static String removerPatronTexto(String patron,String texto){
		String cadena = texto.replaceFirst(patron,"");
		return cadena;
	}
}
