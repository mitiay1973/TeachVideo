package com.example.teachvideo;

public class DataModal {

    // string variables for our name and job
    private int id;
    private String Name;
    private String Video;

    public DataModal(String Name, String Video) {
        this.Name = Name;
        this.Video = Video;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
    public String getVideo() {
        return Video;
    }

    public void setVideo(String Video) {
        this.Video = Video;
    }



}
