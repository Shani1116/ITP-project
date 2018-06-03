
package Carpark_class;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;


public class parkingVehicles {
    
    
    static Connection conn = dbconnct.connect();
    static PreparedStatement pst = null;
    static ResultSet rs = null;
    
    Ticket t = new Ticket();
    Memberc m = new Memberc();
    Arduino a = new Arduino();
    
    DateFormat dft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    //DateFormat tf = new SimpleDateFormat("HH:mm:ss");
    Date dt = new Date();
    
    Calendar cal = Calendar.getInstance();
    
  String  vid;
  //String ;
  String  licenseNo;
  String  category;
  String  vehi_status;
  

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getVehi_status() {
        return vehi_status;
    }

    public void setVehi_status(String vehi_status) {
        this.vehi_status = vehi_status;
    }


    public void addParkVehi(String cat,String lipno,String slno,String empid)
    {
        String vca=null;
        
        switch(cat)
        {
            case "1": vca="Bicycle"; break;
            case "2": vca="Three Wheel"; break;
            case "3": vca="Car"; break;
            case "4": vca="Van"; break;
            case "5": vca="Jeep"; break;
            case "6": vca="Lorry"; break;
        }
        
        this.setCategory(vca);
        this.setLicenseNo(lipno);
        this.setVehi_status("in");
        
        //String d = df.format(dt);
        //String ti = tf.format(dt);
        
        //Boolean b = this.isSuspend(this.getLicenseNo());
        //Boolean r = m.isReject(vid);
        
        //if(b==false)
        //this.isMember(this.getLicenseNo());
        
        //if(b == false)
        //{
                String chk = this.isMember(this.getLicenseNo());
        
                if(chk.equalsIgnoreCase("no") || chk.equalsIgnoreCase("rej") )
                {
                    String q ="INSERT INTO parkingvehicle(status,category,plateno,ticketno,slotno,datetime,emp_id)  VALUES ('"+this.getVehi_status()+"','"+this.getCategory()+"','"+this.getLicenseNo()+"','"+t.settickNo()+"','"+slno+"','"+dft.format(dt)+"','"+empid+"')";

                    //JOptionPane.showMessageDialog(null,t.settickNo()+vca);

                    try {

                        pst=conn.prepareStatement(q);
                        pst.execute();

                        JOptionPane.showMessageDialog(null,this.getLicenseNo()+"  -  "+this.getCategory()+"\n Successfully Added "+chk);


                    } catch (SQLException e) {            

                        JOptionPane.showMessageDialog(null,"Problem with the Querry "+e);
                    }


                }



                else
                {
                    String q ="INSERT INTO parkingvehicle(status,category,plateno,ticketno,slotno,datetime,emp_id,mid)  VALUES ('"+this.getVehi_status()+"','"+this.getCategory()+"','"+this.getLicenseNo()+"','"+t.settickNo()+"','"+slno+"','"+dft.format(dt)+"','"+empid+"','"+chk+"')";

                    //JOptionPane.showMessageDialog(null,t.settickNo()+vca);

                    try {

                        pst=conn.prepareStatement(q);
                        pst.execute();

                        JOptionPane.showMessageDialog(null,this.getLicenseNo()+"  -  "+this.getCategory()+"\n Successfully Added "+chk);


                    } catch (SQLException e) {            

                        JOptionPane.showMessageDialog(null,"Problem with the Querry "+e);
                    }



                }
                
     

        //}
        
        //else
          //JOptionPane.showMessageDialog(null," SUSPENDED !!!\n  must pay !!");


    }
    
    


    public void updateParkedVehi(String tickno)
    {
        String q = "UPDATE parkingvehicle SET status = '"+"out"+"' WHERE ticketno = '"+tickno+"' " ;

        try {
                pst = conn.prepareStatement(q);
                pst.execute();

                

            } catch (SQLException e) {

                JOptionPane.showMessageDialog(null, " Problem with the update parkedVehi "+e);

            }
    }
    
    
    public Boolean isSuspend(String licNo)
    {
        boolean rslt=false;
        
        String q = "SELECT COUNT(ticketno),plateno,status FROM parkingvehicle WHERE plateno ='"+licNo+"' ";
        
        try {
            
            //JOptionPane.showMessageDialog(null, licNo);
            pst=conn.prepareStatement(q);
            rs = pst.executeQuery();
            //JOptionPane.showMessageDialog(null,rs.getString("plateno"));
            rs.next();
            if(rs.getString("COUNT(ticketno)").equals("0"))
            {
                System.out.println(rs.getString(1));
                rslt = false;
            }
                System.out.println(rs.getString("COUNT(ticketno)"));
                System.out.println(rs.getString("plateno"));
                System.out.println(rs.getString("status"));
            
            //String sta = rs.getString("plateno");
            
                
            
            
        } catch (SQLException e) {
            
            //JOptionPane.showMessageDialog(null, " Problem with the isSuspend method "+e);
            
            
        }
        System.out.println(rslt);
    return rslt;
        
    }
    
    public String isMember(String vlic)
    {
        String q = "SELECT * FROM member WHERE  vehilicense = '"+vlic+"' ";
        
        try {
            
            pst=conn.prepareStatement(q);
            rs=pst.executeQuery();
            rs.next();
            
            String psta = rs.getString("paystatus");
            
            if(psta.equalsIgnoreCase("1"))
                return rs.getString("mid");
            
            else if(psta.equalsIgnoreCase("0"))
                return "rej";
            
                        
                       
            
        } catch (SQLException e) {
            
           // JOptionPane.showMessageDialog(null, "Problem with isMember method "+e);
            return "no";
        }
        
        return null;
    }
    
    
 //to get vehi category
    public static String getVehicat(String vlic,String type1,String type2)
    {
                    

               
        
        try {
            
             String sq ="SELECT category FROM parkingvehicle WHERE plateno = '"+vlic+"' AND (status = '"+type1+"' OR status='"+type2+"') ";
            
            pst = conn.prepareStatement(sq);
            rs = pst.executeQuery();
            rs.next();
            
            String cat = rs.getString("category");
            
            
            
            return cat;
            
        } catch (SQLException e) {
            
            
        }
        
        return "Can`t find";
    }
    
    
    public int getTotalvehicle()
    {
        String q = "SELECT COUNT(ve_id) FROM parkingvehicle WHERE status='"+"in"+"' OR status='"+"rej"+"' OR status='"+"toexit"+"' OR status='"+"topark"+"'";
        
        try {
            pst = conn.prepareStatement(q);
            rs = pst.executeQuery();
            rs.next();
            int tot = Integer.parseInt(rs.getString("COUNT(ve_id)"));
            
            return tot;
            
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Problem with progress \n "+e);
            return 0;
        }
    }
    
    
    public void suspends(String vno)
    {
        String q = "UPDATE parkingvehicle SET status='"+"suspended"+"' WHERE PLATENO='"+vno+"' AND status = '"+"in"+"' ";
        
        try {
            pst = conn.prepareStatement(q);
            pst.execute();
            
            JOptionPane.showMessageDialog(null,vno + " succesfully added to suspended list ");
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null," Problem with suspends() method\n Can`t added to suspended list ");
                    
        }
    }
    
    
    public void addRejectedList(String rvno,String rslot)
    {
        String q = "UPDATE parkingvehicle SET status ='"+"rej"+"', slotno='"+rslot+"' WHERE plateno='"+rvno+"' AND status='"+"in"+"'";
        
        try {
            pst = conn.prepareStatement(q);
            pst.execute();
            
            
            
            JOptionPane.showMessageDialog(null, rvno+" is added to the rejected list \n");
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, " Can`t do the rejection \n "+ e);
        }
    }
    
    
    public void giveNewSlot(String nvno,String nslot)
    {
        String q = "UPDATE parkingvehicle SET  slotno='"+nslot+"' WHERE plateno='"+nvno+"' AND status='"+"in"+"'";
        
        try {
            pst = conn.prepareStatement(q);
            pst.execute();
            
            
            
            JOptionPane.showMessageDialog(null, nvno+" can park at "+nslot+" now.");
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, " Can`t give a new slot \n "+ e);
        }
    }
    
    //check the sensor availabilty of a slot
    public static int chkSenava(String slot)
    {
        int senAva = -1;
        
        String sql = "SELECT senAva FROM carparkslot WHERE slotNo = '"+slot+"'";
        
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();
            
            senAva = rs.getShort("senAva");
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return senAva;
    }
    
    //reject the vehicle automatically by using sensor data
    public static void rejectVehiAuto(String slot, String vehi)
    {
        int senAva = chkSenava(slot);
        
        if(senAva==0)
        {
            String sql = "UPDATE parkingvehicle SET status='"+"rej"+"' WHERE plateno='"+vehi+"' AND status='"+"in"+"'";
            
            try {
                pst = conn.prepareStatement(sql);
                pst.execute();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        
        else if(senAva==1)
        {
            String sql = "UPDATE carparkslot SET status='"+"parked"+"' WHERE slotNo='"+slot+"'";
            //String sq = "U{DATE parkingvehicle SET status='"+"in"+"'"
            
            try {
                pst = conn.prepareStatement(sql);
                pst.execute();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        
    }
    
    public static void updateParkingVehi(String slot,String stat)
    {
        String vno = selectVehilic(slot);
        
        String sql = "UPDATE parkingvehicle SET status='"+stat+"' WHERE plateno='"+vno+"' AND status='"+"in"+"' OR status='"+"toexit"+"'" ;
        
        if(vno!=null)
        {
            try {
                pst = conn.prepareStatement(sql);
                pst.execute();
                
                //a.exitMsg(slot, vno);

            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
    
     public static String selectVehilic(String slot)
    {
        String vno=null;
        
        String sql = "SELECT vehilic FROM carparkslot WHERE slotNo='"+slot+"' AND STATUS='"+"parked"+"' AND senAva='"+0+"'";
        
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next())
               vno = rs.getString("vehilic");
        
        } catch (SQLException e) {
            
            System.out.println(e);
        }
        
        return vno;
            
    }
     
     public boolean isReject(String vno)
     {
         boolean rsl =true;
         
         String sq="select count(plateno) from parkingvehicle where status='"+"rej"+"' group by plateno";
         
         try {
             pst = conn.prepareStatement(sq);
             rs = pst.executeQuery();
             rs.next();
             
             if(rs.getString("count(plateno)").equals("0"))
                 rsl=false;
             
         } catch (Exception e) {
         }
         
         return rsl;
     }
    
    
}
