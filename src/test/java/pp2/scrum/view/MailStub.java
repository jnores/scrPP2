package pp2.scrum.view;

import pp2.scrum.dominio.Resultado;
import pp2.scrum.dominio.entidad.Mail;
import pp2.scrum.dominio.interfaz.MailGateway;

public class MailStub implements MailGateway
{

   @Override
   public Resultado enviar(Mail mail)
   {
      Resultado resultado = new Resultado();
      resultado.AgregarError("1", "Envio Correcto de Mail (Stub)");
      return resultado;
   }

}
