package com.example.dell3.demoapp.Model;

import com.google.gson.Gson;

import java.io.Serializable;

/**
 * Created by Dell3 on 02-04-2018.
 */

public class Menu implements Serializable {
    private int mId;
    private String mName;

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    static public Menu create(String serializedData) {
        // Use GSON to instantiate this class using the JSON representation of the state
        Gson gson = new Gson();
        return gson.fromJson(serializedData, Menu.class);
    }
    public String serialize() {
        // Serialize this class into a JSON string using GSON
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
