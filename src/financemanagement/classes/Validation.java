/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financemanagement.classes;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Anu
 */
public class Validation {
    
    
    public boolean IsEmpty(String input){
        if(input != null && input.length() != 0 )
            return false;
        else
            return true;
}
    

    public boolean IsNumeric(String input){
        if(input != null && input.length() != 0 )
            return false;
        else
            return true;
}
     public boolean CheckNIC(String input){
       String npattern = "^[0-9(v|V)]";
       Pattern p = Pattern.compile(npattern);
       
       Matcher m = p.matcher(input);
       
       if(m.matches())
           return true;
       else
           return false;
       
    }
    
    public boolean CheckEmail(String input){
        
     String epattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,))$";
     Pattern p = Pattern.compile(epattern);
       
       Matcher m = p.matcher(input);
       
       if(m.matches())
           return true;
       else
           return false;
    }
    
    public boolean IsValidContact(String input) {

            if (IsNumeric(input) && input.length() >= 10)
                return true;
            else
             return false;
    }
    
/*    public boolean IsDateToday(String date){
            
        
            DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
            Date CurrentDate = new Date();
            
            if(df.format(CurrentDate) == date)
                return true;
            else
                return false;
    }*/
    
    /*public boolean IsEmpAgeValid(String year){
        
            DateFormat df = new SimpleDateFormat("yyyy");
            //Date CurrentDate = new Date();
        
            int userYear = Integer.parseInt(year);
            int Currentyear = Integer.parseInt(df.format(CurrentDate));
            int getAge = Currentyear - userYear;
            if (getAge>=18)
                return true;
            else
                return false;

}*/

}