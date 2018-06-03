
package Carpark_class;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Tick_Lost_Cust {
    
    
    Connection conn = dbconnct.connect();
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    
    String driver;
    String driverLicense;
    String NIC;
    String address;
    String phone;
    String type;
    String vehiOwner;
    String ownerPhone;
    String insuaranceNo;
    String vehiIncmNo;
    

   

   

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getDriverLicense() {
        return driverLicense;
    }

    public void setDriverLicense(String driverLicense) {
        this.driverLicense = driverLicense;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVehiOwner() {
        return vehiOwner;
    }

    public void setVehiOwner(String vehiOwner) {
        this.vehiOwner = vehiOwner;
    }

    public String getOwnerPhone() {
        return ownerPhone;
    }

    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;
    }
    

    public String getInsuaranceNo() {
        return insuaranceNo;
    }

    public void setInsuaranceNo(String insuaranceNo) {
        this.insuaranceNo = insuaranceNo;
    }

    public String getVehiIncmNo() {
        return vehiIncmNo;
    }

    public void setVehiIncmNo(String vehiIncmNo) {
        this.vehiIncmNo = vehiIncmNo;
    }
    
    
    
    
    
    public void addtlc(String vid,String emp,String vlic,String vcat)
    {
        String q = "INSERT INTO ticket_lost_vehi(name,dri_licNo,address,NIC,phone,type,ve_id,vehilic,category,emp_id,vehiowner,ownerphone,ins_no,vehi_incm_cetifi) VALUES ('"+this.getDriver()+"','"+this.getDriverLicense()+"','"+this.getAddress()+"','"+this.getNIC()+"','"+this.getPhone()+"','"+this.getType()+"','"+vid+"','"+vlic+"','"+vcat+"','"+emp+"','"+this.getVehiOwner()+"','"+this.getOwnerPhone()+"','"+this.getInsuaranceNo()+"','"+this.getVehiIncmNo()+"' )  ";
    
        try {
            pst = conn.prepareStatement(q);
            pst.execute();
            
            JOptionPane.showMessageDialog(null," Saved ");
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null," Problem with saving \n"+e);
        }
    }
    
    
     public void updatetlc(String vid,String emp,String vlic,String vcat)
    {
        String q = "UPDATE ticket_lost_vehi SET name='"+this.getDriver()+"',dri_licNo='"+this.getDriverLicense()+"',address='"+this.getAddress()+"',NIC='"+this.getNIC()+"',phone='"+this.getPhone()+"',type='"+this.getType()+"',ve_id='"+vid+"',vehilic='"+vlic+"',category='"+vcat+"',emp_id='"+emp+"',vehiowner='"+this.getVehiOwner()+"',ownerphone='"+this.getOwnerPhone()+"',ins_no='"+this.getInsuaranceNo()+"',vehi_incm_cetifi='"+this.getVehiIncmNo()+"'   ";
    
        try {
            pst = conn.prepareStatement(q);
            pst.execute();
            
            JOptionPane.showMessageDialog(null," Updated ");
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null," Problem with updating \n"+e);
        }
    }
     
     
     
      public void deletetlc(String vid)
    {
        String sq = "DELETE FROM ticket_lost_vehi where ve_id='"+vid+"'";
        
        try {
            
            pst=conn.prepareStatement(sq);
            pst.execute();
            
            JOptionPane.showMessageDialog(null," deleted ");
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null," Can`t delete "+e);
        }
    }
    
    
    
    public String getVID(String lno)
    {
        String q = " SELECT * FROM parkingvehicle WHERE plateno='"+lno+"' AND status='"+"in"+"' ";
    
        try {
            pst = conn.prepareStatement(q);
            rs = pst.executeQuery();
            rs.next();
            
            String vid = rs.getString("ve_id");
            
            return vid;
            
        } catch (SQLException e) {
            return "no" ;
            //JOptionPane.showMessageDialog(null," Problem with getVID \n"+e);
        }
        
        //return "no";
    }
    
    
}
