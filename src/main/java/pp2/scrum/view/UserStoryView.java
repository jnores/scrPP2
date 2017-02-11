package pp2.scrum.view;

import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import pp2.scrum.model.UserStory;

public class UserStoryView extends JPanel implements Observer
{
	/**
	 * default serial version
	 */
	private static final long serialVersionUID = 1L;
	private UserStory userStory;
	
	private JTextArea txtTitulo;
	
	public UserStoryView(UserStory userStory) 
	{
		this.userStory =userStory;
		this.setBounds(0,0,490, 78);
		
		setBorder(BorderFactory.createTitledBorder("[ User Story # ]"));
		this.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Titulo");
		lblTitulo.setBounds(12, 27, 100, 15);
		this.add(lblTitulo);
			
		txtTitulo = new JTextArea();
		txtTitulo.setLineWrap(true);
		txtTitulo.setBounds(110, 25, 368, 45);
		this.add(txtTitulo);
		txtTitulo.setEditable(false);
		
		this.cargarUserStory();
	}
	
	private void cargarUserStory() {
		this.txtTitulo.setText(this.userStory.getTitulo());
	}


	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		this.cargarUserStory();
	}
}