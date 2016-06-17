/**
 * 
 */
package pp2.scrum.dominio.entidad;

/**
 * @author yoshknight
 *
 */
public interface Notificador {
    public void sendMail(String destino,String asunto,String mensaje);
}
