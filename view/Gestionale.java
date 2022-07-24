package it.java.view;

import java.awt.EventQueue;
import java.awt.BorderLayout;

import java.util.List;
import java.util.Locale;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DateFormatter;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.Rectangle;

import it.java.model.Movimenti;
import it.java.model.Soci;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.awt.Font;


public class Gestionale {

	private JFrame frame;
	private JTabbedPane tabbedPane;
	private JScrollPane scrollPane;
	private JTable table;
	private JPanel panel;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblNewLabel_3;
	private JTextField textField_3;
	private JLabel lblNewLabel_4;
	private JTextField textField_4;
	private JLabel lblNewLabel_5;
	private JScrollPane scrollPane_1;
	private JTable table_1;
	private JPanel panel_1;
	private JTextField textField_5;
	
	protected Soci soci = new Soci();
	protected Movimenti movimenti = new Movimenti();
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 * @author Manuel
	 * 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gestionale window = new Gestionale();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Gestionale() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setBounds(new Rectangle(0, 0, 0, 300));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.NORTH);
		
		
		// Users list
		scrollPane = new JScrollPane();
		tabbedPane.addTab("Utenti", null, scrollPane, null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"Tessera", "Nome", "Cognome", "Telefono", "Indirizzo", "Tipo"
			}
		));
		scrollPane.setViewportView(table);
				
		//Insert users
		panel = new JPanel();
		tabbedPane.addTab("Inserisci nuovo utente", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel.setBounds(31, 42, 29, 14);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(91, 39, 96, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Cognome");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_1.setBounds(31, 70, 46, 14);
		panel.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(91, 67, 96, 20);
		panel.add(textField_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tessera");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_2.setBounds(31, 98, 39, 14);
		panel.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		
		
		try {
			//soci.createNewTable();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		textField_2.setText(soci.newTessera().toString());
		textField_2.setColumns(10);
		textField_2.setBounds(91, 95, 96, 20);
		panel.add(textField_2);
		
		lblNewLabel_3 = new JLabel("Indirizzo");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_3.setBounds(241, 45, 42, 14);
		panel.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(301, 42, 96, 20);
		panel.add(textField_3);
		
		lblNewLabel_4 = new JLabel("Telefono");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_4.setBounds(241, 73, 43, 14);
		panel.add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(301, 70, 96, 20);
		panel.add(textField_4);
		
		lblNewLabel_5 = new JLabel("Tipo di socio");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_5.setBounds(228, 101, 62, 14);
		panel.add(lblNewLabel_5);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Socio", "Presidente", "Tesoriere"}));
		comboBox.setBounds(301, 98, 96, 20);
		panel.add(comboBox);
		
		JButton btnNewButton = new JButton("Invio");
		btnNewButton.addActionListener(new ActionListener() {
		

			public void actionPerformed(ActionEvent e) {
								
				soci.setTessera(Integer.parseInt(textField_2.getText()));	
				soci.setName(textField.getText());				
				soci.setSecondName(textField_1.getText());
				soci.setAddress(textField_3.getText());
				soci.setTipo( comboBox.getSelectedIndex());
				soci.setTelephone(textField_4.getText());	
				
				soci.Insert(soci);
				
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				comboBox.setSelectedIndex(0);
				
			}
		});
		btnNewButton.setBounds(91, 170, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("annulla");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				comboBox.setSelectedIndex(0);
				
			}
		});
		btnNewButton_1.setBounds(223, 170, 96, 20);
		panel.add(btnNewButton_1);
		
		panel_1 = new JPanel();
		tabbedPane.addTab("Inserisci movimenti", null, panel_1, null);
		panel_1.setLayout(null);
		
		
		
		SpinnerDateModel model = new SpinnerDateModel();
		JSpinner spinner = new JSpinner(model);

		JSpinner.DateEditor editor = new JSpinner.DateEditor(spinner, "dd.MM.yyyy");
		DateFormatter formatter = (DateFormatter)editor.getTextField().getFormatter();
		formatter.setAllowsInvalid(false); // this makes what you want
		formatter.setOverwriteMode(true);
		
		spinner.setBounds(31, 36, 104, 20);
		panel_1.add(spinner);
		
		textField_5 = new JTextField();
		textField_5.setBounds(240, 36, 96, 20);
		panel_1.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("N\u00B0 fattura");
		lblNewLabel_6.setBounds(181, 39, 49, 14);
		panel_1.add(lblNewLabel_6);
		
		JButton btnNewButton_2 = new JButton("Inserisci");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				movimenti.setImporto(Integer.parseInt(textField_6.getText()));
				//movimenti.setDate(spinner.getValue());
				movimenti.setSocio(textField_8.getText());
				movimenti.setCausale(textField_7.getText());
				movimenti.setNumero(Integer.parseInt(textField_5.getText()));
				try {
					movimenti.insert();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
							
				
				
			}
		});
		btnNewButton_2.setBounds(31, 175, 89, 23);
		panel_1.add(btnNewButton_2);
		
		JLabel lblNewLabel_6_1 = new JLabel("causale");
		lblNewLabel_6_1.setBounds(181, 86, 49, 14);
		panel_1.add(lblNewLabel_6_1);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(240, 83, 96, 20);
		panel_1.add(textField_7);
		
		JLabel lblNewLabel_6_2 = new JLabel("socio");
		lblNewLabel_6_2.setBounds(16, 89, 38, 14);
		panel_1.add(lblNewLabel_6_2);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(75, 86, 96, 20);
		panel_1.add(textField_8);
		
		JLabel lblNewLabel_6_3 = new JLabel("importo");
		lblNewLabel_6_3.setBounds(16, 128, 49, 14);
		panel_1.add(lblNewLabel_6_3);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(75, 125, 96, 20);
		panel_1.add(textField_6);
		
		scrollPane_1 = new JScrollPane();
		tabbedPane.addTab("Movimenti", null, scrollPane_1, null);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"data", "descrizione", "socio", "tipo", "importo", "n\u00B0 fattura"
			}
		));
		scrollPane_1.setViewportView(table_1);
		
		
		
		// end
		
		//Users list		
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		
		Soci utenti = new Soci();
		
		List<Soci> datiUtenti = utenti.selectAll();
		
		for (Soci s : datiUtenti) {
			
			Vector<Comparable> row = new Vector<Comparable>();
			
			row.add(s.getTessera());
			row.add(s.getName());
			row.add(s.getSecondName());
			row.add(s.getTelephone());
			row.add(s.getAddress());
			row.add(s.getTipo());			
						
			dtm.addRow(row);
			
		}
		//end
		
		
		
		
	}
}
