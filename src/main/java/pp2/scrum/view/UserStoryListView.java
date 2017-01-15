package pp2.scrum.view;

import java.awt.Dimension;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import pp2.scrum.controller.UserStoryHelper;
import pp2.scrum.exporter.Exporter;
import pp2.scrum.utils.UserStoryHelperComparator;

public class UserStoryListView extends JPanel implements Observer
{
	/**
	 * default serial version
	 */
	private JFileChooser archivo;
	private static final long serialVersionUID = 1L;
	private List<UserStoryHelper> userStoriesHelper;
	
	public UserStoryListView(List<UserStoryHelper> userStoriesHelper) 
	{
		this.userStoriesHelper = userStoriesHelper;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.cargarUserStories();
		
	}
	
	
	private void cargarUserStories() {
//		Container cont = new Container();
		int width=0, height=0;

		for(UserStoryHelper userStoryHelper: userStoriesHelper) {
			UserStoryView usv = new UserStoryView(userStoryHelper);	
			width = (int)usv.getBounds().getWidth();
			height += (int)usv.getBounds().getHeight();
			
			add( usv, -1 );
		}
		setPreferredSize( new Dimension(width, height));
		setMaximumSize( new Dimension(width, height));
		
		revalidate();
		repaint();
	}


	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		this.cargarUserStories();
	}
	
	public void ordenarPorOpcion(UserStoryHelperComparator opcion,boolean desc) {
		if (desc) {
			Collections.sort(userStoriesHelper, UserStoryHelperComparator.decending(opcion));
		} else {
			Collections.sort(userStoriesHelper, opcion);
		}
		removeAll();
		cargarUserStories();
	}


	public void exportar(Object pluginExport) {
		// TODO Auto-generated method stub
		archivo = new JFileChooser();
		//Ver.. aca solo estoy permitiendo xls
		FileNameExtensionFilter filter = new FileNameExtensionFilter("XLS files", "xls");
		archivo.setFileFilter(filter);
		//solo navego por directorios
		archivo.setFileSelectionMode( JFileChooser.DIRECTORIES_ONLY );
		if( archivo.showOpenDialog(this) == JFileChooser.APPROVE_OPTION )
		{	
			try
			{
				((Exporter) pluginExport).export(archivo.getSelectedFile().getAbsolutePath(),userStoriesHelper);			
			}
			catch (RuntimeException e)
			{
				JOptionPane.showMessageDialog(this, e.getMessage());
			}
			
		}
	}
	
}