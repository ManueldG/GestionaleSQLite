package it.java.model;

import static javax.swing.JOptionPane.showMessageDialog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import it.java.business.GestionaleBusiness;

import it.java.view.TableModel;

public class Soci extends Tables {
	
	int tessera;
	private String name;
	private String secondName;
	private String telephone;
	private String address;
	private int tipo;
	private Boolean remove;
	
	
	public int getTessera() {
		return tessera;
	}
	public void setTessera(int tessera) {
		this.tessera = tessera;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSecondName() {
		return secondName;
	}
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String i) {
		this.telephone = i;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getTipo() {
		
		return tipo;			
		
	}
	public void setTipo(int i) {
		
		this.tipo = i;
		
	}
	
	public Boolean getRemove() {
		
		return remove;
		
	}
	
	public void setRemove(Boolean remove) {
		
		this.remove = remove;
		
	}
	
	/**
	 * Crea la tabella Soci 
	 * @throws Exception
	 */
	public void createNewTable() throws Exception {
		
		String name = this.getClass().getSimpleName();
		
		//super.query("DROP TABLE " + name + " ;");
		
		String sql = super.createNewTableHead(name);
				
		sql += super.createNewTableBody("id", "INTEGER PRIMARY KEY AUTOINCREMENT,");
		sql += super.createNewTableBody("tessera", "INTEGER NOT NULL ,");
		sql += super.createNewTableBody("name", "TEXT NOT NULL,");
		sql += super.createNewTableBody("secondname", "TEXT NOT NULL,");
		sql += super.createNewTableBody("telephone", "INTEGER NOT NULL,");
		sql += super.createNewTableBody("ADDRESS", "TEXT,");
		sql += super.createNewTableBody("TIPO", "TEXT");
					
		super.createNewTableExecute(sql);
		
	}        
    
	
    
    /**
     * Pick all value of Soci table
     * @return List<Soci>
     * 
     **/
    
    public List<Soci> selectAllSoci() throws SQLException{  
    	
    	List<Soci> result = new ArrayList<Soci>();
    	ResultSet rs = selectAll();
            
            // loop through the result set  
            while (rs.next()) {  
            	
            	Soci s = new Soci();
            	s.setId(rs.getInt(1));
            	s.setTessera(rs.getInt(2));
            	s.setName(rs.getString(3));
            	s.setSecondName(rs.getString(4)); 
            	s.setTelephone(rs.getString(5));
            	s.setAddress(rs.getString(6));
            	s.setTipo(rs.getInt(7));
            	                 
                result.add(s);
            }         
               
		return result;
    }    
    
    public TableModel updateTable(TableModel dtm) throws SQLException {
    	
    	List<Soci> datiUtenti = selectAllSoci();
		
		for (Soci s : datiUtenti) {			
			
			dtm.addRow(updateRow(s));
			
			}
		
		return dtm;		
	
    }	   
    
public  Vector<Comparable> updateRow(Soci s){	
					
			Vector<Comparable> row = new Vector<Comparable>();
			
			row.add(s.getId());
			row.add(s.getTessera());
			row.add(s.getName());
			row.add(s.getSecondName());
			row.add(s.getTelephone());
			row.add(s.getAddress());
			row.add(s.getTipo());
			row.add("m");
			row.add("c");	
			
			return row;
    }	

	public String insertHead() { 
		
		String name = this.getClass().getSimpleName();
	    String sql = "INSERT INTO " + name + "(tessera, name, secondname, telephone, address, tipo) VALUES(?,?,?,?,?,?)"; 
	    return sql;
	    
	}

    /**
     * Inserisce nuovi dati nel DB
     * @return int
     */
    public int Insert() {
 	   
        try{          	
             
        	Connection conn = null;
			try {
				conn = GestionaleBusiness.getConnections();
			} catch (Exception e) {
				showMessageDialog(null," Errore  !!! \n " + e.getMessage());
				e.printStackTrace();
			}
            PreparedStatement pstmt = conn.prepareStatement(insertHead()); 
            
            pstmt.setInt(1, getTessera()); 
            pstmt.setString(2, getName()); 
            pstmt.setString(3, getSecondName()); 
            pstmt.setString(4, getTelephone()); 
            pstmt.setString(5, getAddress()); 
            pstmt.setInt(6, getTipo()); 
                        
            int result = pstmt.executeUpdate();  
            
            return result;
            
            
        } 
        
        catch (SQLException e) {  
        	
            System.out.println(e.getMessage());  
            showMessageDialog(null," Errore  !!! \n " + e.getMessage());
            return 0;
        }
    }   
    
    /**
     * 
     * Trova il valore della nuova tessera
     * @return Integer
     * 
     */
    
    public Integer newTessera() {
    	Integer max = 0;
    	String sql = " SELECT MAX(tessera) FROM soci;";
    	try {
    		
    		Connection rf = null;
			try {
				rf = GestionaleBusiness.getConnections();
			} catch (Exception e) {
				
				showMessageDialog(null," Errore  !!! \n " + e.getMessage());
				e.printStackTrace();
				
			}
			
			Statement stmt = rf.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			max = rs.getInt(1) + 1;
			
    	} 
    	
    	catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			showMessageDialog(null," Errore  !!! \n " + e1.getMessage());
			
    	}
    	
    	return max;
    	
    }
    
/**
 * Dalla tabella Soci estrae una lista di nomi di utenti
 * @return String[]
 */
public String[] getSoci(){  
    	
    	String table = this.getClass().getSimpleName(); // nome della classe
    	
        String sql = "SELECT name,secondname FROM " + table; 
        
        ArrayList<String> result = new ArrayList<String> ();
        
        Connection rf = null ;
                
        try {  
        	
        	// create a connection to the database  
            try {
            	
				rf = GestionaleBusiness.getConnections();
				
			} 
            catch (Exception e) {
				showMessageDialog(null," Errore  !!! \n " + e.getMessage());
				e.printStackTrace();
			}
            
            Statement stmt  = rf.createStatement();  
            ResultSet rs    = stmt.executeQuery(sql);  
            
            
            // loop through the result set  
            while (rs.next()) {              	
            	
                result.add(rs.getString(1) + " " + rs.getString(2)); //nome + cognome
                                
            }  
            
        } 
        
        catch (SQLException e) {  
        	showMessageDialog(null," Errore  !!! \n " + e.getMessage());
        }
        String[] array = result.toArray(new String[0]);  
		return (array);
    }
	

}
