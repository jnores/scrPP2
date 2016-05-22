package pp2.scrum.dominio.interfaz;

import java.security.InvalidParameterException;

import pp2.scrum.dominio.Request;
import pp2.scrum.dominio.Resultado;

public interface IComando<T>
{
	void configurar(Request request) throws InvalidParameterException;
   Resultado Execute(T TipoController);
   
}
