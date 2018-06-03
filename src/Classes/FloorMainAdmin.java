//

package Classes;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;



public class FloorMainAdmin {
    
    
    Connection con=DBConnection.connect();
    PreparedStatement pst=null;
  
    
  String emp;
  String cus;
  String department;
  
    //calling the repairs class
    Repairs rep=new Repairs();
    //calling the items class
    Items itm=new Items();
    //calling the slots class
    Slots sl=new Slots();
    //calling the stores class
    Stores sto=new Stores();
    //calling the requets class
    Request_Finance req=new Request_Finance();
    //calling the employee tabble
   // Employee em=new Employee();
    //calling the requests(inventory) class
    Request_stores rs=new  Request_stores();
    
    private Object table1;
    private Object table4;
    private Object table3;
    private Object table2;
    private Object table5;
    
    
    
   
    
    //method to add item details to noncurrent_item table
    public void addItem(String s,int q,double p,String i){
    
    
    itm.serial_no=s;
    itm.quantity=q;
    itm.price=p;
    itm.item_name=i;
    
    emp="EID_001";
    
    
    String sql2="INSERT into noncurrent_item (serial_no,quantity,price,itemName,emp_id)VALUES('"+itm.serial_no+"',"+itm.quantity+","+itm.price+",'"+itm.item_name+"','"+emp+"')";
    try
    {
     pst=con.prepareStatement(sql2);
    pst.execute();
    
    
    JOptionPane.showMessageDialog(null,"One item added to the database");
   
    }
    catch(SQLException e)
    {
    
    System.out.println("Error adding data to the database"+e);
    
    }
    
 
    
    }
    
    
    
  //method to add repair expenses details to maint_exp table.
    public void addExpense(String p,int a,String t,String d){
        
    rep.pid=p;
    rep.amount=a;
    rep.type=t;
    rep.date=d;
    
    
   
   emp="E004";
   
    String sql2="INSERT into maint_exp(pid,amount,type,date,emp_id)  VALUES('"+rep.pid+"',"+rep.amount+",'"+rep.type+"','"+rep.date+"','"+emp+"')";
   try
    {
    
   pst=con.prepareStatement(sql2);
    pst.execute();
    JOptionPane.showMessageDialog(null,"One item added to the database");
   
    }
   catch(SQLException e)
    {
    
    System.out.println("Error adding data to the database"+e);
    
    }
    
 
   }
    

public void addSlot(String n,int a,int f){

sl.slot_no=n;
sl.area=a;
//sl.location=l;
sl.floor_no=f;


cus="CID_001";


String sql2="INSERT into slot (slot_no,area,floorno,cust_id)VALUES('"+sl.slot_no+"',"+sl.area+","+sl.floor_no+",'"+cus+"')";
    try
    {
     pst=con.prepareStatement(sql2);
     pst.execute();
     JOptionPane.showMessageDialog(null,"One item added to the database");
   
    }
    catch(SQLException e)
    {
    
    System.out.println("Error adding data to the database"+e);
    
    }
    


}




public void deleteItem(String s){
    
    
    itm.serial_no=s;
   // itm.quantity=q;
    //itm.price=p;
    //itm.item_name=i;
    
   // emp="E005";
    
    
    String sql2="DELETE from noncurrent_item WHERE serial_no='"+itm.serial_no+"'";
    
    try
    {
     pst=con.prepareStatement(sql2);
    pst.execute();
    JOptionPane.showMessageDialog(null,"One item deleted from the database");
   
    }
    catch(SQLException e)
    {
    
    System.out.println("Error adding data to the database"+e);
    
    }
    
 
    
    }



public void UpdateSlot(String s,int a,int f)
{

sl.slot_no=s;
sl.area=a;
//sl.location=l;
sl.floor_no=f;



try
    {
        String sql2="UPDATE slot SET area="+sl.area+",floorno="+sl.floor_no+" WHERE slot_no='"+sl.slot_no+"' ";
     pst=con.prepareStatement(sql2);
     
     pst.executeUpdate();
     JOptionPane.showMessageDialog(null,"One item added to the database");
   
    }
    catch(SQLException e)
    {
    
    System.out.println("Error adding data to the database"+e);
    
    }
  

}

public void UpdateItem(String s,int q,double p,String i)
{

    itm.serial_no=s;
    itm.quantity=q;
    itm.price=p;
    itm.item_name=i;

String sql2="UPDATE noncurrent_item SET quantity="+itm.quantity+",price="+itm.price+",itemName='"+itm.item_name+"' WHERE serial_no='"+itm.serial_no+"' ";
try
    {
        
     pst=con.prepareStatement(sql2);
     
     pst.executeUpdate();
     JOptionPane.showMessageDialog(null,"One item updated");
   
    }
    catch(SQLException e)
    {
    
    System.out.println("Error adding data to the database"+e);
    
    }

  

}









public void addRequest(String ri,String r ,double a,String date){
    
    
   req.id=ri;
   req.request=r;
   req.amount=a;
   req.date=date;
   
    
    
    
    
    String sql2="INSERT into req_maint (pid,amount,type,date)VALUES('"+req.id+"',"+req.amount+",'"+req.request+"','"+req.date+"')";
    try
    {
     pst=con.prepareStatement(sql2);
    pst.execute();
    JOptionPane.showMessageDialog(null,"Request successfully send");
   
    }
    catch(SQLException e)
    {
    
    System.out.println("Error adding data to the database"+e);
    
    }
    
 
    
    }
    


public void UpdateRepairs(String p,int a,String t,String d)
{

    rep.pid=p;
    rep.amount=a;
    rep.type=t;
    rep.date=d;
    
    
   
   emp="E004";

String sql2="UPDATE maint_exp SET amount="+rep.amount+",type="+rep.type+",date='"+rep.date+"' WHERE pid='"+rep.pid+"' ";
try
    {
        
     pst=con.prepareStatement(sql2);
     
     pst.executeUpdate();
     JOptionPane.showMessageDialog(null,"One item updated");
   
    }
    catch(SQLException e)
    {
    
    System.out.println("Error adding data to the database"+e);
    
    }

  

}


public void reqInventory(String i,String r ,double q,String d,String s){
    
    
   rs.item_no=i;
   rs.request=r;
   rs.quantity=q;
   rs.department=d;
   rs.status=s;
    
    
    
    String sql2="INSERT into request1 (id,request,amount,department,status)VALUES('"+rs.item_no+"','"+rs.request+"',"+rs.quantity+",'"+rs.department+"','"+rs.status+"')";
    try
    {
     pst=con.prepareStatement(sql2);
    pst.execute();
    JOptionPane.showMessageDialog(null,"Request Successfully Send");
   
    }
    catch(SQLException e)
    {
    
    System.out.println("Error adding data to the database"+e);
    
    }
    
 
    
    }
    





//public void addEmp(String er,String n,String t){
    
    
    
   
    
    
    //String sql2="INSERT into maint_empl(emp_id,emp_name,emp.type) VALUES('"+er.+"',"+itm.quantity+","+itm.price+",'"+itm.item_name+"','"+emp+"')";
    //try
    //{
    // pst=con.prepareStatement(sql2);
   // pst.execute();
    
    
    //JOptionPane.showMessageDialog(null,"One item added to the database");
   
    }
   // catch(SQLException e)
    //{
    
   // System.out.println("Error adding data to the database"+e);
    
    //}
    
 
    
    //}





      
//}   
    
 
    
    
    
    
    
    
    
    
   
    
    

