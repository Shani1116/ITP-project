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
public class Feedback {
    public String FID;
    public String Description;
    public String type;
    public String Request;
    public String Complains;


    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFID() {
        return FID;
    }

    public void setFID(String FID) {
        this.FID = FID;
    }

    public String getRequest() {
        return Request;
    }

    public void setRequest(String Request) {
        this.Request = Request;
    }

    public String getComplains() {
        return Complains;
    }

    public void setComplains(String Complains) {
        this.Complains = Complains;
    }


public void SendFeedback(){

}
public void ViewFeedback(){
}
}