package pp2.scrum.consulta;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import pp2.scrum.dominio.Resultado;
import pp2.scrum.dominio.comando.Comando;
import pp2.scrum.dominio.comando.MailComando;
import pp2.scrum.dominio.entidad.Mail;
import pp2.scrum.dominio.interfaz.IMailGateway;

/**
 * @author rub
 *
 */
public class EnviadorMail implements IMailGateway
{
   private int port;    //Quien setea Esto??
   private String host;  //Quien setea Esto??
   private Socket socket;
   private DataOutputStream mensaje;
   private MailComando mailComando;

   @Override
   public Resultado enviar(Mail mail)
   {
      try
      {
        
         socket = new Socket(host,port);
         mensaje = new DataOutputStream(socket.getOutputStream());
         mensaje.writeUTF(mailComando.getUserMail());
         mensaje.flush();
         
         mensaje.writeUTF(mailComando.getUserPassMail());
         mensaje.flush();
         
         mensaje.writeUTF(mailComando.getDestinoMail());
         mensaje.flush();
         
         mensaje.writeUTF(mailComando.getTema());
         mensaje.flush();
         
         mensaje.writeUTF(mailComando.getCuerpo());
         mensaje.flush();
         
         mensaje.close();
         socket.close();
         
      } catch (UnknownHostException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (IOException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
      
      return null;
   }

}
