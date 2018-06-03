/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarClasses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Yasith
 */
public class Paymentsc {
    
    Connection conn = dbconnct.connect();
    PreparedStatement pst = null;
    ResultSet rs = null;
   
    //to get dates and time
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    DateFormat tf = new SimpleDateFormat("HH:mm:ss");
    DateFormat dft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date dt = new Date();
    
    Calendar cal = Calendar.getInstance();
    
    
    DecimalFormat DF = new DecimalFormat("#####.00");
    
    //creates a Member
    Memberc m = new Memberc();
    
    String pid;
    String loggeduser;
    Double charge;
    String type;
    String date;
    String time;
    String emp_id;
    

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getLoggeduser() {
        return loggeduser;
    }

    public void setLoggeduser(String loggeduser) {
        this.loggeduser = loggeduser;
    }

    public Double getCharge() {
        return charge;
    }

    public void setCharge(Double charge) {
        this.charge = charge;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    
  //To find vegi category
    public Double vehicatChrg(String vehicat)
    {
        Double bisy  = 50.0;
        Double three = 60.0;
        Double car   = 100.0;
        Double van   = 120.0;
        Double jeep  = 150.0;
        Double lorry = 130.0;
        
        if(vehicat.equalsIgnoreCase("Bicycle") == true)
            return bisy;
        
        else if(vehicat.equalsIgnoreCase("Three Wheel")== true)
                return three;
        
        else if(vehicat.equalsIgnoreCase("Car")== true)
                return car;
        
        else if(vehicat.equalsIgnoreCase("Van")== true)
                return van;
        
        else if(vehicat.equalsIgnoreCase("Jeep")== true)
                return jeep;
        
        else if(vehicat.equalsIgnoreCase("Lorry")== true)
                return lorry;
        
        else
            return -0.0;
    }
    
  
//To find package charge
    public Double packageAmount(String pack,String vehicat)
    {
        Double vcatchg = vehicatChrg(vehicat);
        
        Double packchrge = vcatchg*31;
        
        
        if(pack.equalsIgnoreCase("Merchant") == true)
            return packchrge-(packchrge*5.0/100.0);
        
        else if(pack.equalsIgnoreCase("School Van") == true)
            return packchrge-(packchrge*8.0/100.0);
        
        else if(pack.equalsIgnoreCase("Banker") == true)
            return packchrge-(packchrge*10.0/100.0);
        
        else
            return -0.0;
            
    }
    
    
//To Calculate Balance
    public Double findBalance(Double paid,Double chrge)
    {
        Double balance = paid - chrge;
        
        return balance;
    }
    
    public Double findTotal(String mid,String pack,String vcat) throws SQLException, ParseException
    {
        Memberc m = new Memberc();
        
        Double fine = m.calFine(mid);
        String tot = DF.format(fine + packageAmount(pack, vcat));
        
        return Double.parseDouble(tot);
    }
    
  //find Charge
    public Double findCharge(String cat, int min)
    {
        Double hrlyrate = this.vehicatChrg(cat);
        
        if(min<=60)
        {   //JOptionPane.showMessageDialog(null, " amount =     "+hrlyrate);
            return hrlyrate;
        }
        else
        {
            int hrs = min/60;
            //JOptionPane.showMessageDialog(null, " amount =     "+hrs*hrlyrate);
            return hrs*hrlyrate;
        }
        
        
    }
    
    
//TO add unregistered Payment
    public void addUnPayments(String vno,Double amnt,int du,String empid,String tickno)
    {
        String sq = "INSERT INTO car_income(vno,amount,type,dep,datetime,duration,emp_id,tickno) VALUES('"+vno+"','"+amnt+"','"+"unreg"+"','"+"Car Park"+"','"+dft.format(dt)+"','"+du+"','"+empid+"', '"+tickno+"')";
    
        try {
            pst = conn.prepareStatement(sq);
            pst.execute();
            
            
            
            JOptionPane.showMessageDialog(null, " Payments are Successfully done ");
        } catch (SQLException e) {
            
          //  JOptionPane.showMessageDialog(null, " Problem with payments "+e);
        }
        
    }
    
    
    public void updatePID(String vno,int tickno)
    {
        String sq = "SELECT * FROM car_income WHERE vno='"+vno+"' AND tickno='"+tickno+"' ";
        
        try {
            pst = conn.prepareStatement(sq);
            rs = pst.executeQuery();
            rs.next();
            
            String q ="UPDATE parkingvehicle SET pid='"+rs.getString("pid")+"' WHERE plateno='"+vno+"' AND (status='"+"toexit"+"' OR status='"+"topark"+"' OR status='"+"rej"+"' OR status='"+"suspended"+"') ";
            pst = conn.prepareStatement(q);
            pst.execute();
        
        } catch (SQLException e) {
        //        JOptionPane.showMessageDialog(null," can`t update pid " +e);
        }
    }
    
    
//To find parked duration
    public  int getParkedDu(String vlic,String type1,String type2) throws ParseException
    {
        
        
        try {
            String q = "SELECT datetime FROM parkingvehicle WHERE plateno = '"+vlic+"' AND (status = '"+type1+"' OR status='"+type2+"') ";
            
            pst = conn.prepareStatement(q);
            rs = pst.executeQuery();
            rs.next();
            
             String  dtm = rs.getString("datetime");
            //String intime = dft.format(dtm);
            
            Date inti = dft.parse(dtm);
            //JOptionPane.showMessageDialog(null, dft.format(dt)+"       "+dtm);
            String curr =dft.format(dt);
            Date curt = dft.parse(curr);
            
            
            
            int du = (int)(curt.getTime()-inti.getTime());
            //JOptionPane.showMessageDialog(null, "nmkjl  "+du/(60*1000));
            return du/(60*1000);
            
        } catch (SQLException e) {
            
            //JOptionPane.showMessageDialog(null, " Problem with getParkDu "+e);
        }
        
        return 0;
    }
    
    
    public void payFine(String vno,double amnt,String type,int du,String emp)
    {
        String q = "INSERT INTO car_income (vno,amount,type,datetime,duration,emp_id) VALUES ('"+vno+"','"+amnt+"','"+type+"','"+dft.format(dt)+"','"+du+"','"+emp+"')";
        
        try {
            pst = conn.prepareStatement(q);
            pst.execute();
            
            JOptionPane.showMessageDialog(null," Fine Payment is successfully done ");
            
            String sq = "UPDATE parkingvehicle SET status='"+"susPaid"+"' WHERE plateno='"+vno+"' AND status='"+"suspended"+"' ";

            pst = conn.prepareStatement(sq);
            pst.execute();
            
        } catch (SQLException e) {
            
      //      JOptionPane.showMessageDialog(null," Can`t do fine payments. Problem with payFine() method\n"+e);
        }
        
    }
    
    
    public double calFine(int du)
    {
        int hr = du/60;
        
        if(hr>=0 && hr <=24)
            return hr*20.0;
        
        else if(hr>=25 && hr<=168)
            return hr*2.5;
        
        else if(hr>=169 && hr<=336)
            return hr*1.5;
        
        else
            return 500.0;
        
    }
    
    
    public int getnextPID()
    {
        String q = "SELECT MAX(pid) FROM car_income ";
        
        try {
            pst = conn.prepareStatement(q);
            rs = pst.executeQuery();
            rs.next();
            
            return rs.getInt("MAX(pid)");
            
        } catch (SQLException e) {
    //        JOptionPane.showMessageDialog(null," Can`t get next pid \n"+e);
        }
        
        return 0;
    }
    
    
    
  //member`s payments
  //add Payment 
    public void addMemPayment(String Mid,String Mpack,String Mvehicat, String empid) throws ParseException, SQLException
    {
        
        setLoggeduser("CPManager");
        setCharge(packageAmount(Mpack, Mvehicat));
        setType("Member");
        setDate(df.format(dt));
        setTime(tf.format(dt));
        setEmp_id(empid);
        
       
     //get last paid date
        String sql = "SELECT * FROM member WHERE mid='"+Mid+"' ";
        
        
            
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next(); 
            
            Date parsedDate = df.parse(rs.getString("expdate"));
            
                        
//            JOptionPane.showMessageDialog(null,df.format(parsedDate));
  //          JOptionPane.showMessageDialog(null,"today"+df.format(dt));
            
            Boolean isr = m.isReject(Mid);
            
            if(isr == false)
            {
                cal.setTime(parsedDate);
                cal.add(Calendar.DAY_OF_MONTH, 31);
                
                String out = df.format(cal.getTime()).toString();
                m.setExp(out);
            
            }
            
            else
            {
                cal.add(Calendar.DATE, 31);
                String out = df.format(cal.getTime()).toString();
                m.setExp(out);
            }
                 
                    
                 String sq = "INSERT INTO car_income(vno,amount,type,datetime,emp_id) VALUES ('"+rs.getString(9)+"','"+getCharge()+"','"+getType()+"','"+dft.format(dt)+"','"+getEmp_id()+"')";
        
                 String sq1 = "UPDATE member SET paystatus = '"+1+"',expdate='"+m.getExp()+"' WHERE mid = '"+Mid+"' ";
        
                try {
            
                        pst = conn.prepareStatement(sq);
                        pst.execute();
                        JOptionPane.showMessageDialog(null,"Payments are successfully done."+"exp is = "+m.getExp());

                        pst = conn.prepareStatement(sq1);
                        pst.execute();
                        JOptionPane.showMessageDialog(null,"update member status.");

                } 
                catch (SQLException e) {
            
                        JOptionPane.showMessageDialog(null,"Can`t do the payments"+e);
                }
            
               
        }
    
}
