package it.java.model;

import static javax.swing.JOptionPane.showMessageDialog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import it.java.business.GestionaleBusiness;

public abstract class Tables {
	
	private int id;
	
	
	
	public Tables() {
    	
    }
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	public String createNewTableHead(String name)  {  
       	       	
        	String sql = "CREATE TABLE " + name + " (" ;
        	
        	return sql;
            
        
    } 
	
	
	public String createNewTableBody(String column, String property) {  
       	              	
        	
        	String sql = column + " " + property+" " ; 
        	       
        	return sql;
         
        
    }
	
	public Boolean createNewTableExecute(String sql) throws Exception  {  
       	
        try {  
        	
        
			this.query(sql + ");");
        	
        	
        	return true;
        	
        }
        catch(Exception ex) {
        	showMessageDialog(null," Errore  !!! \n " + ex.getMessage());
        	return false;
        }
           
        
    }
	
	/*
     *  generic request
     */    
    
    public void query(String sql) {  
                  
        try{     
        	
        	Connection rf = GestionaleBusiness.getConnection();
            Statement stmt = rf.createStatement();  
            ResultSet rs = stmt.executeQuery(sql);  
            System.out.println(rs.getString(1));                  
            
        } 
        
        catch (SQLException e) {  
        	
            System.out.println(e.getMessage());
            
            
        }  
    }    
    
	
    public String insertHead() { 
    	
    	String name = this.getClass().getSimpleName();
        String sql = "INSERT INTO " + name + "(tessera, name, secondname, telephone, address, tipo) VALUES(?,?,?,?,?,?)"; 
        return sql;
        
    }
        
       	

}
