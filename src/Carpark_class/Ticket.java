
package Carpark_class;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Date;
import javax.swing.JOptionPane;


/**
 *
 * @author Yasith
 */
public class Ticket {
    
    String tickNo;
    String secretId;
    Date date;
    Time time;
    
    Connection conn = dbconnct.connect();
    PreparedStatement pst = null;
    ResultSet rs = null;
    

    public String getTickNo() {
        return tickNo;
    }

    public void setTickNo(String tickNo) {
        this.tickNo = tickNo;
    }

    public String getSecretId() {
        return secretId;
    }

    public void setSecretId(String secretId) {
        this.secretId = secretId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
    
    
    
    public int settickNo()
    {
        String sq = " SELECT MAX(ticketno) FROM  parkingvehicle ";
        
        try {
            
            pst = conn.prepareStatement(sq);
            rs= pst.executeQuery();
            rs.next();
                        
            String ptno = rs.getString("MAX(ticketno)");
            
            int newtno = Integer.parseInt(ptno)+1;
            
            return newtno;        
            
            
        } catch (SQLException e) {
            
            //JOptionPane.showMessageDialog(null,"Problem with tickNo() method "+e);
        }
        
        return 1;
    }
    
    public int gettickNo(String vlic,String type1,String type2)
    {
        String sq = "SELECT ticketno FROM parkingVehicle WHERE plateno='"+vlic+"' AND (status ='"+type1+"' OR status='"+type2+"')";
        
        try {
            
            pst = conn.prepareStatement(sq);
            rs = pst.executeQuery();
            rs.next();
            
            int tno = rs.getInt("ticketno");
            
            return tno;
        } catch (SQLException e) {
            
            //JOptionPane.showMessageDialog(null," Problem with load tick no "+e);
            return 0;
        }
    }
        
}
