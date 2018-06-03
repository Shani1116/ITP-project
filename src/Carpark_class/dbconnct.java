
package Carpark_class;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class dbconnct {
    
    public static Connection connect()
    {
        Connection con = null;
        
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/smms","root","" );
            
        } 
        
        catch (ClassNotFoundException | SQLException e) {
        
            System.out.println("Database Connection failed"+e);
        }
        
        return con;
    }
    
    
}
