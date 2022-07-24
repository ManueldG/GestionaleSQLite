package it.java.model;


import static javax.swing.JOptionPane.showMessageDialog;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import it.java.business.GestionaleBusiness;


public class Movimenti extends Tables{
	
	int date;
	int numero;
	String socio;
	int importo;
	int tipo;
	String causale;
	String iva;
	String note;
	
	
	
	public void movimenti() {
		
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
				
		
		    
		this.date =  date;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getSocio() {
		return socio;
	}

	public void setSocio(String socio) {
		this.socio = socio;
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
		
		sql += super.createNewTableBody("id", "BIGINT PRIMARY KEY ,");
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
    
    public void insert() throws SQLException {  
        String sql = "INSERT INTO movimenti(numero, Date, socio, importo,tipo,causale,IVA,note) VALUES(?,?,?,?,?,?,?,?)";  
   
        try{          	
            
            //test
            Connection conn = GestionaleBusiness.getConnection();
            
            PreparedStatement pstmt = conn.prepareStatement(sql); 
                        
            pstmt.setInt(1, this.getNumero()); 
            pstmt.setInt(2, this.getDate()); 
            pstmt.setString(3, this.getSocio()); 
            pstmt.setInt(4, this.getImporto()); 
            pstmt.setInt(5, this.getTipo()); 
            pstmt.setString(6, this.getCausale()); 
            pstmt.setString(7, this.getSocio()); 
            pstmt.setInt(8, this.getImporto());            
                        
            int result = pstmt.executeUpdate();  
            pstmt.close();
            conn.close();
            
        } 
        
        catch (SQLException e) {  
        	
            System.out.println(e.getMessage());  
            
        }  
    }  
	
	
	
		
	}

