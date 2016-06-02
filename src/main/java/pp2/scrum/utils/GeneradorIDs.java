package pp2.scrum.utils;

public class GeneradorIDs {
		
	public static String generarID(){
		//genero un string de letras y numeros 
		return java.util.UUID.randomUUID().toString().replaceFirst("-.*","");
	}
	
	public static long generarIDLong(){
		return java.util.UUID.randomUUID().hashCode();
	} 
}