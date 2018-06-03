/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmanager.classes;

//import cmanager.addcustomer;
//import customer.cfeedback;
import db.dbconnct;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//import java.util.Date;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import javax.swing.JOptionPane;
//import mycode.DBconnect;

/**
 *
 * @author Dell
 */
public class customer {
    
    Connection con = dbconnct.connect();
    PreparedStatement pst = null;
    
    public String CustomerName;
    public String CustomerID;
    public String Address;
    public String Email;
    public String NIC;
    public String PhoneNo;
    public String ShopName;
    public String Password;
    public String RegDate;
    
    
    Feedback f = new Feedback();
    

    public String getRegDate() {
        return RegDate;
    }

    public void setRegDate(String RegDate) {
        this.RegDate = RegDate;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getPhoneNo() {
        return PhoneNo;
    }

    public void setPhoneNo(String PhoneNo) {
        this.PhoneNo = PhoneNo;
    }

    public String getShopName() {
        return ShopName;
    }

    public void setShopName(String ShopName) {
        this.ShopName = ShopName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
        
    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String CustomerID) {
        this.CustomerID = CustomerID;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    
    public void AddCustomerDetais(){
    
    }
    public void UpdateDetails(String CID,String cname,String nic,String phone,String add,String email,String shopname){
    CustomerID=CID;
    CustomerName = cname;
    Address = add;
    Email = email;
    NIC = nic;
    PhoneNo = phone;
    ShopName = shopname;
    
    
    
        String k = "UPDATE customer SET CustomerName ='"+CustomerName+"',NIC='"+NIC+"',PhoneNo='"+PhoneNo+"',Address='"+Address+"',Email='"+Email+"',ShopName='"+ShopName+"' where CustomerId='"+CustomerID+"' ";
        try{
        pst = con.prepareStatement(k);
        pst.execute();
        //System.out.println(k);
        JOptionPane.showMessageDialog(null,"Database has been updated");
             }
          catch(Exception e){
           JOptionPane.showMessageDialog(null,e);
        }
    
    }
    public void DeleteDetails(){
        
    }
    public void SendFeedback(String CNAME,String TYPE,String DESCRIPTION,String CID){
        
        
        CustomerName = CNAME;
        f.type = TYPE;
        f.Description = DESCRIPTION;
        CustomerID = CID;
        
        
        String w = "INSERT INTO feedback (CustomerName,Type,Description,CustomerId) values ('"+CustomerName+"','"+f.type+"','"+f.Description+"','"+CustomerID+"')";
        
        try{
        pst = con.prepareStatement(w);
        pst.execute();
        JOptionPane.showMessageDialog(null,"One feedback added to the database");
        
        }
        catch(SQLException exc){
           JOptionPane.showMessageDialog(null,exc); 
          
        }
        
    }
    public void CheckEmails(){
}
    
    
    
}