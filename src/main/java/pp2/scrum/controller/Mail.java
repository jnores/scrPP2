package pp2.scrum.controller;

public class Mail
{
	private String destinoMail;
	private String tema;
	private String cuerpo;

	public Mail(String destinoMail, String tema, String cuerpo) 
	{
		this.destinoMail = destinoMail;
		this.tema = tema;
		this.cuerpo = cuerpo;
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

}
