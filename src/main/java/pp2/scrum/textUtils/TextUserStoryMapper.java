package pp2.scrum.textUtils;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import pp2.scrum.dominio.entidad.UserStory;
import pp2.scrum.utils.UserStoryMapper;

/**
 * @author yoshknight
 *
 */
public class TextUserStoryMapper implements UserStoryMapper {
	private static final char COMMA_DELIMITER = ';';
	
	private static final String FILE_HEADER = "id,story,descripcion,sprint";
	
	private static final int STORY_ID_IDX = 0;
	private static final int STORY_STORY_IDX = 1;
	private static final int STORY_DESCRIPCION_IDX = 2;
	private static final int STORY_SPRINT_IDX = 3;
	
	

	
	private String filePath;

	public TextUserStoryMapper() throws RuntimeException, IOException{
		filePath = System.getProperty("user.home")+"/historias.dat";
		verificarFile();
	}
	public TextUserStoryMapper(String nameFile) throws RuntimeException, IOException{
		filePath = System.getProperty("user.home")+"/"+nameFile;
		verificarFile();
	}
	/* (non-Javadoc)
	 * @see com.ungs.pp2.scrPP2.utils.UserStoryMapper#getBacklog()
	 */
	@Override
	public List<UserStory> getBacklog() {
		List<UserStory> stories = new ArrayList<UserStory>();
		
		CSVReader reader = null;
		try {
			 reader = new CSVReader(new FileReader(filePath),COMMA_DELIMITER);
		     String [] nextLine;
		     nextLine = reader.readNext();
//		     System.out.println("ID="+nextLine[STORY_ID_IDX]+"|Titulo="+nextLine[STORY_STORY_IDX]+"|Detalle="+nextLine[STORY_DESCRIPCION_IDX]+"|SPRINT="+nextLine[STORY_SPRINT_IDX]);
		     while ((nextLine = reader.readNext()) != null) {
//		    	 System.out.println("ID="+nextLine[STORY_ID_IDX]+"|Titulo="+nextLine[STORY_STORY_IDX]+"|Detalle="+nextLine[STORY_DESCRIPCION_IDX]+"|SPRINT="+nextLine[STORY_SPRINT_IDX]);
				if (nextLine.length > 0 && Long.parseLong(nextLine[STORY_SPRINT_IDX]) == 0) {
					UserStory story = new UserStory(Long.parseLong(nextLine[STORY_ID_IDX]), nextLine[STORY_STORY_IDX], nextLine[STORY_DESCRIPCION_IDX],"");
					stories.add(story);
				}
			}
		}
		catch (Exception e) {
			System.out.println("Error in CsvFileReader !!!");
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				System.out.println("Error while closing fileReader !!!");
			}
		}
		return stories;
	}

	/* (non-Javadoc)
	 * @see com.ungs.pp2.scrPP2.utils.UserStoryMapper#getNextID()
	 */
	@Override
	public long getNextID() {
		long maxID=0;
		CSVReader reader = null;
		try {
			 reader = new CSVReader(new FileReader(filePath),COMMA_DELIMITER);
		     String [] nextLine;
		     nextLine = reader.readNext();
		     while ((nextLine = reader.readNext()) != null) {
				if (nextLine.length > 0) {
					long id = Long.parseLong(nextLine[STORY_ID_IDX]);
					if (id > maxID)
						maxID = id;
				}
			}
		}
		catch (Exception e) {
			System.out.println("Error in CsvFileReader !!!");
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				System.out.println("Error while closing fileReader !!!");
			}
		}
		return maxID+1;
	}

	/* (non-Javadoc)
	 * @see com.ungs.pp2.scrPP2.utils.UserStoryMapper#insert(com.ungs.pp2.scrPP2.Dominio.Entidad.UserStory)
	 */
	@Override
	public void insert(UserStory us) {
		CSVWriter writer = null;
	    try {
			writer = new CSVWriter(new FileWriter(filePath,true),COMMA_DELIMITER);
			// feed in your array (or convert your data to an array)
		    String[] entries = new String[] {String.valueOf(us.getId()),us.getTitulo(),us.getDetalle(),String.valueOf(0)} ;
		    writer.writeNext(entries);
		} catch (Exception e) {
			System.out.println("Error in CsvFileWriter !!!");
		} finally {
			try {
				writer.flush();
				writer.close();
			} catch (IOException e) {
				System.out.println("Error while flushing/closing fileWriter !!!");
			}
		}

			
	}

	/* (non-Javadoc)
	 * @see com.ungs.pp2.scrPP2.utils.UserStoryMapper#update(com.ungs.pp2.scrPP2.Dominio.Entidad.UserStory)
	 */
	@Override
	public void update(UserStory us) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.ungs.pp2.scrPP2.utils.UserStoryMapper#delete(com.ungs.pp2.scrPP2.Dominio.Entidad.UserStory)
	 */
	@Override
	public void delete(UserStory us) {
		// TODO Auto-generated method stub

	}
	
	private void verificarFile() throws RuntimeException, IOException {
		File f = new File(filePath);
		if ( !f.exists() ) {
			if (f.createNewFile() ) {
				CSVWriter writer = null;
			    try {
					writer = new CSVWriter(new FileWriter(filePath),COMMA_DELIMITER);
					// feed in your array (or convert your data to an array)
				    String[] entries = FILE_HEADER.split(",");
				    writer.writeNext(entries);
						
				} catch (Exception e) {
					System.out.println("Error in CsvFileWriter !!!");
				} finally {
					try {
						writer.flush();
						writer.close();
					} catch (IOException e) {
						System.out.println("Error while flushing/closing fileWriter !!!");
					}
				}
			}
		} else if (f.isDirectory() ){
			throw new RuntimeException("Error al abrir el archivo de historias de usuarios. El archivo '"+filePath+"' es un directorio");
		}		
	}

}
