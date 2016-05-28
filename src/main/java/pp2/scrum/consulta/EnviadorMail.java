package pp2.scrum.consulta;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import pp2.scrum.dominio.Resultado;
import pp2.scrum.dominio.entidad.Mail;
import pp2.scrum.dominio.interfaz.IMailGateway;

/**
 * @author rub
 *
 */
public class EnviadorMail implements IMailGateway
{
   private int port;
   private String host;
   private String senderMail;
   private String SenderPassMail;

   public EnviadorMail(int port,String host,String senderMail,String SenderPassMail)
   {
	   this.port = port;
	   this.host = host;
	   this.senderMail = senderMail;
	   this.SenderPassMail = SenderPassMail;
   }
   @Override
   public Resultado enviar(Mail mail)
   {
      try
      {
        
    	 Socket socket = new Socket(host,port);
    	 DataOutputStream mensaje = new DataOutputStream(socket.getOutputStream());
         mensaje.writeUTF(senderMail);
         mensaje.flush();
         
         mensaje.writeUTF(SenderPassMail);
         mensaje.flush();
         
         mensaje.writeUTF(mail.getDestinoMail());
         mensaje.flush();
         
         mensaje.writeUTF(mail.getTema());
         mensaje.flush();
         
         mensaje.writeUTF(mail.getCuerpo());
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
