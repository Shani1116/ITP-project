
package Classes;

import Classes.Employee;
import HR.*;
import db.dbconnct;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Shanika
 */
public class HRmanager extends Employee{
    
    //Creates the database connection
    Connection conn= dbconnct.connect();
    PreparedStatement pst=null;
    ResultSet rs=null;
    
    //Creates an Employee object
    Employee e = new Employee();
    
    //Creates a case object
    discase c1 = new discase();
    
    //Creates a leave object
    leave l = new leave();
    
    //Creates an attendance object
    Attendance a = new Attendance();
    

    public void addemp(String fn, String ln, String bd, String st, String em, String desg, String ty, String jd, String n, String dept, String add, String ph){
        
        e.fname = fn;
        e.lname = ln;
        e.birthday=bd;
        e.email=em;
        e.stat=st;
        e.type=ty;
        e.jdate=jd;
        e.designation = desg;
        e.NIC = n;
        e.dep = dept;
        e.address = add;
        e.phone = ph;
        
        String sq = "INSERT INTO `employee`(`First_name`, `Last_name`, `Birthday`, `Civil_status`, `Email`, `Designation`, `Emp_type`, `Joined_date`, `NIC`, `Department`, `Address`, `Phone_no`) VALUES ('"+ e.fname +"', '"+ e.lname +"', '"+ e.birthday +"', '"+ e.stat +"', '"+ e.email +"', '"+ e.designation +"', '"+ e.type +"', '"+ e.jdate +"', '"+ e.NIC +"', '"+ e.dep +"', '"+ e.address +"', '"+ e.phone +"')";
        
        try {
            pst = conn.prepareStatement(sq);
            pst.execute();
            JOptionPane.showMessageDialog(null,"One employee added to the database!");
            
        } catch (SQLIntegrityConstraintViolationException ex) {
            //System.out.println("Error when adding to database! Please check connectivity.");
            JOptionPane.showMessageDialog(null,"Duplicate values! Please check and enter again!");
            Logger.getLogger(AddEmployee.class.getName()).log(Level.SEVERE, null, ex);  
        }
        catch (SQLException ex) {
            //System.out.println("Error when adding to database! Please check connectivity.");
            JOptionPane.showMessageDialog(null,"Error when adding to database! Please check connectivity.");
            Logger.getLogger(AddEmployee.class.getName()).log(Level.SEVERE, null, ex);  
        }
    }
    
    public void delemp(String eid){
        e.Empid = eid;
        
       // String sq = "DELETE FROM employee WHERE Employee_ID = '"+ e.Empid +"' ";
        String sq = "UPDATE employee SET active='Deactivate' WHERE Employee_ID = '"+ e.Empid +"'";
        try {
            pst = conn.prepareStatement(sq);
            pst.execute();
             JOptionPane.showMessageDialog(null,"One employee deactivated!");
            
        } catch (SQLException ex) {
           System.out.println(ex);
           //System.out.println("Error when accessing database! Please check connectivity.");
           Logger.getLogger(EditEmployee1.class.getName()).log(Level.SEVERE, null, ex);
          // System.out.println(ex);
        }
    }
    
    public void updateemp(String eid, String fn, String ln, String bd, String st, String em, String desg, String ty, String jd, String n, String dept, String add, String ph){
        
        e.Empid = eid;
        e.fname = fn;
        e.lname = ln;
        e.birthday=bd;
        e.email=em;
        e.stat=st;
        e.type=ty;
        e.jdate=jd;
        e.designation = desg;
        e.NIC = n;
        e.dep = dept;
        e.address = add;
        e.phone = ph;
        
        String sq = "UPDATE employee SET First_name = '"+ e.fname +"', Last_name = '"+ e.lname +"', Birthday = '"+ e.birthday +"', Civil_status = '"+ e.stat +"', Email = '"+ e.email +"', Designation = '"+ e.designation +"', Emp_type = '"+ e.type +"', Joined_date = '"+ e.jdate +"', NIC = '"+ e.NIC +"', Department = '"+ e.dep +"', Address = '"+ e.address +"', Phone_no = '"+ e.phone +"' WHERE Employee_ID = '"+ e.Empid +"' ";
        
        try {
            pst = conn.prepareStatement(sq);
            pst.execute();
            JOptionPane.showMessageDialog(null,"One employee was changed in the databse!");
            
        } 
        catch (SQLIntegrityConstraintViolationException ex) {
            //System.out.println("Error when adding to database! Please check connectivity.");
            JOptionPane.showMessageDialog(null,"Duplicate values! Please check and enter again!");
            Logger.getLogger(EditEmployee1.class.getName()).log(Level.SEVERE, null, ex);  
        }
        catch (SQLException ex) {
            System.out.println("Error when adding to database! Please check connectivity.");
            Logger.getLogger(EditEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addleave(String eid, String sd, String ed, String lt, String wp, String r, int d){
        
        l.empID = eid;
        l.sdate = sd;
        l.edate = ed;
        l.type = lt;
        l.workplace = wp;
        l.reason = r;
        l.duration = d;
    
        
        String q="INSERT INTO `leave`(`Start_date`, `End_date`, `Type`, `Workplace`, `Reason`, `Duration`, `Employee_ID`) VALUES ('"+ l.sdate +"','"+ l.edate +"','"+ l.type +"','"+ l.workplace +"','"+ l.reason +"','"+ l.duration +"','"+ l.empID +"')";
        
        try {
            pst = conn.prepareStatement(q);
            pst.execute();
            JOptionPane.showMessageDialog(null,"One leave record added to the databse!");
        } 
        catch (SQLIntegrityConstraintViolationException ex) {
            //System.out.println("Error when adding to database! Please check connectivity.");
            JOptionPane.showMessageDialog(null,"Duplicate values! Please check and enter again!");
            Logger.getLogger(AddLeave.class.getName()).log(Level.SEVERE, null, ex);  
        }
        catch (SQLException ex) {
            
            Logger.getLogger(AddLeave.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void delleave(int lid, String eid){
        
        l.leaveID = lid;
        l.empID = eid;
        
        //String q= "DELETE FROM `leave` WHERE Leave_ID ="+l.leaveID;
        String q1 = "UPDATE leave SET Employee_ID = 'NULL' WHERE Leave_ID="+l.leaveID;
        try {
            pst = conn.prepareStatement(q1);
            pst.execute();
            JOptionPane.showMessageDialog(null,"One leave record deleted from the databse!");
        } 
        catch (SQLIntegrityConstraintViolationException ex) {
            //System.out.println("Error when adding to database! Please check connectivity.");
            JOptionPane.showMessageDialog(null,"Duplicate values! Please check and enter again!");
            Logger.getLogger(SearchLeave.class.getName()).log(Level.SEVERE, null, ex);  
        }
        catch (SQLException ex) {
            
            
        }
        
    }
    
    public void addcase(String eid, String cn, String n, String des, String cb, String co, String dept, String stat){
        
        c1.empID = eid;
        c1.casename = cn;
        c1.name = n;
        c1.desc = des;
        c1.createdby = cb;
        c1.createdon = co;
        c1.dep = dept;
        c1.status = stat;
        
        String q = "INSERT INTO `case`(`Case_name`, `Employee_ID`, `Employee_name`, `Description`, `Created_by`, `Created_on`, `Department`, `Status`) VALUES ('"+ c1.casename +"', '"+ c1.empID +"', '"+ c1.name +"', '"+ c1.desc +"', '"+ c1.createdby +"', '"+ c1.createdon +"', '"+ c1.dep +"', '"+ c1.status +"')";
        
            try{
            pst = conn.prepareStatement(q);
            pst.execute();
            JOptionPane.showMessageDialog(null,"One case was changed in the databse!");
            }
            catch (SQLIntegrityConstraintViolationException ex) {
            //System.out.println("Error when adding to database! Please check connectivity.");
            JOptionPane.showMessageDialog(null,"Duplicate values! Please check and enter again!");
            Logger.getLogger(AddCase.class.getName()).log(Level.SEVERE, null, ex);  
        }
            catch(SQLException e){
            Logger.getLogger(AddCase.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("Error when adding to database! Please check connectivity.");
            }
    }
    
    public void addent(String eid, String n, String d, String st){
        
        a.empID = eid;
        a.name = n;
        a.date = d;
        a.status = st;
        
        String q = "INSERT INTO attendance(Name,Date,Status,Employee_ID) VALUES ('"+ a.name +"', '"+ a.date +"', '"+ a.status +"','"+ a.empID +"')";
        
        try{
            pst = conn.prepareStatement(q);
            pst.execute();
            JOptionPane.showMessageDialog(null,"One entry added to the database");
            }
        catch (SQLIntegrityConstraintViolationException ex) {
            //System.out.println("Error when adding to database! Please check connectivity.");
            JOptionPane.showMessageDialog(null,"Duplicate values! Please check and enter again!");
            Logger.getLogger(AddEntry.class.getName()).log(Level.SEVERE, null, ex);  
        }
            catch(SQLException e){
            Logger.getLogger(AddEntry.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("Error when adding to database! Please check connectivity.");
            }
    }
    
    public void approveleave(String eid, int lid, String a){
    
        l.empID=eid;
        l.leaveID=lid;
        l.appr=a;
        
        if(l.appr.equals("Yes")){
            
            try{
            String sql = "UPDATE `leave` SET `Approvement`='Yes' WHERE `Leave_ID`='"+ l.leaveID +"'";
            
           
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null,"One leave approved!");
            }
            catch (SQLIntegrityConstraintViolationException ex) {
            //System.out.println("Error when adding to database! Please check connectivity.");
            JOptionPane.showMessageDialog(null,"Duplicate values! Please check and enter again!");
            Logger.getLogger(App_Ign_Leave.class.getName()).log(Level.SEVERE, null, ex);  
        }
            catch(SQLException e){
            Logger.getLogger(App_Ign_Leave.class.getName()).log(Level.SEVERE, null, e);
            //System.out.println("Error when adding to database! Please check connectivity.");
            }
        }
        else{
            
            String sql = "UPDATE `leave` SET `Approvement`='No' WHERE `Leave_ID`='"+ l.leaveID +"'";
            
            try{
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null,"One leave Not approved!");
            }
             catch (SQLIntegrityConstraintViolationException ex) {
            //System.out.println("Error when adding to database! Please check connectivity.");
            JOptionPane.showMessageDialog(null,"Duplicate values! Please check and enter again!");
            Logger.getLogger(App_Ign_Leave.class.getName()).log(Level.SEVERE, null, ex);  
        }
            catch(SQLException e){
            Logger.getLogger(AddLeave.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("Error when adding to database! Please check connectivity.");
            }
        }
        
    }
    
}
