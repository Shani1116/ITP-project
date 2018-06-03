/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Event_Classes;
import db.dbconnct;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import javax.swing.JOptionPane;

/**
 *
 * @author Navodya
 */
public class EAManager {
    
    Connection con = dbconnct.connect();;
    PreparedStatement pst=null;
    
    
    
    
      //calling the ad payment car
        Ad_payment adPay = new Ad_payment();
        
     //calling the advertsiment class
        Advertisment a= new Advertisment();
        
     //calling the event class
        Event ev = new Event();
        
     //calling event payment
        event_payment epay =new event_payment();
        
     //calling organizer
        organizer o = new organizer();
        
        
      
//-----------------------------------------------------------Add Event------------------------------------------------------------------------------------
     
        public boolean adEvent(String eid,String ti,String ety,String li,String sd,String ed,String evLoc,String oid) throws ParseException{
        
        ev.setEventId(eid);
        ev.setTitle(ti);
        ev.setEvent_Type(ety);
        ev.setLocation_ID(li);
        ev.setStartDate(sd);
        ev.setEndDate(ed);
        ev.setEvent_Location(evLoc);
        o.setOrganizerID(oid);
        
        
        
        
         if(ev.getEvent_Location().equals("Banquet Hall")&& ev.getLocation_ID().equals("BH100")){
              
             
             this.addTable();
            epay.uppay(eid, sd, ed, li);
             return true;
         
         }
        
         else if(ev.getEvent_Location().equals("Cocktail Lounge")&& ev.getLocation_ID().equals("CL200")){
             
           
             this.addTable();
            epay.uppay(eid, sd, ed, li);
             return true;
         
         }
         
         else if(ev.getEvent_Location().equals("Exhibition Hall")&& ev.getLocation_ID().equals("EH300")){
             
              
              this.addTable();
              epay.uppay(eid, sd, ed, li);
              return true;
         
         }
         
         else if(ev.getEvent_Location().equals("Function Hall")&& ev.getLocation_ID().equals("FH400")){
         
             
             
             this.addTable();
            epay.uppay(eid, sd, ed, li);
             return true;
         
         
         }
         
         else if(ev.getEvent_Location().equals("Open Area")&& ev.getLocation_ID().equals("OA500")){
         
             
             
             this.addTable();
             epay.uppay(eid, sd, ed, li);
             return true;
         
         
         }
         
         else if(ev.getEvent_Location().equals("OutDoor")&& ev.getLocation_ID().equals("OD600")){
        
             
            this.addTable();
           epay.uppay(eid, sd, ed, li);
            return true;
           
         
         }
         
         else{
              JOptionPane.showMessageDialog(null,"Invalid Input");
              return false;
             
             }
         
        }
        
        
       public void addTable(){
        
        
        String sq = "INSERT INTO event (event_id,eventType,title,startDate,endDate,locID,orgID) VALUES ('"+ev.getEventId()+"','"+ev.getEvent_Type()+"','"+ev.getTitle()+"','"+ev.getStartDate()+"','"+ev.getEndDate()+"','"+ev.getLocation_ID()+"','"+o.getOrganizerID()+"')" ;
               
            try {
              
            pst = con.prepareStatement(sq);
            pst.execute();
            
            JOptionPane.showMessageDialog(null,"One event has added to the database!");
            }
            catch(SQLException e){
             //    System.out.println("Error adding to database."+e);
             JOptionPane.showMessageDialog(null,e);
            
                
            }
        
        
        }
       
         public void addAcc(int b,int t,int ol, int p,int s,String eid){
         
             ev.setBanquet_Chairs(b);
             ev.setTables(t);
             ev.setOilLamp(ol);
             ev.setProjectors(p);
             ev.setScreens(s);
             ev.setEventId(eid);
             
             
             String sq1= "INSERT INTO accerssories(Banquet_chairs,Tables,Oil_Lamps,Projectors,Screens,eventID)Values ("+ev.getBanquet_Chairs()+","+ev.getTables()+","+ev.getOilLamp()+","+ev.getProjectors()+","+ev.getScreens()+",'"+ev.getEventId()+"')"; 
         
         try {
              
            pst = con.prepareStatement(sq1);
            pst.execute();
            
            
            }
            catch(SQLException e){
                 System.out.println("accersory  error."+e);
            
                
            }
             
         
         
         }
         
          public void up(){
            
            String sq2= "Update event SET eventType='"+ev.getEvent_Type()+"',title = '"+ev.getTitle()+"',startDate='"+ev.getStartDate()+"',endDate='"+ev.getEndDate()+"' WHERE event_id='"+ev.getEventId()+"' ";
            
            try {
            pst = con.prepareStatement(sq2);
            pst.execute();
            JOptionPane.showMessageDialog(null,"database has been updated");
            
            }
            catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null,"Error"+ex);
            
            }
         
        }
         
          public boolean update_event(String eid,String ti,String ety,String li,String sd,String ed,String evLoc,String oid) throws ParseException{
        
        ev.setEventId(eid);
        ev.setTitle(ti);
        ev.setEvent_Type(ety);
        ev.setLocation_ID(li);
        ev.setStartDate(sd);
        ev.setEndDate(ed);
        ev.setEvent_Location(evLoc);
        o.setOrganizerID(oid);
        
        
        
        
         if(ev.getEvent_Location().equals("Banquet Hall")&& ev.getLocation_ID().equals("BH100")){
              
             
             this.up();
             epay.addEpay(eid, sd, ed, li);
             return true;
         
         }
        
         else if(ev.getEvent_Location().equals("Cocktail Lounge")&& ev.getLocation_ID().equals("CL200")){
             
           
             this.up();
             epay.addEpay(eid, sd, ed, li);
             return true;
         
         
         }
         
         else if(ev.getEvent_Location().equals("Exhibition Hall")&& ev.getLocation_ID().equals("EH300")){
             
              
              this.up();
              epay.addEpay(eid, sd, ed, li);
              return true;
             
         
         }
         
         else if(ev.getEvent_Location().equals("Function Hall")&& ev.getLocation_ID().equals("FH400")){
         
             
             
             this.up();
             epay.addEpay(eid, sd, ed, li);
             return true;
         
         }
         
         else if(ev.getEvent_Location().equals("Open Area")&& ev.getLocation_ID().equals("OA500")){
         
             
             this.up();
             epay.addEpay(eid, sd, ed, li);
             return true;
         
         
         }
         
         else if(ev.getEvent_Location().equals("OutDoor")&& ev.getLocation_ID().equals("OD600")){
         

            this.up();
            epay.addEpay(eid, sd, ed, li);
            return true;
           
         
         }
         
         else{
              JOptionPane.showMessageDialog(null,"Invalid Input");
              return false;
             
             }
         
        
        
        }
        public boolean request(int b,int t,int ol, int p,int s,String eid,String sd){
            
             ev.setBanquet_Chairs(b);
             ev.setTables(t);
             ev.setOilLamp(ol);
             ev.setProjectors(p);
             ev.setScreens(s);
             ev.setEventId(eid);
             ev.setStartDate(sd);
             
         String sq1= "INSERT INTO req_inv(category,Banquet_chairs,Tables,Oil_Lamps,Projectors,Screens,Ref_id,Required_Date)Values ('Event',"+ev.getBanquet_Chairs()+","+ev.getTables()+","+ev.getOilLamp()+","+ev.getProjectors()+","+ev.getScreens()+",'"+ev.getEventId()+"','"+ev.getStartDate()+"')"; 
         
         try {
              
            pst = con.prepareStatement(sq1);
            pst.execute();
            
            JOptionPane.showMessageDialog(null,"Requested");
            }
            catch(SQLException e){
                 System.out.println("accersory  error."+e);
                 return false;
                
            }
             return true;
        }
         public void changestatus(String eid){
             
             ev.setEventId(eid);
         
             String s="UPDATE accerssories SET status = 'requested' WHERE eventID='"+ev.getEventId()+"'";
             
             try {
                pst = con.prepareStatement(s);
                pst.execute();
                //JOptionPane.showMessageDialog(null,"database has been updated");
            
            }
            catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null,"Error"+ex);
            
            }
         
         }
        
        }
        
        
        
         
        
        
        
        

