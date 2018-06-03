/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Shanika
 */
public class Validation {
    
    private static MessageDigest md;
    
    public boolean isNumeric(String x){
     return  x.matches("^(0|[1-9][0-9]*)$");  
    }
    
    public boolean isVaildContactNo(String s){
        return s.matches("\\d{10}");
    }
    
    public boolean CheckNIC(String input){
      return input.matches("\\d{9}(v|V)");
        
    }
    
    public boolean CheckEmail(String input){
        
     String epattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,}$)";
     
     Pattern p = Pattern.compile(epattern);
       
       Matcher m = p.matcher(input);
       
       if(m.matches())
           return true;
       else
           return false;
    }
    
    public boolean IsDateToday(String datetoval){
        
           Date today = Calendar.getInstance().getTime();
           
           Calendar cal = Calendar.getInstance();
           cal.add(Calendar.DATE, -1);
           
           return false;
           
    }
    
    public boolean IsEmpAgeValid(String year){
        
            DateFormat df = new SimpleDateFormat("yyyy");
            Date CurrentDate = new Date();
        
            int userYear = Integer.parseInt(year);
            int Currentyear = Integer.parseInt(df.format(CurrentDate));
            int getAge = Currentyear - userYear;
            if (getAge>=18)
                return true;
            else
                return false;

    }
    
    public static String encrpytpass(String pass){
    
        //private static MessageDigest md;
        
        try{
            md=MessageDigest.getInstance("MD5");
            byte[] passB = pass.getBytes();
            md.reset();
            byte[] dig = md.digest(passB);
            
            StringBuffer sb=new StringBuffer();
            
            for(int i=0; i<dig.length;i++){
                sb.append(Integer.toHexString(0xff & dig[i]));
            }
            
            return sb.toString();
        }
        catch(NoSuchAlgorithmException e){
            System.out.println("Error!");
        }
            
        return null;
    }
    
    
  //car park
     public boolean isValidVehiNum(String vno)
{
    int l = vno.length();

    boolean zero = Character.isLetter(vno.charAt(0));
    boolean one = Character.isLetter(vno.charAt(1));
    boolean two = Character.isLetter(vno.charAt(2));
    
    
    if(zero == true & one == true)
    {
        if( l==7)
        {
            
            
            
            if(two==true)
            {
                boolean thr = Character.isDigit(vno.charAt(3));
                boolean fr = Character.isDigit(vno.charAt(4));
                boolean fv = Character.isDigit(vno.charAt(5));
                boolean sx = Character.isDigit(vno.charAt(6));
                boolean sv = Character.isDigit(vno.charAt(6));
                
                if((thr && fr && fv && sx )==true  )
                    return true;
                
                else
                    return false;
            }    
        }
        else if(l==6) 
        {
                if(one==true && two==false)
                {
                    boolean thr = Character.isDigit(vno.charAt(3));
                    boolean fr = Character.isDigit(vno.charAt(4));
                    boolean fv = Character.isDigit(vno.charAt(5));
                    

                    if((thr && fr && fv )==true )
                        return true;

                    else 
                        return false;
                }
        }
        
        
         
    }
    
    else if(zero==true && one == false)
        {
            char zer = vno.charAt(0);
            
            if(zer=='r' || zer=='n' || zer=='a' || zer=='g' || zer=='s' || zer=='d' || zer=='R' || zer=='N' || zer=='A' || zer=='G' || zer=='S' || zer=='D')
            {
                boolean result =true;
                
                for(int i=1; i<vno.length(); i++)
                {
                    result = Character.isDigit(vno.charAt(i)) && result;
                }
                
                return result;
                
            }
            
            
        }
    
    
    else
       return false;
        return false;
 }
    
    
   public  boolean isMinus(Double bal)
{
    if(bal>=0)
        return false;
    else
        return true;
} 
   
   public boolean isValidCat(String cat)
{
    int l = cat.length();
    System.out.println(l);
    
    if(l==1)
    {
        boolean c = Character.isDigit(cat.charAt(0));
        
        if(c==true)
        {
            String b = Character.toString(cat.charAt(0));
            int n = Integer.parseInt(b);
            
            System.out.println(n);
            
            if(n>0 && n<7)
                return true;
            
            else
                return false;
        }
        
        else return false;
    }
    
    else
        return false;

}
    
    
}
