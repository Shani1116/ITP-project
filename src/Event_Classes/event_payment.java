/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Event_Classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Navodya
 */
public class event_payment {
    
    Connection con= dbconnct.connect();;
    PreparedStatement pst=null;
    
    Event ev = new Event();
    
    private double Amount;
    
    
    
    
    
    public double getAmount() {
        return Amount;
    }

    public void setAmount(double Amount) {
        this.Amount = Amount;
    }

  
    
    public void addEpay(String eid,String sd,String ed,String lid) throws ParseException{
    
        ev.setEventId(eid);
        ev.setStartDate(sd);
        ev.setEndDate(ed);
        ev.setLocation_ID(lid);
        
        String d1=ev.getStartDate();
        Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(d1);
        
        String d2=ev.getEndDate();
        Date date2=new SimpleDateFormat("yyyy-MM-dd").parse(d2);
    
        int x ;
        x = (int) (date2.getTime()-date1.getTime());
        
                 if(ev.getLocation_ID().equalsIgnoreCase("CL200")){
                     
                   Amount=((x+1)*75000.00)/(1000*60*60*24);
                   if(Amount>0){
                  
                   this.ADDep();
                   }
                   else{
                    JOptionPane.showMessageDialog(null,"Incorrect date");
                   }
               }
               
               else if(ev.getLocation_ID().equalsIgnoreCase("BH100"))
               {
                    Amount=((x+1)*200000.00)/(1000*60*60*24);
                   if(Amount>0){
                  
                   this.ADDep();
                   }
                   else{
                    JOptionPane.showMessageDialog(null,"Incorrect date");
                   }
               }
                   
               else if(ev.getLocation_ID().equalsIgnoreCase("EH300"))
               {
                   Amount=((x+1)*150000.00)/(1000*60*60*24);
                    if(Amount>0){
                  
                   this.ADDep();
                   }
                   else{
                    JOptionPane.showMessageDialog(null,"Incorrect date");
                   }
               }
                   
               else if(ev.getLocation_ID().equalsIgnoreCase("FH400"))
               {
                   Amount=((x+1)*100000.00)/(1000*60*60*24);
                    if(Amount>0){
                  
                   this.ADDep();
                   }
                   else{
                    JOptionPane.showMessageDialog(null,"Incorrect date");
                   }
               }
                   
               else if(ev.getLocation_ID().equalsIgnoreCase("OA500"))
               {
                   Amount=((x+1)*75000.00)/(1000*60*60*24);
                     if(Amount>0){
                  
                   this.ADDep();
                   }
                   else{
                    JOptionPane.showMessageDialog(null,"Incorrect date");
                   }
               }
                   
               else if(ev.getLocation_ID().equalsIgnoreCase("OD600"))
               {
                   Amount=((x+1)*25000.00)/(1000*60*60*24);
                    if(Amount>0){
                  
                   this.ADDep();
                   }
                   else{
                    JOptionPane.showMessageDialog(null,"Incorrect date");
                   }
               }
               else{
                System.out.println("Error");
               }
    
    
    
    }
    
     public void ADDep(){
    
       String l1= "INSERT INTO event_income(date,amount,eventID) Values ('"+LocalDate.now()+"',"+Amount+",'"+ ev.getEventId() +"')"; 
       
          
         try {
              
            pst = con.prepareStatement(l1);
            pst.execute();
            
           // JOptionPane.showMessageDialog(null,"One income has added to the database!");
            }
            catch(SQLException e){
                 System.out.println("Error when adding to database! Please check connectivity."+e);
            
                
            }
    
    
     } 
     public void updatePay(){
     
      String sq2= "Update event_income SET amount="+Amount+" WHERE eventID='"+ev.getEventId()+"',startDate='"+ev.getStartDate()+"',endDate='"+ev.getEndDate()+"'";
            
            try {
            pst = con.prepareStatement(sq2);
            pst.execute();
            JOptionPane.showMessageDialog(null,"database has been updated");
            
            }
            catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null,"Error"+ex);
            
            }
     
     
     
     }
     
     public void uppay(String eid,String sd,String ed,String lid) throws ParseException{
    
        ev.setEventId(eid);
        ev.setStartDate(sd);
        ev.setEndDate(ed);
        ev.setLocation_ID(lid);
        
        String d1=ev.getStartDate();
        Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(d1);
        
        String d2=ev.getEndDate();
        Date date2=new SimpleDateFormat("yyyy-MM-dd").parse(d2);
    
        int x ;
        x = (int) (date2.getTime()-date1.getTime());
        
                 if(ev.getLocation_ID().equalsIgnoreCase("CL200")){
                     
                   Amount=((x+2)*75000.00)/(1000*60*60*24);
                   if(Amount>0){
                  
                   this.updatePay();
                   }
                   else{
                    JOptionPane.showMessageDialog(null,"Incorrect date");
                   }
               }
               
               else if(ev.getLocation_ID().equalsIgnoreCase("BH100"))
               {
                    Amount=((x+2)*200000.00)/(1000*60*60*24);
                   if(Amount>0){
                  
                   this.updatePay();
                   }
                   else{
                    JOptionPane.showMessageDialog(null,"Incorrect date");
                   }
               }
                   
               else if(ev.getLocation_ID().equalsIgnoreCase("EH300"))
               {
                   Amount=((x+2)*150000.00)/(1000*60*60*24);
                    if(Amount>0){
                  
                   this.updatePay();
                    }
                   else{
                    JOptionPane.showMessageDialog(null,"Incorrect date");
                   }
               }
                   
               else if(ev.getLocation_ID().equalsIgnoreCase("FH400"))
               {
                   Amount=((x+2)*100000.00)/(1000*60*60*24);
                    if(Amount>0){
                  
                  this.updatePay();
                   }
                   else{
                    JOptionPane.showMessageDialog(null,"Incorrect date");
                   }
               }
                   
               else if(ev.getLocation_ID().equalsIgnoreCase("OA500"))
               {
                   Amount=((x+2)*75000.00)/(1000*60*60*24);
                     if(Amount>0){
                  
                   this.updatePay();
                   }
                   else{
                    JOptionPane.showMessageDialog(null,"Incorrect date");
                   }
               }
                   
               else if(ev.getLocation_ID().equalsIgnoreCase("OD600"))
               {
                   Amount=((x+2)*25000.00)/(1000*60*60*24);
                    if(Amount>0){
                  
                   this.updatePay();
                   }
                   else{
                    JOptionPane.showMessageDialog(null,"Incorrect date");
                   }
               }
               else{
                System.out.println("Error");
               }
    
    
    
    }

    
    
}
