package com.ungs.pp2.scrPP2.textUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.ungs.pp2.scrPP2.Dominio.Entidad.UserStory;
import com.ungs.pp2.scrPP2.utils.UserStoryMapper;

/**
 * @author yoshknight
 *
 */
public class TextUserStoryMapper implements UserStoryMapper {
	private static final String COMMA_DELIMITER = ";";
	private static final String NEW_LINE_SEPARATOR = "\n";
	
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
		
		BufferedReader fileReader = null;
		try {
			String line = "";
			fileReader = new BufferedReader(new FileReader(filePath));
			fileReader.readLine();
			while ((line = fileReader.readLine()) != null) {
				String[] tokens = line.split(COMMA_DELIMITER);
				if (tokens.length > 0 && Long.parseLong(tokens[STORY_SPRINT_IDX]) == 0) {
					UserStory story = new UserStory(Long.parseLong(tokens[STORY_ID_IDX]), tokens[STORY_STORY_IDX], tokens[STORY_DESCRIPCION_IDX],"");
					stories.add(story);
				}
			}
		}
		catch (Exception e) {
			System.out.println("Error in CsvFileReader !!!");
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				System.out.println("Error while closing fileReader !!!");
				e.printStackTrace();
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
		BufferedReader fileReader = null;
		try {
			String line = "";
			fileReader = new BufferedReader(new FileReader(filePath));
			//Salto la fila de cabecera
			fileReader.readLine();
			while ((line = fileReader.readLine()) != null) {
				String[] tokens = line.split(COMMA_DELIMITER);
				if (tokens.length > 0) {
					long id = Long.parseLong(tokens[STORY_ID_IDX]);
					if (id > maxID)
						maxID = id;
				}
			}
		}
		catch (Exception e) {
			System.out.println("Error in CsvFileReader !!!");
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				System.out.println("Error while closing fileReader !!!");
				e.printStackTrace();
			}
		}
		return maxID+1;
	}

	/* (non-Javadoc)
	 * @see com.ungs.pp2.scrPP2.utils.UserStoryMapper#insert(com.ungs.pp2.scrPP2.Dominio.Entidad.UserStory)
	 */
	@Override
	public void insert(UserStory us) {
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(filePath,true);
//			fileWriter.append(FILE_HEADER.toString());
//			fileWriter.append(NEW_LINE_SEPARATOR);
			fileWriter.append(String.valueOf(us.getId()));
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(String.valueOf(us.getTitulo()));
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(String.valueOf(us.getDetalle()));
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(String.valueOf(0));
			fileWriter.append(NEW_LINE_SEPARATOR);
			
		} catch (Exception e) {
			System.out.println("Error in CsvFileWriter !!!");
			e.printStackTrace();
		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				System.out.println("Error while flushing/closing fileWriter !!!");
				e.printStackTrace();
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
				FileWriter fileWriter = null;
				try {
					fileWriter = new FileWriter(filePath,true);
					fileWriter.append(FILE_HEADER.toString());
					fileWriter.append(NEW_LINE_SEPARATOR);	
				} catch (Exception e) {
					System.out.println("Error in CsvFileWriter !!!");
					e.printStackTrace();
				} finally {
					try {
						fileWriter.flush();
						fileWriter.close();
					} catch (IOException e) {
						System.out.println("Error while flushing/closing fileWriter !!!");
						e.printStackTrace();
					}
				}
			}
		} else if (f.isDirectory() ){
			throw new RuntimeException("Error al abrir el archivo de historias de usuarios. El archivo '"+filePath+"' es un directorio");
		}		
	}

}
