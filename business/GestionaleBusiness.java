package it.java.business;

import java.sql.SQLException;

import static javax.swing.JOptionPane.showMessageDialog;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;  

import java.util.*;

import it.java.model.Movimenti;
import it.java.model.Row;
import it.java.model.Soci;


public class GestionaleBusiness {  
		
	private static String fileName="db.db"; //nome file 
	protected static Connection rf;
	protected static Soci soci = new Soci();
	protected static Movimenti movimenti = new Movimenti();
		 
    public static Connection connect() throws Exception { 
    	       
        	try {  
            // db parameters  
            String url = "jdbc:sqlite:C:/sqlite/" + fileName;             
			
            // create a connection to the database             
            rf = DriverManager.getConnection(url);  
           
            System.out.println("Connection to SQLite has been established.");              
              
	        } 
	        catch (SQLException e) {
	        	
	            System.out.println(e.getMessage()); 
	            
	            createNewDatabase(fileName); // creo il database
	            
	            movimenti.createNewTable(); 
				soci.createNewTable();// creo la tabella soci
				 
				
	        }
        
                
        return rf;        
		 
    }
    
    public static Connection getConnection() { 
    	    	
        if (rf != null) {
        	return rf;
        } 
        else
        try {
        	
			rf = connect();
			return rf;
		} 
        catch (Exception e) {
			
			System.out.println(e);
			e.printStackTrace();
			
		}
        
        return rf;                
		 
     }
    
    
    /*
     * create new DB
     */
    
    public static void createNewDatabase(String fileName) {  
    	               
        try {  
            
            if (rf != null) { 
            	
                DatabaseMetaData meta = rf.getMetaData();  
                System.out.println("The driver name is " + ((DatabaseMetaData) rf).getDriverName());  
                System.out.println("A new database has been created.");
                
            } 
            System.out.println("Close");  
            rf.close();            
   
        } 
        
        catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    }    		
	
		public void update(Row data){
							
				if (data.getId() > 0) {
					
					System.out.print(data.getId()+" ");
					
					if (data.getName().length()>0) {
					
						String sql="UPDATE employees set name = ? where id=?";
						
						PreparedStatement ps;
						
						try {
							
							ps = rf.prepareStatement(sql);
							ps.setString(1, data.getName());
							ps.setInt(2, data.getId());
							
							ps.executeUpdate();
							ps.close();
							rf.close();
							
						} 
						
						catch (SQLException e) {
							
							e.printStackTrace();
						} 					
						
						System.out.print("chiuso2  " + data.getName()+" ");
					}				
					
				}				
    
		}	    	
	    	
    }

    
    
    
    