package com.my.listandrecycler.bean;

/**
 * Created by dllo on 15/12/29.
 */
public class Hero {

    private String name,sex;
    private int imageid;

    public Hero(String name, int imageid, String sex) {
        this.name = name;
        this.imageid = imageid;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getImageid() {
        return imageid;
    }

    public void setImageid(int imageid) {
        this.imageid = imageid;
    }
}
