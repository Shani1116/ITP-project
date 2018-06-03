/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financemanagement.classes;

import java.sql.Date;

/**
 *
 * @author Anu
 */
public class Income {

   
    
    public String IncomeID;
    public String category;
    public  String date;
    public double Amount;
    public double Events;
    public double Entertainment;
    public double carpark;
    public double advertisements;
    public double shopRentals;
    
    
    
     public String getIncomeID() {
        return IncomeID;
    }

    public void setIncomeID(String IncomeID) {
        this.IncomeID = IncomeID;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String  getDate() {
        return date;
    }

   /* public void setDate(Date date) {
        this.date = date;
    }*/

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double Amount) {
        this.Amount = Amount;
    }
    
    
}
