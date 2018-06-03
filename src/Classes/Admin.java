/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Classes.Employee;
import db.dbconnct;
import Admin.AddUser;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Shanika
 */
public class Admin extends Employee {
    
    //Creates the database connection
    Connection conn= dbconnct.connect();;
    PreparedStatement pst=null;
    
    //Creates a user onject
    User u1 = new User();
    
    public void adduser(String id, String uname, String pass, int p){
        
        u1.empId= id;
        u1.user_name = uname;
        u1.Password = pass;
        u1.priv_no = p;
        
        String q = "INSERT INTO user VALUES ('"+ u1.user_name +"', '"+ u1.Password +"', '"+ u1.priv_no +"', '"+ u1.empId +"')";
        
        try {
            pst = conn.prepareStatement(q);
            pst.execute();
            JOptionPane.showMessageDialog(null,"One user added to the database!");
            
        } 
         catch (SQLIntegrityConstraintViolationException ex) {
            //System.out.println("Error when adding to database! Please check connectivity.");
            JOptionPane.showMessageDialog(null,"Duplicate values! Please check and enter again!");
            Logger.getLogger(AddUser.class.getName()).log(Level.SEVERE, null, ex);  
        }
        catch (SQLException ex) {
            System.out.println("Error when adding to database! Please check connectivity."+ex);
            
        }
        
    }
    
    public void deluser(String un){
        
        u1.user_name = un;
        
         String q = "DELETE FROM user WHERE username='"+ u1.user_name +"'";
        
        try {
            pst = conn.prepareStatement(q);
            pst.execute();
            JOptionPane.showMessageDialog(null,"One user deleted from the database!");
            
        } 
         catch (SQLIntegrityConstraintViolationException ex) {
            //System.out.println("Error when adding to database! Please check connectivity.");
            JOptionPane.showMessageDialog(null,"Duplicate values! Please check and enter again!");
           // Logger.getLogger(AddUser.class.getName()).log(Level.SEVERE, null, ex);  
        }
        catch (SQLException ex) {
            System.out.println("Error when deleting to database! Please check connectivity.");
            
        }
    }
    
    public void searchuser(){
    
    }
    
    
}
