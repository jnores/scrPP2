/**
 * 
 */
package pp2.scrum.dominio.comando;

import pp2.scrum.controller.HomeController;
import pp2.scrum.dominio.Resultado;
import pp2.scrum.dominio.interfaz.IComando;

/**
 * @author yoshknight
 *
 */
public class ComandoAgregarHistoria implements IComando<HomeController>{


	@Override
	public Resultado Execute(HomeController TipoController) {
		// TODO Crear el nuebo objeto, persistirlo, loguear y  agregarlo al modelo. esto debe disparar el observer! :p
		// Pedir al controller el mapper y el ¿logger?
		return null;
	}
	

}
