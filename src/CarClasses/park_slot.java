
package CarClasses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import javax.swing.JOptionPane;


public class park_slot {
    
    Connection conn = dbconnct.connect();
    PreparedStatement pst = null;
    ResultSet rs = null; 
    
    
    
    private String slotNo;
    private int ava;
    private String vehiNo;

    public String getSlotNo() {
        return slotNo;
    }

    public void setSlotNo(String slotNo) {
        this.slotNo = slotNo;
    }

    public int getAva() {
        return ava;
    }

    public void setAva(int ava) {
        this.ava = ava;
    }

    public String getVehiNo() {
        return vehiNo;
    }

    public void setVehiNo(String vehiNo) {
        this.vehiNo = vehiNo;
    }
    
    
    public void takeSlot()
    {
    
        String q = "UPDATE carparkslot SET status='"+"topark"+"' , vehilic='"+this.getVehiNo()+"'WHERE slotNo='"+this.getSlotNo()+"'  ";
        
        try {
            
            pst = conn.prepareStatement(q);
            pst.execute();
            
        } catch (Exception e) {
            
  //          JOptionPane.showMessageDialog(null,"take slot\n"+ e);
        }
    }
    
    
    public void releaseSlot()
    {
        
        String q = "UPDATE carparkslot SET ava='"+0+"' , vehilic='"+"-"+"'  WHERE slotNo='"+this.getSlotNo()+"'  ";
        
        try {
            
            pst = conn.prepareStatement(q);
            pst.execute();
            
        } catch (SQLException e) {
            
    //        JOptionPane.showMessageDialog(null,"release slot\n"+ e);
        }
        
    }
    
    
    public String findSlotNo(String vno,String type1, String type2)
    {
        String q = " SELECT slotno FROM parkingvehicle WHERE plateno = '"+vno+"' AND (status = '"+type1+"' OR status='"+type2+"')";
        
         try {
            
            pst = conn.prepareStatement(q);
            rs = pst.executeQuery();
            rs.next();
            
            String slotno = rs.getString("slotno");
            
            
            
            return slotno;
            
        } catch (SQLException e) {
            
      //      JOptionPane.showMessageDialog(null,"release slot\n"+ e);
            
        }
         
         return "no";
    }
    
    
    
    
}
