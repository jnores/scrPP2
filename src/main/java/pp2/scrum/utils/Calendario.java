/**
 * 
 */
package pp2.scrum.utils;

import java.util.Date;

/**
 * @author yoshknight
 *
 */
public class Calendario {

	public static Date getFechaIntermedia(Date inicio, Date fin) {
		long diferencia= fin.getTime()-inicio.getTime();
		long diferenciaDias = ((long)((diferencia/2)/86400000) )*86400000;
		
		return new Date(inicio.getTime()+diferenciaDias);
	}

	public static int getDuracion(Date inicio, Date fin) {
		long diferencia= fin.getTime()-inicio.getTime();
		return (int) ((diferencia)/86400000);
	}

}
