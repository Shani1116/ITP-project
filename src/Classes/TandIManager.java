 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates

*/
package Classes;


import Classes.Employee;
import db.dbconnct;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.Date;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class TandIManager extends Employee {
    
    String Eid;
    String fname;
    String lname;
    String designation;
    String department;
    String NIC;
    String address;
    int phone_no;

    Connection conn=dbconnct.connect();
    
    
    Charge c=new Charge();
//    Driver1 d=new Driver1();
    Driver1 d = new Driver1();
    Inventoryc i=new Inventoryc();
    Vehicle v=new Vehicle();
    
    public Driver1 getD() {
        return d;
    }

    public void setD(Driver1 d) {
        this.d = d;
    }

    public String getEid() {
        return Eid;
    }

    public void setEid(String Eid) {
        this.Eid = Eid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
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

    public int getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(int phone_no) {
        this.phone_no = phone_no;
    }
    
    public void addInventory(String iname,String iid,int iqty,String ictgry){
        i.id=iid;
        i.name=iname;
        i.quantity=iqty;
        i.category=ictgry;
        
        
        
          String q = "INSERT INTO inventory_details(item_id,name,quantity,category) values('"+i.id+"','"+ i.name +"',"+ i.quantity +",'"+ i.category+ "')";       
          try{
              
               conn.prepareStatement(q).execute();
               JOptionPane.showMessageDialog(null,"One item is added successfully");
              
              }
            catch(SQLException e){
           
                
                System.out.println("Error adding the database"+e);
                
            
            }
    }
    public void updateInventory(String iname,String iid,int iqty,String ictgry){
        i.id=iid;
        i.name=iname;
        i.quantity=iqty;
        i.category=ictgry;
        
        System.out.println(i.id);
        
          String q = "UPDATE inventory_details SET name='"+ i.name +"', quantity="+ i.quantity +",category='"+ i.category+ "' WHERE item_id='"+i.id+"'";       
          
          try{
              
               conn.prepareStatement(q).execute();
               JOptionPane.showMessageDialog(null,"One item is updated successfully");
              
              }
            catch(SQLException e){
           
                
                System.out.println("Error updating the database"+e);
                
            
            }
    
    
    }
    public void deleteInventory(String iid){
        i.id=iid;
        
        
        
         String q = "DELETE from inventory_details WHERE item_id='"+i.id+"'";       
          
          try{
              
               conn.prepareStatement(q).execute();
               JOptionPane.showMessageDialog(null,"The row has been deleted ");
              
              }
            catch(SQLException e){
           
                
                System.out.println("Error deleting item from the database"+e);
                
            
            }
    }
    public void addIcharges(String in,String inm,String cat,int qt,double iamnt,String pd){
        c.inumber=in;
        c.iname=inm;
        c.category=cat;
        c.quantity=qt;
        c.amount=iamnt;
        c.pid=pd;
        
        
            String q = "INSERT INTO inven_exp(item_id,name,type,qty,amount,pid) values('"+c.inumber+"','"+c.iname+"','"+ c.category+ "',"+c.quantity+","+ c.amount +",'"+ c.pid +"')";       
          try{
              
               conn.prepareStatement(q).executeUpdate();
               JOptionPane.showMessageDialog(null,"One item is added successfully");
              
              }
            catch(SQLException e){
           
                System.out.println("Error adding the database"+e);
            
            }
    }
    public void updateICharges(String pd,double amnt,String id,String name,String ty,int qty)
    {   
        c.pid=pd;
        c.amount=amnt;
        c.inumber=id;
        c.iname=name;
        c.category=ty;
        c.quantity=qty;
        
        String q = "UPDATE inven_exp SET pid='"+c.pid+"',amount="+ c.amount +",item_id='"+ c.inumber +"',name='"+ c.iname+ "',type='"+ c.category +"',qty='"+c.quantity +"'  WHERE pid='"+c.pid+"'";
        
            try{
              
               conn.prepareStatement(q).execute();
               JOptionPane.showMessageDialog(null,"One item is updated successfully");
              
              }
            catch(SQLException e){
           
                
                System.out.println("Error updating the database"+e);
              }
        
        
    }
    public void addCharges(String v,double camnt,String cdate,String t,String p){
        c.pid=p;
        c.amount=camnt;
        c.date=cdate;
        c.vehicleNo=v;
        c.type=t;
        
        
         
          
              String q = "INSERT INTO trans_exp(vehi_num,amount,date,exp_type,pid) values('"+c.vehicleNo+"',"+ c.amount +",'"+ c.date+"','"+ c.type+ "','"+ c.pid +"')";       
          try{
              
               conn.prepareStatement(q).executeUpdate();
               JOptionPane.showMessageDialog(null,"One item is added successfully");
              
              }
            catch(SQLException e){
           
                System.out.println("Error adding the database"+e);
            
            }
       

    }
    public void updatecharges(String pid,double camnt,String cdate,String cvnmbr,String ty){
        c.pid=pid;
        c.amount=camnt;
        c.date=cdate;
        c.vehicleNo=cvnmbr;
        c.type=ty;
        
            String q = "UPDATE trans_exp SET pid='"+c.pid+"',amount="+ c.amount +",date='"+ c.date +"',vehi_num='"+ c.vehicleNo+ "',exp_type='"+ c.type +"' WHERE pid='"+c.pid+"'";
        
            try{
              
               conn.prepareStatement(q).execute();
               JOptionPane.showMessageDialog(null,"One item is updated successfully");
              
              }
            catch(SQLException e){
           
                
                System.out.println("Error updating the database"+e);
              }
    
        
        
    }
    public void addvehicles(String avlblty,String ty,String vn,String pur){
        v.vid=vn;
        v.type=ty;
        v.purpose=pur;
        v.availability=avlblty;
        
        
        
              String q = "INSERT INTO vehicle(availability,type,vehiclenum,purpose) values('"+v.availability+"','"+ v.type +"','"+ v.vid +"','"+ v.purpose+ "')";       
          try{
              
               conn.prepareStatement(q).execute();
               JOptionPane.showMessageDialog(null,"One item is added successfully");
              
              }
            catch(SQLException e){
           
                System.out.println("Error adding the database"+e);
                
            
            }
        
        
    }
    
    public void updatevehicles(String avlblty,String ty,String vn,String pur){
        v.vid=vn;
        v.type=ty;
        v.purpose=pur;
        v.availability=avlblty;
        
         String q = "UPDATE vehicle SET availability='"+v.availability+"',type='"+ v.type +"',vehiclenum='"+ v.vid +"',purpose='"+ v.purpose+ "' WHERE vehiclenum='"+ v.vid +"'";
        
         try{
              
               conn.prepareStatement(q).execute();
               JOptionPane.showMessageDialog(null,"One item is updated successfully");
              
              }
            catch(SQLException e){
           
                
                System.out.println("Error updating the database"+e);
              }
    
    }
     public void requestIcharges(String rqst,double amnt){
        c.category=rqst;
        c.amount=amnt;
        
        
          String q = "INSERT INTO request(request,amount) values('"+ c.category+ "',"+ c.amount +")";       
          try{
              
               conn.prepareStatement(q).execute();
               JOptionPane.showMessageDialog(null,"One item is added successfully");
              
              }
            catch(SQLException e){
           
                System.out.println("Error adding the database"+e);
            
            }
        
        
    }

 public void requestVcharges(String rqst,double amnt){
        c.type=rqst;
        c.amount=amnt;
        
        
          String q = "INSERT INTO request(request,amount) values('"+ c.type+ "',"+ c.amount +")";       
          try{
              
               conn.prepareStatement(q).execute();
               JOptionPane.showMessageDialog(null,"One item is added successfully");
              
              }
            catch(SQLException e){
           
                System.out.println("Error adding the database"+e);
            
            }
        
        
    }
 
 
 public void requesthandling(String rd){
        // i.status=stats;
         
         i.setRid(rd);
         
          
        
          String q = "UPDATE req_inv SET Status='Accepted' WHERE Ref_id='"+i.getRid()+"' AND Status='Requesting'";       
          
          try{
              
               conn.prepareStatement(q).execute();
               JOptionPane.showMessageDialog(null,"It is updated successfully");
              
              }
            catch(SQLException e){
           
                
                System.out.println("Error updating the database"+e);
                
            
            }
     }
    
    
}