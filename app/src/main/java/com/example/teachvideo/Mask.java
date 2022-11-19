package com.example.teachvideo;

import android.os.Parcel;
import android.os.Parcelable;

public class Mask implements Parcelable {
    private int id;
    private String name;
    private String video;

    public Mask(int Id, String Name, String Video) {
        this.id = Id;
        name=Name;
        video = Video;
    }

    protected Mask(Parcel in) {
        id = in.readInt();
        name=in.readString();
        video = in.readString();
    }

    public static final Creator<Mask> CREATOR = new Creator<Mask>() {
        @Override
        public Mask createFromParcel(Parcel in) {
            return new Mask(in);
        }

        @Override
        public Mask[] newArray(int size) {
            return new Mask[size];
        }
    };


    public void setId(int Id) {
        this.id = Id;
    }
    public void setName(String Name) {
        name = Name;
    }

    public void setVideo(String Video) {
        video = Video;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeString(video);
    }

    public String getVideo() {
        return video;
    }
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
