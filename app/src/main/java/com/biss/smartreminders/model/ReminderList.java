package com.biss.smartreminders.model;

import android.app.Activity;
import android.content.SharedPreferences;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

public class ReminderList {
    private String name;
    private String username;
    private String mode;
    private String time;
    private String priority;




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public static void saveItem(Activity a, int id, Reminders item) {
        try {
            SharedPreferences sharedPref = a.getSharedPreferences("Smart Reminders", a.MODE_PRIVATE);
            String json = sharedPref.getString("JSON", "{}");
            JSONObject object = new JSONObject(json);

            JSONObject itemObject = new JSONObject();
            itemObject.put("name", item.getName());
            itemObject.put("priority", item.getPriority());
            itemObject.put("time", item.getTime());

            object.put("id"+id ,itemObject);
            json = object.toString();
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString("JSON", json);
            editor.apply();

        } catch (JSONException e) {
            Log.e("JSON Error", "Failed to create JSONObject", e);
        }
    }
}
