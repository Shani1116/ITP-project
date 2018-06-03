/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financemanagement.classes;

import java.util.Date;

/**
 *
 * @author Anu
 */
public class Expense {

    
    
    public String expenseID;
    public String category;
    public String date;
    public double Amount;
    
    public String getExpenseID() {
        return expenseID;
    }

    public void setExpenseID(String expenseID) {
        this.expenseID = expenseID;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    //public void setDate(Date date) {
      //  this.date = date;
    //}

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double Amount) {
        this.Amount = Amount;
    }
    
    
}
