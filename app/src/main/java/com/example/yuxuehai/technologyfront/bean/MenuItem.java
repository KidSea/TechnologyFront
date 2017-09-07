package com.example.yuxuehai.technologyfront.bean;

/**
 * Created by yuxuehai on 2017/9/7.
 */

public class MenuItem {

    public int iconResId;
    public String text;

    public MenuItem(String text,int resId){
        this.text = text;
        this.iconResId = resId;
    }
}
