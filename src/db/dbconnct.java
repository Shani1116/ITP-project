
package db;



//import java.sql.Connection;
import com.mysql.jdbc.Connection;

//import com.mysql.jdbc.Connection;
//import java.sql.Connection;

import java.sql.DriverManager;





public class dbconnct {
    
    public static Connection connect()
    {
        Connection conn = null;
        
        
        
        
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/smms","root","");
                    
        }
        
        
        catch (Exception e)
        {
            System.out.println(e);
        }
        return conn;
        
    
    }
    
    
}
