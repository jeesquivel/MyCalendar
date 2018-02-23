package itcr.mycalendar.entities;

/**
 * Created by Monserrath on 22/2/2018.
 */

public class Events {

    private String userFullname;
    private String eventName;
    private String date;
    private String place;
    private String time;

    public Events(String userFullname, String eventName, String date, String place, String time) {
        this.userFullname = userFullname;
        this.eventName = eventName;
        this.date = date;
        this.place = place;
        this.time = time;
    }

    public String getUserFullname() {
        return userFullname;
    }

    public void setUserFullname(String userFullname) {
        this.userFullname = userFullname;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
