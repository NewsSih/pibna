package com.example.pib;

public class ModelClass {
    private String  title,  url, published_by,date,time,Ministry;
    private String[] description;
    public String getdate() {
        return date;
    }

    public void setdate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getDescription() {
        return description;
    }

    public void setDescription(String[] description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPublished_by() {
        return published_by;
    }

    public void setPublished_by(String time) {
        this.published_by = time;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String publishedAt) {
        this.time = publishedAt;
    }

    public String getMinistry() {
        return Ministry;
    }

    public void setMinistry(String ministry) {
        Ministry = ministry;
    }

    public ModelClass() {
    }

    public ModelClass(String date, String title, String[] description, String url, String time, String published, String ministry) {
        this.date = date;
        this.title = title;
        this.description = description;
        this.url = url;
        this.time = time;
        this.published_by = published;
        this.Ministry = ministry;
    }
}
