/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financemanagement.classes;

/**
 *
 * @author Anu
 */
public class Profit {

    public double Taxes;
    public double Interests;
    public double Depreciations;
    public String ProfitID;
    public double Cost_of_sales;
    public double income;
    public double whole_revenue;
    public double all_operating_expenses;
    public String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
   
    public double getTaxes() {
        return Taxes;
    }

    public void setTaxes(double Taxes) {
        this.Taxes = Taxes;
    }

    public double getInterests() {
        return Interests;
    }

    public void setInterests(double Interests) {
        this.Interests = Interests;
    }

    public double getDepreciations() {
        return Depreciations;
    }

    public void setDepreciations(double Depreciations) {
        this.Depreciations = Depreciations;
    }
    
     public String getProfitID() {
        return ProfitID;
    }

    public void setProfitID(String ProfitID) {
        this.ProfitID = ProfitID;
    }

    public void setCost_of_sales(double Cost_of_sales) {
        this.Cost_of_sales = Cost_of_sales;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public void setWhole_revenue(double whole_revenue) {
        this.whole_revenue = whole_revenue;
    }

    public void setAll_operating_expenses(double all_operating_expenses) {
        this.all_operating_expenses = all_operating_expenses;
    }

    public double getCost_of_sales() {
        return Cost_of_sales;
    }

    public double getIncome() {
        return income;
    }

    public double getWhole_revenue() {
        return whole_revenue;
    }

    public double getAll_operating_expenses() {
        return all_operating_expenses;
    }
    
    
}
