/**
 * 
 */
package pp2.scrum.calendario;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yoshknight
 *
 */
public class Calendario extends CalendarioService {

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

    /* (non-Javadoc)
     * @see pp2.scrm.calendario.ClendarioService#getFechaIntermedia(java.util.Date, java.util.Date)
     */
    @Override
    public Date getFechaIntermedia(Date inicio, Date fin) {
        long diferencia= fin.getTime()-inicio.getTime();
        long diferenciaDias = ((long)((diferencia/2)/DAY) )*DAY;

        return new Date(inicio.getTime()+diferenciaDias);
    }

    /* (non-Javadoc)
     * @see pp2.scrm.calendario.ClendarioService#getDuracion(java.util.Date, java.util.Date)
     */
    @Override
    public int getDuracion(Date inicio, Date fin) {
        long diferencia= fin.getTime()-inicio.getTime();
        return (int) (diferencia/DAY);
    }

    /* (non-Javadoc)
     * @see pp2.scrm.calendario.ClendarioService#agregarDias(java.util.Date, long)
     */
    @Override
    public Date agregarDias(Date inicio, long dias) {
        long diasEnMili= dias * DAY ;
        return new Date(inicio.getTime()+diasEnMili); 
    }

    /* (non-Javadoc)
     * @see pp2.scrm.calendario.ClendarioService#getDate(java.lang.String)
     */
    @Override
    public Date getDate(String string) throws ParseException {

        return dateFormat.parse(string);
    }

    /* (non-Javadoc)
     * @see pp2.scrm.calendario.ClendarioService#getToday()
     */
    @Override
    public Date getToday() {
        return new Date();
    }
    
    /* (non-Javadoc)
     * @see pp2.scrm.calendario.ClendarioService#createString(java.util.Date)
     */
    @Override
    public String createString(Date date) {
        return dateFormat.format(date);
    }
    
}
