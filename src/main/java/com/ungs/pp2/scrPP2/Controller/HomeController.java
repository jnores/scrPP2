package com.ungs.pp2.scrPP2.Controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jfree.data.xy.XYSeriesCollection;

import com.ungs.pp2.scrPP2.Dominio.Entidad.Sprint;
import com.ungs.pp2.scrPP2.Dominio.Entidad.UserStory;
import com.ungs.pp2.scrPP2.Dominio.Enums.Estado;
import com.ungs.pp2.scrPP2.Dominio.Enums.OpcionGrafico;
import com.ungs.pp2.scrPP2.Dominio.Interfaz.IDataComponent;
import com.ungs.pp2.scrPP2.Dominio.Interfaz.IConsulta;
import com.ungs.pp2.scrPP2.View.HomeView;
import com.ungs.pp2.scrPP2.Dominio.Composite.*;

public class HomeController extends Controller
{


	public HomeController(IConsulta consulta) {
		super(consulta);
	}
	
	
}
