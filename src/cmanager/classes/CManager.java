/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmanager.classes;
    
//import cmanager.addcustomer;
import db.dbconnct;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import javax.swing.JOptionPane;
//import mycode.DBconnect;
//import net.proteanit.sql.DbUtils;

 
 
public class CManager  {
    
    Connection con = dbconnct.connect();
    PreparedStatement pst =null ;
    
    
    String CMID; 
    String CMName; 
    String CustomerDetails;
    public String CustomerName;
    public String CustomerID;
    public String Address;
    public String Email;
    public String NIC;
    public String PhoneNo;
    public String ShopName;
    public String Password;
    public String RegDate;
    String emp;
    
    
    customer c =new customer();
    RentIncome ri = new RentIncome();
    Feedback f = new Feedback();
    ResultSet rs = null;
    
    
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

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
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

    public String getRegDate() {
        return RegDate;
    }

    public void setRegDate(String RegDate) {
        this.RegDate = RegDate;
    }
        
      // employee e =new employee;
    public String getCMID() {
        return CMID;
    }

    public void setCMID(String CMID) {
        this.CMID = CMID;
    }

    public String getCMName() {
        return CMName;
    }

    public void setCMName(String CMName) {
        this.CMName = CMName;
    }

    public String getCustomerDetails() {
        return CustomerDetails;
    }

    public void setCustomerDetails(String CustomerDetails) {
        this.CustomerDetails = CustomerDetails;
    }
    


    public void AddCustomer(String CID,String cname,String nic,String phone,String add,String email,String shopname,String pass,String rdate){
    
        
    c.CustomerID=CID;
    c.CustomerName = cname;
    c.NIC = nic;
    c.PhoneNo = phone;
    c.Email = email;
    c.ShopName = shopname;
    c.Address = add;
    c.Password = pass;
    c.RegDate = rdate;
     emp="e009";
    
     System.out.println(c.CustomerID);
     
     
         String q = "INSERT INTO customer (CustomerId, CustomerName, NIC, PhoneNo, Address, Email, ShopName, emp_id, Password, RegisterDate) values ('"+ c.CustomerID +"','"+ c.CustomerName +"','"+ c.NIC +"','"+ c.PhoneNo +"','"+ c.Address +"','"+ c.Email +"','"+ c.ShopName +"','"+ emp +"','"+ c.Password +"','"+ c.RegDate +"') ";
     
     try{
        pst = con.prepareStatement(q);
        pst.execute();
        JOptionPane.showMessageDialog(null,"One customer added to the database");
        
        }
        catch(SQLException eq){
          
            JOptionPane.showMessageDialog(null,eq);
        }
        
      
     
     
     
    }
    
    public void DeleteCustomerDetails(String CID,String cname,String nic,String phone,String add,String email,String shopname,String rdate){
        
    c.CustomerID=CID;
    c.CustomerName = cname;
    c.Address = add;
    c.Email = email;
    c.NIC = nic;
    c.PhoneNo = phone;
    c.ShopName = shopname;
    c.RegDate = rdate;
    
    String s = "DELETE from customer where CustomerId ='"+c.CustomerID+"' ";
    try{
        
        //System.out.println(q);
        pst = con.prepareStatement(s);
        pst.execute();
        
        JOptionPane.showMessageDialog(null,"Database has been updated");
        
             }
          catch(Exception e){
           JOptionPane.showMessageDialog(null,"Error"+e);
        }
    
    }
    public void UpdateCustomer(String CID,String cname,String nic,String phone,String add,String email,String shopname,String rdate){
    c.CustomerID=CID;
    c.CustomerName = cname;
    c.Address = add;
    c.Email = email;
    c.NIC = nic;
    c.PhoneNo = phone;
    c.ShopName = shopname;
    
    c.RegDate = rdate;
    
    
        String sql1 = "UPDATE customer SET CustomerName ='"+c.CustomerName+"', NIC='"+c.NIC+"', PhoneNo='"+c.PhoneNo+"', Address='"+c.Address+"', Email='"+c.Email+"', ShopName='"+c.ShopName+"', RegisterDate='"+c.RegDate+"' where CustomerId = '"+c.CustomerID+"'";
        
        try{
        pst = con.prepareStatement(sql1);
        pst.execute();
        
        //tableload();
        
        JOptionPane.showMessageDialog(null,"Database has been updated");
             }
          catch(Exception ex){
           JOptionPane.showMessageDialog(null,"Error"+ex);
        }
    
    }
    
   
    public void checkFeedbacks(){
       
    }
    public void SendEmails(){
        
    }
    
    public void AddRentDetails(String YEAR,String MONTH,String CID,String CNAME,String PLEVEL,String PDATE,Double AMOUNT){
         
        
         ri.Year = YEAR;
         ri.Month = MONTH;
         c.CustomerID=CID;
         c.CustomerName = CNAME;
          ri.PaymentLevel = PLEVEL;
         ri.PayDate = PDATE;
         ri.Amount = AMOUNT;
         
         
        // System.out.println(ri.Amount);
         
        String q = "INSERT INTO shop_rent(Year,Month,CustomerId,CustomerName,PaymentLevel,PaidDate,Amount) values ('"+ri.Year+"','"+ri.Month+"','"+ c.CustomerID +"','"+c.CustomerName+"','"+ri.PaymentLevel+"','"+ri.PayDate+"','"+ri.Amount+"') ";
        System.out.println(ri.Year);
        
        try{
        pst = con.prepareStatement(q);
        pst.execute();
        JOptionPane.showMessageDialog(null,"Rent details added to the database");
        
        }
        
        catch(Exception e){
           JOptionPane.showMessageDialog(null,e);
           
        }
    }
    public void UpdateRentDetails(String YEAR,String MONTH,String CID,String CNAME,String PLEVEL,String PDATE,Double AMOUNT){
        
        c.CustomerID=CID;
         ri.Year = YEAR;
         ri.Month = MONTH;
          ri.PaymentLevel = PLEVEL;
         ri.PayDate = PDATE;
         ri.Amount = AMOUNT;
         c.CustomerName = CNAME;
         
         String sql = "UPDATE shop_rent SET Year='"+ri.Year+"', Month='"+ri.Month+"',CustomerName='"+c.CustomerName+"', PaymentLevel = '"+ri.PaymentLevel+"', PaidDate = '"+ri.PayDate+"', Amount = "+ri.Amount+" where CustomerId = '"+c.CustomerID+"'";
        try{
        pst = con.prepareStatement(sql);
        pst.execute();
        
        //tableload();
        
        JOptionPane.showMessageDialog(null,"Database has been updated");
             }
          catch(Exception ex){
           JOptionPane.showMessageDialog(null,"Error"+ex);
        }
    }
         public void DeleteRentDetails(String YEAR,String MONTH,String CID,String CNAME,String PLEVEL,String PDATE,Double AMOUNT){
        
        c.CustomerID=CID;
         ri.Year = YEAR;
         ri.Month = MONTH;
          ri.PaymentLevel = PLEVEL;
         ri.PayDate = PDATE;
         ri.Amount = AMOUNT;
         c.CustomerName = CNAME;
         
         String m = "DELETE From shop_rent where CustomerId ='"+ c.CustomerID +"'";
        try{
        pst = con.prepareStatement(m);
        pst.execute();
        
        JOptionPane.showMessageDialog(null,"Database has been updated");
        
             }
          catch(Exception ex){
           JOptionPane.showMessageDialog(null,ex);
        }
         
         
}
    public void DeleteFeedbacks(String fid,String CNAME,String type,String description,String CID) {
        
        f.FID = fid;
        c.CustomerName = CNAME;
        f.type = type;
        f.Description = description;
        c.CustomerID = CID;
        
        String fed =  "DELETE From feedback where FeedbackId ='"+ f.FID +"'";
        
         try{
        pst = con.prepareStatement(fed);
        pst.execute();
        
        JOptionPane.showMessageDialog(null,"Database has been updated");
        
             }
          catch(Exception ex){
           JOptionPane.showMessageDialog(null,ex);
        }
        
    }    
         
         

    
}
