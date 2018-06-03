
package Carpark_class;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Yasith
 */
public class Memberc {
    
    String mid;
    String name;
    String address;
    String l_no;
    String NIC;
    String phone;
    String packag;
    Boolean paystatus;
    String exp;

    Connection conn = dbconnct.connect();
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    DateFormat tf = new SimpleDateFormat("HH:mm:ss");
    Date dt = new Date();
    
    Calendar cal = Calendar.getInstance();
    
    //creates a registered vehicle
    Registered r = new Registered();
    
  

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getL_no() {
        return l_no;
    }

    public void setL_no(String l_no) {
        this.l_no = l_no;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPackag() {
        return packag;
    }

    public void setPackag(String packag) {
        this.packag = packag;
    }
    
    public Boolean getPaystatus() {
        return paystatus;
    }

    public void setPaystatus(Boolean paystatus) {
        this.paystatus = paystatus;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }
    

    //Member adding,updating and deleting       
    public void addMember( String Mname, String Maddress, String Ml_no, String Mpackage, String MNIC, String Mphone, String Memp_id, String Mvehilic,String Mvehicat)
    {
        //setMid(Mid);
        setName(Mname);
        setAddress(Maddress);
        setL_no(Ml_no);
        setPackag(Mpackage);
        setNIC(MNIC);
        setPhone(Mphone);
        setExp(df.format(dt.getTime()));
        
        r.setVehilicense(Mvehilic);
        r.setVehicat(Mvehicat);
        
        String sq = "INSERT INTO member(name,address,l_no,package,NIC,phone,emp_id,vehilicense,vehicat,paystatus,expdate) VALUES ('"+getName()+"','"+getAddress()+"','"+getL_no()+"','"+getPackag()+"','"+getNIC()+"','"+getPhone()+"','"+Memp_id+"','"+r.getVehilicense()+"','"+r.getVehicat()+"','"+0+"','"+getExp()+"')";
        
        try {
            
            pst = conn.prepareStatement(sq);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Successfully added a member.\n***COLLECT PAYMENTS***");
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null,"Can`t add a member??"+e);
        }
    
    }
    
    
    public void updateMember(String Mid,String Mname, String Maddress, String Ml_no, String Mpackage, String MNIC, String Mphone, String Memp_id, String Mvehilic,String Mvehicat)
    {
        setMid(Mid);
        setName(Mname);
        setAddress(Maddress);
        setL_no(Ml_no);
        setPackag(Mpackage);
        setNIC(MNIC);
        setPhone(Mphone);
        
        r.setVehilicense(Mvehilic);
        r.setVehicat(Mvehicat);
        
        String sq = "UPDATE member SET name='"+getName()+"',address='"+getAddress()+"',l_no='"+getL_no()+"',package='"+getPackag()+"',NIC='"+getNIC()+"',phone='"+getPhone()+"',emp_id='"+Memp_id+"',vehilicense='"+r.getVehilicense()+"',vehicat='"+r.getVehicat()+"' WHERE mid = '"+getMid()+"'";
        
        try {
            
            pst = conn.prepareStatement(sq);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Successfully updated the member.");
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null,"Can`t update the member??"+e);
        }
    }
    
    public void deleteMember(String Mid)
    {
        String sq = "DELETE FROM member where mid='"+Mid+"'";
        
        try {
            
            pst=conn.prepareStatement(sq);
            pst.execute();
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null,"Can`t delete the member??"+e);
        }
    }
    
//Check is the Member reject
    public boolean isReject(String Mid) throws SQLException, ParseException
    {
        String sql = "SELECT * FROM member WHERE mid='"+Mid+"' ";
           
          try {
            
                pst = conn.prepareStatement(sql);
                rs = pst.executeQuery();
                rs.next(); 
                                              
        }
        catch (SQLException e) {
        
                JOptionPane.showMessageDialog(null,"Something wrongs with isReject method???");
        }
  
             Date parsedDate = df.parse(rs.getString("expdate"));
             Date current = df.parse(df.format(dt));
                
                if(parsedDate.before(current))
                {
                    JOptionPane.showMessageDialog(null,"WARNING!\nRejected Member...\n***HAVE TO PAY FINE***");
                    return true;
                }
                
                else
                    
                    return false;
            
    }
    
    
    public Double calFine(String Mid) throws SQLException, ParseException
    {
        Double f1 = 250.0;
        Double f2 = 50.0;
        
        String sql = "SELECT * FROM member WHERE mid='"+Mid+"' ";
           
          try {
            
                pst = conn.prepareStatement(sql);
                rs = pst.executeQuery();
                rs.next(); 
          }
          
          catch(SQLException e){
              
          }
          
          Date parsedDate = df.parse(rs.getString("expdate"));
          
          long diff = dt.getTime() - parsedDate.getTime();
                   
          Double tot = f1 + (f2*diff / 1000 / 60 /60 /24);
          
          return tot;
        
    
    }
    
    //Search Member for do payments
    public String searchMember(String key, String type)
    {
        if(type.equalsIgnoreCase("Vehicle License") == true)
        {
        
            String sq = "SELECT * FROM member WHERE vehilicense ='"+key+"' ";
        
            try {
            
                    pst = conn.prepareStatement(sq);
                    rs = pst.executeQuery();
                    rs.next();
                    
                    String output =   "     Member ID = "+rs.getString("mid")
                                   +"\n     Name      = "+rs.getString("name")
                                     +"                    NIC      = "+rs.getString("NIC")
                                   +"\n     Package   = "+rs.getString("package")
                                   +"\n     Vehi. License NO. = "+rs.getString("vehilicense")
                                     +"                Category = "+rs.getString("vehicat");
                    return output;
                    
                }
        
            catch (SQLException e) {
        
                    //JOptionPane.showMessageDialog(null,"Can`t Search"+ e);
            }
                       
        }
        
        else 
        {
            String sq1 = "SELECT * FROM member WHERE NIC='"+key+"'";
        
            try {
            
                    pst = conn.prepareStatement(sq1);
                    rs = pst.executeQuery();
                    rs.next();
                     
                    String output =   "     Member ID = "+rs.getString("mid")
                                   +"\n     Name      = "+rs.getString("name")
                                     +"                    NIC      = "+rs.getString("NIC")
                                   +"\n     Package   = "+rs.getString("package")
                                   +"\n     Vehi. License NO. = "+rs.getString("vehilicense")
                                     +"                Category = "+rs.getString("vehicat");
                    return output;
                    
            }
        
            catch (SQLException e) {
        
                    //JOptionPane.showMessageDialog(null,"Can`t Search"+ e);
            }      
        }
    
        return "Not Found";
    }
    
}


