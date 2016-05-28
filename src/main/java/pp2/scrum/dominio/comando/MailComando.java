package pp2.scrum.dominio.comando;

public class MailComando extends Comando
{
   private String userMail;
   private String userPassMail;
   private String destinoMail;
   private String tema;
   private String cuerpo;
   public MailComando(String userMail, String userPassMail, String destinoMail, String tema, String cuerpo)
   {
      super();
      this.userMail = userMail;
      this.userPassMail = userPassMail;
      this.destinoMail = destinoMail;
      this.tema = tema;
      this.cuerpo = cuerpo;
   }
   public String getUserMail()
   {
      return userMail;
   }
   public String getUserPassMail()
   {
      return userPassMail;
   }
   public String getDestinoMail()
   {
      return destinoMail;
   }
   public String getTema()
   {
      return tema;
   }
   public String getCuerpo()
   {
      return cuerpo;
   }
   public void setUserMail(String userMail)
   {
      this.userMail = userMail;
   }
   public void setUserPassMail(String userPassMail)
   {
      this.userPassMail = userPassMail;
   }
   public void setDestinoMail(String destinoMail)
   {
      this.destinoMail = destinoMail;
   }
   public void setTema(String tema)
   {
      this.tema = tema;
   }
   public void setCuerpo(String cuerpo)
   {
      this.cuerpo = cuerpo;
   }
   

}
