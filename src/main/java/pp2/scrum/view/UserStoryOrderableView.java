package pp2.scrum.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import pp2.scrum.exporter.Exporter;
import pp2.scrum.exporter.PluginFactory;
import pp2.scrum.utils.UserStoryComparator;

public class UserStoryOrderableView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserStoryListView userStoriesPane;
	private JComboBox<UserStoryComparator> cmbOpciones;
	private JToggleButton tglbtnAscdesc;
	private JButton btnOrdenar;
	private JComboBox<Exporter> cmbTipoExport;

	/**
	 * Create the frame.
	 */
	public UserStoryOrderableView( UserStoryListView userStoriesList) {
		this.userStoriesPane = userStoriesList;
		
		this.cmbTipoExport = new JComboBox<Exporter>();

		for (Exporter i : PluginFactory.getPlugins())
			this.cmbTipoExport.addItem(i);

		this.cmbTipoExport.addActionListener (new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				userStoriesPane.exportar(cmbTipoExport.getSelectedItem());
			}
		});
		
		JPanel panel = new JPanel();
		this.add(panel, BorderLayout.NORTH);
		
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		
		cmbOpciones = new JComboBox<UserStoryComparator>();
		cmbOpciones.setModel(new DefaultComboBoxModel<UserStoryComparator>(UserStoryComparator.values()));
		panel.add(cmbOpciones);
		
		tglbtnAscdesc = new JToggleButton("ASC(desc)");
		tglbtnAscdesc.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if ( tglbtnAscdesc.isSelected() ) {
					tglbtnAscdesc.setText("DESC(asc)");
				} else {
					tglbtnAscdesc.setText("ASC(desc)");
				}
					
			}
		});
		panel.add(tglbtnAscdesc);

		btnOrdenar = new JButton("Ordenar");
		btnOrdenar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				userStoriesPane.ordenarPorOpcion(cmbOpciones.getItemAt(cmbOpciones.getSelectedIndex()),tglbtnAscdesc.isSelected());
			}
		});
		panel.add(btnOrdenar);
		
		boolean controlsEnabled = userStoriesList.getComponentCount() > 0;
		cmbOpciones.setEnabled(controlsEnabled);
		tglbtnAscdesc.setEnabled(controlsEnabled);
		btnOrdenar.setEnabled(controlsEnabled);
		
		panel.add(cmbTipoExport);
		
		JScrollPane scrollPane = new JScrollPane(userStoriesList);
		//scrollPane.setBounds(5, 5, 380, 160);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 0, 350, 160);
		this.add(scrollPane, BorderLayout.CENTER);
		scrollPane.validate();
	}
	
	public void showWindow(boolean b) {
		setVisible(b);
	}

}
