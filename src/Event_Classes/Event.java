/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Event_Classes;

/**
 *
 * @author Navodya
 */
public class Event {
    
     private String eventId;
     private String EventName;
     private String title;
     private String event_Type;
     private String Event_Location;
     private String contactPerson;
     private String ContacNum;
     private String Location;
     private String Location_ID;
     private String startDate;
     private String endDate;
     private int Banquet_Chairs;
     private int Tables;
     private int oilLamp;
     private int projectors;
     private int screens; 

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return EventName;
    }

    public void setEventName(String EventName) {
        this.EventName = EventName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEvent_Type() {
        return event_Type;
    }

    public void setEvent_Type(String event_Type) {
        this.event_Type = event_Type;
    }

    public String getEvent_Location() {
        return Event_Location;
    }

    public void setEvent_Location(String Event_Location) {
        this.Event_Location = Event_Location;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getContacNum() {
        return ContacNum;
    }

    public void setContacNum(String ContacNum) {
        this.ContacNum = ContacNum;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public String getLocation_ID() {
        return Location_ID;
    }

    public void setLocation_ID(String Location_ID) {
        this.Location_ID = Location_ID;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getBanquet_Chairs() {
        return Banquet_Chairs;
    }

    public void setBanquet_Chairs(int Banquet_Chairs) {
        this.Banquet_Chairs = Banquet_Chairs;
    }

    public int getTables() {
        return Tables;
    }

    public void setTables(int Tables) {
        this.Tables = Tables;
    }

    public int getOilLamp() {
        return oilLamp;
    }

    public void setOilLamp(int oilLamp) {
        this.oilLamp = oilLamp;
    }

    public int getProjectors() {
        return projectors;
    }

    public void setProjectors(int projectors) {
        this.projectors = projectors;
    }

    public int getScreens() {
        return screens;
    }

    public void setScreens(int screens) {
        this.screens = screens;
    }

    
   /* public void searchEv(String sdate){
    
        this.setStartDate(sdate);
        
        
    
    
    
    }*/
    
    
}
