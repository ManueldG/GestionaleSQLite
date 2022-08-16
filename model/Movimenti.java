package it.java.model;


import static javax.swing.JOptionPane.showMessageDialog;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import it.java.business.GestionaleBusiness;


public class Movimenti extends Tables{
	
	private String date;
	private int numero;
	private int socio;
	private int importo;
	private int tipo;
	private String causale;
	private String iva;
	private String note;
	
	
	
	public void movimenti() {
		
	}

	public String getDate() {
		
		return date;
		
	}

	public void setDate(String string) {
					    
		this.date =  string;
		
	}

	public int getNumero() {
		
		return numero;
		
	}

	public void setNumero(int numero) {
		
		this.numero = numero;
		
	}

	public int getSocio() {
		
		return socio;
		
	}

	public void setSocio(int i) {
		
		this.socio = i;
		
	}

	public int getImporto() {
		
		return importo;
		
	}

	public void setImporto(int i) {
		
		this.importo = i;
		
	}

	public int getTipo() {
		
		return tipo;
		
	}

	public void setTipo(int tipo) {
		
		this.tipo = tipo;
		
	}

	public String getCausale() {
		
		return causale;
		
	}

	public void setCausale(String causale) {
		
		this.causale = causale;
	}

	public String getIva() {
		
		return iva;
		
	}

	public void setIva(String iva) {
		
		this.iva = iva;
	}

	public String getNote() {
		
		return note;
	}

	public void setNote(String note) {
		
		this.note = note;
	}
	
	
	
	public void createNewTable() throws Exception {
		String name = this.getClass().getSimpleName();
		//super.query("DROP TABLE " + name + " ;");
		
		String sql = super.createNewTableHead(name);
		
		sql += super.createNewTableBody("id", "INTEGER PRIMARY KEY AUTOINCREMENT ,");
		sql += super.createNewTableBody("Date", "INTEGER NOT NULL ,");
		sql += super.createNewTableBody("numero", "INTEGER NOT NULL,");
		sql += super.createNewTableBody("socio", "TEXT NOT NULL,");
		sql += super.createNewTableBody("importo", "REAL NOT NULL,");
		sql += super.createNewTableBody("tipo", "TEXT,");
		sql += super.createNewTableBody("causale", "TEXT,");
		sql += super.createNewTableBody("IVA", "INTEGER,");
		sql += super.createNewTableBody("note", "TEXT");
				
		super.createNewTableExecute(sql);
		
	}
	
	/*
     * insert new value
     */
    
    public int insert() throws SQLException {  
        String sql = "INSERT INTO movimenti(numero, Date, socio, importo,tipo,causale,IVA,note) VALUES(?,?,?,?,?,?,?,?)";  
   
        try{          	
            
            //test
            Connection conn = null;
			try {
				conn = GestionaleBusiness.getConnections();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				showMessageDialog(null," Errore  !!! \n " + e.getMessage());			}
            
            PreparedStatement pstmt = conn.prepareStatement(sql); 
                        
            pstmt.setInt(1, this.getNumero()); 
            pstmt.setString(2, this.getDate()); 
            pstmt.setInt(3, this.getSocio()); 
            pstmt.setInt(4, this.getImporto()); 
            pstmt.setInt(5, this.getTipo()); 
            pstmt.setString(6, this.getCausale()); 
            pstmt.setString(7, this.getIva()); 
            pstmt.setString(8, this.getNote());            
                        
            int result = pstmt.executeUpdate();  
            
            return result;
            
        } 
        
        catch (SQLException e) {  
        	
            System.out.println(e.getMessage());
            showMessageDialog(null," Errore  !!! \n " + e.getMessage());
            return 0;
            
        }
		  
    }  
    
    /*
     * Select All
     * return List<soci>
     */
    
    public List<Movimenti> selectAllMovimenti() throws SQLException{  
    	
    	String table = this.getClass().getSimpleName();
    	
        String sql = "SELECT * FROM " + table; 
        
        List<Movimenti> result = new ArrayList<Movimenti>();
        
        Connection rf = null ;
                
         
        ResultSet rs    = selectAll();  
            
            // loop through the result set  
            while (rs.next()) {  
            	
            	Movimenti m = new Movimenti();
            	
            	m.setId(rs.getInt(1));
            	m.setDate(rs.getString(2));
            	m.setNumero(rs.getInt(3));
            	m.setSocio(rs.getInt(4)); 
            	m.setImporto(rs.getInt(5));
            	m.setTipo(rs.getInt(6));
            	m.setCausale(rs.getString(7));
            	m.setIva(rs.getString(8));
            	m.setNote(rs.getString(9));            	
            	              
                result.add(m);
            }  
        
        
          
		return result;
    }
	
	
	
		
	}

