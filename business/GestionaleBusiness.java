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

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import it.java.model.Movimenti;
import it.java.model.Row;
import it.java.model.Soci;


public class GestionaleBusiness {  
		
	private static String fileName="db.db"; //nome file 
	protected static Connection rf;
	protected static Soci soci = new Soci();
	protected static Movimenti movimenti = new Movimenti();
	private static GestionaleBusiness gb;
	
    public static Connection getConnections() throws Exception { 
    	       
        	try {  
        		
            // db parameters  
            String url = "jdbc:sqlite:C:/sqlite/" + fileName;             
			
            // create a connection to the database   
            if (rf == null) {
            	
            	rf = DriverManager.getConnection(url);  
               	System.out.println("Connection to SQLite has been established."); 
               	
            }
            	             
            
	        } 
	        catch (SQLException e) {
	        	
	            System.out.println(e.getMessage()); 
	            
	            createNewDatabase(fileName); // creo il database
	            movimenti.createNewTable(); 	            
				soci.createNewTable();// creo la tabella soci
								
	        }
                        
        return rf;    
        
    }
    
    public static GestionaleBusiness getInstance() { 
    	    	
        if (gb == null) {
        	
        	 gb = new GestionaleBusiness();
        	
        }             
        
        return gb;                
		 
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
   
        } 
        
        catch (SQLException e) {  
            System.out.println(e.getMessage()); 
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame, "Errore!!!" + e);
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
							
							
						} 
						
						catch (SQLException e) {
							
							e.printStackTrace();
							JFrame frame = new JFrame();
				            JOptionPane.showMessageDialog(frame, "Hello there! How are you today?");
						} 					
						
						
					}				
					
				}				
    
		}	    	
	    	
    }

    
    
    
    