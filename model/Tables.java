package it.java.model;

import static javax.swing.JOptionPane.showMessageDialog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import it.java.business.GestionaleBusiness;

public abstract class Tables {
	
	private Integer id;
	
	
	
	public Tables() {
    	
    }
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
        	
        	
        	Connection rf = null;
			try {
				rf = GestionaleBusiness.getInstance().getConnections();
			} catch (Exception e) {
				showMessageDialog(null," Errore  !!! \n " + e.getMessage());
				e.printStackTrace();
			}
        	
            Statement stmt = rf.createStatement();  
            ResultSet rs = stmt.executeQuery(sql);  
                              
            
        } 
        
        catch (SQLException e) {          	
            
        	showMessageDialog(null," Errore  !!! \n " + e.getMessage());
            
        }  
    }    
    
	
    public String insertHead() { 
    	
    	String name = this.getClass().getSimpleName();
        String sql = "INSERT INTO " + name + "(tessera, name, secondname, telephone, address, tipo) VALUES(?,?,?,?,?,?)"; 
        return sql;
        
    }
    
    public String deleteHead() { 
    	
    	String name = this.getClass().getSimpleName();
        String sql = "DELETE FROM " + name + " WHERE id = ?"; 
        return sql;
        
    }
    
    public boolean delete(int id) { 
    	
    	Connection conn = null ;
    	try {
			conn = GestionaleBusiness.getConnections();
		} catch (Exception e1) {
			showMessageDialog(null," Errore  !!! \n " + e1.getMessage());
			e1.printStackTrace();
		}
    	
    	
        PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(this.deleteHead());
			
			pstmt.setInt(1, id); 	        
            
	        boolean result = pstmt.execute(); 
	        pstmt.close();
	        conn.close();
	        return result;
	        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
			return false;
        
        
        
    	
        
    }
        
       	

}
