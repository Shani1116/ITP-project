/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmanager.classes;

/**
 *
 * @author Dell
 */
public class Email {
    
    
       public String EMAIL ;
       public String PW ;
       public String TO ;
       public String SUBJECT ;
       public String MESGE ;
       public String DATA;

    public String getDATA() {
        return DATA;
    }

    public void setDATA(String DATA) {
        this.DATA = DATA;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getPW() {
        return PW;
    }

    public void setPW(String PW) {
        this.PW = PW;
    }

    public String getTO() {
        return TO;
    }

    public void setTO(String TO) {
        this.TO = TO;
    }

    public String getSUBJECT() {
        return SUBJECT;
    }

    public void setSUBJECT(String SUBJECT) {
        this.SUBJECT = SUBJECT;
    }

    public String getMESGE() {
        return MESGE;
    }

    public void setMESGE(String MESGE) {
        this.MESGE = MESGE;
    }

   
}
