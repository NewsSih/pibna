package com.example.pib;

public class News {

    String Title;
    String Date;
    String Time;
    String Posted_by;
    String Ministry;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getPosted_by() {
        return Posted_by;
    }

    public void setPosted_by(String posted_by) {
        Posted_by = posted_by;
    }

    public String getMinistry() {
        return Ministry;
    }

    public void setMinistry(String ministry) {
        Ministry = ministry;
    }

    public News(String title, String date, String time, String posted_by, String ministry) {
        Title = title;
        Date = date;
        Time = time;
        Posted_by = posted_by;
        Ministry = ministry;
    }
}
