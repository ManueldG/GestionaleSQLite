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
	
	Date date;
	int numero;
	String socio;
	int importo;
	String tipo;
	String causale;
	String iva;
	String note;
	
	
	
	public void movimenti() {
		
	}

	public Date getDate() {
		return date;
	}

	public void setDate(int day, int month, int year, int hour, int minute) {
				
		Date date=null;
		    
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
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
        String sql = "INSERT INTO movimenti(numero, Date, socio, importo) VALUES(?,?,?,?)";  
   
        try{          	
            
            
            Connection conn = GestionaleBusiness.getConnection();
            
            PreparedStatement pstmt = conn.prepareStatement(sql); 
            
            pstmt.setInt(1, 2345);  
            pstmt.setInt(2, 345);  
            pstmt.setString(3,"ffre");
            pstmt.setFloat(4, 100);
            
            pstmt.executeUpdate();  
            
        } 
        
        catch (SQLException e) {  
        	
            System.out.println(e.getMessage());  
            
        }  
    }  
	
	
	
		
	}

