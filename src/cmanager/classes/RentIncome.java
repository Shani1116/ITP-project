/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmanager.classes;

//import cmanager.addcustomer;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.swing.JOptionPane;


/**
 *
 * @author Dell
 */
public class RentIncome {
    
    
   
    public String RID;
    public String Year;
    public String Month;
    public String PayDate;
    public Double Amount;

    public String getYear() {
        return Year;
    }

    public void setYear(String Year) {
        this.Year = Year;
    }

    public String getMonth() {
        return Month;
    }

    public void setMonth(String Month) {
        this.Month = Month;
    }


    public Double getAmount() {
        return Amount;
    }

    public void setAmount(Double Amount) {
        this.Amount = Amount;
    }
    public String PaymentLevel;
    
    customer c = new customer();
    

    public String getPaymentLevel() {
        return PaymentLevel;
    }

    public void setPaymentLevel(String PaymentLevel) {
        this.PaymentLevel = PaymentLevel;
    }
    

    

    public String getRID() {
        return RID;
    }

    public void setRID(String RID) {
        this.RID = RID;
    }


    public String getPayDate() {
        return PayDate;
    }

    public void setPayDate(String PayDate) {
        this.PayDate = PayDate;
    }
    public void UpdatePayDate(){
        
    }
    public void UpdateAmount(){
        
    }

    
    
    
}
