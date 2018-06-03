 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financemanagement.classes;

import com.mysql.jdbc.Connection;
import db.dbconnct;
import financemanagement.HandlingRequestsForm;
import financemanagement.NetProfitForm;
//import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Anu
 */
public class financeManager {
        
     Connection conn = dbconnct.connect();
     PreparedStatement pst=null;
  
     Expense e = new Expense();
     
     Income i = new Income();
     
     Mall m = new Mall();
     
     Profit p = new Profit();
     
     Request r = new Request();
     
     DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
     Date dt = new Date();
     
     
     
     
     
    
    String Eid;
    String fname;
    String lname;
    String designation;
    String department;
    String NIC;
    String address;
    int phone_no;
 
    private Object dbconnect;
    private Object jTextField4;

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
    
    public void addExpense(String b,String c, Double a, String d){
        
        e.expenseID=b;
        e.category = c;
        e.Amount = a;
        e.date =d;
        
        //JOptionPane.showMessageDialog(null, e.date+"     m  "+df.format(dt)+dt);
         
        try {
        String sql1 = "Insert into expenses(expenseID,category,Amount,date) VALUES ('"+e.expenseID+"','"+ e.category +"','"+ e.Amount+"','"+ e.date+"')";
        pst = conn.prepareStatement(sql1);
        pst.execute();
        JOptionPane.showMessageDialog(null, "one expense added to the database");
        
        }
        
        catch(SQLException e){
        
        System.out.println("Error adding to the database"+e);
        
        }
        }
    
    public void approvestatus(int a,String b,String d,double m,String s){
    
    
        r.request_id=a;
        r.request=b;
        r.department=d;
        r.amount=m;
        r.status=s;
        
        if(r.status.equals("Yes")){
            
            try{
            String sql = "UPDATE `request` SET `status`='Yes' WHERE `request_id`='"+ r.request_id +"'";
            
           
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null,"One request accepted");
            }
            catch(SQLException e){
            Logger.getLogger(HandlingRequestsForm.class.getName()).log(Level.SEVERE, null, e);
            //System.out.println("Error when adding to database! Please check connectivity.");
            }
        }
        else{
            
            String sql = "UPDATE `request` SET `status`='No' WHERE `request_id`='"+ r.request_id +"'";
            
            try{
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null,"One request is Not accepted!");
            }
            catch(SQLException e){
            Logger.getLogger(HandlingRequestsForm.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("Error when adding to database! Please check connectivity.");
            }
        }
    
    
    }
        
        
    
     public void addIncome(String b ,String c, Double a, String d) {
         
        i.IncomeID=b;
        i.category = c;
        i.Amount = a; 
        i.date =d;
        
        
        
        //JOptionPane.showMessageDialog(null, i.date+"     m  "+df.format(dt)+dt);
                
        
        String sql2 = "Insert into incomes (Income_ID,category,Amount,date) values('"+i.IncomeID+"','"+ i.category +"',"+ i.Amount+",'"+ i.date+"')";
      
         try {
        
        pst = conn.prepareStatement(sql2);
        pst.execute();
        JOptionPane.showMessageDialog(null, "one income added to the database");
        
        }
        
        catch(SQLException e){
        
        System.out.println("Error adding to the database"+e);
        
        }
        }
        
       
     
     
     public void UpdateIncome(String b,String c,String d,double a){

        i.IncomeID=b;
        i.category = c;
        i.date =d;
        i.Amount = a;
       
        
     
       try {
        String sql2 = "update incomes SET category ='"+i.category+"', Amount ="+i.Amount+",date='"+i.date+"' where Income_ID='"+i.IncomeID+"' ";
        pst = conn.prepareStatement(sql2);
        pst.execute();
        JOptionPane.showMessageDialog(null, "one income updated to the databaase");
        
        }
        
        catch(SQLException e){
        
        System.out.println("Error updating  the database"+e);
        
        }
        }
        
     
     public void calculateGrossProfit(String h,Double c,Double i){
         p.ProfitID=h;
         p.Cost_of_sales=c;
         p.income=i;
         
         double profit=(i-c);
         JOptionPane.showMessageDialog(null, "the calculated profit is :"+profit);
        /*try{
        
        String sql3 = "Insert into Profit () values ('"+p.ProfitID+"','+p.Cost_of_sales+','+p.income+')";//,'"+p.whole_revenue+"','"+p.all_operating_expenses+"')";
        pst = conn.prepareStatement(sql3);
        pst.execute();
        JOptionPane.showMessageDialog(null, "one Profit detail added to the databse");
        
        }
        catch(Exception e){
        
        System.out.println(e);
        }
        */
     
     
     }
     public void addGrossProfitDetails(String a,double s,double d){
     
     p.ProfitID=a;
     p.Cost_of_sales=s;
     p.income=d;
     
     String sql2 = "Insert into grossprofit (ProfitID,cost_of_sales,incomes) values ('"+p.ProfitID+"',"+p.Cost_of_sales+","+p.income+")";
     try{
     pst = conn.prepareStatement(sql2);
     pst.execute();
     JOptionPane.showMessageDialog(null, "one Gross Profit detail added to the database");
     }
     
     
     catch(Exception ex){
         
     System.out.println(ex);
     }
     
     
     }
     
     public void addNetProfitDetails(String a,double r,double e,double d,double g,double b,String l){
     
         p.ProfitID=a;
         p.whole_revenue=r;
         p.all_operating_expenses=e;
         p.Taxes=d;
         p.Interests=g;
         p.Depreciations=b;
         p.date=l;
                 
    
        String sql3 = "Insert into netprofit (Profit_ID,whole_revenue,all_operating_expenses,Taxes,interests,depreciations,date) values ('"+p.ProfitID+"',"+p.whole_revenue+","+p.all_operating_expenses+","+p.Taxes+","+p.Interests+","+p.Depreciations+",'"+p.date+"')";
         try{
        
        pst = conn.prepareStatement(sql3);
        pst.execute();
        JOptionPane.showMessageDialog(null, "one net Profit detail added to the database");
        
        }
       catch(Exception ex){
       
       System.out.println(ex);
       
       }
     
     }
     
     
     public void calculateNetProfit(String y,Double r,Double a){
         p.ProfitID=y;
         p.whole_revenue=r;
         p.all_operating_expenses=a;
         
         double netprofit=(r-a);
         JOptionPane.showMessageDialog(null, "The calculated  net profit is :"+netprofit);
         
         
        
     
     }
     
     public void addOperatingExpenses(double t,double b,double d){
     
         
     
      
      String sql2 = "Insert into netprofit (Taxes,interests,depreciations)values ("+p.Taxes+","+p.Interests+","+p.Depreciations+")";
     try{
         pst = conn.prepareStatement(sql2);
         pst.execute();
         JOptionPane.showMessageDialog(null, "one Profit detail added to the databse");
     
     
     }
     catch(Exception ex){
     
         System.out.println(ex);
     }
     
     }
    
     
     public void addSheetDetails(String w,String d,String c,double b,double l,double f,double t,double s){
         
         m.sheetID=w;
         m.Date=d;
         m.Company=c;
         m.Current_Assets=b;
         m.Current_Liabilities=l;
         m.Fixed_Assets=f;
         m.LongTerm_Liabilities=t;
         m.Shareholders_Equity=s;
         
          String sql2 = "Insert into sheet (sheetID,date,company,current_liabilities,fixed_assests,long_term_liabilities,current_assests,shareholders_equity) values ('"+m.sheetID+"','"+m.Date+"','"+m.Company+"',"+m.Current_Liabilities+","+m.Fixed_Assets+","+m.LongTerm_Liabilities+","+m.Current_Assets+","+m.Shareholders_Equity+")";
   
         try{
         
             pst = conn.prepareStatement(sql2);
             pst.execute();
             JOptionPane.showMessageDialog(null, "Details are added to the database to generate the sheet");
         
         
         
         }
         
         catch(Exception e){
        
        System.out.println(e);
         }
     
     
     }
     public void getDetails(String a,String f,double c,double l,double d,double g,double s){
     
     
         m.startdate=a;
         m.enddate=f;
         m.Current_Assets=c;
         m.Current_Liabilities=l;
         m.Fixed_Assets=d;
         m.LongTerm_Liabilities=g;
         m.Shareholders_Equity=s;
          
  
                        
     
     
     try{
     
         String sql1 = "SELECT current_assets,current_liabilities,fixed_assets,long_term_liabilities,shareholders_equity FROM mall where startdate='"+m.startdate+"' AND Enddate='"+m.enddate+"'";  
         pst = conn.prepareStatement(sql1);
         pst.execute();
         //JOptionPane.showMessageDialog(null, "Details are added to the database to generate the sheet");
     
     
     }
     catch(Exception e){
     
     System.out.println(e);
     
     }
     
     
     }
     
     public void addMallDetails(String e,String r,double c,double l,double f,double d,double s){
     
         m.startdate=e;
         m.enddate=r;
         m.Current_Assets=c;
         m.Current_Liabilities=l;
         m.Fixed_Assets=f;
         m.LongTerm_Liabilities=d;
         m.Shareholders_Equity=s;
     
     
        // JOptionPane.showMessageDialog(null, m.Month+"     m  "+df.format(dt)+dt);
         try{
         
         String sql3 = "INSERT INTO mall (startdate,Enddate,current_assets,current_liabilities,Fixed_assets,long_term_liabilities,shareholders_equity) VALUES ('"+m.startdate+"','"+m.enddate+"',"+m.Current_Assets+","+ m.Current_Liabilities +","+m.Fixed_Assets+","+m.LongTerm_Liabilities+","+m.Shareholders_Equity+")";
         pst = conn.prepareStatement(sql3);
         pst.execute();
         JOptionPane.showMessageDialog(null, "1 mall detail is added to the database");
         
         }
         catch(Exception ex){
         
         System.out.println(ex);
         
         }
    
     }
     
     public void getMallDetails(String a,String y,double c,double l,double f,double d,double s){
     
         m.startdate=a;
         m.enddate=y;
         m.Current_Assets=c;
         m.Current_Liabilities=l;
         m.Fixed_Assets=f;
         m.LongTerm_Liabilities=d;
         m.Shareholders_Equity=s;
     
         try{
         
         String sql1 = "SELECT current_assets,current_liabilities,fixed_assets,long_term_liabilities,shareholders_equity FROM mall where startdate='"+m.startdate+"' AND Enddate='"+m.enddate+"'";
         pst = conn.prepareStatement(sql1);
         pst.execute();
         JOptionPane.showMessageDialog(null, "Here shows the mall details for this time period");
         
         }
         catch(Exception e){
         
         System.out.println(e);
         
         }
     
     
     
     }
     
}
