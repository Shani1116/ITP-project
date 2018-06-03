/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Event_Classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Navodya
 */
public class Ad_payment {
    
    Connection con= dbconnct.connect();;
    PreparedStatement pst=null;
    
        
    Advertisment a= new Advertisment();
//    Ad_payment  ap = new Ad_payment();
    
    ;
    private double Rate; 

   

    
    public double getRate() {
        return Rate;
    }

    public void setRate(double Rate) {
        this.Rate = Rate;
    }

    public Date getDd() {
        return dd;
    }

    public void setDd(Date dd) {
        this.dd = dd;
    }

    public SimpleDateFormat getS() {
        return s;
    }

    public void setS(SimpleDateFormat s) {
        this.s = s;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
           Date dd=new Date();
           SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd");
           String date=s.format(dd);
           
    public void calPay(String aid,String loc,String Ty,String adTy,int p,String d){
        
       a.setAdvertismentID(aid);
       a.setPeriod(p);
       a.setLocation(loc);
       a.setType(Ty);
       a.setaType(adTy);
       a.setDescription(d);
       
        
           if(a.getLocation().equals("BillBoard")){
               if(a.getType().equals("40 X 60")){
                    Rate=5000.00*a.getPeriod();
                    this.InPay();
               }      

               else if(a.getType().equals("120 X 60")){
                   Rate=5500.00*a.getPeriod();
                   this.InPay();
               }
               else if(a.getType().equals("80 X 120")){
                   Rate=6000.00*a.getPeriod();
                   this.InPay();
                     
               }
               else if(a.getType().equals("240 X 120")){
                   Rate=6500.00*a.getPeriod();
                   this.InPay();
                      
                   
               }
               
               
               
           
           }
           else if(a.getLocation().equals("Banners")){
                 if(a.getType().equals("Full Banner 20KB 480 x 60")){
                    Rate=7000.00*a.getPeriod();
                    this.InPay();
                    
               }      

               else if(a.getType().equals("LeaderBoard 25KB 728 x 280")){
                     Rate=6000.00*a.getPeriod();
                     this.InPay();
               }
               else if(a.getType().equals("Square 20KB 336 x 280")){
                     Rate=6500.00*a.getPeriod();
                     this.InPay();
                    
               }
               else if(a.getType().equals("Skyscraper 20KB 120 x 240")){
                     Rate=71000.00*a.getPeriod();
                     this.InPay();
                     
               }
               
           
           }
           else if(a.getLocation().equals("Escalators and Elevator wraps")){
                 if(a.getType().equals("Pannel")){
                 Rate=3000.00*a.getPeriod();
                 this.InPay();
                 
               }      

               else if(a.getType().equals("Fins")){
                    Rate=4000.00*a.getPeriod();
                    this.InPay();
                       
               }
              
               
           }
           
           else if(a.getLocation().equals("Floor Graphics")){
               
                 if(a.getType().equals("Carpet Graphics")){
                       Rate=3000.00*a.getPeriod();
                       this.InPay();
                          
               }      

               else if(a.getType().equals("Custom Shape")){
                     Rate=2500.00*a.getPeriod();
                     this.InPay();
                          
               }
               else if(a.getType().equals("Sidewalk")){
                     Rate=2100.00*a.getPeriod();
                     this.InPay();
                      
               }
               else if(a.getType().equals("Outdoor")){
                   Rate=3050.00*a.getPeriod();
                   this.InPay();
                    
                   
               }
               
           }
           
           else if(a.getLocation().equals("Kiosks")){
                 if(a.getType().equals("10 feet ")){
                 Rate=10000.00*a.getPeriod();
                 this.InPay();
                 
               }      

               else if(a.getType().equals("7 feet")){
                     Rate=7000.00*a.getPeriod();
                     this.InPay();
                     
               }
               else if(a.getType().equals("3 feet")){
                    Rate=5500.00*a.getPeriod();
                    this.InPay();
                    
               }
              
               
           }
           
           else if(a.getLocation().equals("LCD Panel")){
                 if(a.getType().equals("32'")){
                 Rate=2500.00*a.getPeriod();
                 this.InPay();
                 
               }      

               else if(a.getType().equals("40'")){
                     Rate=3000.00*a.getPeriod();
                     this.InPay();
                     
               }
               else if(a.getType().equals("43'")){
                     Rate=3500.00*a.getPeriod();
                     this.InPay();
                     
               }
               
               else if(a.getType().equals("50'")){
                     Rate=4000.00*a.getPeriod();
                     this.InPay();
                    
               }
               
           
           }
       }
    public void InPay(){
    
        
    String s1="INSERT INTO ad_income(amount,date,adID)VALUES("+Rate+",'"+date+"','"+a.getAdvertismentID()+"')";
                           try {
                               pst = con.prepareStatement(s1);
                               pst.execute();
                               JOptionPane.showMessageDialog(null,"payment added");
    
                           } catch (SQLException e1) {
                                       System.out.println("Error when adding to database! Please check connectivity."+e1);
                                       
                                   }
    
    
    }
    
     public void upamount(){
    
      
      String sq2= "Update ad_income SET amount="+Rate+" WHERE adID='"+a.getAdvertismentID()+"'";
            
            try {
            pst = con.prepareStatement(sq2);
            pst.execute();
            JOptionPane.showMessageDialog(null,"database income has been updated");
            
            }
            catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null,"Error"+ex);
            
            }
     
     
     
     }
            
    public void upPay(String aid,String loc,String Ty,String adTy,int p){
        
       a.setAdvertismentID(aid);
       a.setPeriod(p);
       a.setLocation(loc);
       a.setType(Ty);
       a.setaType(adTy);
     //  a.setDescription(d);
       
        
           if(a.getLocation().equals("BillBoard")){
               if(a.getType().equals("40 X 60")){
                    Rate=5000.00*a.getPeriod();
                    this.upamount();
                    a.updateAd(a.getPeriod(),a.getAdvertismentID());
               }      

               else if(a.getType().equals("120 X 60")){
                   Rate=5500.00*a.getPeriod();
                   this.upamount();
                    a.updateAd(a.getPeriod(),a.getAdvertismentID());
               }
               else if(a.getType().equals("80 X 120")){
                   Rate=6000.00*a.getPeriod();
                   this.upamount();
                    a.updateAd(a.getPeriod(),a.getAdvertismentID());
                     
               }
               else if(a.getType().equals("240 X 120")){
                   Rate=6500.00*a.getPeriod();
                  this.upamount();
                    a.updateAd(a.getPeriod(),a.getAdvertismentID());
                      
                   
               }
               
          
           
           }
           else if(a.getLocation().equals("Banners")){
                 if(a.getType().equals("Full Banner 20KB 480 x 60")){
                    Rate=7000.00*a.getPeriod();
                    this.upamount();
                    a.updateAd(a.getPeriod(),a.getAdvertismentID());
                    
               }      

               else if(a.getType().equals("LeaderBoard 25KB 728 x 280")){
                     Rate=6000.00*a.getPeriod();
                    this.upamount();
                    a.updateAd(a.getPeriod(),a.getAdvertismentID());
               }
               else if(a.getType().equals("Square 20KB 336 x 280")){
                     Rate=6500.00*a.getPeriod();
                     this.upamount();
                    a.updateAd(a.getPeriod(),a.getAdvertismentID());
               }
               else if(a.getType().equals("Skyscraper 20KB 120 x 240")){
                     Rate=71000.00*a.getPeriod();
                     this.upamount();
                    a.updateAd(a.getPeriod(),a.getAdvertismentID());
                     
               }
               
           
           }
           else if(a.getLocation().equals("Escalators and Elevator wraps")){
                 if(a.getType().equals("Pannel")){
                 Rate=3000.00*a.getPeriod();
                 this.upamount();
                    a.updateAd(a.getPeriod(),a.getAdvertismentID());
                 
               }      

               else if(a.getType().equals("Fins")){
                    Rate=4000.00*a.getPeriod();
                    this.upamount();
                    a.updateAd(a.getPeriod(),a.getAdvertismentID());
                       
               }
              
               
           }
           
           else if(a.getLocation().equals("Floor Graphics")){
               
                 if(a.getType().equals("Carpet Graphics")){
                       Rate=3000.00*a.getPeriod();
                       this.upamount();
                    a.updateAd(a.getPeriod(),a.getAdvertismentID());
                          
               }      

               else if(a.getType().equals("Custom Shape")){
                     Rate=2500.00*a.getPeriod();
                     this.upamount();
                    a.updateAd(a.getPeriod(),a.getAdvertismentID());
                          
               }
               else if(a.getType().equals("Sidewalk")){
                     Rate=2100.00*a.getPeriod();
                     this.upamount();
                    a.updateAd(a.getPeriod(),a.getAdvertismentID());
                      
               }
               else if(a.getType().equals("Outdoor")){
                   Rate=3050.00*a.getPeriod();
                   this.upamount();
                    a.updateAd(a.getPeriod(),a.getAdvertismentID());
                    
                   
               }
               
           }
           
           else if(a.getLocation().equals("Kiosks")){
                 if(a.getType().equals("10 feet ")){
                 Rate=10000.00*a.getPeriod();
                 this.upamount();
                    a.updateAd(a.getPeriod(),a.getAdvertismentID());
                 
               }      

               else if(a.getType().equals("7 feet")){
                     Rate=7000.00*a.getPeriod();
                     this.upamount();
                    a.updateAd(a.getPeriod(),a.getAdvertismentID());
                     
               }
               else if(a.getType().equals("3 feet")){
                    Rate=5500.00*a.getPeriod();
                    this.upamount();
                    a.updateAd(a.getPeriod(),a.getAdvertismentID());
                    
               }
              
               
           }
           
           else if(a.getLocation().equals("LCD Panel")){
                 if(a.getType().equals("32'")){
                 Rate=2500.00*a.getPeriod();
                 this.upamount();
                    a.updateAd(a.getPeriod(),a.getAdvertismentID());
                 
               }      

               else if(a.getType().equals("40'")){
                     Rate=3000.00*a.getPeriod();
                     this.upamount();
                    a.updateAd(a.getPeriod(),a.getAdvertismentID());
                     
               }
               else if(a.getType().equals("43'")){
                     Rate=3500.00*a.getPeriod();
                     this.upamount();
                    a.updateAd(a.getPeriod(),a.getAdvertismentID());
                     
               }
               
               else if(a.getType().equals("50'")){
                     Rate=4000.00*a.getPeriod();
                     this.upamount();
                    a.updateAd(a.getPeriod(),a.getAdvertismentID());
                    
               }
               
           
                }
            }
    
    
    
          
    
    } 
           
           
           
           
           
           

