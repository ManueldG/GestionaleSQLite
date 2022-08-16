package it.java.view;

import java.awt.EventQueue;
import java.awt.BorderLayout;
import java.util.List;
import java.util.Locale;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.text.DateFormatter;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JCheckBox;

import it.java.business.ButtonColumn;
import it.java.business.GestionaleBusiness;
import it.java.model.Movimenti;
import it.java.model.Soci;

public class Gestionale {

	private JFrame frame;
	private JTabbedPane tabbedPane;
	private JScrollPane scrollPane;
	private JTable table;
	private JPanel panel;
	
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	
	private JScrollPane scrollPane_1;
	private JTable table_1;
	private JPanel panel_1;
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JComboBox textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JComboBox textField_11;
	
	
	protected Soci soci = new Soci();
	protected Movimenti movimenti = new Movimenti();
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JPanel panel_2;
	
	
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
	@SuppressWarnings({ "unchecked", "deprecation" })
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setBounds(new Rectangle(0, 0, 0, 300));
		frame.setBounds(100, 100, 450, 340);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
					
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 436, 303);
		
		frame.getContentPane().add(tabbedPane);
		
		panel_2 = new JPanel();
		tabbedPane.addTab("Utenti", null, panel_2, null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(-10, 5, 452, 208);
		//tabbedPane.addTab("Utenti", null, scrollPane, null);
		
		table = new JTable();
		
		table.getModel().addTableModelListener(new MyListener());
		panel_2.setLayout(null);
				
		table.setModel(new TableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Tessera", "Nome", "Cognome", "Telefono", "Indirizzo", "Tipo", "Modifica", "Cancella"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Object.class, Object.class, Object.class, Object.class, Integer.class, Object.class, Object.class,Object.class
			};
			
		public Class getColumnClass(int columnIndex) {
			return columnTypes[columnIndex];
			}
		});
		
		
					
		scrollPane.setViewportView(table);
		panel_2.add(scrollPane);
				
								
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
							
				TableModel dtm = (TableModel) table.getModel();
				
				soci.setTessera(Integer.parseInt(textField_2.getText()));	
				soci.setName(textField.getText());				
				soci.setSecondName(textField_1.getText());
				soci.setAddress(textField_3.getText());
				soci.setTipo( comboBox.getSelectedIndex());
				soci.setTelephone(textField_4.getText());	
													
				soci.Insert();				
				
				textField.setText("");
				textField_1.setText("");
				textField_2.setText(soci.newTessera().toString()); 
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
		
		lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setBounds(192, 11, 49, 14);
		panel.add(lblNewLabel_9);
		
				
		panel_1 = new JPanel();
		tabbedPane.addTab("Inserisci movimenti", null, panel_1, null);
		panel_1.setLayout(null);
		
		
		SpinnerDateModel model = new SpinnerDateModel();
		JSpinner spinner = new JSpinner(new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH));

		
		spinner.setEditor(new JSpinner.DateEditor(spinner, "dd/MM/yyyy"));
			
		
		spinner.setBounds(67, 36, 104, 20);
		panel_1.add(spinner);
		
		textField_5 = new JTextField();
		textField_5.setBounds(312, 36, 96, 20);
		panel_1.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("N\u00B0 fattura");
		lblNewLabel_6.setLabelFor(textField_5);
		lblNewLabel_6.setForeground(new Color(0, 0, 0));
		lblNewLabel_6.setBackground(new Color(255, 20, 147));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_6.setBounds(253, 39, 44, 13);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_6_1 = new JLabel("causale");
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_6_1.setBounds(264, 86, 32, 13);
		panel_1.add(lblNewLabel_6_1);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(312, 83, 96, 20);
		panel_1.add(textField_7);
		
		JLabel lblNewLabel_6_2 = new JLabel("socio");
		lblNewLabel_6_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_6_2.setBounds(35, 86, 30, 13);
		panel_1.add(lblNewLabel_6_2);
		
		textField_8 = new JComboBox();
		
		textField_8.setModel(new DefaultComboBoxModel(soci.getSoci()));
		textField_8.setBounds(75, 86, 96, 20);
		panel_1.add(textField_8);
		
		JLabel lblNewLabel_6_3 = new JLabel("importo");
		lblNewLabel_6_3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_6_3.setBounds(31, 128, 33, 13);
		panel_1.add(lblNewLabel_6_3);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(75, 125, 96, 20);
		panel_1.add(textField_6);
		
		JLabel lblNewLabel_6_3_1 = new JLabel("note");
		lblNewLabel_6_3_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_6_3_1.setBounds(272, 134, 19, 13);
		panel_1.add(lblNewLabel_6_3_1);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(312, 128, 96, 20);
		panel_1.add(textField_9);
		
		JLabel lblNewLabel_6_3_1_1 = new JLabel("IVA");
		lblNewLabel_6_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_6_3_1_1.setBounds(48, 173, 16, 13);
		panel_1.add(lblNewLabel_6_3_1_1);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(75, 170, 96, 20);
		panel_1.add(textField_10);
		
		lblNewLabel_8 = new JLabel("tipo");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_8.setBounds(272, 173, 15, 13);
		panel_1.add(lblNewLabel_8);
		
		textField_11 = new JComboBox();
		textField_11.setModel(new DefaultComboBoxModel(new String[] {"entrata", "uscita"}));
		textField_11.setBounds(312, 167, 96, 20);
		panel_1.add(textField_11);		
		
		JButton btnNewButton_2 = new JButton("Inserisci");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				movimenti.setNumero(Integer.parseInt(textField_5.getText()));
				movimenti.setDate( spinner.getValue().toString());
				movimenti.setSocio(textField_8.getSelectedIndex());
				movimenti.setImporto(Integer.parseInt(textField_6.getText()));
				movimenti.setTipo(textField_11.getSelectedIndex());
				movimenti.setCausale(textField_7.getText());
				movimenti.setIva(textField_10.getText());
				movimenti.setNote(textField_9.getText());
				
				
				try {
					
					movimenti.insert();
					
				} 
				catch (SQLException e1) {
					
					// TODO Auto-generated catch block
					e1.printStackTrace();
					
				}
				
				textField_6.setText("");
				textField_7.setText("");
				
				textField_9.setText("");
				textField_10.setText("");
				textField_11.setSelectedItem(null);				
				
			}
		});
		btnNewButton_2.setBounds(165, 233, 89, 23);
		panel_1.add(btnNewButton_2);
		
		JLabel lblNewLabel_7 = new JLabel("Data");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_7.setBounds(33, 39, 24, 14);
		panel_1.add(lblNewLabel_7);
		
		scrollPane_1 = new JScrollPane();
				
		tabbedPane.addTab("Movimenti", null, scrollPane_1, null);
		
		table_1 = new JTable();
		
		table_1.setModel(new TableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "data", "descrizione", "socio", "tipo", "importo", "n\u00B0 fattura", "IVA", "Note"
			}
		));	
		
		   	
		TableModel dtm2 = (TableModel) table_1.getModel();
		
		Movimenti movimenti = new Movimenti();
		
		List<Movimenti> datiMovimenti = null;
		try {
			datiMovimenti = movimenti.selectAllMovimenti();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		for (Movimenti m : datiMovimenti) {
			
			Vector<Comparable> row = new Vector<Comparable>();
			
			row.add(m.getId());
			row.add(m.getDate());
			row.add(m.getCausale());
			row.add(m.getSocio());
			
			switch (m.getTipo()) {
			
			case 0:
				row.add("Entrata");	
			break;
			
			default:
				row.add("Uscita");
				
		}			
			row.add(m.getImporto());
			row.add(m.getNumero());		
			row.add(m.getIva());	
			row.add(m.getNote());
			
			
									
			dtm2.addRow(row);
						
		}
		//end
		
		scrollPane_1.setViewportView(table_1);
		
		
		
		//Users list		
		
		TableModel dtm = (TableModel) table.getModel();
		JTable t = new JTable(dtm);
		
		Action delete = new AbstractAction()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		        JTable table = (JTable)e.getSource();
		        Soci s = new Soci();
		        
		        int modelRow = Integer.valueOf( e.getActionCommand() );
		        
		        Integer id = (Integer) dtm.getValueAt(modelRow, 0);
		        s.delete(id);
		        ((TableModel)table.getModel()).removeRow(modelRow);
		        
		        
		    }
		};
		
		Action modify = new AbstractAction()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		        JTable table = (JTable)e.getSource();
		        int modelRow = Integer.valueOf( e.getActionCommand() );
		        Integer id = (Integer) dtm.getValueAt(modelRow, 0);
		        
		        System.out.println(id.intValue());
		        
		        	
		        tabbedPane.setSelectedIndex(1); //vado al tab 1 (inserisci soci)
		        
		        Soci s = new Soci();
		        //s.delete(id);
		        try {
					s.updateTable(dtm);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        textField_2.setText(dtm.getValueAt(modelRow,1).toString());
		        textField.setText(dtm.getValueAt(modelRow,2).toString());
		        textField_1.setText(dtm.getValueAt(modelRow,3).toString());
		        textField_3.setText(dtm.getValueAt(modelRow,5).toString());
		        textField_4.setText(dtm.getValueAt(modelRow,4).toString());
		        lblNewLabel_9.setText(dtm.getValueAt(modelRow,0).toString());		        
		        
		        comboBox.setSelectedIndex((int)(dtm.getValueAt(modelRow,6)));
		        dtm.removeRow(modelRow-1);
		        
		        
		    }
		};
		 
		ButtonColumn buttonColumn = new ButtonColumn(table, delete, 8);
		buttonColumn.setMnemonic(KeyEvent.VK_D);
		
		ButtonColumn buttonColumn2 = new ButtonColumn(table, modify, 7);
		buttonColumn.setMnemonic(KeyEvent.VK_D);
		
		L list = new  L();		
		table.getModel().addTableModelListener(list);//listener
		
		Soci s = new Soci();
		try {
			s.updateTable(dtm); //carica i dati nella tabella
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}	
	
	/**
	 * 
	 * Listener per le modifiche della tabella
	 * 
	 */
	
	private class MyListener implements TableModelListener {

		public void tableChanged(TableModelEvent e) {

			System.out.println(e.toString());

		}
		
	}
	
	class L implements TableModelListener{
				
		private int x;		
		private int y;
		
		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}	

		@Override
		public void tableChanged(TableModelEvent e) {
			
			this.x=(e.getColumn());
			this.y=(e.getFirstRow());
			
			TableModel dtm = (TableModel) table.getModel();
			
			if ((this.getX()>0)&&(this.getY()>=0)) {
				
				System.out.println(dtm.getColumnName(getX()));
				System.out.println(dtm.getDataVector().elementAt(getY()).elementAt(getX()));   
				
			}		
			
		}	
		
	}
}

 