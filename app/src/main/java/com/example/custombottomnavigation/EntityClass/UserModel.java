package com.example.custombottomnavigation.EntityClass;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.custombottomnavigation.DatabaseClass;

@Entity(tableName = "user")
public class UserModel {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int key;
    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "details")
    private String details;

    public UserModel() {
    }

    public UserModel(int key, String name, String details) {
        this.key = key;
        this.name = name;
        this.details = details;
    }

    public int getKey() {
        return key;

    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}

