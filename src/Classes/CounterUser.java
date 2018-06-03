package Classes;

//import .*;

import Classes.Movies;
import Classes.Ticket;
import db.dbconnct;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



public class CounterUser {
    
     Connection con = dbconnct.connect();;
    PreparedStatement pst=null;
    ResultSet rs = null;
    
    public String Name;
    public String CID;
    public String NIC;
    String emp="e123";
    
    
    DateFormat tf=new SimpleDateFormat("HH:mm:ss");
    DateFormat dft=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    
    Date dt=new Date();
    
     Movies m=new Movies();
      Package P1=new Package();
    Games g=new Games();
    Ticket t=new Ticket();

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getCID() {
        return CID;
    }

    public void setCID(String CID) {
        this.CID = CID;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }
    public void issuemovieticket(Integer n,float tot,String email){
        
       // t.ticketId=tId;
        
        //t.time=(tf.format(dt));
        //t.date=tf.format(dt);
        t.number=n;
        t.total=tot;
        String type="m";
        t.time=(dft.format(dt));
        t.email=email;
     
        System.out.println("3");
        String q ="INSERT INTO ticket1(number,Total,Type,empid,date,time,Email)  VALUES ('"+ t.number +"' ,'"+t.total+"','"+type+"','"+emp +"','"+dft.format(dt)+"','"+dft.format(dt)+"','"+t.email+"')"; 
     //   String p ="INSERT INTO ticket1(number,Total,Type,empid,date,time,Email)  VALUES ('"+ t.number +"' ,'"+t.total+"','"+type+"','"+emp +"','"+dft.format(dt)+"','"+dft.format(dt)+"','"+ t.email +"')";
        try{
        
        pst =con.prepareStatement(q);
        
        pst.execute();
        JOptionPane.showMessageDialog(null,"One ticket is issued");
        }catch(SQLException e){
         JOptionPane.showMessageDialog(null,e);
    }
        
    
    }
    
    public void issuegameticket(Integer n,float tot){
        
       // t.ticketId=tId;
        t.number=n;
       // t.time=(tf.format(dt));
        //t.date=d;
       // t.type=typ;
        t.total=tot;
        String type="g";
         t.time=(dft.format(dt));
        
        
         String q ="INSERT INTO ticket1(number,Total,Type,empid,date,time)  VALUES ('"+ t.number +"' ,'"+t.total+"','"+type+"','"+emp +"','"+dft.format(dt)+"','"+dft.format(dt)+"')";
        try{
        
        pst =con.prepareStatement(q);
        
        pst.execute();
        JOptionPane.showMessageDialog(null,"One ticket is issued");
        }catch(SQLException e){
         JOptionPane.showMessageDialog(null,e);
    }
        
    }
    
    public Double calMovieTotal(String mName,int amnt)
    {
        String q = "SELECT * FROM movie WHERE name = '"+mName+"'";  
        
         try {
                pst = con.prepareStatement(q);
                rs = pst.executeQuery();
                rs.next();
                
                double fee = Double.parseDouble(rs.getObject("Fee").toString());
                Double tot = fee*amnt;
                
                return tot;
                
         } catch (SQLException ex) {
             //JOptionPane.showMessageDialog(null, "Problem with calMovieTotal method "+ex);
        
             
             return -1.1;
         }
        
    }
    
    
    public Double calGameTotal(String gName,int amnt)
    {
        String q = "SELECT * FROM game WHERE name = '"+gName+"'";  
        
         try {
                pst = con.prepareStatement(q);
                rs = pst.executeQuery();
                rs.next();
                
                double fee = Double.parseDouble(rs.getObject("Fee").toString());
                Double tot = fee*amnt;
                
                return tot;
                
         } catch (SQLException ex) {
             //JOptionPane.showMessageDialog(null, "Problem with calMovieTotal method "+ex);
        
             
             return -1.1;
         }
        
    }
    
   public Double calPackageTotal(String pName,int amnt)
    {
        String q = "SELECT * FROM package WHERE p_name = '"+pName+"'";  
        
         try {
                pst = con.prepareStatement(q);
                rs = pst.executeQuery();
                rs.next();
                
                double fee = Double.parseDouble(rs.getObject("Fee").toString());
                Double tot = fee*amnt;
                
                return tot;
                
         } catch (SQLException ex) {
             //JOptionPane.showMessageDialog(null, "Problem with calMovieTotal method "+ex);
        
             
             return -1.1;
         }
        
    }
   
   public Double calSubtot(String gamnt,String pamnt)
    {
        Double g = Double.parseDouble(gamnt);
        Double p = Double.parseDouble(pamnt);
    
        return g+p;
    }
}








