/**
 * 
 */
package pp2.scrum.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yoshknight
 *
 */
public class Calendario {

    public static final long DAY = 86400000;
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");

    public static Date getFechaIntermedia(Date inicio, Date fin) {
        long diferencia= fin.getTime()-inicio.getTime();
        long diferenciaDias = ((long)((diferencia/2)/DAY) )*DAY;

        return new Date(inicio.getTime()+diferenciaDias);
    }

    public static int getDuracion(Date inicio, Date fin) {
        long diferencia= fin.getTime()-inicio.getTime();
        return (int) (diferencia/DAY);
    }

    public static Date agregarDias(Date inicio, long dias) {
        long diasEnMili= dias * DAY ;
        return new Date(inicio.getTime()+diasEnMili); 
    }

    public static Date getDate(String string) throws ParseException {

        return dateFormat.parse(string);
    }

    public static Date getToday() {
        return new Date();
    }
}
