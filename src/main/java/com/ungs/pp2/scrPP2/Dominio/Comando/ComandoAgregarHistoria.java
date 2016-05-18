/**
 * 
 */
package com.ungs.pp2.scrPP2.Dominio.Comando;

import java.security.InvalidParameterException;

import com.ungs.pp2.scrPP2.Controller.HomeController;
import com.ungs.pp2.scrPP2.Dominio.Request;
import com.ungs.pp2.scrPP2.Dominio.Resultado;
import com.ungs.pp2.scrPP2.Dominio.Interfaz.IComando;

/**
 * @author yoshknight
 *
 */
public class ComandoAgregarHistoria implements IComando<HomeController>{

	@Override
	public void configurar(Request request) throws InvalidParameterException {
		// TODO Validar Parametros
	}

	@Override
	public Resultado execute(HomeController TipoController) {
		// TODO Crear el nuebo objeto, persistirlo, loguear y  agregarlo al modelo. esto debe disparar el observer! :p
		// Pedir al controller el mapper y el ¿logger?
		return null;
	}
	

}
