/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Event_Classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Navodya
 */
public class organizer {
    
    Connection con= dbconnct.connect();;
    PreparedStatement pst=null;
    
    private String organizerID;
    private String Name; 
    private String ContactsPerson; 
    private String  email;
    private String  FaxNo;
    private String eventID;
    private String phoneNo; 

    public String getOrganizerID() {
        return organizerID;
    }

    public void setOrganizerID(String organizerID) {
        this.organizerID = organizerID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getContactsPerson() {
        return ContactsPerson;
    }

    public void setContactsPerson(String ContactsPerson) {
        this.ContactsPerson = ContactsPerson;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFaxNo() {
        return FaxNo;
    }

    public void setFaxNo(String FaxNo) {
        this.FaxNo = FaxNo;
    }

    public String getEventID() {
        return eventID;
    }

    public void setEventID(String eventID) {
        this.eventID = eventID;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
    
     public void addO(String oid,String oName,String cp,String no,String email,String fno){
    
        this.setOrganizerID(oid);
        this.setName(oName);
        this.setContactsPerson(cp);
        this.setPhoneNo(no);
        this.setEmail(email);
        this.setFaxNo(fno);
      ///  this.setEventID(eid);
        
        
         String q1="INSERT INTO organizer(orgId,oname,contactPerson,phoneno,email,faxno) VALUES ('"+ this.getOrganizerID() +"','"+ this.getName() +"','"+ this.getContactsPerson() +"','"+this.getPhoneNo() +"','"+ this.getEmail() +"','"+ this.getFaxNo() +"')";
             try {
            pst = con.prepareStatement(q1);
            pst.execute();
            JOptionPane.showMessageDialog(null,"An organizer has been added to the database!");
           
        } catch (SQLException ex) {
            System.out.println("Error when adding to database! Please check connectivity."+ex);
            
        }
     }
    
    
    
    
     public void updateOr(String oID,String onme,String conP,String em,String phone,String Fax){
           
            this.setOrganizerID(oID);
            this.setName(onme);
            this.setContactsPerson(conP);
            this.setEmail(em);
            this.setPhoneNo(phone); 
            this.setFaxNo(Fax);
            
            String q3= "UPDATE  organizer SET orgId='"+this.getOrganizerID()+"',oname='"+this.getName()+"',contactPerson='"+this.getContactsPerson()+"',email='"+this.getEmail()+"',phoneno='"+this.getPhoneNo()+"',faxno='"+this.getFaxNo()+"' WHERE orgId='"+this.getOrganizerID()+"'";
            try {
            pst = con.prepareStatement(q3);
            pst.execute();
            //JOptionPane.showMessageDialog(null,"database has been updated");
            
            } 
            catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error"+ex);
            
            }
    
    
    
     }
    
    
}
