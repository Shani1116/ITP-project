/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import db.dbconnct;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Shanika
 */
public class User   {
    
    
    //Creates the database connection
    Connection conn= dbconnct.connect();;
    PreparedStatement pst=null;
    ResultSet rs = null;
    
    
    public String user_name;
    public String Password;
    public int priv_no;
    public String empId;

    public String getUsername() {
        return user_name;
    }

    public String getPassword() {
        return Password;
    }

    public int getPriv_no() {
        return priv_no;
    }
    
    public int getPriv_no(String us){
        
        this.user_name = us;
      
        
        switch(this.user_name){
            case "Admin":
                return 1;
                //break;
            case "HRM":
                return 2;
                //break;
            case "FinM":
                return 3;
            case "MaintM":
                return 4;
            case "CustM":
                return 5;
            case "TransM":
                return 6;
            case "EventM":
                return 7;
            case "EntM":
                return 8;
            case "CarM":
                return 9;
            case "GameC":
            case "MovieC":
                return 10;
            case "CarC":
                return 11;
            default:
                return 0;
        }    
        
    }

    public void setUsername(String username) {
        this.user_name = username;
    }

   
    
    public String login(String u, String p){
    
            this.user_name = u;
            this.Password = Validation.encrpytpass(p);
            
            
            System.out.println(this.Password);
            int priv = this.getPriv_no(u);
                    
            String sq = "SELECT username,password FROM user WHERE username=? AND password=?";
    
            try {
            pst = conn.prepareStatement(sq);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             
            pst.setString(1,this.user_name);
           
            pst.setString(2,this.Password);
            
           
            rs=pst.executeQuery();
            
            if(rs.next())                
            {
             
                try{
                
                    String po = "SELECT username,password FROM user WHERE username=?";
                    
                    pst=conn.prepareStatement(po);
                    pst.setString(1,this.user_name);
                    
                    rs=pst.executeQuery();
                   
                    rs.next();
                    
                    String f = rs.getString(1);
                    
                switch(priv){
                 case 1:
                    JOptionPane.showMessageDialog(null,"Logged in as Admin!");
                    return rs.getString("username");
                    
                 case 2:
                    JOptionPane.showMessageDialog(null,"Logged in as HR Manager!");
                    return rs.getString("username");
                 case 3:
                    JOptionPane.showMessageDialog(null,"Logged in as Finance Manager!");
                    return rs.getString("username");
                 case 4:
                    JOptionPane.showMessageDialog(null,"Logged in as Maintainance Manager!");
                    return rs.getString("username");
                 case 5:
                    JOptionPane.showMessageDialog(null,"Logged in as Customer Manager!");
                    return rs.getString("username");
                 case 6:
                    JOptionPane.showMessageDialog(null,"Logged in as Trans/Inventory Manager!");
                    return rs.getString("username");
                 case 7:
                    JOptionPane.showMessageDialog(null,"Logged in as Event Manager!");
                    return rs.getString("username");
                 case 8:
                    JOptionPane.showMessageDialog(null,"Logged in as GameZone Manager!");
                    return rs.getString("username");
                 case 9:
                    JOptionPane.showMessageDialog(null,"Logged in as Car Park Manager!");
                    return rs.getString("username");
                 case 10:
                    if(rs.getString("username").equals("GameC")){
                     JOptionPane.showMessageDialog(null,"Logged in as Game Counter user!");
                    return rs.getString("username");
                    }
                    if(rs.getString("username").equals("MovieC")){
                     JOptionPane.showMessageDialog(null,"Logged in as Movie Counter user!");
                    return rs.getString("username");
                    }
                 case 11:
                    JOptionPane.showMessageDialog(null,"Logged in as Car Park Counter!");
                    return rs.getString("username");
                 default:
                    return "Wrng";
             }
           
             }
                catch(Exception e){
                
                }
                
            }else{
            return "Wrng";
            }
            
            }
            
    
        catch (SQLException ex) {
            System.out.println("Error when connecting to database! Please check connectivity.");
            
        }
    
            return "a";
            
    }
    
    public void logout(){
        
        
    } 
    
    
}
