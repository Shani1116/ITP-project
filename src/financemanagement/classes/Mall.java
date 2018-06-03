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
public class Mall {
        public String startdate;
        public String enddate;
        public String sheetID;
        public double Current_Assets;
        public double Fixed_Assets;
        public double Current_Liabilities;
        public double LongTerm_Liabilities;
        public double Shareholders_Equity;
        public String Date;
        public String Company;

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }
        
    
        
      public String getSheetID() {
        return sheetID;
    }

    public void setSheetID(String sheetID) {
        this.sheetID = sheetID;
    }   
        
    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String Company) {
        this.Company = Company;
    }

    public double getCurrent_Assets() {
        return Current_Assets;
    }

    public void setCurrent_Assets(double Current_Assets) {
        this.Current_Assets = Current_Assets;
    }

    public double getFixed_Assets() {
        return Fixed_Assets;
    }

    public void setFixed_Assets(double Fixed_Assets) {
        this.Fixed_Assets = Fixed_Assets;
    }

    public double getCurrent_Liabilities() {
        return Current_Liabilities;
    }

    public void setCurrent_Liabilities(double Current_Liabilities) {
        this.Current_Liabilities = Current_Liabilities;
    }

    public double getLongTerm_Liabilities() {
        return LongTerm_Liabilities;
    }

    public void setLongTerm_Liabilities(double LongTerm_Liabilities) {
        this.LongTerm_Liabilities = LongTerm_Liabilities;
    }

    public double getShareholders_Equity() {
        return Shareholders_Equity;
    }

    public void setShareholders_Equity(double Shareholders_Equity) {
        this.Shareholders_Equity = Shareholders_Equity;
    }
    
}
