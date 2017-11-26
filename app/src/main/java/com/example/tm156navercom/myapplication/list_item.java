package com.example.tm156navercom.myapplication;

import android.widget.CheckBox;

import java.util.Date;
import android.view.View;
/**
 * Created by HOON on 2017-11-13.
 */

public class list_item {

    private int profile_image;
    private String nickname;
    private String title;
    private Date write_date;
    private Boolean important=false;

    public int getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(int profile_image) {
        this.profile_image = profile_image;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getWrite_date() {
        return write_date;
    }

    public Boolean getImportant(){return important;}

    final public void setImportant()
    {
        if(this.important==true)
        {this.important=false;}
        else{this.important=true;}
    }
    public void setWrite_date(Date write_date) {
        this.write_date = write_date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    private String content;


    public list_item(int profile_image, String nickname, String title, Date write_date, String content) {
        this.profile_image = profile_image;
        this.nickname = nickname;
        this.title = title;
        this.write_date = write_date;
        this.content = content;
    }

}
