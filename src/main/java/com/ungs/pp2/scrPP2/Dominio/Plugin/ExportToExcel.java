package com.ungs.pp2.scrPP2.Dominio.Plugin;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.ungs.pp2.scrPP2.Controller.UserStoryHelper;




import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class ExportToExcel implements Exporter {
	private String pathExl;

	@Override
	public void export(String path, List<UserStoryHelper> userStoriesHlpr)throws RuntimeException {
		this.pathExl=path;
		
		if (userStoriesHlpr.size()==0) throw new RuntimeException("No existen historias de usuario para exportar."); 		
		
		try {

			File exlFile = new File(pathExl);
			WritableWorkbook writableWorkbook = Workbook.createWorkbook(exlFile);

			WritableSheet writableSheet = writableWorkbook.createSheet("hoja1", 0);
			
			//Cabeceras - esto no me gusta que esté fijo aca. Estoy acoplando la exportación solo a historias de usuario
			Label headerID = new Label(0, 0, "ID HISTORIA");
			Label headerTitulo = new Label(1, 0, "TITULO");
			Label headerEstado= new Label(2, 0, "ESTADO");
			Label headerResponsable = new Label(3, 0, "RESPONSABLE");
			Label headerPtsHistoria = new Label(4, 0, "PTS. HISTORIA");
			
			//Agrego a la hoja las cabeceras
			writableSheet.addCell(headerID);
			writableSheet.addCell(headerTitulo);
			writableSheet.addCell(headerEstado);
			writableSheet.addCell(headerResponsable);
			writableSheet.addCell(headerPtsHistoria);
			
			//Datos del excel
			for (int i = 0; i<userStoriesHlpr.size();i++)
			{	
				writableSheet.addCell(new Label(0,i+1,userStoriesHlpr.get(i).getId()+""));
				writableSheet.addCell(new Label(1,i+1,userStoriesHlpr.get(i).getTitulo()));
				writableSheet.addCell(new Label(2,i+1,userStoriesHlpr.get(i).getEstado().name()));
				writableSheet.addCell(new Label(3,i+1,userStoriesHlpr.get(i).getResponsable()));
				writableSheet.addCell(new Label(4,i+1,userStoriesHlpr.get(i).getStoryPoints()+""));
			}

//------------------columna, fila
//			Label primero = new Label(0, 0, "Soy el primer dato");
//			Label segundo = new Label(1, 1, "Soy el segundo dato");
//			Label tercero = new Label(2, 0, "Soy el tercer dato");
//			Label cuarto = new Label(3, 0, "Soy el cuarto dato");
//			
			writableWorkbook.write();
			writableWorkbook.close();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}

	}

}
