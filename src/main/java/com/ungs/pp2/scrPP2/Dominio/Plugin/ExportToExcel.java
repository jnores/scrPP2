package com.ungs.pp2.scrPP2.Dominio.Plugin;

import java.io.File;
import java.io.IOException;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class ExportToExcel implements Exporter {

	@Override
	public void export() {
		try {
			//ruta de archivo hiper cochina. Asumo windows asumo que hay unidad C, etc.. esto se va a cambiar despues
			//con filechooser  y eso
			File exlFile = new File("c:/archivo_excel.xls");
			WritableWorkbook writableWorkbook = Workbook
					.createWorkbook(exlFile);

			WritableSheet writableSheet = writableWorkbook.createSheet("hoja1", 0);
			
			//------------------columna, fila
			Label primero = new Label(0, 0, "Soy el primer dato");
			Label segundo = new Label(1, 1, "Soy el segundo dato");
			Label tercero = new Label(2, 0, "Soy el tercer dato");
			Label cuarto = new Label(3, 0, "Soy el cuarto dato");
			
			//Agrego a la hoja
			writableSheet.addCell(primero);
			writableSheet.addCell(segundo);
			writableSheet.addCell(tercero);
			writableSheet.addCell(cuarto);

			//no se para que cierra y abre el documento pero es necesario
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
