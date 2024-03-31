package com.example.assignment2;

import java.io.Serializable;

public class Restaurant implements Serializable {
    String name,desc,phone,loc,rating;
    public Restaurant() {
    }
    public Restaurant(String name, String desc, String phone, String loc, String rating) {
        this.name = name;
        this.desc = desc;
        this.phone = phone;
        this.loc = loc;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public String getPhone() {
        return phone;
    }

    public String getLoc() {
        return loc;
    }

    public String getRating() {
        return rating;
    }
}
