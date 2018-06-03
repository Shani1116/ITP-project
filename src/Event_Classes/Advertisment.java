/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Event_Classes;

import java.sql.Connection;
import static java.sql.DriverManager.println;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Navodya
 */
public class Advertisment {
    
     Connection con= dbconnct.connect();
     PreparedStatement pst=null;
     ResultSet rs = null;   
     
    private String AdvertismentID;       
    private String type;
    private String Location;
    private String aType;
    private int period;
    private String description;
    private double Rate;
    private int locId;
    public int count;
    int val;
    public int getLocId() {
        return locId;
    }

    public void setLocId(int locId) {
        this.locId = locId;
    }
    
    public String getAdvertismentID() {
        return AdvertismentID;
    }

    public void setAdvertismentID(String AdvertismentID) {
        this.AdvertismentID = AdvertismentID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public String getaType() {
        return aType;
    }

    public void setaType(String aType) {
        this.aType = aType;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRate() {
        return Rate;
    }

    public void setRate(double Rate) {
        this.Rate = Rate;
    }
    
    
    public int setLocId(){
        
        String sq1="SELECT MAX(LocationID)FROM dis_location";
        
             try {
              
                pst = con.prepareStatement(sq1);
                rs=pst.executeQuery();
                rs.next();
            
                String val=rs.getString("MAX(LocationID)");
                int max=Integer.parseInt(val);
                //System.out.println(max);
                return max+1;
            }
            catch(SQLException e){
                             
            }
     return 1;
    }
    
    
    
    public boolean addAd(String aid,int per,String d,String adty,String loc,String p){
        
        this.setAdvertismentID(aid);
        this.setaType(adty);//ad type
        this.setPeriod(per);
        this.setDescription(d);
        this.setLocation(loc); //location 1
        this.setType(p); 
        
        String sq="INSERT INTO advertisments(ad_id,adType,period,description,locID) VALUES ('"+this.getAdvertismentID()+"','"+this.getaType()+"',"+this.getPeriod()+",'"+this.getDescription()+"',"+this.setLocId()+")";
    
          try {
              
                pst = con.prepareStatement(sq);
                pst.execute();
                adLoc();
                
                JOptionPane.showMessageDialog(null,"One Advertisment has added to the database!");
                return true;
            }
            catch(SQLException e){
                 System.out.println("here  error."+e);
                 return false;
                
            }
        
    
    }
    
    public void adLoc(){
    
          
    
         String sq1="INSERT INTO dis_location (Location,locTy) VALUES ('"+this.getLocation()+"','"+this.getType()+"')";
          
            try {
              
                pst = con.prepareStatement(sq1);
                pst.execute();
            
                //JOptionPane.showMessageDialog(null,"One Advertisment has added to the database!");
            }
            catch(SQLException e){
                 System.out.println("loc error."+e);
            
                
            }
    
    }
    
    public void updateAd(int p,String aid){
         
        this.setPeriod(p);
        this.setAdvertismentID(aid);
         
        String s="UPDATE advertisments SET period="+this.getPeriod()+" WHERE ad_id="+this.getAdvertismentID()+"";
         try {
            pst = con.prepareStatement(s);
            pst.execute();
            JOptionPane.showMessageDialog(null,"database has been updated");
            
            }
            catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null,"Error"+ex);
            
            }
    
    }
    
    
    
}
