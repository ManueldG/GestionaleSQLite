package it.java.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import it.java.business.GestionaleBusiness;

public class Soci extends Tables {
	
	int tessera;
	private String name;
	private String secondName;
	private String telephone;
	private String address;
	private int tipo;
	
	
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
      
    
    /*
     * Select All
     * return List<soci>
     */
    
    public List<Soci> selectAll(){  
    	
    	String table = this.getClass().getSimpleName();
    	
        String sql = "SELECT * FROM " + table; 
        
        List<Soci> result = new ArrayList<Soci>();
        
        Connection rf ;
                
        try {  
        	
        	// create a connection to the database  
            rf = GestionaleBusiness.getConnection();
            Statement stmt  = rf.createStatement();  
            ResultSet rs    = stmt.executeQuery(sql);  
            
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
        } 
        
        catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }
        System.out.println(result);
       
		return result;
    }
    
    
    
    public int Insert(Soci s) {
 	   
        try{          	
             
        	Connection conn = GestionaleBusiness.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(super.insertHead()); 
            
            pstmt.setInt(1, s.getTessera()); 
            pstmt.setString(2, s.getName()); 
            pstmt.setString(3, s.getSecondName()); 
            pstmt.setString(4, s.getTelephone()); 
            pstmt.setString(5, s.getAddress()); 
            pstmt.setInt(6, s.getTipo()); 
                        
            int result = pstmt.executeUpdate();  
            pstmt.close();
            conn.close();
            return result;
            
            
        } 
        
        catch (SQLException e) {  
        	
            System.out.println(e.getMessage());  
            return 0;
        }
    }   
    
    
    
    public Integer newTessera() {
    	
    	String sql = " SELECT MAX(tessera) FROM soci;";
    	try {
    		
    		Connection rf = GestionaleBusiness.getConnection();
			Statement stmt = rf.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			Integer max = rs.getInt(1) + 1;
			return max;
    	} 
    	catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
    	}
    	
    }
    
    
    
    
	
	
	
	

}
