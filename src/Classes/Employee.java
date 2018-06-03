/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Shanika
 */
public class Employee extends User {
    
    public String Empid;
    public String fname;
    public String lname;
    public String birthday;
    public String stat;
    public String email;
    public String type;
    public String jdate;
    public String designation;
    public String NIC;
    public String dep;
    public String address;
    public String phone;

    public String getEmpid() {
        return Empid;
    }

    public void setEmpid(String Empid) {
        this.Empid = Empid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getDep() {
        return dep;
    }

    public void setDep(String dep) {
        this.dep = dep;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void reqLeave(){
        
    }
    
    public void addcase(){
        
    }  
}
