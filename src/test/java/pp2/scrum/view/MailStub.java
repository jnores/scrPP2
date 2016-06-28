package pp2.scrum.view;

import pp2.scrum.controller.Mail;
import pp2.scrum.controller.MailGateway;
import pp2.scrum.controller.Resultado;

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
